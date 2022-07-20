package config;

import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Slf4j
public class RetryConfig implements IRetryAnalyzer {

	private int retryCount = 1;

	@Override
	public boolean retry(final ITestResult result) {
		final int maxRetryCount = 1;
		if (retryCount <= maxRetryCount) {
			if (result.getStatus() == 2) {
				log.info("Retrying test: " + result.getName());
				retryCount++;
				return true;
			}
		}
		return false;
	}

}
