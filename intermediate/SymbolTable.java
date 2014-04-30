package intermediate;

import java.util.HashMap;
import java.util.Set;

public class SymbolTable extends HashMap<String, Object> {
	
	public String toString() {
		String result = "";
//		symbolTable.
		Set<String> list = keySet();
		for (String t : list) {
			result += t + ": " + get(t) + "\n";
		}
		return result;
	}
}
