package frontend.token;

import java.io.IOException;

import frontend.Source;

public class CharacterToken extends Token {

	private Character value;
	
	public CharacterToken(Source src) throws IOException {
		value = src.next();
	}
	
	@Override
	public Object getValue() {
		return value;
	}

	public String toString() {
		return "#\\" + value;
	}
	
	public TokenType getType() {
		return TokenType.Character;
	}
}