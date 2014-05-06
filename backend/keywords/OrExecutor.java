package backend.keywords;

import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTab;
import intermediate.SymTabStack;
import backend.Executor;

public class OrExecutor extends Executor{

	public OrExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}
	
	public Object execute(Node node) {
		Object A = super.execute(node);
		boolean eq = false;
		
		while (node.getRightChild() != null) {
			eq = (boolean) or(A, super.execute(node.getRightChild()));
			node = node.getRightChild();
		}
		return eq;
	}
	
	private Object or(Object A, Object B) {
		return (Boolean) A || (Boolean) B;
	}

}
