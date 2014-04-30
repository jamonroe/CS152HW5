package backend;

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
			default:
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
				return execute(child);
			
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
