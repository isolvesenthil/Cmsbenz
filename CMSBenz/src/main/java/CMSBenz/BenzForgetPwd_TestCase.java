package CMSBenz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CMSBenzRead.ReadExcel;
import CMSBenzRead.ReadProperties;

public class BenzForgetPwd_TestCase {
		CommonFunctions common = new CommonFunctions();
		static WebDriver driver;
		String expectedText = "Forgot Password";
		
	@BeforeTest
		public void loadBrowser() throws Exception {
			common.openBrowser("chrome");
			common.getURL(ReadProperties.readProperties("url"));
			common.maximizeScreen();
			common.waitForTime(20);
	}
	
	@Test(priority=1)
		public void forgetPasswordWithMailID_TCID_BNZ_FPWD001() throws Exception{  // Check forgetPasswordWithMail
			common.printMessage("Case1 ::: forgetPasswordWithMailID_TCID_BNZ_FPWD001 :::");
			
			common.inputForSendKeysAndClick(ReadProperties.readProperties("frgtpwdlnk"), "", "click");
			common.sleep(1000);			
			
			
			WebElement element = common.webElementinput(ReadProperties.readProperties("frgtpwd_mailtxt"), ReadExcel.getValue("frgt_mailid"), "input");
			common.printMessage(element.getAttribute("value"));
			String getMailID = element.getAttribute("value");

			boolean mailTest = validate(getMailID);
			if(mailTest) {
				System.out.println("Valid MailID");
			} else {
				System.out.println("InValid MailID");
			}
			
			common.inputForSendKeysAndClick(ReadProperties.readProperties("frgtpwd_resetbtn"), "", "click");
			common.takeScreenshot("C:\\Users\\bs2896\\git\\Cmsbenz\\CMSBenz\\Screenshots\\TCID_BNZ_FPWD001.png");
			common.closeBrowser();
		}
		
		@Test (priority=2)
		public void forgetPasswordWithOutMailID_TCID_BNZ_FPWD002() throws Exception{  // Check forgetPassword WithOut MailID
			loadBrowser();
			common.printMessage("Case2 ::: forgetPasswordWithOutMailID_TCID_BNZ_FPWD002 :::");
		
			common.inputForSendKeysAndClick(ReadProperties.readProperties("frgtpwdlnk"), "", "click");
			common.sleep(1000);
			common.inputForSendKeysAndClick(ReadProperties.readProperties("frgtpwd_mailtxt"), "", "input");
			common.sleep(1000);
			common.inputForSendKeysAndClick(ReadProperties.readProperties("frgtpwd_resetbtn"), "", "click");
			common.takeScreenshot("C:\\Users\\bs2896\\git\\Cmsbenz\\CMSBenz\\Screenshots\\TCID_BNZ_FPWD002.png");
			common.closeBrowser();
		}
		
		@Test (priority=3)
		public void closeButton_TCID_BNZ_FPWD003() throws Exception{  // Check closeButton function
			loadBrowser();
			common.printMessage("Case3 ::: forgetPasswordWithOutMailID_TCID_BNZ_FPWD003 :::");
			
			common.inputForSendKeysAndClick(ReadProperties.readProperties("frgtpwdlnk"), "", "click");
			common.sleep(2000);
			
			WebElement closeBtn = common.webElementinput(ReadProperties.readProperties("frgtpwd_closeBtn"), "", "");
			closeBtn.click();
			common.printMessage("Clicked Close button");
			Thread.sleep(2000);		
			
			WebElement text = common.webElementinput(ReadProperties.readProperties("frgtpwd_text"), "", "");
			common.printMessage(text.getText());
			
			if (expectedText.equals(text.getText())) {
				common.printMessage("Failed");
			} else {
				common.printMessage("Passed");
			}		
		}
		
		public Pattern ValidateMail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		
		public boolean validate(String emailStr) {
			Matcher matcher = ValidateMail .matcher(emailStr);
			return matcher.find();
			}
		
		@AfterTest
		public void closeBrowser() {
		common.closeBrowser();
		}
}
