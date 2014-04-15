package frontend;

import intermediate.Node;
import frontend.token.SpecialSymbol;
import static frontend.token.SpecialSymbol.LPAREN;
import static frontend.token.SpecialSymbol.RPAREN;
import frontend.token.SpecialToken;
import frontend.token.Token;
import java.io.IOException;

public class Parser {

    String src;
    Scanner scan;
    Node head;

    public Parser(Scanner scan) throws IOException {
        this.scan = scan;
    }

    public Node parse() throws IOException {
        Token token = scan.next(); // LPAREN
        
        if (token != null && token.getValue() == SpecialSymbol.LPAREN) {
            System.out.print(token);
            head = new Node(token);
            parseList(head, true);
        } else {
            return null;
        }
        System.out.println();
        // Return root node for tree
        return head;
    }

    private Node parseList(Node root, boolean real) throws IOException {
        Token temp;
    	System.out.print(temp = scan.next());
        Node car = new Node(temp); 
        // LEFT CHILD
        if (car.getToken().getValue() == LPAREN) {
            root.setLeftChild(parseList(car, true));
        } else 
        if (car.getToken().getValue() == RPAREN) {
        	return root;
        } else {
            root.setLeftChild(car);
        }
        
        // RIGHT CHILD
        if (scan.peek() != ')') {
            root.setRightChild(parseList(new Node(new SpecialToken("(")), false));
        }
    	if (real) {
    		System.out.print(scan.next());
    	}

    	return root;
    }
}
