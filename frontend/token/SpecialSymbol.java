package frontend.token;

public enum SpecialSymbol {
	LPAREN ("("),
	RPAREN (")"),
	APOSTROPHE ("'");
	
	private String value;
	SpecialSymbol(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
	public static SpecialSymbol toEnum(String value) {
		for (SpecialSymbol symbol : SpecialSymbol.values())
			if (value.equalsIgnoreCase(value.toString()))
				return symbol;
		return null;
	}
}
