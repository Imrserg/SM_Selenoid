package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import config.RetryConfig;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {
	public void transform(final ITestAnnotation annotation, final Class testClass, final Constructor testConstructor, final Method testMethod) {
		final Class<? extends IRetryAnalyzer> analyzer = annotation.getRetryAnalyzerClass();
		if (analyzer != null) {
			annotation.setRetryAnalyzer(RetryConfig.class);
		}
	}
}
