package intermediate;

import java.util.ListIterator;
import java.util.Stack;

public class SymTabStack extends Stack<SymTab> {
	
	public Object search(String key) {
		for (int i = size() - 1; i >= 0; i--) {
			if (get(i).containsKey(key))
				return get(i).get(key);
		}
		return null;
	}
	
	public Object searchLocal(String key) {
		if (firstElement().containsKey(key))
			return firstElement().get(key);
		return null;
	}
	
	public SymTab push() {
		return push(new SymTab(size()));
	}
	
	public SymTab pop() {
		return super.pop();
	}
	
	public String toString() {
		String result = "";
		ListIterator<SymTab> iterator = listIterator();
		while (iterator.hasNext())
			result += iterator.next().toString();
		return result;
	}
}
