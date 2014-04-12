package frontend.token.jason;

public abstract class Token {
	public abstract Object getValue();
	public abstract TokenType getType();
	public String toString() {
		return getType() + ": ";
	}
}
