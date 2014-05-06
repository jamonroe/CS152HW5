package frontend.token;

import java.io.IOException;

import frontend.Source;

public class WordToken extends Token {

	private Object value;
	private TokenType type;
	
	public WordToken(Source src) throws IOException {
		String value = "";
		do {
			value += src.next();
		} while (valid(value, src.peek()));

		type = TokenType.Identifier;
		
		// Is this a keyword?
		if (Keyword.toEnum(value) != null) {
			type = TokenType.Keyword;
			this.value = Keyword.toEnum(value);
		} else if (Predefined.toEnum(value) != null){
			this.value = Predefined.toEnum(value);
		} else {
			this.value = value;
		}
	}

	public WordToken(Object value, TokenType type) {
		this.value = value;
		this.type = type;
	}
	
	private boolean valid(String value, char c) {
		if (SpecialSymbol.toEnum("" + c) == null 
		&&	c != ' '
		&&  c != '\r'
		&&  c != '\n')
		{
			// # is a special symbol
			if (c == '#' && value.charAt(value.length() - 1) != '\\')
				return false;
			return true;
		}
		return false;
	}
	
	@Override
	public Object getValue() {
		return value;
	}
	
	public String toString() {
		return value.toString();
	}
	
	public TokenType getType() {
		return type;
	}

	@Override
	public WordToken clone() {
		return new WordToken(value, type);
	}
}
