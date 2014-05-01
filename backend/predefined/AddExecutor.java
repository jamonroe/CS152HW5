package backend.predefined;

import backend.Executor;
import intermediate.Node;
import intermediate.SymbolTable;

public class AddExecutor extends Executor {

	public AddExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		Object A = super.execute(node);
		Object B = super.execute(node.getRightChild());
		
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