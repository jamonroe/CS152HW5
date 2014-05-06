package backend.keywords;

import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;
import backend.Executor;

public class OrExecutor extends Executor{

	public OrExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}
	
	public Object execute(Node node) {
		boolean eq = (Boolean) super.execute(node);
		
		while (node.getRightChild() != null) {
			eq = (boolean) or(eq, super.execute(node.getRightChild()));
			node = node.getRightChild();
		}
		return eq;
	}
	
	private Object or(Object A, Object B) {
		return (Boolean) A || (Boolean) B;
	}

}
