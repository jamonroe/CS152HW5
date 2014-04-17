import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import frontend.Parser;
import frontend.Scanner;
import frontend.Source;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
            
		
		
        String src = "input.lisp";
        Source source = new Source(new FileInputStream(new File(src)));
        Scanner scan = new Scanner(source);	
        Parser parser = new Parser(scan);
        
        System.out.println("**** Scanner Results ****\n");
        
        while (parser.parse() != null) {
        	System.out.println();
        }
        
        System.out.println("**** Symbol Table Entries ****\n");
        System.out.println(parser.getTable().toString());
	}
}