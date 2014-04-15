package frontend.token;

public enum SpecialSymbol {
	EQ ("="),
	ADD ("+"),
	SUB ("-"),
	MUL ("*"),
	DIV ("/"),
	GT (">"),
	LT ("<"),
	GE (">="),
	LE ("<="),
	LPAREN ("("),
	RPAREN (")"),
	APOSTROPHE ("'");
	
	private String symbol;
	SpecialSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public static SpecialSymbol get(String symbol) {
		if (symbol.length() == 2) {
			// Assumes that the equals is there
			switch (symbol.charAt(0)) {
			case '<': return LE;
			case '>': return GE;
			}
		}
		switch (symbol.charAt(0)) {
		case '(': return LPAREN;
		case ')': return RPAREN;
		case '\'': return APOSTROPHE;
		case '=': return EQ;
		case '+': return ADD;
		case '-': return SUB;
		case '*': return MUL;
		case '/': return DIV;
		case '<': return LT;
		case '>': return GT;
		}
		return null;
	}
}
