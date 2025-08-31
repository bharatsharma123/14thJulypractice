package bharatcompany.SeleniumFramework14July;

import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import testComponents.BaseTest;

public class LoginTestFail extends BaseTest{
	
	@Test
	public void logintestfailure()
	{
		LoginPageObjects lpobject=new LoginPageObjects(driver);
		lpobject.enterUserEmail("mebharatbhardwaj@gmail.com");
		lpobject.enterUserPassword("Swift@052");
		lpobject.pressLoginButton();
	}
}
