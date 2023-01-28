package testCase;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commonData.CommonFunctions;
import pageObjectModel.Setting_pom;
public class Setting_tc extends CommonFunctions {
	Logger logger=Logger.getLogger(CommonFunctions.class);
    @Test(priority = 1)
	public void OrganizationRegister() throws InterruptedException {
    	logger.info("Registeration of organization");
    	testcase=extentReport.createTest("Open the Organization register");
    	PageFactory.initElements(driver, Setting_pom.class);
    	Setting_pom.SettingTab.click();
    	Setting_pom.OrganizationTab.click();
    	Setting_pom.AddOrganization.click();
    	Setting_pom.OrganizationName.sendKeys("JeanMartin Madurai");
    	Setting_pom.Address1.sendKeys("8 th cross street,ganapathy Avenue");
    	Setting_pom.Address2.sendKeys("Gomathiyapuram");
    	Setting_pom.City.sendKeys("Madurai");
    	Setting_pom.State.sendKeys("Tamilnadu");
    	Select select=new Select(Setting_pom.Country);
    	select.selectByIndex(1);
    	Setting_pom.Zipcode.sendKeys("600500");
    	//JavascriptExecutor executor2=(JavascriptExecutor)driver;
		//executor2.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
    	Setting_pom.OrganizationSave.click();
    	String currentUrl1="https://dev.viewandhire.com/organizationList";
    	String expectedUrl1=driver.getCurrentUrl();
    	Thread.sleep(1000);
    	if (currentUrl1.equalsIgnoreCase(expectedUrl1)) {
    		testcase.log(Status.PASS,"Organization registered succesfully");
    	}else {
    		testcase.log(Status.FAIL,"Organization not registered");
    	}
        Assert.assertEquals(currentUrl1, expectedUrl1);
    	Thread.sleep(2000);
	}
    @Test(priority = 2)
     public void JobCategoryRegister() throws InterruptedException {
    	logger.info("Registeration of job category");
    	testcase=extentReport.createTest("Open the Job category register");
    	PageFactory.initElements(driver, Setting_pom.class);
    	 Setting_pom.JobCategory.click();
    	 Setting_pom.AddJobCategoryButton.click();
    	 Setting_pom.JobCategoryName.sendKeys("Web Technologies");
    	 Thread.sleep(2000);
    	 Setting_pom.SaveJobCategory.click();
    	 String currentUrl1="https://dev.viewandhire.com/jobcategoryList";
     	String expectedUrl1=driver.getCurrentUrl();
     	Thread.sleep(1000);
     	if (currentUrl1.equalsIgnoreCase(expectedUrl1)) {
     		testcase.log(Status.PASS,"Job category registered succesfully");
     	}else {
     		testcase.log(Status.FAIL,"Job category not registered");
     	}
         Assert.assertEquals(currentUrl1, expectedUrl1);
     	Thread.sleep(2000);
     }
    @Test(priority = 3)
     public void Skills() throws InterruptedException {
    	logger.info("Registeration of major and sub skills");
    	testcase=extentReport.createTest("Open the Skill register");
    	PageFactory.initElements(driver, Setting_pom.class);
   Setting_pom.SkillsTab.click();
   Setting_pom.AddMajorSkills.click();
   Setting_pom.MajorSkillName.sendKeys("Automation Testing");
   Setting_pom.MajorSkillSave.click();
   Thread.sleep(1000);
   Setting_pom.AddSubSkillButton.click();
   Select majorSkillDropdown=new Select(Setting_pom.MajorSkillSelection);
   majorSkillDropdown.selectByVisibleText("Database");
   Setting_pom.EnterSubSkill.sendKeys("MS SQL");
   Setting_pom.SaveSubSkill.click();
   Thread.sleep(1000);
   String currentUrl1="https://dev.viewandhire.com/skillList";
	String expectedUrl1=driver.getCurrentUrl();
	Thread.sleep(1000);
	if (currentUrl1.equalsIgnoreCase(expectedUrl1)) {
		testcase.log(Status.PASS,"Major and Sub skills registered succesfully");
	}else {
		testcase.log(Status.FAIL,"Major and Sub skills not registered");
	}
   Assert.assertEquals(currentUrl1, expectedUrl1);
	Thread.sleep(2000);
     }
    @Test(priority = 4)
    public void QuestionsBank() throws InterruptedException {
    	logger.info("Registeration of question set and Questions");
    	testcase=extentReport.createTest("Open the Questions register");
    	PageFactory.initElements(driver, Setting_pom.class);
    	Setting_pom.QuestionsTab.click();
    	Setting_pom.AddQuestionsSet.click();
    	Setting_pom.QuestionSetName.sendKeys("Automation Testing");
    	Setting_pom.SaveQuestions.click();
    	Thread.sleep(2000);
    	Setting_pom.AddQuestionList.click();
    	Thread.sleep(2000);
    	Setting_pom.AddQuestions.click();
    	Setting_pom.AddQuestionBankName.sendKeys("Selenium");
    	Select SelectDuration=new Select(Setting_pom.SelectDuration);
    	SelectDuration.selectByVisibleText("3 Minutes");
    	Setting_pom.SaveQuestionsList.click();
    	Setting_pom.BackToQuestions.click();
    	Thread.sleep(1000);
    	String currentUrl1="https://dev.viewandhire.com/questionList";
    	String expectedUrl1=driver.getCurrentUrl();
    	Thread.sleep(1000);
    	if (currentUrl1.equalsIgnoreCase(expectedUrl1)) {
    		testcase.log(Status.PASS,"Questions registered succesfully");
    	}else {
    		testcase.log(Status.FAIL,"Questions not registered");
    	}
        Assert.assertEquals(currentUrl1, expectedUrl1);
    	Thread.sleep(2000);
	}
    @Test(priority = 5)
    public void Users() throws InterruptedException {
    	logger.info("Registeration of user");
    	testcase=extentReport.createTest("Open the User register");
    	PageFactory.initElements(driver, Setting_pom.class);
    	Setting_pom.UsersTab.click();
    	Setting_pom.AddUserButton.click();
    	Setting_pom.UserfirstName.sendKeys("Kavin");
    	Setting_pom.UserLastName.sendKeys("kumar");
    	Setting_pom.UserName.sendKeys("vijaymvj110m25@gmail.com");
    	Setting_pom.MobileNumber.sendKeys("9988776655");
    	Select SelectRole=new Select(Setting_pom.UserRole);
    	SelectRole.selectByValue("HR");
    	Select SelectTimezone=new Select(Setting_pom.Timezone);
    	SelectTimezone.selectByIndex(1);
    	Setting_pom.OrganizationForUser.click();
    	Setting_pom.SelectHP.click();
    	Setting_pom.SelectTCS.click();
    	Setting_pom.OrganizationForUser2.click(); 
    	Setting_pom.SaveUser.click();
    	String currentUrl1="https://dev.viewandhire.com/userList";
    	String expectedUrl1=driver.getCurrentUrl();
    	Thread.sleep(1000);
    	if (currentUrl1.equalsIgnoreCase(expectedUrl1)) {
    		testcase.log(Status.PASS,"User registered succesfully");
    	}else {
    		testcase.log(Status.FAIL,"User not registered");
    	}
        Assert.assertEquals(currentUrl1, expectedUrl1);
    	Thread.sleep(2000);
    	
    }
}
