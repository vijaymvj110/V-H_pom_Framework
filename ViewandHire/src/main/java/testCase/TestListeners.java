package testCase;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import commonData.CommonFunctions;

public class TestListeners extends CommonFunctions implements ITestListener{
Logger logger=Logger.getLogger(CommonFunctions.class);
//public static WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Testing the application");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Testing the application successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Testing the application failed");
		Calendar calendar=Calendar.getInstance();
		Date time=calendar.getTime();
		String timeStamp=time.toString().replace(":", "").replace(" ", "");
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File sourcefile= screenshot.getScreenshotAs(OutputType.FILE);
		File destintionFile=new File(".//Tests//Screenshots_"+timeStamp+".png");
		try {
			FileHandler.copy(sourcefile, destintionFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	/*File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(screenshot, new File("./Tests/Screenshots_"+timeStamp+".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Testing the application is skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Testing the application is started");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Testing the application is completed");	
	}

}
