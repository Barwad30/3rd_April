package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.annotations.Listeners;
import pojo.LaunchBrowser;
import pom.LoginPage;
import utility.Reports;
import utility.Screenshot;
@Listeners(test.Listeners.class)
public class LoginTest extends BaseClass {
	    ExtentReports extent;
	    ExtentTest test;
	    
		@BeforeTest
		public void configureReports() {
			extent=Reports.createReports();
		}
		
		@BeforeMethod
		public void OpenBrowser() {
			 driver = LaunchBrowser.chrome("https://www.facebook.com/");
		}
		
		@Test
		public void loginWithValidCredentials() {
			test = extent.createTest("loginWithValidCredentials");
			LoginPage faceBookLoginPage = new LoginPage(driver);
			faceBookLoginPage.enterEmailId("Barwadp@gmail.com");
			faceBookLoginPage.enterPassword("8698557878");
			faceBookLoginPage.clickOnLogin();	
			String currentTitale = driver.getTitle();
			
			Assert.assertNull(currentTitale);
			
		}
		    @Test
		   public void loginWithValidUserNameAndInvalidPassword() {
			    test = extent.createTest("loginWithValidUserNameAndInvalidPassword");
			    LoginPage faceBookLoginPage = new LoginPage(driver);
				faceBookLoginPage.enterEmailId("Barwadp@gmail.com");
				faceBookLoginPage.enterPassword("1111111");
				faceBookLoginPage.clickOnLogin();	
		   }
		    
		    @Test
		   public void loginWithInvalidUserNameAndPassword() {
			    test = extent.createTest("loginWithInvalidUserNameAndPassword");
			    LoginPage faceBookLoginPage = new LoginPage(driver);
				faceBookLoginPage.enterEmailId("xyz@gmail.com");
				faceBookLoginPage.enterPassword("1111111");
				faceBookLoginPage.clickOnLogin();   
		   }
		    
		    @Test
		    public void creatNewAccount() {
		    	 test = extent.createTest("creatNewAccount");
		    	 LoginPage faceBookLoginPage = new LoginPage(driver);
		    	 faceBookLoginPage.clickOnCreateAccount();
		    	 faceBookLoginPage.enterFirstName("Arise",driver);
		    }
		    
	    @AfterMethod
	       public void  captureResult(ITestResult result) {
	    	
	    	if(result.getStatus() == ITestResult.SUCCESS) {
	    		test.log(Status.PASS, result.getName());
	    	}
	    	else if (result.getStatus() == ITestResult.FAILURE) {
	    		test.log(Status.FAIL, result.getName());
	    	}
	    	else
	    	{
	    		test.log(Status.SKIP, result.getName());
	    	}
	    	driver.close();
	    }
	    
	    @AfterTest
	    public void publish() {
	    	extent.flush();
	    }
	

}



//System.out.println("Post assertion");
//Assert.assertEquals(currentTitale, "Log in to Facebook");
//Assert.assertTrue(true);