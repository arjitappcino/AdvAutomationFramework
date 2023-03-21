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
import coreFramework.CommonWebActions;
import coreFramework.Constants;
import coreFramework.ExcelUtil;
import coreFramework.ExcelUtilForLinkNavs;
import coreFramework.ORUtil;
import coreFramework.ReportUtil;

public class TC08_TakamolE2E_DisabilityClassificationServiceForUniversityStudents {
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

        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Disability Classification Service For University Students");
        Thread.sleep(1000);
        CommonWebActions.webClick("DUC_Link");
        Thread.sleep(1000);

        AUT.validateBreadCrumb("DUC_Header", " Disability Classification Service For University Students");
        Thread.sleep(1000);
        CommonWebActions.webClick("DUC_ChooseTheBeneficiary");
        Thread.sleep(1000);
        CommonWebActions.webClick("DUC_ChooseTheBeneficiary_value");
        Thread.sleep(1000);
        CommonWebActions.getWebElement("UniversityId").sendKeys("78789");
        Thread.sleep(1000);
        CommonWebActions.webClick("RegionName_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("DUC_RegionName_value");
      
        CommonWebActions.webClick("CityName_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("DUC_CityName_value");
        
        CommonWebActions.webClick("UniversityName_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("DUC_UniversityName_value");
        AUT.validateBreadCrumb("Issuebutton", "Form");
        CommonWebActions.webClick("Issuebutton");
        Thread.sleep(1000);
       
     //   CommonWebActions.webClick("DownloadButton");
     //   Thread.sleep(1000);
        CommonWebActions.webClick("SendCerticateToEmail");
        Thread.sleep(2000);
        AUT.validateBreadCrumb("EmailSent_Header", "Send Certificate to Email");
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



