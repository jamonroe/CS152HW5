package frontend;

import frontend.token.SpecialToken;
import frontend.token.Token;
import intermediate.Node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
            
            String src = "input.txt";	
            Scanner scan = new Scanner(new Source(new FileInputStream(new File(src))));
            /*
            Root

			L: (
			LL: a
			LR: (
			LRL: b
			
			R: (
			RL: c
			
			((a b) c)
			*/
            
            Node head = new Node(new SpecialToken("("));
            Node L = head.setLeftChild(new Node(new SpecialToken("(")));
            Node LL = L.setLeftChild(new Node(new SpecialToken("a")));
            Node LR = L.setRightChild(new Node(new SpecialToken("(")));
            Node LRL = LR.setLeftChild(new Node(new SpecialToken("b")));

            Node R = head.setRightChild(new Node(new SpecialToken("(")));
            Node RL = R.setLeftChild(new Node(new SpecialToken("c")));
            
            head.print();
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