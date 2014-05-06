package backend.predefined;

import backend.Executor;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;

public class AddExecutor extends Executor {

	public AddExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		Object A = super.execute(node);
		while (node.getRightChild() != null) {
			A = add(A, 
					super.execute(node.getRightChild()));
			node = node.getRightChild();
		}
		return A;
	}
	
	private Object add(Object A, Object B) {
		if (A instanceof Double)
			if (B instanceof Double)
				return (Double) A + (Double) B;
			else
				return (Double) A + (Integer) B;
		else
			if (B instanceof Double)
				return (Integer) A + (Double) B;
			else
				return (Integer) A + (Integer) B;
	}
}
