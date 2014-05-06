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

public class ConsExecutor extends Executor{

	public ConsExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node){
		Object first = super.execute(node);
		Object second;
		
		if (node.getLeftChild().getTokenValue() == SpecialSymbol.APOSTROPHE)
			second = super.execute(node.getRightChild().getRightChild());
		else 
			second = super.execute(node.getRightChild());
		
		Node first_node, second_node, result = new Node(new SpecialToken("("));
		if (first instanceof Integer)
			first_node = new Node(new NumberToken((Integer) first));
		else if (first instanceof Double)
			first_node = new Node(new NumberToken((Double) first));
		else if (first instanceof Boolean)
			first_node = new Node(new BooleanToken((Boolean) first));
		else if (first instanceof Character)
			first_node = new Node(new CharacterToken((Character) first));
		else if (first instanceof String)
			first_node = new Node(new StringToken((String) first));
		else
			first_node = (Node) first;
		
		if (second instanceof Integer)
			second_node = new Node(new NumberToken((Integer) first));
		else if (second instanceof Double)
			second_node = new Node(new NumberToken((Double) first));
		else if (second instanceof Boolean)
			second_node = new Node(new BooleanToken((Boolean) first));
		else if (second instanceof Character)
			second_node = new Node(new CharacterToken((Character) first));
		else if (second instanceof String)
			second_node = new Node(new StringToken((String) first));
		else
			second_node = (Node) second;
		
		result.setLeftChild(first_node.clone());
		result.setRightChild(second_node.clone());
		
		return result;
	}
}
