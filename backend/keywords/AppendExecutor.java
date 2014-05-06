package backend.keywords;

import frontend.token.SpecialSymbol;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;
import backend.Executor;

public class AppendExecutor extends Executor {

	public AppendExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}
	
	public Object execute(Node node) {
		Node first = ((Node) super.execute(node)).clone();
		Node second;
		
		if (node.getLeftChild().getTokenValue() == SpecialSymbol.APOSTROPHE)
			second = ((Node) super.execute(node.getRightChild().getRightChild())).clone();
		else 
			second = ((Node) super.execute(node.getRightChild())).clone();
		
		Node temp = first;
		while (temp.getRightChild() != null)
			temp = temp.getRightChild();
		temp.setRightChild(second);
		
		return first;
	}
}
