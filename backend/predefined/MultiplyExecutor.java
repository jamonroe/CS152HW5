package backend.predefined;

import backend.Executor;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;

public class MultiplyExecutor extends Executor {

	public MultiplyExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		Object A = super.execute(node);
		while (node.getRightChild() != null) {
			A = multiply(A, super.execute(node.getRightChild()));
			node = node.getRightChild();
		}
		return A;
	}
	
	private Object multiply(Object A, Object B) {
		if (A instanceof Double)
			if (B instanceof Double)
				return (Double) A * (Double) B;
			else
				return (Double) A * (Integer) B;
		else
			if (B instanceof Double)
				return (Integer) A * (Double) B;
			else
				return (Integer) A * (Integer) B;
	}
}
