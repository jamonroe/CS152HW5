package frontend.token.jason;

import java.io.IOException;

import frontend.jason.Source;

public class BooleanToken extends Token {

	private Boolean value;
	
	public BooleanToken(Source src) throws IOException {
		switch (src.next()) {
		case 't': 
		case 'T': value = true;
				  break;
		case 'f':
		case 'F': value = false;
				  break;
		}
	}
	
	@Override
	public Object getValue() {
		return value;
	}

	public String toString() {
		if (value) {
			return super.toString() + "#t";
		}
		return super.toString() + "#f";
	}
	
	public TokenType getType() {
		return TokenType.Boolean;
	}
}
