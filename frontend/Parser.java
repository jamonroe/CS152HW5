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
            
            SpecialToken sToken = new SpecialToken("(");
            parseList(scan, new Node(sToken));
        }
        return root;
    }
}
