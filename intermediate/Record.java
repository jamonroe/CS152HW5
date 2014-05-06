package intermediate;

import java.util.HashMap;

public class Record extends HashMap<String, Object> {

	private Record previous;
	private int level;
	
	public Record(Record previous, int level) {
		this.previous = previous;
		this.setLevel(level);
	}

	public Record getPrevious() {
		return previous;
	}

	public void setPrevious(Record previous) {
		this.previous = previous;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
