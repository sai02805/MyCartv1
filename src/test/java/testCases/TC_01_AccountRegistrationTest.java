package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_01_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void verify_account_registration() {
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
