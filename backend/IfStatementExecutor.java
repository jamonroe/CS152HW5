package backend;

import intermediate.Node;
import intermediate.SymbolTable;

public class IfStatementExecutor extends Executor {

	public IfStatementExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		// IF
		Boolean bool = (Boolean) super.execute(node);
		if (bool) {
			// THEN
			return super.execute(node.getRightChild());
		} else {
			// ELSE
			if (node.getRightChild().getRightChild() != null) {
				return super.execute(node.getRightChild().getRightChild());
			}
		}
		
		return "IF FAILED";
	}
	
}
