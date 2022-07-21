package pages;

import config.RunnerConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BasePage {

	private final RunnerConfig config = new RunnerConfig();

	public WikipediaMainPage wikipediaMainPage = new WikipediaMainPage();

	@BeforeClass
	//@Parameters ( {"browser", "browserVersion"})
	// ("chrome") final String browser, @Optional final String browserVersion
	public void setUp() {
		config.setUpConfig();
	}
}
