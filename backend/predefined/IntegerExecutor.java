package backend.predefined;

import backend.Executor;
import intermediate.Node;
import intermediate.SymbolTable;

public class IntegerExecutor extends Executor {

	public IntegerExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		return super.execute(node) instanceof Integer;
	}
}
