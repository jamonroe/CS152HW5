package frontend;

import intermediate.Node;
import intermediate.SymTab;
import intermediate.SymTabStack;
import frontend.token.SpecialSymbol;
import static frontend.token.SpecialSymbol.LPAREN;
import static frontend.token.SpecialSymbol.RPAREN;
import frontend.token.Keyword;
import frontend.token.Predefined;
import frontend.token.SpecialToken;
import frontend.token.Token;
import frontend.token.TokenType;

import java.io.IOException;

public class Parser {

	SymTabStack symtabs;
	SymTab global;
	String src;
    Scanner scan;
    Node head;
    String currentLine;
    int lineNumber;

    public Parser(Scanner scan) throws IOException {
        this.scan = scan;
        symtabs = new SymTabStack();
        global = symtabs.push().initPredefined();
        symtabs.push();
    }

    public Node parse() throws IOException {
        Token token = scan.next(); // LPAREN
        
        if (token != null && token.getValue() == SpecialSymbol.LPAREN) {
            System.out.println("\n**** Parser Results ****\n");
        	lineNumber = token.getLine();
            currentLine = String.format("%02d: ", lineNumber) + token.toString();
    		// Print first parenthesis
//            System.out.println(String.format("%-14s: %s", token.getType(), token.toString()));
        	head = new Node(token);
            parseList(head, true);
            // Print final line
            System.out.println(currentLine);
        } else {
            return null;
        }
        // Return root node for tree
        return head;
    }

    private void parseList(Node root, boolean real) throws IOException {
        Token temp;
        boolean scoped = false;
    	if((temp = scan.next()) == null) return;
        Node car = new Node(temp); 

        /* Begin print out */
        if (temp.getLine() != lineNumber) {
        	System.out.println(currentLine);
//    		System.out.println(String.format("%-14s: %s", temp.getType(), temp.toString()));
        	lineNumber = temp.getLine();
        	currentLine = String.format("%02d: ", lineNumber);
        } else {
//    		System.out.println(String.format("%-14s: %s", temp.getType(), temp.toString()));
        }
        currentLine += " " + temp.toString();
        /* End print out */
        
		car.connect(symtabs.peek());
		
        // Add identifiers to symbol table
        if (car.getToken().getType() == TokenType.Identifier){
        	if (car.getTokenValue() instanceof Predefined) {
        		car.connect(global);
        	} else {
        		
	        	Node value = (Node) symtabs.search(car.getTokenValue().toString());
	        	if (value == null) {
	        		symtabs.peek().put(car.getTokenValue().toString(), car);
	        	} else {
	        		car.connect(value.getTable());
	        	}
        	}
        }
        
        // Push new scopes
        if (car.getToken().getType() == TokenType.Keyword &&
        	((Keyword)car.getTokenValue()).newScope()) {
        	scoped = true;
        	car.connect(symtabs.push());
        }
        
        // LEFT CHILD
        if (car.getToken().getValue() == LPAREN) {
        	root.setLeftChild(car);
            parseList(car, true);
        } else 
        if (car.getToken().getValue() == RPAREN) {
        	return;
        } else {
            root.setLeftChild(car);
        }
        
        // RIGHT CHILD
        if (scan.peek() != ')' && scan.peek() != 65535) {
            Node virtual_list = new Node(new SpecialToken("("));
            root.setRightChild(virtual_list);
        	parseList(virtual_list, false);
        }
    	if (real) {
    		temp = scan.next();
    		if (temp.getLine() != lineNumber) {
            	System.out.println(currentLine);
//        		System.out.println(String.format("%-14s: %s", temp.getType(), temp.toString()));
            	lineNumber = temp.getLine();
            	currentLine = String.format("%02d: ", lineNumber);
            } else {
//        		System.out.println(String.format("%-14s: %s", temp.getType(), temp.toString()));
            }
            currentLine += " " + temp.toString();
    	}
    	
    	if (scoped) {
    		symtabs.pop();
    	}
    }
    
    public SymTabStack getStack() {
    	return symtabs;
    }
    
    public String toString() {
    	return head.print();
    }
    
    public Node getRoot() {
    	return head;
    }
}
