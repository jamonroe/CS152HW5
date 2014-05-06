package backend.predefined;

import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;
import backend.Executor;

public class PairExecutor extends Executor {

	public PairExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		return (Boolean) true;
	}
}
