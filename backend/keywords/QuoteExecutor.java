package backend.keywords;

import backend.Executor;
import intermediate.Node;
import intermediate.SymbolTable;

public class QuoteExecutor extends Executor {

	public QuoteExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		return node.getLeftChild();
	}
}
