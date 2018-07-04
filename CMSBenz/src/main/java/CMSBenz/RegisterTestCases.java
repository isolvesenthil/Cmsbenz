package CMSBenz;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CMSBenzRead.ReadExcel;
import CMSBenzRead.ReadProperties;

public class RegisterTestCases {
	CommonFunctions common = new CommonFunctions();
	WebDriver driver;
	
	@BeforeTest
	public void loadBrowser() throws Exception {
		common.openBrowser("chrome");
		common.getURL(ReadProperties.readProperties("url"));
		common.maximizeScreen();
		common.waitForTime(20);
	}
	
	@Test
	public void UserRegistration_UR_TC001() throws Exception 
	{
		common.inputForSendKeysAndClick(ReadProperties.readProperties("register_ink") ,ReadExcel.getValue(""),"click");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("firstname_reg"),ReadExcel.getValue("firstname_reg_pg"), "input");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("lastname_reg"),ReadExcel.getValue("lastname_reg_pg"), "input");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("email_reg"),ReadExcel.getValue("email_reg_pg"),"input");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("employeeno_reg"),ReadExcel.getValue("employeeno_reg_pg"),"input");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("username_reg"),ReadExcel.getValue("username_reg_pg"),"input");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("designation_reg"), ReadExcel.getValue(""),"click");
		
		common.sleep(2000);
		
		common.dp(ReadProperties.readProperties("designation_reg"),4);
		
		
		common.inputForSendKeysAndClick(ReadProperties.readProperties("mobileno_reg"),ReadExcel.getValue("mobileno_reg_pg"),"input");
		common.sleep(2000);
		common.inputForSendKeysAndClick(ReadProperties.readProperties("registerbtn_reg"),ReadExcel.getValue(""),"click");
		common.takeScreenshot("C:\\Users\\bs2896\\git\\Cmsbenz\\CMSBenz\\Screenshots\\UR_TC001.png");
		common.sleep(2000);
	}
	
	@AfterTest
	public void closeBrowser() throws Exception {
		common.closeBrowser();
	}
}
