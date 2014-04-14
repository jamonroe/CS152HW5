package frontend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import frontend.token.Token;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scan = new Scanner(new Source(new FileInputStream(new File("input.txt"))));
		int line = scan.getLine();
		Token token;
		String tokenresults = "";
		String lineresults = "";
		while ((token = scan.next()) != null)
		{
			if (scan.getLine() != line)
			{
				System.out.println(lineresults);
				System.out.println(tokenresults);
				line = scan.getLine();
				lineresults = "";
				tokenresults = "";
			}
			lineresults += token + " ";
			tokenresults += line + ": " + token.getType() + ": " + token + " == " + token.getValue() + "\n";
		}
		System.out.println(lineresults);
		System.out.println(tokenresults);
	}
}
