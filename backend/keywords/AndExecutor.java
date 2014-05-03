package backend.keywords;

import intermediate.Node;
import intermediate.SymbolTable;
import backend.Executor;

public class AndExecutor extends Executor {

	public AndExecutor(SymbolTable symtab) {
		super(symtab);
	}
	
	public Object execute(Node node) {
		Object A = super.execute(node);
		boolean eq = false;
		
		while (node.getRightChild() != null) {
			eq = (boolean) and(A, super.execute(node.getRightChild()));
			node = node.getRightChild();
		}
		return eq;
	}
	
	private Object and(Object A, Object B) {
		return (Boolean) A && (Boolean) B;
	}
}
