package backend.predefined;

import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;
import backend.Executor;

public class EqualExecutor extends Executor {

	public EqualExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}
	
	public Object execute(Node node) {
		Object A = super.execute(node);
		boolean eq = false;
		
		while (node.getRightChild() != null) {
			eq = (boolean) equals(A, super.execute(node.getRightChild()));
			node = node.getRightChild();
		}
		return eq;
	}
	
	private Object equals(Object A, Object B) {
		return A.equals(B);
	}

}
