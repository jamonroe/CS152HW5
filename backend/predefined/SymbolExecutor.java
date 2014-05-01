package backend.predefined;

import backend.Executor;
import frontend.token.TokenType;
import intermediate.Node;
import intermediate.SymbolTable;

public class SymbolExecutor extends Executor {

	public SymbolExecutor(SymbolTable symtab) {
		super(symtab);
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
