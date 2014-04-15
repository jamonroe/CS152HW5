package frontend.jason;

import frontend.jason.Parser.Node;

import frontend.token.jason.Token;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
            
            String src = "input.txt";	
            Scanner scan = new Scanner(new Source(new FileInputStream(new File(src))));
            
            Node[] nodeArray = new Node[3];
            Parser parser = new Parser(scan);
            Node temp;
            
            int i = 0;
            while((temp = parser.parse()) != null) 
            {
                nodeArray[i] = temp;
                nodeArray[i].print(nodeArray[i]);
                i++;
            }
            
            
            
            
            
	}
}
//
//Scanner scan = new Scanner(new Source(new FileInputStream(new File(inSrc))));
//        int line = scan.getLine();
//        Token token;
//        String tokenresults = "";
//        String lineresults = "";
//        while ((token = scan.next()) != null) {
//            if (scan.getLine() != line) {
////                System.out.println(lineresults);
////                System.out.println(tokenresults);
//
//                line = scan.getLine();
//                //lineresults = "";
//              //  tokenresults = "";
//            }
//
//            //lineresults += token + " ";
//           // tokenresults += line + ": " + token.getType() + ": " + token + " == " + token.getValue() + "\n";
//        }