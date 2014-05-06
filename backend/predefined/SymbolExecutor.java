package backend.predefined;

import backend.Executor;
import frontend.token.TokenType;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;

public class SymbolExecutor extends Executor {

	public SymbolExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		Object value = super.execute(node);
		if (value instanceof Node) {
			if (((Node)value).getToken().getType() == TokenType.Identifier)
				return true;
		}
		return false;
	}
}
