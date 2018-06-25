package CMSBenz;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwiggyLogin {
		static WebDriver driver;
		
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://partner.swiggy.com/orders");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"sign-up-form\"]/div[1]/input")).sendKeys("25720");
		driver.findElement(By.xpath("//*[@id=\"sign-up-form\"]/div[2]/input")).sendKeys("thane1234");
		driver.findElement(By.xpath("//*[@id=\"sign-up-btn\"]")).click();
		
		WebElement name = driver.findElement(By.xpath("//*[@id=\"new\"]/div[2]/div/div/div/div/h2"));
		String value = name.getText();
		System.out.println("Data = "+ value );
	}
}
