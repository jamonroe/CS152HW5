package backend.keywords;

import frontend.token.Keyword;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;
import backend.Executor;

public class ListOpExecutor extends Executor {

	public ListOpExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
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
		if (result instanceof Node) {
			switch (result.getToken().getType()) {
			case Boolean:
			case Character:
			case Number:
			case String:
				return result.getTokenValue();
			}
		}
		return result;
	}
}
