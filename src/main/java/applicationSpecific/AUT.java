package applicationSpecific;

import coreFramework.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.primitives.Ints;

import edu.emory.mathcs.backport.java.util.Collections;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * This class consists of methods specific to application under test
 * 
 * @author KAMIL PARVEZ
 * @version 1.0
 */
public class AUT {

	static String Title = "";
	static String LaunchDate = "";
	static String flag = "";
	static String category = "";
	static String link = "";
	static String KeyofLinkName = "";
	static String KeyofExpectedObject = "";
	static String expected = "";
	static String itemdesc = "";
	static String resultPath = "";
	public static int rownum = 0;
	//
	public static XSSFWorkbook workbook1;
	public static XSSFSheet sheet1;
	public static XSSFRow row1;
	static XSSFCell cell1;
	static File file1;
	static FileInputStream fin1;
	public static FileOutputStream fout;
	public static String path;
	public static final int STARTCELL = 3;

	/**
	 * This method is used to Login to the application
	 * 
	 * @param strEnvURL
	 *            - Environment name present in config file
	 * @param strUserName
	 *            - User name present in data sheet
	 * @param strPassword
	 *            - encoded password present in data sheet
	 */
	public static void login(String strEnvURL, String strUserName, String strPassword) {
		try {
			CommonWebActions.launch(strEnvURL);
			Thread.sleep(2000);
			CommonWebActions.webClick("AcceptButton");
			Thread.sleep(2000);
			CommonWebActions.webExplicitWait("Appian_UnTextBox", 180);
			CommonWebActions.webExists(CommonWebActions.getWebElement("Appian_UnTextBox"));
			CommonWebActions.webExplicitWait("Appian_UnTextBox", 180);
			CommonWebActions.webClick("Appian_UnTextBox");
			CommonWebActions.webSet("Appian_UnTextBox", strUserName);
			Thread.sleep(1000);
			CommonWebActions.webClick("Appian_PwdTextBox");
			CommonWebActions.webSet("Appian_PwdTextBox", strPassword);
			CommonWebActions.webClick("LoginButton");
			Thread.sleep(8000);
	
			CommonWebActions.webClick("BlogButton");
			Thread.sleep(8000);
			
			CommonWebActions.webClick("UserProfile");
			Thread.sleep(3000);
			
			CommonWebActions.webClick("LogoutButton");
			Thread.sleep(3000);
			
			CommonWebActions.webClick("AcceptButton");
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();

			ReportUtil.reporterEvent("fatal", "Login failure" + CommonWebActions.captureScreenshotAsBase64());

		}

	}
	
	public static void loginInReact(String strUserName, String strPassword) {
		try {

			CommonWebActions.webClick("LanguageIcon");
			Thread.sleep(1000);
			CommonWebActions.webClick("English");
			CommonWebActions.webExplicitWait("LoginId", 180);
			CommonWebActions.webExists(CommonWebActions.getWebElement("LoginId"));
			CommonWebActions.webExplicitWait("LoginId", 180);
			CommonWebActions.webClick("LoginId");
			CommonWebActions.webSet("LoginId", strUserName);
			Thread.sleep(1000);
			CommonWebActions.webClick("LoginPassword");
			CommonWebActions.webSecureSet("LoginPassword", strPassword);
			CommonWebActions.webClick("LoginButtonFirst");
			Thread.sleep(2000);
			CommonWebActions.webClick("VerificationTextBox");
			Thread.sleep(2000);
			CommonWebActions.getWebElement("VerificationTextBox").sendKeys("123456");
			Thread.sleep(3000);
			CommonWebActions.webClick("LoginButtonSecond");
			Thread.sleep(3000);
			CommonWebActions.webVerifyPageTitle("PageTitle", true);
			CommonWebActions.webExplicitWait("UserNameText", 180);
			
			String expectedUserName ="Automation Services Taheel Test";
			String actualUserName = CommonWebActions.getWebElement("UserNameText").getText();
			//String actualUserName=CommonWebActions.wd.findElement(By.xpath("//div[text()='Automation Services Taheel Test']")).getText();
			if (actualUserName.contains(expectedUserName)) {

				ReportUtil.reporterEvent("pass", "Login Successful - UserName name displayed");
			} else {

				ReportUtil.reporterEvent("fail", "Unable to login successfully - UserName not matched");

			}

			

		} catch (Exception e) {
			e.printStackTrace();

			ReportUtil.reporterEvent("fatal", "Login failure" + CommonWebActions.captureScreenshotAsBase64());

		}

	}
	
