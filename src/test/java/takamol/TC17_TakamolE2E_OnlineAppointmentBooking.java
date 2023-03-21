package takamol;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import applicationSpecific.AUT;
import applicationSpecific.Takamol;
import coreFramework.CommonWebActions;
import coreFramework.Constants;
import coreFramework.ExcelUtil;
import coreFramework.ExcelUtilForLinkNavs;
import coreFramework.ORUtil;
import coreFramework.ReportUtil;

public class TC17_TakamolE2E_OnlineAppointmentBooking {
	
	@BeforeClass
	public void beforeSuite() throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		Date date = new Date();

		AUT.path = System.getProperty("user.dir") + Constants.AUTRESULTPATH + dateFormat.format(date) + ".xlsx";

		ORUtil.strObjectRepoFilePath = Constants.TESTARTIFACTSPATH + ORUtil.getConfigValue("TakamolLocators");
		ExcelUtilForLinkNavs.setExcel(AUT.path, "Takamol");

	}
	@Test
	public void testCaseFlow() throws InterruptedException, IOException {
		try {
		ReportUtil.startReporting();
		AUT.timeStamp();
		ReportUtil.reporterEvent("info", "This automation script covers Test Case Ids: ");
		ExcelUtil.strFile=ORUtil.getConfigValue("TestTakamol");
		if(ExcelUtil.getDataFromExcel(CommonWebActions.onlyTestCaseName, "Execute").equals("Y"))
		{						
		AUT.login("url_React","UserName","Password");	
        AUT.CheckLogo("TakamolLogo");
        Takamol.verifyTakamolHomePage();
        CommonWebActions.webClick("TakamolService");
        Thread.sleep(1000);
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Online Appointment Booking Service");
        Thread.sleep(1000);
        CommonWebActions.webClick("OnlineAppBooking_link");
        Thread.sleep(1000);
        AUT.validateBreadCrumb("OnlineAppBooking_Header", "Online Appointment Booking Service header ");
        Thread.sleep(1000);
        Takamol.OnlineAppointmentBookingDetails();
        CommonWebActions.webClick("AppointmentBookingButton");
        Thread.sleep(5000);
        String requestPopup = CommonWebActions.getWebElement("MMP_RequestCreatedHeader").getText();
        String requestNumber = requestPopup.substring(0,16);
        System.out.println("Request number is " + requestNumber);
        AUT.validateBreadCrumb("MMP_RequestCreatedHeader", "Online Appointment Booking Service has been Created ");
        CommonWebActions.webClick("OkButton");
        Thread.sleep(2000);
       /* 
          CommonWebActions.webClick("POP-UPButton");
          Thread.sleep(2000);
         */
        CommonWebActions.webClick("SendCerticateToEmail");
        Thread.sleep(2000);
        
        AUT.validateBreadCrumb("EmailSent_Header", "Email sent page header ");
        CommonWebActions.webClick("OkButton");
        Thread.sleep(2000);
        Takamol.navigateOnAppian("url_Appian");
        Takamol.loginInAppian();
        Thread.sleep(10000);
        CommonWebActions.wd.navigate().refresh();
        Thread.sleep(2000);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Takamol.approveRequestFromUnitEmployee();
        Thread.sleep(2000);
        AUT.closeBrowserWindow();
		}
        
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			ReportUtil.endReporter();	
		}
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE){
			ReportUtil.reporterEvent("fatal", "Test case incomplete");
			
			ReportUtil.endReporter();
		}
	}

}
