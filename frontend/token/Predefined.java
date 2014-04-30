package frontend.token;

/**
 * + - * /
 * null?
 * equal?
 * pair?
 * real?
 * integer?
 * symbol?
 * float?
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
	REAL ("real?"),
	INTEGER ("integer?"),
	SYMBOL ("symbol?"),
	FLOAT ("float?"),
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
