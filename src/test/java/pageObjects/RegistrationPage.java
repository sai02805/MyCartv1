package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath="//input[@name= 'firstname']")
WebElement txtfirstName;

@FindBy(xpath="//input[@name= 'lastname']")
WebElement txtlastName;

@FindBy(xpath="//input[@name= 'email']")
WebElement txtemail;

@FindBy(xpath="//input[@name= 'telephone']")
WebElement txttelephone;

@FindBy(xpath="//input[@name= 'password']")
WebElement txtpassword;

@FindBy(xpath="//input[@name= 'confirm']")
WebElement txtconfirm;

@FindBy(xpath="//input[@name= 'agree']")
WebElement chkagree;

@FindBy(xpath = "//input[@value= 'Continue']")
WebElement btnContinue;
@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setFirstname(String fname)
{
	txtfirstName.sendKeys(fname);
}
public void setLastname(String lname)
{
	txtlastName.sendKeys(lname);
}
public void setEmail(String email)
{
	txtemail.sendKeys(email);
}
public void setTelephone(String tphone)
{
	txttelephone.sendKeys(tphone);
}
public void setPwd(String pwd)
{
	txtpassword.sendKeys(pwd);
}
public void setConfirmPwd(String pwd)
{
	txtconfirm.sendKeys(pwd);
}
public void setPrivacyPolicy()
{
	chkagree.click();;
}
public void clickContinue()
{
	btnContinue.click();
}

public String getConfirmationMsg()
{
	try {
		return(msgConfirmation.getText());
	}catch(Exception e) {
		return(e.getMessage());
	}
}



}
