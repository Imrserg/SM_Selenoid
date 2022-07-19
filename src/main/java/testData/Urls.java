package testData;

public enum Urls {

	WIKIPEDIA_MAIN_PAGE("https://www.wikipedia.org/");

	private final String url;

	Urls(final String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
