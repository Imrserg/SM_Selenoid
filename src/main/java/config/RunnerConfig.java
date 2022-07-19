package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnerConfig {

	@Step
	public void setUpConfig(final String browser, final String browserVersion) {
		Configuration.pageLoadTimeout = 20000;
		Configuration.timeout = 10000;
		Configuration.downloadsFolder = "target/build/downloads";
		Configuration.reportsFolder = "target/screenshots";
		Configuration.browser = browser;
		if (browserVersion != null) {
			Configuration.browserVersion = browserVersion;
		}
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
				.screenshots(true)
				.savePageSource(true));
		log.info("ok");
	}
}
