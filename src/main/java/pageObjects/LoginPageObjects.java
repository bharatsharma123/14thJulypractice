package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponents;

public class LoginPageObjects extends AbstractComponents{
	
	public WebDriver driver;
	
			public LoginPageObjects(WebDriver driver)
			{
				super(driver);
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement userPassword;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement loginButton;
	
	public void enterUserEmail(String useremail)
	{
		userEmail.sendKeys(useremail);
	}
	
	public void enterUserPassword(String userpassword)
	{
		userPassword.sendKeys(userpassword);
	}
	
	public void pressLoginButton()
	{
		loginButton.click();
	}

}
