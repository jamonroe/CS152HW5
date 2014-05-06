package frontend.token;

public abstract class Token {
	private int line;
	public abstract Object getValue();
	public abstract TokenType getType();
	public Token setLine(int line) {
		this.line = line;
		return this;
	}
	public int getLine() {
		return line;
	}
	public boolean equals(Object object) {
		if (!(object instanceof Token))
			return false;
		Token token = (Token) object;
		if (getType() != token.getType())
			return false;
		if (!getValue().toString().equalsIgnoreCase(token.getValue().toString()))
			return false;
		return true;
	}
	public abstract Token clone();
}
