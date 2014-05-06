package intermediate;

import java.util.HashMap;
import java.util.Set;

import frontend.token.Predefined;

public class SymTab extends HashMap<String, Object> {
	
	private int level;
	
	public SymTab(int level) {
		this.setLevel(level);
	}
	
	public SymTab initPredefined() {
		for (Predefined p : Predefined.values()) {
			put(p.toString(), p);
		}
		return this;
	}
	
	public String toString() {
		String result = "Level: " + level + "\n";
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
