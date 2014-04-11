package frontend.token.jason;

public abstract class Token {
	public abstract Object getValue();
	public String toString() {
		return this.getClass().getSimpleName() + ": " + getValue();
	}
}
