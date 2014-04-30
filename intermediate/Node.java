package intermediate;

import frontend.token.Token;

public class Node { // Very very basic node class.

        Token token;
        Node lchild;
        Node rchild;

        public Node(Token inToken) {
            token = inToken;
        }

        public Token getToken() {
            return this.token;
        }
        
        public Object getTokenValue() {
            return this.token;
        }

        public Node setLeftChild(Node node) {
            return this.lchild = node;
        }

        public Node getLeftChild() {
            return this.lchild;
        }

        public Node setRightChild(Node node) {
            return this.rchild = node;
        }

        public Node getRightChild() {
            return this.rchild;
        }
        
        public String print() {
        	return printLeft(0);
        }
        
        public String printLeft(int line) {
            // Preorder Traversal: Root, Left, Right
            String result = "";
            // Root
            if (getToken().getLine() != line) {
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
            } else if (getTokenValue().equals("(")) {
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
            } else if (getTokenValue().equals("(")) {
                result += ") ";
            }
            return result;
        }
        
        public String toString() {
        	return printLeft(0);
        }
    }