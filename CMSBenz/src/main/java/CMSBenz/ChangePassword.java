package CMSBenz;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangePassword {
		WebDriver driver;
	

	public void loadBrowser1() throws Exception{   
		
		System.setProperty("webdriver.chrome.driver", "D:\\Testing docs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://172.16.0.74/isolvecms");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("arun"); 
		System.out.println("Entered UserName");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("CMS123$");
		System.out.println("Entered Password");
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		System.out.println("Clicked Login Button");
		Thread.sleep(3000);
		
		****************************
		System.out.println("Testing Github");
		****************************
		driver.close();
		
		System.out.println("Test GITHUB");
		Thread.sleep(3000);
	}
	
	public void chnagePwdCancel() throws InterruptedException {
		System.out.println("Cancel Change Password");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/nav[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"oldPassword\"]")).sendKeys("CMS123$");
		driver.findElement(By.xpath("//*[@id=\"newPassword\"]")).sendKeys("iSolve123$");
		driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("iSolve123$");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"divForgotPasswordwindow\"]/div/center/div/div[2]/form/div[4]/div[2]/button")).click();
		driver.close();
	}
	
	public void chnagePwd() throws InterruptedException {
		System.out.println("Change Password");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/nav[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"oldPassword\"]")).sendKeys("CMS123$");
		driver.findElement(By.xpath("//*[@id=\"newPassword\"]")).sendKeys("iSolve123$");
		driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("iSolve123$");
		Thread.sleep(2000);
	}
	public void loadBrowser() throws Exception{  // Loading Browser
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://172.16.0.74/isolvecms");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("arun"); 
		System.out.println("Entered UserName");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("CMS123$");
		System.out.println("Entered Password");
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		System.out.println("Clicked Login Button");
		Thread.sleep(3000);
	}
	
	public void chnagePwdCancel1() throws InterruptedException {
		System.out.println("Cancel Change Password");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/nav[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"oldPassword\"]")).sendKeys("CMS123$");
		driver.findElement(By.xpath("//*[@id=\"newPassword\"]")).sendKeys("iSolve123$");
		driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("iSolve123$");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"divForgotPasswordwindow\"]/div/center/div/div[2]/form/div[4]/div[2]/button")).click();
	}
	
	public void chnagePwd1() throws InterruptedException {
		System.out.println("Change Password");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/nav[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"oldPassword\"]")).sendKeys("CMS123$");
		driver.findElement(By.xpath("//*[@id=\"newPassword\"]")).sendKeys("iSolve123$");
		driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("iSolve123$");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"btnChangePassword\"]")).click();
		
	}
	public static void main(String[] args) throws Exception {
		ChangePassword change = new ChangePassword();
		change.loadBrowser1();
		change.chnagePwdCancel();
		change.loadBrowser1();
		change.chnagePwd();
	}
}
