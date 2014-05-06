package backend.keywords;

import frontend.token.BooleanToken;
import frontend.token.CharacterToken;
import frontend.token.NumberToken;
import frontend.token.SpecialSymbol;
import frontend.token.SpecialToken;
import frontend.token.StringToken;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;
import backend.Executor;

public class ListExecutor extends Executor {

	public ListExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {
		Node result = new Node(new SpecialToken("("));
		Node expansion = result;
		Node temp = node;
		Object value;
		
		do {
			
			if (temp == null || temp.getLeftChild() == null)
				break;
			value = super.execute(temp);
			
			Node value_node;
			if (value instanceof Integer)
				value_node = new Node(new NumberToken((Integer) value));
			else if (value instanceof Double)
				value_node = new Node(new NumberToken((Double) value));
			else if (value instanceof Boolean)
				value_node = new Node(new BooleanToken((Boolean) value));
			else if (value instanceof Character)
				value_node = new Node(new CharacterToken((Character) value));
			else if (value instanceof String)
				value_node = new Node(new StringToken((String) value));
			else
				value_node = (Node) value;
			
			expansion.setLeftChild(value_node.clone());
			
			if (temp.getLeftChild().getTokenValue() == SpecialSymbol.APOSTROPHE)
				temp = temp.getRightChild();
			
			if (temp.getRightChild() != null)
				expansion = expansion.setRightChild(new Node(new SpecialToken("(")));
			
		} while ((temp = temp.getRightChild()) != null);
		
		return result;
	}
}
