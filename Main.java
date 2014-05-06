import intermediate.RuntimeStack;

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

		if (args.length == 0) {
			System.out.println("Please pass the lisp file as a parameter");
			return;
		}
		
		String src = args[0];
		
        Source source = new Source(new FileInputStream(new File(src)));
        Scanner scan = new Scanner(source);	
        Parser parser = new Parser(scan);
        Executor exe = new Executor(parser.getStack(), new RuntimeStack());

        Object result;
        while (parser.parse() != null) {
        	result = exe.execute(parser.getRoot());
        	if (result != null) {
            	System.out.println("\n**** Execution Results ****\n");
        		System.out.println(exe.execute(parser.getRoot()));
        	}
        }
	}
}
