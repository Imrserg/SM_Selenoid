package listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class CustomListener implements ITestListener {

	@Override
	public void onTestStart(final ITestResult result) {
		log.info("Test case: " + result.getName());
	}

	@Override
	public void onTestSuccess(final ITestResult result) {
		log.info("Test passed" + "\n");
	}

	@Override
	public void onTestFailure(final ITestResult result) {
		log.info("Test failed!");
		log.info(result.getThrowable().getMessage() + "\n");
	}

	@Override
	public void onTestSkipped(final ITestResult result) {
		log.info("Test was skipped!");
		log.info(result.getThrowable().getMessage() + "\n");
	}

	@Override
	public void onStart(final ITestContext context) {
	}

	@Override
	public void onFinish(final ITestContext context) {
	}
}
