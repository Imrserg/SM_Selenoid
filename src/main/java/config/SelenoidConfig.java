package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeOptions;

@Slf4j
public class SelenoidConfig {

	public void createWebDriverInstance(String browser) {
		final String chrome = "Chrome";
		//final String browser2 = System.getenv("BROWSER");
		if (browser.equals("${BROWSER}")) {
			browser = chrome;
		}
		if (browser.equals(chrome)) {
			final ChromeOptions options = new ChromeOptions();

			options.addArguments("--disable-notifications");
			Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
			Configuration.browserVersion = "102";
		}
		Configuration.driverManagerEnabled = false;
		Configuration.browser = browser;
		Configuration.remote = "http://34.77.150.104:4444/wd/hub";
		Configuration.timeout = 30_000;
		Configuration.reportsFolder = "target/screenshots";
		Configuration.clickViaJs = true;
		Configuration.browserCapabilities.setCapability("enableVNC", true);
		Configuration.browserCapabilities.setCapability("enableVideo", false);
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
		//WebDriverManager.chromedriver().setup();
		log.info("Browser {} instance is ready to working", browser);
	}
}
