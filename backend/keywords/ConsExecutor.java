package backend.keywords;

import intermediate.Node;
import intermediate.SymbolTable;
import backend.Executor;

public class ConsExecutor extends Executor{

	public ConsExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node){
		return 0;
	}
}
