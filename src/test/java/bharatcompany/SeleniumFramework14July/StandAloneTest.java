package bharatcompany.SeleniumFramework14July;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String zaraexpected="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("mebharatbhardwaj@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Swift@0527");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		String zaratext=driver.findElement(By.xpath("//div[@class='card-body'] //b[text()='ZARA COAT 3']")).getText();
		System.out.println(zaratext);
		if(zaratext.equals(zaraexpected))
		{
			driver.findElement(By.xpath("//div[@class='card-body']/button[text()=' Add To Cart']")).click();
		}
		//List<WebElement> buttons=driver.findElements(By.xpath("//div[@class='card-body']/button[text()=' Add To Cart']"));
		//System.out.println(buttons.size());
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='toast-bottom-right toast-container']")));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		//driver.close();
		
		
		

	}

}
