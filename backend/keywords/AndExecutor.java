package backend.keywords;

import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTab;
import intermediate.SymTabStack;
import backend.Executor;

public class AndExecutor extends Executor {

	public AndExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}
	
	public Object execute(Node node) {
		boolean eq = (Boolean) super.execute(node);;
		Node temp = node;
		while (temp.getRightChild() != null) {
			eq = (boolean) and(eq, super.execute(temp.getRightChild()));
			temp = temp.getRightChild();
		}
		return eq;
	}
	
	private Object and(Object A, Object B) {
		return (Boolean) A && (Boolean) B;
	}
}
