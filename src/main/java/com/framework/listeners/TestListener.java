package com.framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.framework.reports.ExtentManager;
import com.framework.reports.ExtentTestManager;
import com.framework.utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {

		System.out.println("===== Test Suite Started =====");
	}

	@Override
	public void onTestStart(ITestResult result) {

		// System.out.println("STARTED : " + result.getName());

		ExtentTest test =

				ExtentManager.getInstance().createTest(result.getMethod().getMethodName());

		ExtentTestManager.setTest(test);

		ExtentTestManager.getTest().log(Status.INFO, "Test Started : " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// System.out.println("PASSED : " + result.getName());

		ExtentTestManager.getTest().pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		// System.out.println("FAILED : " + result.getName());

		// ScreenshotUtil.captureScreenshot(result.getName());

		ExtentTestManager.getTest().fail(result.getThrowable());

		// Optional screenshot attachment for UI tests
		/*
		 * String screenshotPath = ScreenshotUtil.capture( result.getMethod()
		 * .getMethodName());
		 * 
		 * ExtentTestManager .getTest() .addScreenCaptureFromPath( screenshotPath);
		 */

		/*
		 * String path =
		 * 
		 * ScreenshotUtil.captureScreenshot(result.getName());
		 * 
		 * ExtentTestManager.getTest()
		 * 
		 * .fail(result.getThrowable())
		 * 
		 * .addScreenCaptureFromPath(path);
		 */
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ExtentTestManager.getTest().skip("Test Skipped : " + result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {

		// System.out.println("Execution Completed");

		ExtentManager.getInstance().flush();

		System.out.println("===== Test Suite Finished =====");
	}
}
