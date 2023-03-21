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

public class TC02_TakamolE2E_IICServiceRequest {
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
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Incubation Identification Certificate");
        CommonWebActions.webClick("IIC_Link");
        AUT.validateBreadCrumb("IIC_Header", "IIC header ");
        Takamol.validateHeaderList("Sr.No. ID Number Orphan Name Sex Age Skin Color Date Of Birth");
		Thread.sleep(2000);
        CommonWebActions.webClick("NextButton");
        AUT.validateBreadCrumb("IIC_RequestHeader", "IIC request header ");
        CommonWebActions.webClick("IssueButton");
		Thread.sleep(2000);
		AUT.validateBreadCrumb("CertificatePageHeader", "Certificate page header ");
		Takamol.validateLLCCertificatePageScreen();
		CommonWebActions.webClick("SendCerticateToEmail");
		Thread.sleep(2000);
		AUT.validateBreadCrumb("EmailSent_Header", "Email sent page header ");
		CommonWebActions.webClick("OkButton");
		Takamol.navigateOnAppian("url_Appian");
        Takamol.loginInAppian();
        Takamol.createRequestForIIC();
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