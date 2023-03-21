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

public class TC16_TakamolE2E_InvestmentAccount {
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
        Thread.sleep(1000);
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Investment");
        Thread.sleep(1000);
        CommonWebActions.webClick("InvestmentServiceLink");
        Thread.sleep(1000);
        Takamol.selectInvestmentAccountEnquiry();
        String requestPopup = CommonWebActions.getWebElement("RequestCreatedHeaderFFP").getText();
		String requestNumber=requestPopup.substring(0,16);
		System.out.println("Request number is "+requestNumber);	
        Takamol.verifyMedicalDeviceRequestCreatedOrNot();
        CommonWebActions.webClick("OkButton"); 
        Thread.sleep(1000);
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Investment");
        Thread.sleep(1000);
        CommonWebActions.webClick("InvestmentServiceLink");
        Thread.sleep(1000);
        Takamol.selectInvestmentAccountWithdraw();
        String requestPopup1 = CommonWebActions.getWebElement("RequestCreatedHeaderFFP").getText();
		String requestNumber1=requestPopup1.substring(0,16);
		System.out.println("Request number is "+requestNumber1);	
        Takamol.verifyMedicalDeviceRequestCreatedOrNot();
        CommonWebActions.webClick("OkButton"); 
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
	}}


