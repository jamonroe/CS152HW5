package backend.keywords;

import java.util.ArrayList;

import backend.Executor;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;

public class LetExecutor extends Executor {

	public LetExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}
	
	/*
	(let ((x 5) (b 6) (c 6)) (+ x b))
	; 11	*/
	// (((x 5) (b 6) (c 6)) (+ x b))
	public Object execute(Node node) {
	  
	 // Identifier params
	  ArrayList<String> args = new ArrayList<String>();
	  
	 // Values of params
	  ArrayList<Object> vals = new ArrayList<Object>();
	  
	 // Node containing all params and their values
	  Node passed_param = node.getLeftChild(); 
	  
	 // Node containing the body
	  Node body = node.getRightChild();
	  
	 // Add identifiers and values to corresponding array lists 
	  while (passed_param != null) {
	   
		   // Add to array lists
		   args.add(passed_param.getLeftChild().getLeftChild().getTokenValue().toString());
		   vals.add(super.execute(passed_param.getLeftChild().getRightChild()));
		 
		   // Advance down the tree   
		   passed_param = passed_param.getRightChild();
	  }
	  
//	  Push the new scope
	  runtime.push(node.getLeftChild()
			  .getTable()
			  .getLevel());
	  
//	  Add the parameters
	  for (int i = 0; i < vals.size(); i++) {
		  runtime.add(args.get(i), vals.get(i));
	  }

	  Object result = super.execute(body);
	  
//	  Pop the scope
	  runtime.pop();
	  
	  return result;
	  }
	}