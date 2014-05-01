package backend.keywords;

import backend.Executor;
import intermediate.Node;
import intermediate.SymbolTable;

public class NotExecutor extends Executor{

	public NotExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {		
		return !(Boolean) super.execute(node);
	}

}
