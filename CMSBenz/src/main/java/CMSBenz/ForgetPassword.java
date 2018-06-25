package CMSBenz;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ForgetPassword {

		static WebDriver driver;
		
		
		public void loadBrowser() throws Exception{  // Loading Browser
			
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
//			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumDrivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
			
			driver.get("http://172.16.0.74/isolvecms");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			}
		
		public void forgetPasswordWithMailID() throws Exception{  // Check forgetPasswordWithMailID
			
			System.out.println("Case1 ::: forgetPasswordWithMailID :::");
			driver.findElement(By.xpath("//*[contains(text(),'Forgot Password')]")).click();
			
			WebElement mailID = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
			mailID.sendKeys("testing.engg@isolve.co.in");
			String getMailID = mailID.getAttribute("value");
			System.out.println(getMailID);
			
			boolean mailTest = validate(getMailID);
			if(mailTest) {
				System.out.println("Valid MailID");
			} else {
				System.out.println("InValid MailID");
			}
			
			driver.findElement(By.xpath("//input[@id='btnResetPassword']")).click();
			File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(image, new File("D:\\Senthil\\Java Program\\CMSBenz\\Screenshots\\forgetPasswordWithMailID-ForgetPassword.png"));
		}
		
		public void forgetPasswordWithOutMailID() throws Exception{  // Check forgetPassword WithOut MailID
			System.out.println("Case2 ::: forgetPasswordWithOutMailID :::");
			driver.findElement(By.xpath("//*[contains(text(),'Forgot Password')]")).click();
			driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("");
			driver.findElement(By.xpath("//input[@id='btnResetPassword']")).click();
		}
		
		
		public void closeButton() throws Exception{  // Check closeButton function
			System.out.println("Case3 ::: closeButton Check :::");
			driver.findElement(By.xpath("//*[contains(text(),'Forgot Password')]")).click();
			Thread.sleep(2000);
			WebElement closeBtn = driver.findElement(By.xpath("//*[@id='divForgotPasswordwindow']/div/div/div[3]/button"));     
			String buttontext = closeBtn.getText();			
			
			
			WebElement checkName = driver.findElement(By.xpath("//*[contains(text(), 'Forgot Password')]"));
			//System.out.println(checkName.getText());
			String ch_name = checkName.getText();
			
			closeBtn.click();
			System.out.println("Clicked Close button");
			Thread.sleep(2000);
			
			
			if(driver.findElement(By.xpath("//*[@id='divForgotPasswordwindow']/div/div/div[3]/button")).isDisplayed()) {
				System.out.println("Case Failed ::: Close function not works");
			} else {
				System.out.println("Case Passed ::: Close function works");
			}
//			if(driver.findElement(By.xpath("//*[@id='divForgotPasswordwindow']/div/div/div[3]/button")) != null) {
//				System.out.println("Failed ::: Close Function nots Works");
//			} else {
//				System.out.println("Passed ::: Close Function Works");
//			}
			
		}
		
		public Pattern ValidateMail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		
		public boolean validate(String emailStr) {
			Matcher matcher = ValidateMail .matcher(emailStr);
			return matcher.find();
			}
		public void closeBrowser() {
			driver.close();
		}
		
		public static void main(String[] args) throws Exception {
			ForgetPassword fog = new ForgetPassword();
//			fog.loadBrowser();
//			fog.forgetPasswordWithMailID();
//			fog.closeBrowser();
//			fog.loadBrowser();
//			fog.forgetPasswordWithOutMailID();
//			fog.closeBrowser();
			fog.loadBrowser();
			fog.closeButton();
			//fog.closeBrowser();			
		}
}
