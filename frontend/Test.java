package frontend;

import intermediate.Node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
            
            String src = "input.txt";
            Source source = new Source(new FileInputStream(new File(src)));
            source = new Source(new FileInputStream(new File(src)));
            Scanner scan = new Scanner(source);	
            
            Node node;
            Parser parser = new Parser(scan);
            while ((node = parser.parse()) != null) {
            	System.out.println(node.print());
            }
            
//            System.out.println(parser.getTable().toString());
	}
}