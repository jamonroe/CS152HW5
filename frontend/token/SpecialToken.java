package frontend.token;

import java.io.IOException;

import frontend.Source;

public class SpecialToken extends Token {

	private SpecialSymbol symbol;
	private String value;
	
	public SpecialToken (Source src) throws IOException {
		value = "" + src.next();
		symbol = SpecialSymbol.toEnum(value);
	}
        
    public SpecialToken (String string) {
		value = string;
		symbol = SpecialSymbol.toEnum(string);
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

	@Override
	public SpecialToken clone() {
		return new SpecialToken(value);
	}
}
