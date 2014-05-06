package backend.keywords;

import frontend.token.Keyword;
import backend.Executor;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;

public class CondExecutor extends Executor{

	public CondExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {		
			
		Node temp = node; // entire expression	
		
		while (temp != null) {
			// If else statement, return
			if (temp.getLeftChild().getLeftChild().getTokenValue() == Keyword.ELSE){
				return super.execute(temp.getLeftChild().getRightChild());
			}
			
			if ((Boolean) super.execute(temp.getLeftChild().getLeftChild()))
				   return super.execute(temp.getLeftChild().getRightChild());
			
			temp = temp.getRightChild();
			
		}
		
		return null;
	}
}

