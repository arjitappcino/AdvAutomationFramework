package takamol;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class TC23_TakamolE2E_SupportServiceIDCard {
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
			     
        AUT.loginInAppian("url_Appian","UserName","Password");
        CommonWebActions.webClick("CreateRequestButton");
        AUT.validateBreadCrumb("CreateRequestHeader", "create request page appian header ");
        CommonWebActions.webClick("DisabilityButton");
		Thread.sleep(3000);
        CommonWebActions.webClick("DisabilityIdentificationCardService");
		Thread.sleep(3000);
		AUT.validateBreadCrumb("SearchBeneficiaryHeader", "Beneficiary serach appian header ");
		CommonWebActions.getWebElement("NationalIDTextBox").sendKeys("8000000115");
		Thread.sleep(1000);
		CommonWebActions.webClick("NationalIDSearchButtonSS");
		Thread.sleep(1000);
		CommonWebActions.webClick("SelectFirstRecord");
		CommonWebActions.webClick("RequestNxtButton");
		Thread.sleep(1000);
		CommonWebActions.webClick("RequestIssueButton");
		Thread.sleep(1000);
		CommonWebActions.webClick("DownloadCard");
		Thread.sleep(1000);
		CommonWebActions.webClick("SendtheIDcardtoEmailCard");
		Thread.sleep(1000);
		AUT.validateBreadCrumb("IDcard_POPUP", "has been submitted");
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



