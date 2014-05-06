package backend;

import backend.keywords.AndExecutor;
import backend.keywords.AppendExecutor;
import backend.keywords.CondExecutor;
import backend.keywords.ConsExecutor;
import backend.keywords.DefineExecutor;
import backend.keywords.IfStatementExecutor;
import backend.keywords.LambdaExecutor;
import backend.keywords.LetExecutor;
import backend.keywords.ListOpExecutor;
import backend.keywords.NotExecutor;
import backend.keywords.OrExecutor;
import backend.keywords.QuoteExecutor;
import backend.predefined.AddExecutor;
import backend.predefined.BooleanExecutor;
import backend.predefined.CharExecutor;
import backend.predefined.DivideExecutor;
import backend.predefined.IntegerExecutor;
import backend.predefined.MultiplyExecutor;
import backend.predefined.NullExecutor;
import backend.predefined.PairExecutor;
import backend.predefined.RealExecutor;
import backend.predefined.StringExecutor;
import backend.predefined.SubtractExecutor;
import backend.predefined.SymbolExecutor;
import backend.predefined.EqualExecutor;
import frontend.token.Keyword;
import frontend.token.Predefined;
import frontend.token.SpecialSymbol;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;

public class Executor {

	protected SymTabStack symtabs;
	protected RuntimeStack runtime;
	
	public Executor(SymTabStack symtabs, RuntimeStack runtime) {
		this.symtabs = symtabs;
		this.runtime = runtime;
	}
	
	public Object execute(Node node) {
		
		if (node.getLeftChild() == null)
			return null;
		Node child = node.getLeftChild();
		
		switch (child.getToken().getType()) {
		
		/* Keyword Tokens */
		
		case Keyword:
			switch ((Keyword)child.getTokenValue()) {
			case IF:
				return new IfStatementExecutor(symtabs, runtime).execute(node.getRightChild());
			case DEFINE:
				return new DefineExecutor(symtabs, runtime).execute(node.getRightChild());
			case COND:
				return new CondExecutor(symtabs, runtime).execute(node.getRightChild());
			case LET:
				return new LetExecutor(symtabs, runtime).execute(node.getRightChild());
			case NOT:
				return new NotExecutor(symtabs, runtime).execute(node.getRightChild());
			case QUOTE:
				return new QuoteExecutor(symtabs, runtime).execute(node.getRightChild());
			case LAMBDA:
				// Need to retain the LAMBDA so we know it's not a list
				// This is only called when LAMBDA functions are declared
				return node; 
			case AND:
				return new AndExecutor(symtabs, runtime).execute(node.getRightChild());
			case OR:
				return new OrExecutor(symtabs, runtime).execute(node.getRightChild());
			case CONS:
				return new ConsExecutor(symtabs, runtime).execute(node.getRightChild());
			case APPEND:
				return new AppendExecutor(symtabs, runtime).execute(node.getRightChild());
			default:
				if (((Keyword)child.getTokenValue()).listOp())
					return new ListOpExecutor(symtabs, runtime).execute(node); // Exception: need the operator
				return "KEYWORD FAILED";
			}
		
		/* Special Symbol Tokens */
			
		case Special:
			switch ((SpecialSymbol)child.getTokenValue()) {
			
			// Returns the node following an apostrophe
			// Based on the root it could be a list or a value
			case APOSTROPHE:
				return node.getRightChild().getLeftChild(); // No execute should go here
			
			// Child element is a list
			case LPAREN:
				return new Executor(symtabs, runtime).execute(child); // The new Executor is very important
			
			default:
				return "SPECIAL FAILED";
			}
			
		/* Identifier Tokens */
		
		case Identifier:
			Object value = child.getTable().get(child.getTokenValue().toString());
			if (value instanceof Node) {
				Node value_node = (Node) value;
				
				/* Lambda Functions */
				
				if (value_node.getLeftChild() != null &&
				    value_node.getLeftChild().getTokenValue() == Keyword.LAMBDA) {
					return new LambdaExecutor(symtabs, runtime).execute(node);
				}
				
				return runtime.search(child.getTokenValue().toString());
			} else 
			if (value instanceof Predefined){
				
				/* Predefined Functions */
					
				switch ((Predefined) value) {
				case ADD:
					return new AddExecutor(symtabs, runtime).execute(node.getRightChild());
				case SUBTRACT:
					return new SubtractExecutor(symtabs, runtime).execute(node.getRightChild());
				case MULTIPLY:
					return new MultiplyExecutor(symtabs, runtime).execute(node.getRightChild());
				case DIVIDE:
					return new DivideExecutor(symtabs, runtime).execute(node.getRightChild());
				case SYMBOL:
					return new SymbolExecutor(symtabs, runtime).execute(node.getRightChild());
				case STRING:
					return new StringExecutor(symtabs, runtime).execute(node.getRightChild());
				case BOOLEAN:
					return new BooleanExecutor(symtabs, runtime).execute(node.getRightChild());
				case NULL:
					return new NullExecutor(symtabs, runtime).execute(node.getRightChild());
				case CHAR:
					return new CharExecutor(symtabs, runtime).execute(node.getRightChild());
				case INTEGER:
					return new IntegerExecutor(symtabs, runtime).execute(node.getRightChild());
				case REAL:
					return new RealExecutor(symtabs, runtime).execute(node.getRightChild());
				case PAIR:
					return new PairExecutor(symtabs, runtime).execute(node.getRightChild());
				case EQUAL:
				case EQ:
				case EQSIGN:
					return new EqualExecutor(symtabs, runtime).execute(node.getRightChild());
			
				default:
					return "PREDEFINED FAILED";
				}
			} else {
				
				/* Variable */
				
				return runtime.search(child.getTokenValue().toString());
			}
		
		/* Boolean, Character, Number, String Tokens */
			
		case Boolean:
		case Character:
		case Number:
		case String:
			return child.getTokenValue();

		default:
			return "EXECUTOR FAILED";
		}
	}
	
}
