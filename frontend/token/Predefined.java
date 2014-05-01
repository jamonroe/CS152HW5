package frontend.token;

import java.util.Arrays;
import java.util.List;

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
	EQUAL ("="),
	PAIR ("pair?"),
	INTEGER ("integer?"),
	SYMBOL ("symbol?"),
	REAL ("real?"),
	BOOLEAN ("boolean?"),
	CHAR ("char?"),
	STRING ("string?");
	
	private String value;
	private List<String> values;
	
	Predefined(String value) {
		this.value = value;
	}
	
	Predefined(String ...values) {
		this.values = Arrays.asList(values);
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
