package myWordpress.myWordpress;




import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public WebDriver driver;
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.navigate().to("https://wordpress.org/");
		driver.manage().window().maximize();


	}
	@AfterClass
	public void Teardown() {
		String str2="Beach";
		WebElement ele1= driver.findElement(By.id("s"));
		ele1.sendKeys(str2, Keys.ENTER);
		String str3=driver.findElement(By.xpath("//*[@id='main']/header/h2/strong")).getText();
		System.out.println(str3);
		if(str3.equals(str2)){
			System.out.println(str3 + " Is Displayed");
		}
		else{
			System.out.println(str3+" results is not found ");
		}
		driver.quit();

	}
}
