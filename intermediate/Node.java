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
        
        public String getTokenValue() {
            return this.token.toString();
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
        
        public void print() {
        	printLeft();
        }
        
        public void printLeft() {
            // Preorder Traversal: Root, Left, Right
            
            // Root
            System.out.print(getTokenValue() + " ");
            
            // Left, if not null.
            if (getLeftChild() != null) 
            {
                getLeftChild().printLeft(); 
            }
            
            // Right, if not null.
            if (getRightChild() != null) 
            {
                getRightChild().printRight();
            } else if (getTokenValue().equals("(")) {
                System.out.print(") ");
            }
        }
        
        public void printRight() {
        	// Preorder Traversal: Root, Left, Right
            
            // Left, if not null.
            if (getLeftChild() != null) 
            {
                getLeftChild().printLeft(); 
            }
            
            // Right, if not null.
            if (getRightChild() != null) 
            {
                getRightChild().printRight();
            } else if (getTokenValue().equals("(")) {
                System.out.print(") ");
            }
        }
    }