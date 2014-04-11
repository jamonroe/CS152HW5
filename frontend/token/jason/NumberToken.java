package frontend.token.jason;

import java.io.IOException;

import frontend.jason.Source;

public class NumberToken extends Token {

	private String value;
	
	public NumberToken(Source src) throws IOException {
		value = "";
		// consume digits
		do {
			value += src.next();
		} while (digit(src.peek()));
		// consume decimal
		if (src.peek() == '.') 
		{
			// consume digits
			do {
				value += src.next();
			} while (digit(src.peek()));
		}
	}

	private boolean digit(char c) {
		if (c >= '0' && c <= '9') return true;
		return false;
	}
	
	@Override
	public Object getValue() {
		return Double.parseDouble(value);
	}
}
