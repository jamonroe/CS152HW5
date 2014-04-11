package frontend.jason;

import java.io.IOException;
import java.io.InputStream;

public class Source {

	private int current;
	private InputStream stream;
	
	public Source(InputStream stream) throws IOException {
		current = stream.read();
		this.stream = stream;
	}
	
	public char next() throws IOException {
		char val = (char) current;
		current = stream.read();
		return val;
	}
	
	public char peek() {
		return (char) current;
	}
}
