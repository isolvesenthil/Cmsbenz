package CMSBenz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CMSBenzRead.ReadExcel;
import CMSBenzRead.ReadProperties;

public class ChangePassword {
	CommonFunctions common = new CommonFunctions();
	static WebDriver driver;
	
@BeforeTest
public void loadBrowser() throws Exception {
	common.openBrowser("chrome");
	common.getURL(ReadProperties.readProperties("url"));
	common.maximizeScreen();
	common.waitForTime(20);
	
	common.inputForSendKeysAndClick(ReadProperties.readProperties("username_logtxt"), ReadExcel.getValue("login_username"), "input");
	WebElement pwd_Text = common.webElementinput(ReadProperties.readProperties("pwd_logtxt"), ReadExcel.getValue("login_pwd"), "input");
	String actualPwd = pwd_Text.getAttribute("value");
	common.printMessage("Entered Password="+actualPwd);
	
	common.inputForSendKeysAndClick(ReadProperties.readProperties("submitbtn"), "", "click");
	
	
}

@Test 
public void changePwd() throws Exception {
	
}
}
