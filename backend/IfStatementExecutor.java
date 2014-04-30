package backend;

import frontend.token.Token;
import intermediate.Node;
import intermediate.SymbolTable;

public class IfStatementExecutor extends Executor {

	public IfStatementExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		// IF
		Token bool = (Token) super.execute(node.getRightChild());
		if ((Boolean) bool.getValue()) {
			// THEN
			return super.execute(node.getRightChild().getRightChild());
		} else {
			// ELSE
			if (node.getRightChild().getRightChild().getRightChild() != null) {
				return super.execute(node.getRightChild().getRightChild().getRightChild());
			}
		}
		
		return "IF FAILED";
	}
	
}
