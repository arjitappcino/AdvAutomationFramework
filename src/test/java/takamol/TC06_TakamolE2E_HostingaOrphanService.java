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

public class TC06_TakamolE2E_HostingaOrphanService {
	
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
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("request to host");
        Thread.sleep(1000);
        CommonWebActions.webClick("HostingService");
        Thread.sleep(1000);
        AUT.validateBreadCrumb("HostingHeader", "Request to Host Service header ");
        Thread.sleep(1000);
     // My Role Model Program
        Takamol.selectMyRoleModel();
        String requestPopup = CommonWebActions.getWebElement("MMP_RequestCreatedHeader").getText();
        String requestNumber = requestPopup.substring(0,16);
        System.out.println("Request number is " + requestNumber);
        AUT.validateBreadCrumb("MMP_RequestCreatedHeader", "Hosting request for My Role Model Program has been Created ");
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
        Takamol.HostingReqSocialWorker1();
        Thread.sleep(10000);
        CommonWebActions.wd.navigate().refresh();
        Thread.sleep(2000);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Takamol.HostingReqSocialWorker2();
        Thread.sleep(25000);
        CommonWebActions.wd.navigate().refresh();
        Thread.sleep(2000);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Takamol.HostingReqSocialWorker3();
        Thread.sleep(2000);
     // Friendly Family Program  
        Takamol.navigateOnAppian("url_React");
        AUT.CheckLogo("TakamolLogo");
        Takamol.verifyTakamolHomePage();
        CommonWebActions.webClick("TakamolService");
        Thread.sleep(1000);
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("request to host");
        Thread.sleep(1000);
        CommonWebActions.webClick("HostingService");
        Thread.sleep(1000);
        AUT.validateBreadCrumb("HostingHeader", "Request to Host Service header ");
        Thread.sleep(1000);
        Takamol.selectFriendlyFamilyProgram();
        String requestPopup1 = CommonWebActions.getWebElement("MMP_RequestCreatedHeader").getText();
        String requestNumber1 = requestPopup1.substring(0,16);
        System.out.println("Request number is " + requestNumber1);
        AUT.validateBreadCrumb("MMP_RequestCreatedHeader", "Hosting request for Friendly Family Program has been Created ");
        CommonWebActions.webClick("OkButton");
        Thread.sleep(2000);
        Takamol.navigateOnAppian("url_Appian");
        Thread.sleep(10000);
        CommonWebActions.wd.navigate().refresh();
        Thread.sleep(2000);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber1);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Takamol.HostingReqSocialWorker1();
        Thread.sleep(10000);
        CommonWebActions.wd.navigate().refresh();
        Thread.sleep(2000);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber1);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Takamol.HostingReqSocialWorker2();
        Thread.sleep(25000);
        CommonWebActions.wd.navigate().refresh();
        Thread.sleep(2000);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber1);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Takamol.HostingReqSocialWorker3();
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
