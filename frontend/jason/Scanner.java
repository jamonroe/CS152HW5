package frontend.jason;

import java.io.IOException;

import frontend.token.jason.BooleanToken;
import frontend.token.jason.CharacterToken;
import frontend.token.jason.NumberToken;
import frontend.token.jason.SpecialToken;
import frontend.token.jason.StringToken;
import frontend.token.jason.Token;
import frontend.token.jason.WordToken;

public class Scanner {

	private Source src;
	
	public Scanner(Source src) {
		this.src = src;
	}
	
	public Token next() throws IOException {
		skipWhitespace();
		// Word Token
		if (isCharacter(src.peek())) 
		{
			return new WordToken(src);
		}
		// Number Token
		if (isDigit(src.peek()))
		{
			return new NumberToken(src);
		}
		// String Token
		if (src.peek() == '\"')
		{
			return new StringToken(src);
		}
		if (src.peek() == '#') 
		{
			// Consume #
			src.next();
			// Character Token
			if (src.peek() == '\\')
			{
				// Consume \
				src.next();
				return new CharacterToken(src);
			}
			if (src.peek() == 't' || 
				src.peek() == 'f' ||
				src.peek() == 'T' ||
				src.peek() == 'F')
			{
				return new BooleanToken(src);
			}
		}
		if (src.peek() != 65535)
			return new SpecialToken(src);
		return null;
	}
	
	public boolean isCharacter(char current) {
		if (current >= 'a' && current <= 'z') return true;
		if (current >= 'A' && current <= 'A') return true;
		return false;
	}
	
	public boolean isDigit(char current) {
		if (current >= '0' && current <= '9') return true;
		return false;
	}
	
	public void skipWhitespace() throws IOException {
		// skip spaces, carriage returns, and newlines
		while(src.peek() == ' '  ||
			  src.peek() == '\r' ||
			  src.peek() == '\n') 
		{
			src.next();
		}
		// skip comments
		if (src.peek() == ';') {
			while(src.next() != '\n') 
			{
				// do nothing until newline
			}
			// skip any additional whitespace
			skipWhitespace();
		}
	}
}
