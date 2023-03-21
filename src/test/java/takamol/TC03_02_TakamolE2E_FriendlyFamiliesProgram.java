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

public class TC03_02_TakamolE2E_FriendlyFamiliesProgram {
	
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
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Foster/Friendly Families/My Role Model Program");
        CommonWebActions.webClick("FFM_Link");
        AUT.validateBreadCrumb("FFM_Header", "FFM header ");
        CommonWebActions.webClick("FFP_Link");
        AUT.validateBreadCrumb("FFP_Header", "FFP header ");
        Thread.sleep(1000);
        Takamol.selectFFPHostingDetails();
        AUT.validateBreadCrumb("DeclartionHeader", "Declaration & Undertaking header ");
        CommonWebActions.webClick("DeclartionCheckBox");
        Thread.sleep(1000);
        CommonWebActions.webClick("UnderTakingCheckBox");
        Thread.sleep(1000);
        CommonWebActions.scrollIntoWebElement_ActionClass("MMP_UploadButton");
        Thread.sleep(1000);
        //Takamol.attachAndVerifyFiles("Test.pdf");
        Takamol.uploadImageBySendKeys("Other Files", "Test.pdf");
        String expectedFile ="Test.pdf";
		String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
		if (actualFile.contains(expectedFile)) {

			ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
		} else {

			ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

		}
        Thread.sleep(1000);
        CommonWebActions.webClick("MMP_SubmitButton");
        String requestPopup = CommonWebActions.getWebElement("RequestCreatedHeaderFFP").getText();
		String requestNumber=requestPopup.substring(0,16);
		System.out.println("Request number is "+requestNumber);	
        Takamol.verifyMMRRequestSubmitOrNot();
        Takamol.navigateOnAppian("url_Appian");
        Takamol.loginInAppian();
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.FFPapproveRequestFromSocialWorker1();
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000); 
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.FFPapproveRequestFromSocialWorker2();
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.FFPapproveRequestFromAttributionManager1();
		Thread.sleep(10000); 
        Takamol.navigateOnAppian("url_React"); 
        Thread.sleep(5000); 
        CommonWebActions.wd.navigate().refresh();
        Thread.sleep(1000);
		Takamol.FFPapproveRequestFromApplicant();
		Thread.sleep(1000); 
		Takamol.navigateOnAppian("url_Appian");
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
        Thread.sleep(2000);
        CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.FFPapproveRequestFromSocialWorker3();
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000); 
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.FFPapproveRequestFromAttributionManager2();
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.FFPapproveRequestFromCommitteeMember();
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000); 
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.FFPapproveRequestFromCommitteeChairman();
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000); 
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber); 
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.FFPapproveRequestFromUnderSecretary();
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
