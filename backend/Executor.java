package backend;

import frontend.token.Keyword;
import intermediate.Node;
import intermediate.SymbolTable;

public class Executor {

	private SymbolTable symtab;
	
	public Executor(SymbolTable symtab) {
		this.symtab = symtab;
	}
	
	public Object execute(Node node) {
		
		Node child = node.getLeftChild();
		
		switch (child.getToken().getType()) {
		
		case Keyword:
			switch ((Keyword)child.getToken().getValue()) {
			case IF:
				new IfStatementExecutor(symtab).execute(node); // NOT THE CHILD
				break;
			default:
				break;
			}
			break;
		
		case Identifier:
			symtab.getSymbolTable().get(child.getTokenValue()); // TODO Change this
			break;
		
		// Simple cases
		case Boolean:
		case Character:
		case Number:
		case String:
			return child.getTokenValue();

		default:
			break;
		
		}
		return null;
	}
	
}
