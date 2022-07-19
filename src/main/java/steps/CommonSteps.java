package steps;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

@Slf4j
public final class CommonSteps {

	@Step
	public static void clickTheElementByTagAndText(final String tag, final String text) {
		log.info("Check element text {}", text);
		Selenide.$(Selectors.byXpath("//" + tag + "[text()='" + text + "']")).click();
	}

	@Step
	public static void clickTheElementByTagAndText(final String tag, final String text, final int index) {
		log.info(text + " - Ok");
		Selenide.$(Selectors.byXpath("(//" + tag + "[text()='" + text + "'])[" + index + "]")).click();
	}

	@Step
	public static void checkUrl(final String mustContains, final int timeOut) {
		log.info("Check url");
		boolean conditionForUrl = false;
		for (int i = 0; i < timeOut * 2; i++) {
			if (WebDriverRunner.url().contains(mustContains)) {
				conditionForUrl = true;
				getAndAttachScreenshot();
				break;
			} else {
				Selenide.sleep(500);
			}
		}
		if (!conditionForUrl) {
			getAndAttachScreenshot();
			Assert.fail("Actual URL: " + WebDriverRunner.url() + "\n" + "Expected URL: " + mustContains);
		}
	}

	@SuppressWarnings ("UnusedReturnValue")
	@Attachment (value = "Screenshot", type = "image/png")
	public static byte[] getAndAttachScreenshot() {
		return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
	}
}
