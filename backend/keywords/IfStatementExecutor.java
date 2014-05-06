package backend.keywords;

import frontend.token.SpecialSymbol;
import backend.Executor;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTab;
import intermediate.SymTabStack;

public class IfStatementExecutor extends Executor {
	
	public IfStatementExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		// IF
		Boolean bool = (Boolean) super.execute(node);
		if (bool) {
			// THEN
			return super.execute(node.getRightChild());
		} else {
			// ELSE
			if (node.getRightChild().getLeftChild().getTokenValue() == SpecialSymbol.APOSTROPHE)
				node = node.getRightChild();
			if (node.getRightChild().getRightChild() != null) {
				return super.execute(node.getRightChild().getRightChild());
			}
		}
		
		return "IF FAILED";
	}
	
}
