package frontend.jason;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import frontend.token.jason.Token;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scan = new Scanner(new Source(new FileInputStream(new File("inputjason.txt"))));
		Token token;
		while ((token = scan.next()) != null)
			System.out.println(token);
	}
	
}
