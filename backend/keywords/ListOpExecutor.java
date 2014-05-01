package backend.keywords;

import frontend.token.Keyword;
import intermediate.Node;
import intermediate.SymbolTable;
import backend.Executor;

public class ListOpExecutor extends Executor {

	public ListOpExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		Keyword key = (Keyword) node.getLeftChild().getTokenValue();
		Node result = (Node) super.execute(node.getRightChild());
		char[] ops = key.toString().substring(1, key.toString().length() - 1).toLowerCase().toCharArray();
		for (char c : ops) {
			if (c == 'a')
				result = result.getLeftChild();
			else
				result = result.getRightChild();
		}
		return result;
	}
}
