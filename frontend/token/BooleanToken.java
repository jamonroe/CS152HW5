package frontend.token;

import java.io.IOException;

import frontend.Source;

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
			return "#t";
		}
		return "#f";
	}
	
	public TokenType getType() {
		return TokenType.Boolean;
	}
}
