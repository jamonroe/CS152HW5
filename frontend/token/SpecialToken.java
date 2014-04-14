package frontend.token;

import java.io.IOException;

import frontend.Source;

public class SpecialToken extends Token {

	private SpecialSymbol symbol;
	private String value;
	
	public SpecialToken (Source src) throws IOException {
		String next = "" + src.next();
		if (src.peek() == '=')
			next += src.next();
		value = next;
		symbol = SpecialSymbol.get(next);
	}
	
	@Override
	public Object getValue() {
		if (symbol != null)
			return symbol;
		return value;
	}

	public String toString() {
		return value;
	}
	
	public TokenType getType() {
		return TokenType.Special;
	}
}
