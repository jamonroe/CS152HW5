package backend;

import intermediate.Node;
import intermediate.SymbolTable;

public class MultiplyExecutor extends Executor {

	public MultiplyExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		Double A = (Double) super.execute(node);
		Double B = (Double) super.execute(node.getRightChild());
		return A * B;
	}
}
