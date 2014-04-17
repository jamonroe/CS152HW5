package intermediate;

import java.util.HashMap;
import java.util.Set;

public class SymbolTable {

	private HashMap<String, String> symbolTable;
	
	/**
	 * Constructs the symbol table using a hash map
	 */
	public SymbolTable(){
		this.symbolTable = new HashMap<String, String>();
	}
	
	/**
	  * Adds a key and its value to the symbol table 
	  * @param token the identifier or operator
	  * @param value the value of the token
	 */
	public void put(String token, String value){
		symbolTable.put(token, value);
	}
	
	/**
	  * Returns the current symbol table
	  * @return a hash map containing the symbols
	 */
	public HashMap<String, String> getSymbolTable(){
		return symbolTable;
	}
	
	public String toString() {
		String result = "";
//		symbolTable.
		Set<String> list = symbolTable.keySet();
		for (String t : list) {
			result += t + "\n";
		}
		return result;
	}
}
