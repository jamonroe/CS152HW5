package backend.predefined;

import backend.Executor;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;

public class StringExecutor extends Executor {

	public StringExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		return super.execute(node) instanceof String;
	}
}
