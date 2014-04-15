package frontend.token;

import java.io.IOException;

import frontend.Source;

public class StringToken extends Token {

	private String value;
	
	public StringToken(Source src) throws IOException {
		value = "";
		// Skip first quote
		char next = src.next();
		while ((next = src.next()) != '\"')
		{
			value += next;
		} 
	}
	
	@Override
	public Object getValue() {
		return value;
	}

	public String toString() {
		return "\"" + value + "\"";
	}
	
	public TokenType getType() {
		return TokenType.String;
	}
}