	public static void loginInAppian(String strEnvURL, String strUserName, String strPassword) {
		try {

			CommonWebActions.launch(strEnvURL);
			Thread.sleep(1000);
			CommonWebActions.webExplicitWait("Appian_UnTextBox", 180);
			CommonWebActions.webExists(CommonWebActions.getWebElement("Appian_UnTextBox"));
			CommonWebActions.webExplicitWait("Appian_UnTextBox", 180);
			CommonWebActions.webClick("Appian_UnTextBox");
			CommonWebActions.webSet("Appian_UnTextBox", strUserName);
			Thread.sleep(1000);
			CommonWebActions.webClick("Appian_PwdTextBox");
			CommonWebActions.webSecureSet("Appian_PwdTextBox", strPassword);
			CommonWebActions.webClick("Appian_SignIn");
			Thread.sleep(4000);
			CommonWebActions.webVerifyPageTitle("AppianPageTitle", true);
			CommonWebActions.webExplicitWait("Appian_UserNameText", 180);
			String expectedUserName ="Ministry Employee";
			String actualUserName = CommonWebActions.getWebElement("Appian_UserNameText").getText();
			if (actualUserName.contains(expectedUserName)) {

				ReportUtil.reporterEvent("pass", " UserName name displayed");
			} else {

				ReportUtil.reporterEvent("fail", " UserName not matched");

			}

			

		} catch (Exception e) {
			e.printStackTrace();

			ReportUtil.reporterEvent("fatal", "Login failure" + CommonWebActions.captureScreenshotAsBase64());

		}

	}
	public static void Launch(String strEnvURL) {
		try {

			CommonWebActions.launch(strEnvURL);
	        Thread.sleep(1000);		


		} catch (Exception e) {
			e.printStackTrace();

			ReportUtil.reporterEvent("fatal", "Login failure" + CommonWebActions.captureScreenshotAsBase64());

		}

	}
	

	
	
	

	/**
	 * This method is used to logoff from the application
	 * 
	 * @author Kamil Parvez
	 */
	public static void logOff() {
		try {
			CommonWebActions.webExplicitWait("UserName", 180);
			CommonWebActions.webClick("UserName");
			CommonWebActions.webClick("LogoutButton");
			CommonWebActions.webExplicitWait("LogoutMessage", 180);
			if (CommonWebActions.webExists(CommonWebActions.getWebElement("LogoutMessage"))) {
				ReportUtil.reporterEvent("pass", "Logoff Successful, [You have been Logged out] messgae displayed"
						+ CommonWebActions.captureScreenshotAsBase64());
			} else {
				ReportUtil.reporterEvent("fail",
						"Unable to logoff successfully" + CommonWebActions.captureScreenshotAsBase64());
			}

		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Logoff failure" + CommonWebActions.captureScreenshotAsBase64());
		}
	}


	public static void closeBrowserWindow() {
		CommonWebActions.closeBrowser();
	}

	
	
	
	public static boolean validateBreadCrumb(String breadcrumb,String breadcrumbDescrip){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement(breadcrumb))){
				ReportUtil.reporterEvent("pass", breadcrumbDescrip+"breadcrumb is Displayed" +CommonWebActions.captureScreenshotAsBase64());
				return true;
			}else{
				ReportUtil.reporterEvent("fail", breadcrumbDescrip+"breadcrumb validation failed"+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	

	public static void timeStamp() {
		Date date1= new Date();
		long time = date1.getTime();
	    Timestamp ts = new Timestamp(time);
		System.out.println("Time Stamp: "+ts);
	}

	
	

	

	

	public static void CheckLogo(String logo) {
		if (CommonWebActions.webExists(CommonWebActions.getWebElement(logo))) {
			ReportUtil.reporterEvent("pass",
					"App logo is displayed" + CommonWebActions.captureScreenshotAsBase64());
		}

		else {
			ReportUtil.reporterEvent("fail",
					"App logo is not displayed" + CommonWebActions.captureScreenshotAsBase64());
		}

	}

	public static void switchToHomePage() {
		CommonWebActions.webClick("HomeLink");
	}


	

	public static void launchElectronicTestData() throws InterruptedException {
		String strParentWin = null;
		String strTipWin = null;
		CommonWebActions.webExplicitWait("ElectronicTestData", 180);
		CommonWebActions.webClick("ElectronicTestData");
		Set<String> setWinHandle = CommonWebActions.getAllWindowHandles();
		Iterator<String> itr = setWinHandle.iterator();
		while (itr.hasNext()) {
			strParentWin = itr.next();
			strTipWin = itr.next();
			System.out.println("Test-1");
		}
		CommonWebActions.switchToWindow(strTipWin);
		if (CommonWebActions.getWebElement("Header") != null) {
			ReportUtil.reporterEvent("pass",
					"Header is verified" + CommonWebActions.captureScreenshotAsBase64());
			
			}
		else {
			ReportUtil.reporterEvent("fail",
					"Header is not verified" + CommonWebActions.captureScreenshotAsBase64());
		}
		
		CommonWebActions.wd.close();	
		Thread.sleep(2000);
		CommonWebActions.switchToWindow(strParentWin);
	}


	

	public static void verifyLaunchAvailableAccessoriesLink() throws InterruptedException {
		String strParentWin = null;
		String strTipWin = null;
		CommonWebActions.webExplicitWait("AvailableAccessories", 180);
		CommonWebActions.webClick("AvailableAccessories");
		Set<String> setWinHandle = CommonWebActions.getAllWindowHandles();
		Iterator<String> itr = setWinHandle.iterator();
		while (itr.hasNext()) {
			strParentWin = itr.next();
			strTipWin = itr.next();
		}
		CommonWebActions.switchToWindow(strTipWin);
		
		CommonWebActions.wd.close();
        Thread.sleep(2000);
		CommonWebActions.switchToWindow(strParentWin);
	}
	
 public static String readCaseNoFromMessage(String strMessageLogicalName) {
		CommonWebActions.webExplicitWait("Message", 150);
		String text = CommonWebActions.getWebElement("Message").getText().toString();
		System.out.println(text);
		String strCaseNumber = text.split("\\:")[1].trim();
		return strCaseNumber;
	}


	
		

	
}