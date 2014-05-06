package backend.keywords;

import java.util.ArrayList;

import frontend.token.SpecialSymbol;
import backend.Executor;
import intermediate.Node;
import intermediate.RuntimeStack;
import intermediate.SymTabStack;

public class LambdaExecutor extends Executor {

	public LambdaExecutor(SymTabStack symtabs, RuntimeStack runtime) {
		super(symtabs, runtime);
	}
	
	public Object execute(Node node) {
		Node passed_param = node.getRightChild();
		Node func = (Node) symtabs.search(node.getLeftChild().getTokenValue().toString());
		Node func_param = func.getRightChild().getLeftChild();
		
		ArrayList<Object> passed_parameters = new ArrayList<Object>();
		while (passed_param != null) {
			passed_parameters.add(super.execute(passed_param));
			if (passed_param.getLeftChild().getTokenValue() == SpecialSymbol.APOSTROPHE) {
				passed_param = passed_param.getRightChild();
			}
			passed_param = passed_param.getRightChild();
		}
		
		ArrayList<String> func_parameters = new ArrayList<String>();
		while (func_param != null && func_param.getLeftChild() != null) {
			func_parameters.add(func_param.getLeftChild().getTokenValue().toString());
			func_param = func_param.getRightChild();
		}
		
		// Push the new scope
		runtime.push(func.getTable().getLevel());
		
		// Add the parameters
		for (int i = 0; i < func_parameters.size(); i++) {
			runtime.add(func_parameters.get(i), passed_parameters.get(i));
		}

		// Execute the function
		Object result = super.execute(func.getRightChild().getRightChild().getLeftChild());

		// Pop the scope
		runtime.pop();
		
		return result;
	}
}
