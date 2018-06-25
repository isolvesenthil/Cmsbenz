package CMSBenz;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import CMSBenzRead.ReadExcel;
import CMSBenzRead.ReadProperties;

public class LoginScreenTestCases {
	ReadProperties readPro = new ReadProperties();
	ReadExcel readExe = new ReadExcel();
	
		static WebDriver driver;
		static String homePageTitle = "Home Page - CMS";
		
	public void loadBrowser() throws Exception{  // Loading Browser
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(readPro.readProperties("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		}
		
	public void loginWithValidCredentials() throws Exception{  // Valid Credentials-Login
		System.out.println("Case1 ::: loginWithValidCredentials :::");
		driver.findElement(By.xpath(readPro.readProperties("username_logbtn"))).sendKeys(readExe.getValue("login_username")); 
		System.out.println("Entered UserName");
		driver.findElement(By.xpath(readPro.readProperties("pwd_logbtn"))).sendKeys(readExe.getValue("login_pwd"));
		System.out.println("Entered Password");
		driver.findElement(By.xpath(readPro.readProperties("submitbtn"))).click();
		System.out.println("Clicked Login Button");
		Thread.sleep(3000);
		
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(image, new File("D:\\Senthil\\Java Program\\CMSBenz\\Screenshots\\ValidCredentials-Login.png"));

		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		if(actTitle.equals(homePageTitle)) {
			System.out.println("Logged In successfully");
		} else {
			System.out.println("Log In UnSuccessfull");
		}	
	}
	
	public void loginWithInValidUserName() throws Exception{ // InValid UserName-Login
		System.out.println("Case2 ::: loginWithInValidUserName :::");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("aruntest");
		System.out.println("Entered UserName for Invalidcase");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("CMS123$");
		System.out.println("Entered Password");
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		System.out.println("Clicked Login Button");
		
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(image, new File("D:\\Senthil\\Java Program\\CMSBenz\\Screenshots\\InValidUserName-Login.png"));
		
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		if(actTitle.equals(homePageTitle)) {
			System.out.println("Logged In successfully");
		} else {
			System.out.println("Log In UnSuccessfull");
		}	
	}
	
	public void loginWithInValidPassword() throws Exception{ // InValid Password-Login
		System.out.println("Case3 ::: loginWithInValidPassword :::");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("arun");
		System.out.println("Entered UserName for Invalidcase");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("CMS12345$");
		System.out.println("Entered Password");
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		System.out.println("Clicked Login Button");
		
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(image, new File("D:\\Senthil\\Java Program\\CMSBenz\\Screenshots\\InValidPassword-Login.png"));
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		if(actTitle.equals(homePageTitle)) {
			System.out.println("Logged In successfully");
		} else {
			System.out.println("Log In UnSuccessfull");
		}	
	}
	
	public void loginWithEmptyCredentials() throws Exception{ // Empty Credentials-Login
		System.out.println("Case5 ::: loginWithEmptyCredentials :::");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("");
		System.out.println("Entered UserName for Invalidcase");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
		System.out.println("Entered Password");
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		System.out.println("Clicked Login Button");
		
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(image, new File("D:\\Senthil\\Java Program\\CMSBenz\\Screenshots\\EmptyCredentials.png"));
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		if(actTitle.equals(homePageTitle)) {
			System.out.println("Logged In successfully");
		} else {
			System.out.println("Log In UnSuccessfull");
		}	
	}
	
	public void closeBrowser() throws Exception{  // Close Browser
		Thread.sleep(1000);
		driver.close();
		}	
	
	public static void main(String[] args) throws Exception{
		LoginScreenTestCases log = new LoginScreenTestCases();
		log.loadBrowser();
		log.loginWithValidCredentials();
		log.closeBrowser();
//		log.loadBrowser();
//		log.loginWithInValidUserName();
//		log.closeBrowser();
//		log.loadBrowser();
//		log.loginWithInValidPassword();
//		log.closeBrowser();
//		log.loadBrowser();
//		log.loginWithEmptyCredentials();
//		log.closeBrowser();

	}
}
