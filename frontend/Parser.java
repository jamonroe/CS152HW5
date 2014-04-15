package frontend.jason;

import frontend.token.jason.SpecialSymbol;
import static frontend.token.jason.SpecialSymbol.LPAREN;
import frontend.token.jason.SpecialToken;
import frontend.token.jason.Token;
import java.io.IOException;

public class Parser {

    String src;
    Scanner scan;

    public Parser(Scanner _scan) throws IOException {
        scan = _scan;
    }

    public Node parse() throws IOException {
        Token token = scan.next(); // LPAREN
        Node RootNode;

        if (token.getValue() == SpecialSymbol.LPAREN) {
            RootNode = new Node(token);
            parseList(scan, RootNode);
        } else {
            return null;
        }
        // Return root node for tree
        return RootNode;
    }

    private Node parseList(Scanner scan, Node root) throws IOException {
        
        Token tempT;
        Node car = new Node(scan.next()); 
       
        // LEFT CHILD
        if (car.getToken().toString().equals(LPAREN)) {
            parseList(scan, car);
        } else {
            root.setLeftChild(car);
        }
        
        
        // RIGHT CHILD
        if (scan.sPeek() == ')') {
            return root;
        } else {
            
            SpecialToken sToken = new SpecialToken('(');
            parseList(scan, new Node(sToken));
        }
        return root;
    }

    class Node { // Very very basic node class.

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

        public void setLeftChild(Node node) {
            this.lchild = node;
        }

        public Node getLeftChild() {
            return this.lchild;
        }

        public void setRightChild(Node node) {
            this.rchild = node;
        }

        public Node getRightChild() {
            return this.rchild;
        }
        
        public void print(Node root) {
            // Preorder Traversal: Root, Left, Right
            
            // Root
            System.out.println(root.getTokenValue());
            
            // Left, if not null.
            if (root.getLeftChild() != null) 
            {
                print(root.getLeftChild()); 
            }
            
            // Right, if not null.
            if (root.getRightChild() != null) 
            {
                print(root.getRightChild());
            } else if (root.getRightChild() == null) {
                System.out.println(")");
            }
        }
    }
}
