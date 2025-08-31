package bharatcompany.SeleniumFramework14July;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPageObjects;
import testComponents.BaseTest;

public class LoginTest extends BaseTest{

	/*@Test(dataProvider= "loginTestData")
	public void loginPageTest(String username,String password) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		LoginPageObjects lpobject=new LoginPageObjects(driver);
		lpobject.enterUserEmail(username);
		lpobject.enterUserPassword(password);
		lpobject.pressLoginButton();
		
	}*/
	
	@Test(dataProvider= "loginTestDatausingHashMap")
	public void loginPageTestusinghashmap(HashMap<String,String> input) {
		// TODO Auto-generated method stub
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		LoginPageObjects lpobject=new LoginPageObjects(driver);
		lpobject.enterUserEmail(input.get("useremail"));
		lpobject.enterUserPassword(input.get("password"));
		lpobject.pressLoginButton();
		
	}
	

}
