package frontend;

import intermediate.Node;
import intermediate.SymbolTable;
import frontend.token.SpecialSymbol;
import static frontend.token.SpecialSymbol.LPAREN;
import static frontend.token.SpecialSymbol.RPAREN;
import frontend.token.SpecialToken;
import frontend.token.Token;
import frontend.token.TokenType;

import java.io.IOException;

public class Parser {

	SymbolTable symtab;
	String src;
    Scanner scan;
    Node head;
    String currentLine;
    int lineNumber;

    public Parser(Scanner scan) throws IOException {
        this.scan = scan;
        symtab = new SymbolTable().initPredefined();
    }

    public Node parse() throws IOException {
        Token token = scan.next(); // LPAREN
        
        if (token != null && token.getValue() == SpecialSymbol.LPAREN) {
        	lineNumber = token.getLine();
            currentLine = String.format("%02d: ", lineNumber) + token.toString();
    		// Print first parenthesis
            System.out.println(String.format("%-14s: %s", token.getType(), token.toString()));
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
    	if((temp = scan.next()) == null) return;
        Node car = new Node(temp); 

        if (temp.getLine() != lineNumber) {
        	System.out.println(currentLine + "\n");
    		System.out.println(String.format("%-14s: %s", temp.getType(), temp.toString()));
        	lineNumber = temp.getLine();
        	currentLine = String.format("%02d: ", lineNumber);
        } else {
    		System.out.println(String.format("%-14s: %s", temp.getType(), temp.toString()));
        }
        currentLine += " " + temp.toString();
        
        // Add identifiers to symbol table
        if (car.getToken().getType() == TokenType.Identifier){
        	if (symtab.get(car.getTokenValue().toString()) == null)
        		symtab.put(car.getTokenValue().toString(), null);        	
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
            	System.out.println(currentLine + "\n");
        		System.out.println(String.format("%-14s: %s", temp.getType(), temp.toString()));
            	lineNumber = temp.getLine();
            	currentLine = String.format("%02d: ", lineNumber);
            } else {
        		System.out.println(String.format("%-14s: %s", temp.getType(), temp.toString()));
            }
            currentLine += " " + temp.toString();
    	}
    }
    
    public SymbolTable getTable() {
    	return symtab;
    }
    
    public String toString() {
    	return head.print();
    }
    
    public Node getRoot() {
    	return head;
    }
}
