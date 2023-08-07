package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.LaunchBrowser;
import pom.LoginPage;

public class LoginTest2 {
	WebDriver driver;
	@BeforeMethod
	public void OpenBrowser() {
		 driver = LaunchBrowser.chrome("https://www.facebook.com/");
	}
	@Test
	public void loginWithValidCredentials() {
		LoginPage faceBookLoginPage = new LoginPage(driver);
		SoftAssert softAssert = new SoftAssert();
		faceBookLoginPage.enterEmailId("Barwadp@gmail.com");
		faceBookLoginPage.enterPassword("8698557878");
		faceBookLoginPage.clickOnLogin();	
		String currentTitale = driver.getTitle();
		
		softAssert.assertEquals(currentTitale,"log in to facebook");
		System.out.println("Home page validation done");
		
		softAssert.assertTrue(true);
		System.out.println("assert true validation done");
		
		softAssert.assertNull(currentTitale);
		System.out.println("Post assertion");
		
		softAssert.assertAll();
	}

}
