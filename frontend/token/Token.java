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
}
