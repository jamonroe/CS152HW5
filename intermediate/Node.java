package intermediate;

import frontend.token.SpecialSymbol;
import frontend.token.Token;

public class Node { // Very very basic node class.

    Token token;
    SymTab symtab;
    Node lchild;
    Node rchild;

    public Node(Token inToken) {
        token = inToken;
    }

    public SymTab connect(SymTab symtab) {
    	return this.symtab = symtab;
    }
    
    public SymTab getTable() {
    	return symtab;
    }
    
    public Token getToken() {
        return token;
    }
    
    public Object getTokenValue() {
        return token.getValue();
    }

    public Node setLeftChild(Node node) {
        return lchild = node;
    }

    public Node getLeftChild() {
        return lchild;
    }

    public Node setRightChild(Node node) {
        return rchild = node;
    }

    public Node getRightChild() {
        return rchild;
    }
    
    public String print() {
    	return printLeft(0);
    }
    
    public String printLeft(int line) {
        // Preorder Traversal: Root, Left, Right
        String result = "";
        // Root
        if (getToken().getLine() != line && line != -1) {
        	line = getToken().getLine();
        	result += "\n" + line + ": ";
        }
    	result += token.toString() + " ";
        
        // Left, if not null.
        if (getLeftChild() != null) 
        {
            result += getLeftChild().printLeft(line); 
        }
        
        // Right, if not null.
        if (getRightChild() != null) 
        {
            result += getRightChild().printRight(line);
        } else if (getTokenValue() == SpecialSymbol.LPAREN) {
            result += ") ";
        }
        return result;
    }
    
    public String printRight(int line) {
    	// Preorder Traversal: Root, Left, Right
    	String result = "";
    	
        // Left, if not null.
        if (getLeftChild() != null) 
        {
            result += getLeftChild().printLeft(line); 
        }
        
        // Right, if not null.
        if (getRightChild() != null) 
        {
            result += getRightChild().printRight(line);
        } else if (getTokenValue() == SpecialSymbol.LPAREN) {
            result += ") ";
        }
        return result;
    }
    
    public String toString() {
    	return printLeft(-1);
    	//return printLeft(0);
    }
    
    public boolean equals(Object object) {
    	if (!(object instanceof Node))
    		return false;
    	Node node = (Node) object;
    	if (!getToken().equals(node.getToken()))
    		return false;
    	if (getLeftChild() != null)
	    	if (!getLeftChild().equals(node.getLeftChild()))
	    		return false;
    	if (getRightChild() != null)
	    	if (!getRightChild().equals(node.getRightChild()))
	    		return false;
    	return true;
    }
    
    public Node clone() {
    	Node result = new Node(getToken().clone());
    	if (getLeftChild() != null)
    		result.setLeftChild(getLeftChild().clone());
    	if (getRightChild() != null)
    		result.setRightChild(getRightChild().clone());
    	return result;
    }
}