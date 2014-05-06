package intermediate;

import java.util.Stack;

import frontend.token.Predefined;

public class RuntimeStack extends Stack<Record> {

	public static int STACK_MAX = 20;
	public Record[] display;
	
	public RuntimeStack() {
		display = new Record[STACK_MAX];
		push(0);
		for (Predefined p : Predefined.values()) {
			add(p.toString(), p);
		}
		push(1);
	}
	
	public Object search(String key) {
		int top = -1;
		for (int i = 0; i < STACK_MAX; i++) {
			if (display[i] == null) {
				top = i - 1;
				break;
			}
		}
		for (int i = top; i >= 0; i--) {
			if (display[i].containsKey(key)) {
				return display[i].get(key);
			}
		}
		return null;
	}
	
	public Object add(String key, Object value) {
		return peek().put(key, value);
	}
	
	public Record push(int level) {
		return display[level] = push(new Record(display[level], level));
	}
	
	public Record pop() {
		Record result = super.pop();
		display[result.getLevel()] = display[result.getLevel()].getPrevious();
		return result;
	}
}
