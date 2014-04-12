package frontend.token.jason;

import java.io.IOException;

import frontend.jason.Source;

public class WordToken extends Token {

	private String value;
	private TokenType type;
	
	public WordToken(Source src) throws IOException {
		value = "";
		do {
			value += src.next();
		} while (valid(src.peek()));
		
		// Is this a keyword?
		try {
			Keyword.valueOf(value.toUpperCase());
			type = TokenType.Keyword;
		} catch (IllegalArgumentException e) {
			type = TokenType.Identifier;
		}
	}

	private boolean valid(char c) {
		if (c >= 'a' && c <= 'z') return true;
		if (c >= 'A' && c <= 'Z') return true;
		if (c >= '0' && c <= '9') return true;
		if (c == '-') return true;
		if (c == '?') return true;
		return false;
	}
	
	@Override
	public Object getValue() {
		if (type == TokenType.Keyword)
			return Keyword.valueOf(value.toUpperCase());
		return value;
	}
	
	public String toString() {
		return super.toString() + value;
	}
	
	public TokenType getType() {
		return type;
	}
}
