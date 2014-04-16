package frontend.token;

/**
 * ( ) [ ] " , ' ` ; # | \
 * 
 * @author Jason
 */
public enum SpecialSymbol {
	LPAREN ("("),
	RPAREN (")"),
	LBRACKET ("["),
	RBRACKET ("]"),
	QUOTE ("\""),
	COMMA (","),
	APOSTROPHE ("'"),
	TILDE ("`"),
	SEMICOLON (";"),
	POUND ("#"),
	BAR ("|"),
	BACKSLASH ("\\");
	
	private String value;
	
	SpecialSymbol(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
	public static SpecialSymbol toEnum(String value) {
		for (SpecialSymbol symbol : SpecialSymbol.values())
			if (value.equalsIgnoreCase(symbol.toString()))
				return symbol;
		return null;
	}
}
