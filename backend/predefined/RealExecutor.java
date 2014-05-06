package backend.predefined;

import backend.Executor;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;

public class RealExecutor extends Executor {

	public RealExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		Object value = super.execute(node);
//		System.out.println(value);
		return value instanceof Integer
			|| value instanceof Double;
	}
}
