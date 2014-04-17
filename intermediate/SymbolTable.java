package intermediate;

import java.util.HashMap;

import frontend.token.Token;

public class SymbolTable {

	private HashMap<Token, String> symbolTable;
	
	/**
	 * Constructs the symbol table using a hash map
	 */
	public SymbolTable(){
		this.symbolTable = new HashMap<Token, String>();
	}
	
	/**
	  * Adds a key and its value to the symbol table 
	  * @param token the identifier or operator
	  * @param value the value of the token
	 */
	public void put(Token token, String value){
		symbolTable.put(token, value);
	}
	
	/**
	  * Returns the current symbol table
	  * @return a hash map containing the symbols
	 */
	public HashMap<Token, String> getSymbolTable(){
		return symbolTable;
	}
	
}
