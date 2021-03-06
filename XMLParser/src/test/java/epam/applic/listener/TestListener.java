package epam.applic.listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {
    final static Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult testResult) {
        logger.info("test " + testResult.getName() + " start");
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        logger.info("test [" + testResult.getName() + "] Success");
        logger.info(testResult.getTestClass().getName());
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        logger.error(testResult.getStatus() + "Test [" + testResult.getName() + "] failed");
        logger.error(testResult.getThrowable());
        logger.error("Priority of this method is " + testResult.getMethod().getPriority());
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        logger.warn(testResult.getStatus() + "test [" + testResult.getName() + "] skipped");
    }
}
