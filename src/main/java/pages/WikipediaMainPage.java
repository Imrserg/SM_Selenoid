package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

@Slf4j
public class WikipediaMainPage {

	@Step ("Press button with language {0}")
	public void pressButtonWithLanguage(final String countryCode) {
		log.info("Press button with language {}", countryCode);
		Selenide.$(Selectors.byXpath("//a[@class='link-box']//strong[text()='" + transformCountryCodeToLanguage(countryCode) + "']")).click();
	}

	@Step ("Transform Country Code To Language")
	public String transformCountryCodeToLanguage(final String countryCode) {
		switch (countryCode) {
			case "EN":
				return "English";
			case "JA":
				return "日本語";
			case "RU":
				return "Русский";
			case "IT":
				return "Italiano";
			case "PT":
				return "Português";
			case "ES":
				return "Español";
			case "DE":
				return "Deutsch";
			case "ZH":
				return "中文";
			case "FR":
				return "Français";
			case "PL":
				return "Polski";
			default:
				Assert.fail("Country code " + countryCode + " not found!");
		}
		return null;
	}
}
