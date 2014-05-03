package frontend.token;

public enum Keyword {
	AND ("AND"),
	APPEND ("APPEND"),
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
	CONS ("CONS"),
	
	CAR ("CAR"),
	CDR ("CDR"),
	CAAR ("CAAR"),
	CADR ("CADR"),
	CDAR ("CDAR"),
	CDDR ("CDDR"),
	CAAAR ("CAAAR"),
	CAADR ("CAADR"),
	CADAR ("CADAR"),
	CADDR ("CADDR"),
	CDAAR ("CDAAR"),
	CDADR ("CDADR"),
	CDDAR ("CDDAR"),
	CDDDR ("CDDDR"),
	CAAAAR ("CAAAAR"),
	CAAADR ("CAAADR"),
	CAADAR ("CAADAR"),
	CAADDR ("CAADDR"),
	CADAAR ("CADAAR"),
	CADADR ("CADADR"),
	CADDAR ("CADDAR"),
	CADDDR ("CADDDR"),
	CDAAAR ("CDAAAR"),
	CDAADR ("CDAADR"),
	CDADAR ("CDADAR"),
	CDADDR ("CDADDR"),
	CDDAAR ("CDDAAR"),
	CDDADR ("CDDADR"),
	CDDDAR ("CDDDAR"),
	CDDDDR ("CDDDDR");
	
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
	
	public boolean listOp() {
		return ordinal() >= CAR.ordinal();
	}
}
