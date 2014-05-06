package backend.keywords;

import backend.Executor;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTab;
import intermediate.SymTabStack;

public class NotExecutor extends Executor{

	public NotExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {		
		return !(Boolean) super.execute(node);
	}

}
