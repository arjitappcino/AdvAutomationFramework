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

public class TC04_TakamolE2E_DisabilityAssessment {
	
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
        
        CommonWebActions.webClick("DisabilityAssessment_link");
        Thread.sleep(1000);
        AUT.validateBreadCrumb("DisabilityAssessmentHeader", "Disability Assessment header ");
        Thread.sleep(1000);
        CommonWebActions.webClick("DisabilityAssessment_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("DisabilityAssessmentBeneficiary_dropdownValue");
        
        Takamol.selectDisabilityAssessmentDetails();
        Thread.sleep(2000);
		String requestPopup = CommonWebActions.getWebElement("DAS_Header").getText();
		String requestNumber=requestPopup.substring(1,16);
		System.out.println("Request number is "+requestNumber);
        Takamol.verifyMedicalDeviceRequestCreatedOrNot();
        CommonWebActions.webClick("OkButton");
		Takamol.navigateOnAppian("url_Appian");
  		Takamol.loginInAppian();
		Thread.sleep(4000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.approveDisabilityAseessmentRequestFromVerifier();
		CommonWebActions.wd.navigate().refresh();
	    Thread.sleep(2000);
	    CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
	    Thread.sleep(3000);
		Takamol.approveDisabilityAseessmentRequestFromDataEntryClerk();
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	    Takamol.approveDisabilityAseessmentRequestFromPhysician();
	    CommonWebActions.wd.navigate().refresh();
	    Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	    Takamol.approveDisabilityAseessmentRequestFromSocialWorker();
	    Thread.sleep(1000);
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
