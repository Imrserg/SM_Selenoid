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
		Configuration.pageLoadTimeout = 50_000;
		Configuration.timeout = 50_000;
		Configuration.downloadsFolder = "target/build/downloads";
		Configuration.reportsFolder = "target/screenshots";
		Configuration.browser = "firefox";
		Configuration.baseUrl = "";
		//Configuration.browserVersion = "102";
		Configuration.remote = "http://34.77.150.104:4444/wd/hub"; //for run tests locally on remote
		//Configuration.remote = "http://localhost:4444/wd/hub"; //for local should be empty
		Configuration.browserCapabilities.setCapability("enableVNC", true);
		Configuration.browserCapabilities.setCapability("enableVideo", false);
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
	}
}
