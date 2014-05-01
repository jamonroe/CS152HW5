package frontend.token;

/**
 * + - * /
 * null?
 * equal?
 * pair?
 * integer?
 * symbol?
 * real?
 * boolean?
 * char?
 * string?
 * 
 * @author Jason
 */
public enum Predefined {
	ADD ("+"),
	SUBTRACT ("-"),
	MULTIPLY ("*"),
	DIVIDE ("/"),
	NULL ("null?"),
	EQUAL ("equal?"),
	PAIR ("pair?"),
	INTEGER ("integer?"),
	SYMBOL ("symbol?"),
	REAL ("real?"),
	BOOLEAN ("boolean?"),
	CHAR ("char?"),
	STRING ("string?");
	
	private String value;
	
	Predefined(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
	public static Predefined toEnum(String value) {
		for (Predefined symbol : Predefined.values())
			if (value.equalsIgnoreCase(symbol.toString()))
				return symbol;
		return null;
	}
}
