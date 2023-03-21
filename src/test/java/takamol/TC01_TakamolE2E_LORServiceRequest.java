package takamol;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
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

public class TC01_TakamolE2E_LORServiceRequest {
	
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
        CommonWebActions.webClick("TakamolService");
        AUT.validateBreadCrumb("TakamolServiceHeader", "Takamol header ");
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Recommendation Letter for Orphan");
		Thread.sleep(1000);
		CommonWebActions.webClick("LOR_Link");
		AUT.validateBreadCrumb("LOR_Header", "LOR header ");
		Thread.sleep(1000);
		Takamol.selectEducationLORDetails();
		AUT.validateBreadCrumb("RequestSummary_Header", "Request Summary header ");
		CommonWebActions.webClick("IssueButton");
		Thread.sleep(3000);
		AUT.validateBreadCrumb("LetterPageHeader", "Letter page header ");
		Thread.sleep(1000);
		Takamol.validateLetterPageScreen();
		Thread.sleep(1000);
		CommonWebActions.webClick("SendCerticateToEmail");
		Thread.sleep(2000);
		AUT.validateBreadCrumb("EmailSent_Header", "Email sent page header ");
		CommonWebActions.webClick("OkButton");
		Thread.sleep(2000);
		CommonWebActions.webClick("LOR_Link");
		Takamol.selectHealthLORDetails();
		AUT.validateBreadCrumb("RequestSummary_Header", "Request Summary header ");
		CommonWebActions.webClick("IssueButton");
		Thread.sleep(3000);
		AUT.validateBreadCrumb("LetterPageHeader", "Letter page header ");
		CommonWebActions.webClick("SendCerticateToEmail");
		Thread.sleep(4000);
		AUT.validateBreadCrumb("EmailSent_Header", "Email sent page header ");	
		CommonWebActions.webClick("OkButton");
		CommonWebActions.webClick("LOR_Link");
		Takamol.selectOtherLORDetails();
		Thread.sleep(2000);
		String requestPopup = CommonWebActions.getWebElement("RequestCreatedHeader").getText();
		String requestNumber=requestPopup.substring(25,41);
		System.out.println("Request number is "+requestNumber);	
        Takamol.verifyRequestCreatedOrNot();       
        Takamol.navigateOnAppian("url_Appian");
        Takamol.loginInAppian();
		Thread.sleep(3000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Takamol.approveRequestFromMinistry();
		Thread.sleep(4000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Takamol.approveRequestFromDirector();
		Thread.sleep(2000);
		Takamol.createRequestForLOREducation();
		Thread.sleep(2000);
		Takamol.createRequestForLOROther();
		String requestPopupLOR = CommonWebActions.getWebElement("LOROtherSuccessScreen").getText();
		String requestNumberLOR=requestPopupLOR.substring(35,51);
		System.out.println("Request number is "+requestNumberLOR);	
		CommonWebActions.webClick("FFPCloseButton");
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumberLOR);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.approveRequestFromDirector();
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
