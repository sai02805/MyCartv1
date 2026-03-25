package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_03_LoginDDT extends BaseClass  {
	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class,groups = "Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
	
	{
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountExists();
	
	
	if(exp.equalsIgnoreCase("valid"))
	{
		if(targetPage == true)
		{
			macc.click_Logout();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	if(exp.equalsIgnoreCase("invalid"))
	{
		if(targetPage == true)
		{
			macc.click_Logout();
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
}
		catch(Exception e)
		{
		    Assert.fail();	
		}
		
		Thread.sleep(3000);
	}
}
