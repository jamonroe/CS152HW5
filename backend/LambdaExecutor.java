package backend;

import java.util.ArrayList;

import intermediate.Node;
import intermediate.SymbolTable;

public class LambdaExecutor extends Executor {

	public LambdaExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {
		Node passed_param = node.getRightChild();
		Node func = (Node) symtab.get(node.getLeftChild().getTokenValue().toString());
		Node func_param = func.getRightChild().getLeftChild();
		
		ArrayList<Object> passed_parameters = new ArrayList<Object>();
		while (passed_param != null) {
			passed_parameters.add(super.execute(passed_param));
			passed_param = passed_param.getRightChild();
		}
		
		ArrayList<String> func_parameters = new ArrayList<String>();
		while (func_param != null && func_param.getLeftChild() != null) {
			func_parameters.add(func_param.getLeftChild().getTokenValue().toString());
			func_param = func_param.getRightChild();
		}
		
		// TODO push new symtab
		
		for (int i = 0; i < func_parameters.size(); i++) {
			symtab.put(func_parameters.get(i), passed_parameters.get(i));
		}
		
		return super.execute(func.getRightChild().getRightChild());
		
		// TODO pop symtab
	}
}
