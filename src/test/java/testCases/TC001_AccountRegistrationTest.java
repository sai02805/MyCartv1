package testCases;

import java.time.Duration;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC001_AccountRegistrationTest {
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
	@Test
	public void verify_account_registration()
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		RegistrationPage regpage = new RegistrationPage(driver);
		regpage.setFirstname("sai");
		regpage.setLastname("B");
		regpage.setEmail("saib@gmail.com");
		regpage.setTelephone("9059776734");
		regpage.setPwd("Satya123");
		regpage.setConfirmPwd("Satya123");
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg = regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
	

}
