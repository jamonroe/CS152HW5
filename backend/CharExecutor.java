package backend;

import intermediate.Node;
import intermediate.SymbolTable;

public class CharExecutor extends Executor {

	public CharExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		return super.execute(node) instanceof Character;
	}
}
