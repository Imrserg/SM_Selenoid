package pages;

import config.RunnerConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BasePage {

	private final RunnerConfig config = new RunnerConfig();

	public WikipediaMainPage wikipediaMainPage = new WikipediaMainPage();

	@BeforeClass
	@Parameters ( {"browser", "browserVersion"})
	public void setUp(@Optional ("chrome") final String browser, @Optional ("102") final String browserVersion) {
		config.setUpConfig(browser, browserVersion);
	}
}
