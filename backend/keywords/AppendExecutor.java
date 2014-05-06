package backend.keywords;

import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTab;
import intermediate.SymTabStack;
import backend.Executor;

public class AppendExecutor extends Executor {

	public AppendExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}
	
	public Object execute(Node node){
		return null;
	}

}
