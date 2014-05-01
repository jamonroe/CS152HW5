import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import backend.Executor;
import frontend.Parser;
import frontend.Scanner;
import frontend.Source;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
            
        String src = "executor.lisp";
        Source source = new Source(new FileInputStream(new File(src)));
        Scanner scan = new Scanner(source);	
        Parser parser = new Parser(scan);
        
        Executor exe = new Executor(parser.getTable());

        System.out.println("**** Parser Results ****\n");
        while (parser.parse() != null) {
        	System.out.println("\n**** Execution Results ****");
            System.out.println(exe.execute(parser.getRoot()));
        	System.out.println();
            System.out.println("**** Symbol Table Entries ****\n");
            System.out.println(parser.getTable().toString());
            System.out.println("**** Parser Results ****\n");
        }
	}
}