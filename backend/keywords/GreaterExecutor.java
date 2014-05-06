package backend.keywords;

import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;
import backend.Executor;

public class GreaterExecutor extends Executor {

	public GreaterExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		Object A = super.execute(node);
		Object B;
		while (node.getRightChild() != null) {
			if (!greater(A, B = super.execute(node.getRightChild())))
				return (Boolean) false;
			A = B;
			node = node.getRightChild();
		}
		return (Boolean) true;
	}
	
	private Boolean greater(Object A, Object B) {
		if (A instanceof Double)
			if (B instanceof Double)
				return (Double) A > (Double) B;
			else
				return (Double) A > (Integer) B;
		else
			if (B instanceof Double)
				return (Integer) A > (Double) B;
			else
				return (Integer) A > (Integer) B;
	}
}
