package frontend;

import java.io.IOException;

import frontend.token.BooleanToken;
import frontend.token.CharacterToken;
import frontend.token.NumberToken;
import frontend.token.SpecialSymbol;
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
		char peek = src.peek();
		Token result;
		
		// Character or Boolean
		if (peek == '#') 
		{
			// Consume #
			src.next();
			peek = src.peek();
			// Character Token
			if (peek == '\\')
			{
				// Consume \
				src.next();
				result = new CharacterToken(src).setLine(line);
				System.out.println(String.format("%s: %s", result.getType(), result.toString()));
				return result;
			}
			if (peek == 't' || 
				peek == 'f' ||
				peek == 'T' ||
				peek == 'F')
			{
				result = new BooleanToken(src).setLine(line);
				System.out.println(String.format("%s: %s", result.getType(), result.toString()));
				return result;
			}
		} else
		
		// Special Symbol
		if (SpecialSymbol.toEnum("" + peek) != null) {
			result = new SpecialToken(src).setLine(line);
			System.out.println(String.format("%s: %s", result.getType(), result.toString()));
			return result;
		} else
		
		// Number Token
		if (isDigit(peek))
		{
			result = new NumberToken(src).setLine(line);
			System.out.println(String.format("%s: %s", result.getType(), result.toString()));
			return result;
		} else
		
		// String Token
		if (peek == '\"')
		{
			result = new StringToken(src).setLine(line);
			System.out.println(String.format("%s: %s", result.getType(), result.toString()));
			return result;
		} else
		
		// Word Token
		if (peek != 65535) {
			result = new WordToken(src).setLine(line);
			System.out.println(String.format("%s: %s", result.getType(), result.toString()));
			return result;
		}
		
		// End of file
		return null;
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
				if (src.peek() == 65535)
					return;
			}
			line++;
			// skip any additional whitespace
			skipWhitespace();
		}
	}
	
	public int getLine() {
		return line;
	}
        
    public char peek() {
    	try {
    		skipWhitespace();
    	} catch (IOException e) {
    		
    	}
        return src.peek();
    }
}
