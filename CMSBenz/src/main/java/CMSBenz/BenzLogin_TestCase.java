package CMSBenz;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CMSBenzRead.ReadExcel;
import CMSBenzRead.ReadProperties;

public class BenzLogin_TestCase {
		
		CommonFunctions common = new CommonFunctions();
		ReadProperties readPro = new ReadProperties();
		ReadExcel readExe = new ReadExcel();
		static String homePageTitle = "Home Page - CMS";
			
	@BeforeTest
			public void loadBrowserWithLogin() throws Exception{  // Loading Browser	and login		
			common.loginCMSBens();
			}
	
	@Test(priority=1)
		public void loginWithValidCredentials_TCID_BNZ_LIN001() throws Exception{  // Valid Credentials-Login
			common.printMessage("Case1 ::: loginWithValidCredentials :::");
			common.inputForSendKeysAndClick(ReadProperties.readProperties("username_logtxt"), ReadExcel.getValue("login_username"), "input");
			common.printMessage("Entered UserName");
			common.inputForSendKeysAndClick(ReadProperties.readProperties("pwd_logtxt"), ReadExcel.getValue("login_pwd"), "input");
			common.printMessage("Entered Password");
			common.inputForSendKeysAndClick(ReadProperties.readProperties("submitbtn"), "", "click");
			common.printMessage("Clicked Login Button");
			common.sleep(2000);
			common.takeScreenshot("C:\\Users\\bs2896\\git\\Cmsbenz\\CMSBenz\\Screenshots\\TCID_BNZ001.png");
		
			common.printMessage(common.getPageTitle());
			
			if(common.getPageTitle().equals(homePageTitle)) {
				System.out.println("Logged In successfully");
			} else {
				System.out.println("Log In UnSuccessfull");
			}	
			common.sleep(2000);
			common.closeBrowser();
		}
		
	@Test(priority=2)
		public void loginWithInValidUserName_TCID_BNZ_LIN002() throws Exception{ // InValid UserName-Login
		loadBrowserWithLogin();
		common.printMessage("Case2 ::: loginWithInValidUserName :::");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("username_logtxt"), ReadExcel.getValue("invalid_username"), "input");
		common.printMessage("Entered UserName");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("pwd_logtxt"), ReadExcel.getValue("login_pwd"), "input");
		common.printMessage("Entered Password");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("submitbtn"), "", "click");
		common.printMessage("Clicked Login Button");
		common.sleep(2000);
		common.takeScreenshot("C:\\Users\\bs2896\\git\\Cmsbenz\\CMSBenz\\Screenshots\\TCID_BNZ002.png");
	
		common.printMessage(common.getPageTitle());
		
		if(common.getPageTitle().equals(homePageTitle)) {
			System.out.println("Logged In successfully");
		} else {
			System.out.println("Log In UnSuccessfull");
		}	
		common.sleep(2000);
		common.closeBrowser();
		}
		
	@Test(priority=3)
		public void loginWithInValidPassword_TCID_BNZ_LIN003() throws Exception{ // InValid Password-Login
		loadBrowserWithLogin();
		common.printMessage("Case3 ::: loginWithInValidPassword :::");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("username_logtxt"), ReadExcel.getValue("login_username"), "input");
		common.printMessage("Entered UserName");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("pwd_logtxt"), ReadExcel.getValue("invalid_pwd"), "input");
		common.printMessage("Entered Password");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("submitbtn"), "", "click");
		common.printMessage("Clicked Login Button");
		common.sleep(2000);
		common.takeScreenshot("C:\\Users\\bs2896\\git\\Cmsbenz\\CMSBenz\\Screenshots\\TCID_BNZ003.png");
	
		common.printMessage(common.getPageTitle());
		
		if(common.getPageTitle().equals(homePageTitle)) {
			System.out.println("Logged In successfully");
		} else {
			System.out.println("Log In UnSuccessfull");
		}	
		common.sleep(2000);
		common.closeBrowser();
		}
		
	@Test(priority=4)
		public void loginWithEmptyCredentials_TCID_BNZ_LIN004() throws Exception{ // Empty Credentials-Login
		loadBrowserWithLogin();
		common.printMessage("Case4 ::: loginWithEmptyCredentials :::");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("username_logtxt"), "", "input");
		common.printMessage("Entered UserName");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("pwd_logtxt"), "", "input");
		common.printMessage("Entered Password");
		common.inputForSendKeysAndClick(ReadProperties.readProperties("submitbtn"), "", "click");
		common.printMessage("Clicked Login Button");
		common.sleep(2000);
		common.takeScreenshot("C:\\Users\\bs2896\\git\\Cmsbenz\\CMSBenz\\Screenshots\\TCID_BNZ004.png");
	
		common.printMessage(common.getPageTitle());
		
		if(common.getPageTitle().equals(homePageTitle)) {
			System.out.println("Logged In successfully");
		} else {
			System.out.println("Log In UnSuccessfull");
		}	
	}
	
	@AfterTest
		public void closeBrowser() throws Exception{  // Close Browser
			common.closeBrowser();
			}	
		
}
