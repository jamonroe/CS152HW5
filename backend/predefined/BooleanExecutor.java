package backend.predefined;

import backend.Executor;
import intermediate.Node;
import intermediate.SymbolTable;

public class BooleanExecutor extends Executor {

	public BooleanExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		return super.execute(node) instanceof Boolean;
	}
}
