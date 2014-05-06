package backend.predefined;

import frontend.token.SpecialSymbol;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;
import backend.Executor;

public class PairExecutor extends Executor {

	public PairExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		Object result = super.execute(node);
		if (result instanceof Node) {
			Node temp = (Node) result;
			if (temp.getLeftChild() == null) return false;
			if (temp.getRightChild() != null) return true;
			if (temp.getLeftChild().getTokenValue() == SpecialSymbol.LPAREN)
				return temp.getLeftChild().getLeftChild() != null;
			return true;
		}
		return false;
	}
}
