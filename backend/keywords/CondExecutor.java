package backend.keywords;

import backend.Executor;
import intermediate.Node;
import intermediate.SymbolTable;

public class CondExecutor extends Executor{

	public CondExecutor(SymbolTable symtab) {
		super(symtab);
	}

	public Object execute(Node node) {		
			
		Node temp = node.getRightChild(); // entire expression	
		
		// Base case: first cond expression is true
		if ((Boolean) super.execute(temp.getLeftChild().getLeftChild()))
			return super.execute(temp.getLeftChild().getRightChild());
		
		else {
			while (true){
				
				// Advance down the tree
				temp = temp.getRightChild().getRightChild();		
				
				// If else statement, return
				if (temp.getLeftChild().getLeftChild().toString().trim().equals("ELSE")){
					return super.execute(temp.getLeftChild().getRightChild());
				}
				
				// If reaches true expression, return
				else if ((Boolean) super.execute(temp.getLeftChild().getLeftChild())){
					return super.execute(temp.getLeftChild().getRightChild());
				}			
			}
		}
	}
}

