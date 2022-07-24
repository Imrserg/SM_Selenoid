package tests;

import static steps.CommonSteps.clickTheElementByTagAndText;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import testData.Urls;

public class WikipediaClickableElementsTest extends BasePage {

	@BeforeMethod
	public void openMainPage() {
		Selenide.open(Urls.WIKIPEDIA_MAIN_PAGE.getUrl());
	}

	@Test (description = "Verify tag text")
	public void checkClickableElements() {
		wikipediaMainPage.pressButtonWithLanguage("RU");
		clickTheElementByTagAndText("span", "Содержание");
		clickTheElementByTagAndText("span", "Случайная статья");
		clickTheElementByTagAndText("span", "Форум");
		clickTheElementByTagAndText("span", "Заглавная страница");
		clickTheElementByTagAndText("span", "Обсуждение", 2);
	}
}
