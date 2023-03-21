package takamol;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
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

public class TC18_TakamolE2E_OrphanMarriageBenefit {
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
     /*   AUT.CheckLogo("TakamolLogo");
        
        CommonWebActions.webClick("TakamolService");
        Thread.sleep(1000);
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Orphans Marriage Benefit Service");
        Thread.sleep(1000);
        CommonWebActions.webClick("OMB_Link");
        Thread.sleep(1000);
        AUT.validateBreadCrumb("OMB_Header", " Orphans Marriage Benefit Service ");
        Thread.sleep(1000);
        CommonWebActions.getWebElement("DocumentNo").sendKeys("78789");
        Thread.sleep(1000);
        CommonWebActions.webClick("OMB_Verifybutton");
        Thread.sleep(1000);
        CommonWebActions.getWebElement("DocumentDate").sendKeys("20/01/2023");
        Thread.sleep(1000);
        CommonWebActions.webClick("OMB_Documentstaus_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("OMB_Documentstaus_value");
        CommonWebActions.getWebElement("IDNo").sendKeys("1234");
        Thread.sleep(1000);
        CommonWebActions.getWebElement("IDType").sendKeys("Passport");
        Thread.sleep(1000);
        CommonWebActions.getWebElement("Dateofbirth").sendKeys("20/01/2000");
        Thread.sleep(1000);
        CommonWebActions.getWebElement("Name").sendKeys("Text Entered by Automation");
        Thread.sleep(1000);
        CommonWebActions.webClick("Saudiradiobutton");
        Thread.sleep(1000);
        CommonWebActions.webClick("Maleradiobutton");
        Thread.sleep(1000);
        Takamol.uploadImageBySendKeys("A copy of the marriage contract document", "TestImage.png");
        String expectedFile ="TestImage";
		String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
		if (actualFile.contains(expectedFile)) {

			ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
		} else {

			ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

		}
		 Thread.sleep(1000);
		Takamol.uploadImageBySendKeys("A copy of National ID", "TestImage.png");
        String expectedFile1 ="TestImage.png";
		String actualFile1 = CommonWebActions.getWebElement("AttachedFile").getText();
		if (actualFile1.contains(expectedFile1)) {

			ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
		} else {

			ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

		}
		Thread.sleep(1000);
		CommonWebActions.webClick("Sendbutton");
		Thread.sleep(5000);

       
        AUT.validateBreadCrumb("OMB_POPUP", "has been submitted");
        String requestPopup = CommonWebActions.getWebElement("RequestCreatedHeaderFFP").getText();
		String requestNumber=requestPopup.substring(0,16);
		System.out.println("Request number is "+requestNumber);	
        CommonWebActions.webClick("OkButton");*/
        Takamol.navigateOnAppian("url_Appian");
        Takamol.loginInAppian();
	/*	Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.OMBReviewFromEmployee();
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000); 
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.OMBReviewFromManagerGeneral();
		Thread.sleep(10000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);*/
		Takamol.createRequestForOMB();
		String requestPopup2 = CommonWebActions.getWebElement("OMBSuccessScreen").getText();
		String requestNumber2=requestPopup2.substring(12,28);
		System.out.println("Request number is "+requestNumber2);	
		CommonWebActions.webClick("FFPCloseButton");
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber2);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.OMBReviewFromEmployee();
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000); 
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber2);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.OMBReviewFromManagerGeneral();
		Thread.sleep(2000);
		Takamol.OMBTransactionModule();
		String requestPopup1 = CommonWebActions.getWebElement("PassportSuccessScreen").getText();
		String requestNumber1=requestPopup1.substring(12,28);
		System.out.println("Request number is " +requestNumber1);
		CommonWebActions.webClick("FFPCloseButton");
		Thread.sleep(2000);
		CommonWebActions.webClick("HomeTab");
		Thread.sleep(10000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber1);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.OMBApprovalfromGeneralManagerTM();
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000); 
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber1);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.OMBIssueDataFileFromGeneralManager();
		Thread.sleep(10000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000); 
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber1);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.EOIAttachPaymentReceiptByEmployeeOfTheSubsidyDepartment();
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
	}}


