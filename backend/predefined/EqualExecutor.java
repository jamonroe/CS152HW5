package backend.predefined;

import intermediate.Node;
import intermediate.SymbolTable;
import backend.Executor;

public class EqualExecutor extends Executor {

	public EqualExecutor(SymbolTable symtab) {
		super(symtab);
	}
	
	public Object execute (Node node){
		
		Object A = super.execute(node);
		Object B = super.execute(node.getRightChild());
		
//		if (A instanceof Double && B instanceof Double)
			return (A.equals(B));
	}

}
