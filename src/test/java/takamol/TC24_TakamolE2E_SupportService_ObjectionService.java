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

public class TC24_TakamolE2E_SupportService_ObjectionService {
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
        Takamol.createRequestForObjectionServiceAppian();
        String requestPopup = CommonWebActions.getWebElement("RequestCreatedHeader_objection").getText();
		String requestNumber=requestPopup.substring(12,28);
		System.out.println("Request number is " +requestNumber);
		AUT.validateBreadCrumb("SuccessFFP", "Success");
		CommonWebActions.webClick("FFPCloseButton");
		Thread.sleep(1000);
	//	Takamol.verifyObjectionRequestCreatedOrNot();
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(15000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(1000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.approveRequestFromCommitteeMemeber();
		Thread.sleep(1000);
		AUT.closeBrowserWindow();
		
		
		}}
		catch(Exception e){
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



	