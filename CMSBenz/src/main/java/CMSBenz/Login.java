package CMSBenz;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CMSBenzRead.ReadExcel;
import CMSBenzRead.ReadProperties;

public class Login {
	CommonFunctions common = new CommonFunctions();
	
	
	@BeforeTest
	public void loadBrowser() throws Exception{
		common.openBrowser("chrome");
		common.getURL(ReadProperties.readProperties("url"));
		common.maximizeScreen();
		common.waitForTime(20);
	}
	
	@Test
	public void testCase01() throws Exception{				
		common.inputForSendKeysAndClick(ReadProperties.readProperties("username_logtxt"), ReadExcel.getValue("login_username"), "input");
		common.printMessage("Entered Username");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("pwd_logtxt"), ReadExcel.getValue("login_pwd"), "input");
		common.printMessage("Entered Password");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("submitbtn"), ReadExcel.getValue(""), "click");
		common.printMessage("Clicked Submit button and Home page loaded");
		common.sleep(2000);
	}
	
	@Test
	public void testCase02() throws Exception{
		//common.inputForSendKeysAndClick(ReadProperties.readProperties("chnagePWDlnk"), ReadExcel.getValue(""), "click");
		common.printMessage("clicked link");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("oldpwdtxt"), ReadExcel.getValue("oldpwd"), "input");
		common.printMessage("Entered old Pwd");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("newpwdtxt"), ReadExcel.getValue("newpwd"), "input");
		common.printMessage("Entered new Pwd");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("cnfpwdtxt"), ReadExcel.getValue("cnfpwd"), "input");
		common.printMessage("Entered Cnf Pwd");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("chnagebtn"), ReadExcel.getValue(""), "click");
		common.printMessage("Clicked change btn");
	}
	
	@AfterTest
	public void closeBrowser() throws Exception{
		common.closeBrowser();
	}
}
