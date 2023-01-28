package testCase;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commonData.CommonFunctions;
import pageObjectModel.Login_pom;

public class Login_tc extends CommonFunctions{
	Logger logger=Logger.getLogger(CommonFunctions.class);
	@Test(priority =1)
	public void loginPage() throws InterruptedException {
		logger.info("Login to the application");
		testcase=extentReport.createTest("Login to the application");
		PageFactory.initElements(driver,Login_pom.class);
		Login_pom.username.sendKeys(properties.getProperty("Username"));
		Login_pom.password.sendKeys(properties.getProperty("Password"));
		Login_pom.getstarted.click();
		Thread.sleep(1000);
		String currentUrl="https://dev.viewandhire.com/dashboard";
		String expectedUrl=driver.getCurrentUrl();
		Thread.sleep(1000);

		if (currentUrl.equalsIgnoreCase(expectedUrl)) {
			testcase.log(Status.PASS,"Loggedin to VnH successfully");
			System.out.println("Pass");
			Thread.sleep(1000);
		}else {
			testcase.log(Status.FAIL,"Invalid credentials");
			System.out.println("Fail");	
		}
		Assert.assertEquals(currentUrl, expectedUrl);
		
} 
	/*@Test(priority = 1)
	public void login_InvalidCredentials() throws InterruptedException {
	logger.info("Login to the application 1");
	testcase=extentReport.createTest("Login to the application 1");
	PageFactory.initElements(driver,Login_pom.class);
	Login_pom.username.sendKeys(properties.getProperty("InvalidUsername"));
	Login_pom.password.sendKeys(properties.getProperty("InvalidPassword"));
	Login_pom.getstarted.click();
	String currentUrl1="https://dev.viewandhire.com/";
	String expectedUrl1=driver.getCurrentUrl();
	Thread.sleep(1000);
	if (currentUrl1.equalsIgnoreCase(expectedUrl1)) {
		testcase.log(Status.PASS,"Login not possible");
		System.out.println("Pass1");
		Thread.sleep(1000);
	}else {
		testcase.log(Status.FAIL,"Login possible");
		System.out.println("Fail1");	
	}
	Thread.sleep(3000);
	driver.navigate().refresh();
    Assert.assertEquals(currentUrl1, expectedUrl1);
	}*/
	/*TakesScreenshot screenshot=(TakesScreenshot) driver;
	File sourcefile= screenshot.getScreenshotAs(OutputType.FILE);
	File destintionFile=new File("D://sample.png");
	try {
		FileHandler.copy(sourcefile, destintionFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
}
