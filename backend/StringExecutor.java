package backend;

import intermediate.Node;
import intermediate.SymbolTable;

public class StringExecutor extends Executor {

	public StringExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		return super.execute(node) instanceof String;
	}
}
