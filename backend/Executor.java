package backend;

import backend.keywords.ListOpExecutor;
import backend.keywords.QuoteExecutor;
import backend.predefined.AddExecutor;
import backend.predefined.BooleanExecutor;
import backend.predefined.CharExecutor;
import backend.predefined.DivideExecutor;
import backend.predefined.IntegerExecutor;
import backend.predefined.MultiplyExecutor;
import backend.predefined.NullExecutor;
import backend.predefined.RealExecutor;
import backend.predefined.StringExecutor;
import backend.predefined.SubtractExecutor;
import backend.predefined.SymbolExecutor;
import backend.predefined.EqualExecutor;
import frontend.token.Keyword;
import frontend.token.Predefined;
import frontend.token.SpecialSymbol;
import intermediate.Node;
import intermediate.SymbolTable;

public class Executor {

	protected SymbolTable symtab;
	
	public Executor(SymbolTable symtab) {
		this.symtab = symtab;
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
				return new IfStatementExecutor(symtab).execute(node.getRightChild());
			case DEFINE:
				return new DefineExecutor(symtab).execute(node.getRightChild());
			case COND:
				return new CondExecutor(symtab).execute(node.getRightChild());
			case LET:
				return new LetExecutor(symtab).execute(node.getRightChild());
			case NOT:
				return new NotExecutor(symtab).execute(node.getRightChild());
			case QUOTE:
				return new QuoteExecutor(symtab).execute(node.getRightChild());
			default:
				if (((Keyword)child.getTokenValue()).listOp())
					return new ListOpExecutor(symtab).execute(node); // Exception: need the operator
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
				return new Executor(symtab).execute(child); // The new Executor is very important
			
			default:
				return "SPECIAL FAILED";
			}
			
		/* Identifier Tokens */
		
		case Identifier:
			Object value = symtab.get(child.getTokenValue().toString());
			if (!(value instanceof Predefined)) {
				return value;
			} else {
				
				/* Predefined Tokens */
					
				switch ((Predefined) value) {
				case ADD:
					return new AddExecutor(symtab).execute(node.getRightChild());
				case SUBTRACT:
					return new SubtractExecutor(symtab).execute(node.getRightChild());
				case MULTIPLY:
					return new MultiplyExecutor(symtab).execute(node.getRightChild());
				case DIVIDE:
					return new DivideExecutor(symtab).execute(node.getRightChild());
				case SYMBOL:
					return new SymbolExecutor(symtab).execute(node.getRightChild());
				case STRING:
					return new StringExecutor(symtab).execute(node.getRightChild());
				case BOOLEAN:
					return new BooleanExecutor(symtab).execute(node.getRightChild());
				case NULL:
					return new NullExecutor(symtab).execute(node.getRightChild());
				case CHAR:
					return new CharExecutor(symtab).execute(node.getRightChild());
				case INTEGER:
					return new IntegerExecutor(symtab).execute(node.getRightChild());
				case REAL:
					return new RealExecutor(symtab).execute(node.getRightChild());
				case EQUAL:
					return new EqualExecutor(symtab).execute(node.getRightChild());
			
				default:
					return "PREDEFINED FAILED";
				}
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
