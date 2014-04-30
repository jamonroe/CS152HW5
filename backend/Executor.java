package backend;

import frontend.token.Keyword;
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
		
		case Keyword:
			switch ((Keyword)child.getToken().getValue()) {
			case IF:
				return new IfStatementExecutor(symtab).execute(node); // NOT THE CHILD
			case DEFINE:
				return new DefineExecutor(symtab).execute(node);
			default:
				break;
			}
			break;
		
		case Identifier:
			return symtab.get(child.getTokenValue().toString());
		
		// Simple cases
		case Boolean:
		case Character:
		case Number:
		case String:
			return child.getTokenValue();

		default:
			break;
		
		}
		return "EXECUTOR FAILED";
	}
	
}
