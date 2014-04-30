package backend;

import intermediate.Node;
import intermediate.SymbolTable;

public class IfStatementExecutor extends Executor {

	public IfStatementExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		Object bool = super.execute(node.getRightChild());
		if ((Boolean) bool) {
			return super.execute(node.getRightChild().getRightChild());
		} else {
			if (node.getRightChild().getRightChild().getRightChild() != null) {
				return super.execute(node.getRightChild().getRightChild().getRightChild());
			}
		}
		return null;
	}
	
}
