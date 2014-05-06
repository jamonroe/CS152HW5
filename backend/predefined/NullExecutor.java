package backend.predefined;

import frontend.token.SpecialSymbol;
import backend.Executor;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;

public class NullExecutor extends Executor {

	public NullExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		Object result = super.execute(node);
		if (result == null)
			return true;
		if (result instanceof Node) {
			Node temp = (Node) result;
			if (temp.getTokenValue() == SpecialSymbol.LPAREN
			    && temp.getLeftChild() == null)
				return true;
		}
		return false;
	}
}
