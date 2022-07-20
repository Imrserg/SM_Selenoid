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

		final boolean modeDebug = true;

		Configuration.pageLoadTimeout = 20000;
		Configuration.timeout = 10000;
		Configuration.downloadsFolder = "target/build/downloads";
		Configuration.reportsFolder = "target/screenshots";
		Configuration.browser = browser;
		if (browserVersion != null) {
			Configuration.browserVersion = browserVersion;
		}
		if (!modeDebug) {
			Configuration.remote = "http://localhost:4444/wd/hub";
			Configuration.browserCapabilities.setCapability("enableVNC", true);
			Configuration.browserCapabilities.setCapability("enableVideo", false);
		}
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
				.screenshots(true)
				.savePageSource(true));
	}
}
