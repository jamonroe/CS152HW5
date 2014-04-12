package frontend.token.jason;

import java.io.IOException;

import frontend.jason.Source;

public class NumberToken extends Token {

	private Double value;
	
	public NumberToken(Source src) throws IOException {
		String result = "";
		// consume digits
		do {
			result += src.next();
		} while (digit(src.peek()));
		// consume decimal
		if (src.peek() == '.') 
		{
			// consume digits
			do {
				result += src.next();
			} while (digit(src.peek()));
		}
		value = Double.parseDouble(result);
	}

	private boolean digit(char c) {
		if (c >= '0' && c <= '9') return true;
		return false;
	}
	
	@Override
	public Object getValue() {
		return value;
	}
	
	public String toString() {
		return "" + value;
	}
	
	public TokenType getType() {
		return TokenType.Number;
	}
}
