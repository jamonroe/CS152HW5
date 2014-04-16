package frontend.token;

import java.io.IOException;

import frontend.Source;

public class WordToken extends Token {

	private String value;
	private TokenType type;
	
	public WordToken(Source src) throws IOException {
		value = "";
		do {
			value += src.next();
		} while (valid(src.peek()));
		
		// Is this a keyword?
		if (Keyword.toEnum(value) != null) {
			type = TokenType.Keyword;
		} else {
			type = TokenType.Identifier;
		}
	}

	private boolean valid(char c) {
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
		if (type == TokenType.Keyword)
			return Keyword.toEnum(value);
		return value;
	}
	
	public String toString() {
		return value;
	}
	
	public TokenType getType() {
		return type;
	}
}
