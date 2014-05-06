package backend.keywords;

import backend.Executor;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;

public class DefineExecutor extends Executor {

	public DefineExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		Node variable = node.getLeftChild();
		
		// Add function info into symbol table
		symtabs.peek().put(variable.getTokenValue().toString(), node.getRightChild().getLeftChild());
		
		runtime.add(variable.getTokenValue().toString(), super.execute(node.getRightChild()));
		
		return null;
	}
}
