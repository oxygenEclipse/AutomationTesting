package testScripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerExample implements IRetryAnalyzer {
	int c = 0;
	int limit = 3;

	public boolean retry(ITestResult result) {
		if (c < limit) {
			c++;
			return true;
		}
		return false;

	}

}
