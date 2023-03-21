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

public class TC10_TakamolE2E_DomesticLaborFees {
	
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
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Domestic Labor Fees Exemption Service");
		Thread.sleep(1000);
		
		CommonWebActions.webClick("DomesticLabour_LINK");
		AUT.validateBreadCrumb("Domestic_Header", "Domestic_Labor_Fees Header ");
    	Thread.sleep(1000);
		CommonWebActions.webClick("Select_Beneficiary_Dropdown");
		Thread.sleep(1000);
		CommonWebActions.webClick("DomesticLabour_Droplist");
		Thread.sleep(1000);
		CommonWebActions.webClick("ExemptionType_Dropdown");
		Thread.sleep(1000);
		CommonWebActions.webClick("DomesticLabour_Droplist");
		Thread.sleep(1000);
		CommonWebActions.webClick("WorkersGender_Dropdown");
		Thread.sleep(1000);
		CommonWebActions.webClick("DomesticLabour_Droplist");
		Thread.sleep(1000);
		CommonWebActions.webClick("Profession_Dropdown");
		Thread.sleep(1000);
		CommonWebActions.webClick("DomesticLabour_Droplist");
		
		Thread.sleep(1000);
		Takamol.domesticLabourServiceScreen();
		
		Thread.sleep(1000);
		CommonWebActions.webClick("IssueButton");
		
		Thread.sleep(2000);
		Takamol.domesticLabourEmailScreen();
		
		Thread.sleep(1000);
		CommonWebActions.webClick("SendDecisionToEmailButton");
		Thread.sleep(2000);
		AUT.validateBreadCrumb("EmailSent_Header", "Email header ");
		Thread.sleep(1000);
		CommonWebActions.webClick("OkButton");
		
		
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
