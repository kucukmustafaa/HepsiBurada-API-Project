package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentReportManager.flushReport();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
       ExtentReportManager.createExtentTest(getTestMethodName(iTestResult));
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
       ExtentReportManager.getExtentTest().pass(getTestMethodName(iTestResult)+" test complete.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
       ExtentReportManager.getExtentTest().fail(getTestMethodName(iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
      //  ExtentReportManager.getExtentTest().skip(getTestMethodName(iTestResult)+" test skipped");
    }



}
