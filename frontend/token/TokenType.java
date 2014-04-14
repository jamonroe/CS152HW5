package frontend.token;

public enum TokenType {
	Boolean ("Boolean"),
	Character ("Character"),
	Number ("Number"),
	String ("String"),
	Keyword ("Keyword"),
	Special ("Special Token"),
	Identifier ("Identifier");
	
	private String name;
	TokenType(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
