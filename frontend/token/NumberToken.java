package frontend.token;

import java.io.IOException;

import frontend.Source;

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
		if ((value == Math.floor(value)) && !Double.isInfinite(value)) {
		    return new Integer((int) (double) value);
		}
		return value;
	}
	
	public String toString() {
		if ((value == Math.floor(value)) && !Double.isInfinite(value)) {
		    return String.format("%.0f", value);
		}
		return "" + value;
	}
	
	public TokenType getType() {
		return TokenType.Number;
	}
}
