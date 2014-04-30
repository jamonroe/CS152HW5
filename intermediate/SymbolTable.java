package intermediate;

import java.util.HashMap;
import java.util.Set;

import frontend.token.Predefined;

public class SymbolTable extends HashMap<String, Object> {
	
	public SymbolTable initPredefined() {
		for (Predefined p : Predefined.values()) {
			put(p.toString(), p);
		}
		return this;
	}
	
	public String toString() {
		String result = "";
//		symbolTable.
		Set<String> list = keySet();
		for (String t : list) {
			// Hard coded special print for predefined values
			if (get(t) instanceof Predefined)
				result += String.format("%15s: %s\n", t, ((Predefined)get(t)).name());
			else
				result += String.format("%15s: %s\n", t, get(t));
		}
		return result;
	}
}
