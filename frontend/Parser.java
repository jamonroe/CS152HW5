package frontend;

import intermediate.Node;
import frontend.token.SpecialSymbol;
import static frontend.token.SpecialSymbol.LPAREN;
import frontend.token.SpecialToken;
import frontend.token.Token;
import java.io.IOException;

public class Parser {

    String src;
    Scanner scan;

    public Parser(Scanner scan) throws IOException {
        this.scan = scan;
    }

    public Node parse() throws IOException {
        Token token = scan.next(); // LPAREN
        Node RootNode;

        if (token.getValue() == SpecialSymbol.LPAREN) {
            RootNode = new Node(token);
            parseList(scan, RootNode, true);
        } else {
            return null;
        }
        // Return root node for tree
        return RootNode;
    }

    private Node parseList(Scanner scan, Node root, boolean real) throws IOException {
        
        Node car = new Node(scan.next()); 
       
        // LEFT CHILD
        if (car.getToken().getValue() == LPAREN) {
            root.setLeftChild(parseList(scan, car, true));
        } else {
            root.setLeftChild(car);
        }
        
        // RIGHT CHILD
        if (scan.peek() == ')') {
        	if (real) {
        		scan.next();
        	}
        } else {
            root.setRightChild(parseList(scan, new Node(new SpecialToken("(")), false));
        }
        return root;
    }
}
