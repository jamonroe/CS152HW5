package backend.predefined;

import backend.Executor;
import intermediate.Node;
import intermediate.SymbolTable;

public class RealExecutor extends Executor {

	public RealExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		Object value = super.execute(node);
//		System.out.println(value);
		return value instanceof Integer
			|| value instanceof Double;
	}
}
