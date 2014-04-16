package frontend.token;

public enum Keyword {
	AND ("AND"),
	BEGIN ("BEGIN"),
	COND ("COND"),
	DEFINE ("DEFINE"),
	ELSE ("ELSE"),
	IF ("IF"),
	LAMBDA ("LAMBDA"),
	LET ("LET"),
	LETSTAR ("LET*"),
	LETREC ("LETREC"),
	NOT ("NOT"),
	OR ("OR"),
	QUOTE ("QUOTE"),
	CONS ("CONS");
	
	private String value;
	
	Keyword(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
	public static Keyword toEnum(String value) {
		for (Keyword word : Keyword.values())
			if (value.equalsIgnoreCase(word.toString()))
				return word;
		return null;
	}
}
