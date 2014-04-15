package frontend;

import java.io.IOException;

import frontend.token.BooleanToken;
import frontend.token.CharacterToken;
import frontend.token.NumberToken;
import frontend.token.SpecialToken;
import frontend.token.StringToken;
import frontend.token.Token;
import frontend.token.WordToken;

public class Scanner {

	private Source src;
	private int line;
	
	public Scanner(Source src) {
		line = 1;
		this.src = src;
	}
	
	public Token next() throws IOException {
		skipWhitespace();
		// Word Token
		if (isCharacter(src.peek())) 
		{
			return new WordToken(src).setLine(line);
		}
		// Number Token
		if (isDigit(src.peek()))
		{
			return new NumberToken(src).setLine(line);
		}
		// String Token
		if (src.peek() == '\"')
		{
			return new StringToken(src).setLine(line);
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
				return new CharacterToken(src).setLine(line);
			}
			if (src.peek() == 't' || 
				src.peek() == 'f' ||
				src.peek() == 'T' ||
				src.peek() == 'F')
			{
				return new BooleanToken(src).setLine(line);
			}
		}
		if (src.peek() != 65535)
			return new SpecialToken(src).setLine(line);
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
			if (src.peek() == '\n')
				line++;
			src.next();
		}
		// skip comments
		if (src.peek() == ';') {
			while(src.next() != '\n') 
			{
				// do nothing until newline
			}
			line++;
			// skip any additional whitespace
			skipWhitespace();
		}
	}
	
	public int getLine() {
		return line;
	}
        
        public char sPeek() {
            return src.peek();
        }
}
