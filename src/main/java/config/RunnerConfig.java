package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnerConfig {

	@Step
	public void setUpConfig() {
		Configuration.pageLoadTimeout = 20_000;
		Configuration.timeout = 10_000;
		Configuration.downloadsFolder = "target/build/downloads";
		Configuration.reportsFolder = "target/screenshots";
		Configuration.browser = "chrome";
		Configuration.browserVersion = "102";
		Configuration.remote = "http://localhost:4444/wd/hub";
		Configuration.browserCapabilities.setCapability("enableVNC", true);
		Configuration.browserCapabilities.setCapability("enableVideo", false);
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
	}
}
