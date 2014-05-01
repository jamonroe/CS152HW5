package backend.predefined;

import backend.Executor;
import intermediate.Node;
import intermediate.SymbolTable;

public class NullExecutor extends Executor {

	public NullExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		return super.execute(node) == null;
	}
}
