package backend.keywords;

import java.util.ArrayList;

import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;
import backend.Executor;

public class LetStarExecutor extends Executor {

	public LetStarExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}

	public Object execute(Node node) {

		 // Identifier params
		  ArrayList<String> args = new ArrayList<String>();
		  
		 // Values of params
		  ArrayList<Object> vals = new ArrayList<Object>();
		  
		 // Node containing all params and their values
		  Node passed_param = node.getLeftChild(); 
		  
		 // Node containing the body
		  Node body = node.getRightChild();

		  //Push the new scope
		  runtime.push(node.getLeftChild()
				  .getTable()
				  .getLevel());
		  
		 // Add identifiers and values to corresponding array lists 
		  while (passed_param != null) {
		   
			   // Add to array lists
			   runtime.add(
					   passed_param.getLeftChild().getLeftChild().getTokenValue().toString(),
					   super.execute(passed_param.getLeftChild().getRightChild()));
			 
			   // Advance down the tree   
			   passed_param = passed_param.getRightChild();
		  }
		  
		  Object result = super.execute(body);
		  
//		  Pop the scope
		  runtime.pop();
		  
		  return result;
	}
}
