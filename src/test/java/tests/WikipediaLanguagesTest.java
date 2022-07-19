package tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import steps.CommonSteps;
import testData.Urls;

public class WikipediaLanguagesTest extends BasePage {

	@DataProvider
	public Object[][] languageCodes() {
		return new Object[][] {
				{"EN"}, {"JA"}, {"RU"}, {"IT"}, {"PT"}, {"ES"}, {"DE"}, {"ZH"}, {"FR"}, {"PL"}
		};
	}

	@BeforeMethod
	public void openMainPage() {
		Selenide.open(Urls.WIKIPEDIA_MAIN_PAGE.getUrl());
	}

	@Test (dataProvider = "languageCodes")
	public void checkLanguages(final String languageCode) {
		wikipediaMainPage.pressButtonWithLanguage(languageCode);
		CommonSteps.checkUrl("https://" + languageCode.toLowerCase() + ".wikipedia.org/wiki/", 5);
	}
}
