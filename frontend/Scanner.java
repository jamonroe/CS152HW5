package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.FileInputStream;

public class Scanner {

	public static void main(String[] args) {

		InputStreamReader reader = null;

		try {
			reader = new InputStreamReader(new FileInputStream("input.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}

		StreamTokenizer tokens = new StreamTokenizer(reader);
		tokens.commentChar(';');
		tokens.eolIsSignificant(true);

		int current;
		String line = "";
		
		try {
			while ((current = tokens.nextToken()) != StreamTokenizer.TT_EOF) {
				
				// Returns the next word
				if (current == StreamTokenizer.TT_WORD){
					System.out.println(tokens.sval + "\t:Keyword");
					line += tokens.sval + " ";
					// TODO check if valid keyword/identifier
				}
				
				// Returns the next number
				else if (current == StreamTokenizer.TT_NUMBER){
					System.out.println(tokens.nval + "\t:Number");
					line += tokens.nval + " ";
				}
				
				// Returns the next string literal
				else if (current == '"'){
					System.out.println(tokens.sval + "\t:String Literal");
					line += tokens.sval + " ";
				}
				
				// If end of line, print the line
				else if (current == StreamTokenizer.TT_EOL){
					System.out.println("Line: " + line + "\n");
					line = " ";
				}

				// If anything else, it's counted as a special character
				else{
					System.out.println((char) current + "\t:Special Symbol");
					line += (char) current;
				}
			}
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		}
	}
}
