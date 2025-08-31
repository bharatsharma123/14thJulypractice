package testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	@BeforeMethod
	public void launchApplication() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "//src//main//java//resources//GlobalData.properties");
				
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver",
			//		"/Users/rahulshetty//documents//geckodriver");
			//driver = new FirefoxDriver();
			// Firefox
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Edge
			//System.setProperty("webdriver.edge.driver", "edge.exe");
			//driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.manage().window().maximize();
	}

	/*@DataProvider
	public Object[][] loginTestData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="mebharatbhardwaj@gmail.com";
		data[0][1]="Swift@0527";
		
		data[1][0]="mebharatbhardwaj2@gmail.com";
		data[1][1]="Swift@0527";
		
		return data;
	}
	*/
	@DataProvider
	public Object[][] loginTestDatausingHashMap()
	{
		HashMap<String,String>map1=new HashMap<String,String>();
		map1.put("useremail","mebharatbhardwaj@gmail.com");
		map1.put("password","Swift@0527");
		
		HashMap<String,String>map2=new HashMap<String,String>();
		map2.put("useremail","mebharatbhardwaj2@gmail.com");
		map2.put("password","Swift@0527");
		
		//return new Object[][]{{"map1"},{"map2"}}; The error came for the first time because there was no space
		return new Object[][] { { map1 }, { map2 } };
	}
	
}
