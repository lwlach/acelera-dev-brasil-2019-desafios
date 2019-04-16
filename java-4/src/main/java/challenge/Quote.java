package challenge;

public class Quote {

	private String actor;

	private String quote;

	public Quote() {
	}

	public Quote(String actor, String quote) {
		this.actor = actor;
		this.quote = quote;
	}

	public String getActor() {
		return actor;
	}

	public String getQuote() {
		return quote;
	}

	public String toJson() {
		return "{" +
				"\"actor\": \"" + actor + '"' +
				", \"quote\": \"" + quote + '"' +
				'}';
	}
}
