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

public class TC21_TakamolE2E_SocialRecords {

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
        CommonWebActions.webClick("SocialRecords_Link");
        AUT.validateBreadCrumb("SRHeader", "Social records header ");
        CommonWebActions.webClick("MySocialRecords_Link");
        AUT.validateBreadCrumb("MY_SRHeader", "My Social records header ");
        Takamol.verifySocialRecordsComponents();
        Thread.sleep(2000);
        CommonWebActions.webClick("SR_Personal");
        AUT.validateBreadCrumb("SR_PersonalHeader", "Personal Social records header ");
        Thread.sleep(1000);
        Takamol.uploadImageBySendKeys("Upload A Photo", "TestImage.png");
        //Takamol.attachAndVerifyFiles("TestImage.png");
        String expectedFile ="TestImage";
		String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
		if (actualFile.contains(expectedFile)) {

			ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
		} else {

			ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

		}
       
        Thread.sleep(1000);
        CommonWebActions.webClick("DeleteIcon");
        Thread.sleep(2000);
        Takamol.verifyDeleteImagePopup();
        CommonWebActions.scrollIntoWebElement_ActionClass("MMP_SaveButton");
        Thread.sleep(1000);
        CommonWebActions.webClick("SRAcceptCheckBox");
        CommonWebActions.webClick("MMP_SaveButton");
        Thread.sleep(1000);
        Takamol.confirmPersonalRecords();
        Thread.sleep(1000);
        Takamol.updateSocialRecordsFatherData();
        Takamol.updateSocialRecordsMotherData();
        Takamol.updateSocialRecordsEducationData();
        Takamol.updateBeneficiarySocialData();
        Takamol.updateDependencyData();
        Takamol.updateAddressData();
        Takamol.updateFinancialData();
        Takamol.updateAppData();
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
