package backend;

import intermediate.Node;
import intermediate.SymbolTable;

public class NotExecutor extends Executor{

	public NotExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		
		// TODO add complexity when have equals
		
		return !(Boolean) super.execute(node);
	}

}
