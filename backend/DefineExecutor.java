package backend;

import intermediate.Node;
import intermediate.SymbolTable;

public class DefineExecutor extends Executor {

	public DefineExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		Node variable = node.getRightChild().getLeftChild();
		Object value = super.execute(node.getRightChild().getRightChild());
		symtab.put(variable.getTokenValue().toString(), value);
		return null;
	}
}
