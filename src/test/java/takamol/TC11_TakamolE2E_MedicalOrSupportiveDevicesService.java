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

public class TC11_TakamolE2E_MedicalOrSupportiveDevicesService {
	
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
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Medical Or Supportive Devices Service");
        CommonWebActions.webClick("MedicalServiceDeviceLink");
        Thread.sleep(2000);
        AUT.validateBreadCrumb("MedicalServiceDeviceLinkPage_Header", "Medical Service Device Link header ");
        CommonWebActions.webClick("MedicalBeneficiary_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("MedicalBeneficiary_dropdownValue");
        Thread.sleep(1000);
        Takamol.selectMedicalOrSupportiveHeadphoneDetails();
        Thread.sleep(3000);
        Takamol.verifyMedicalDeviceRequestCreatedOrNot();
        CommonWebActions.wd.navigate().refresh();
        Thread.sleep(2000);
        CommonWebActions.webClick("MedicalBeneficiary_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("MedicalBeneficiary_dropdownValue");
        Thread.sleep(1000);
        Takamol.selectMedicalOrSupportiveRegularDeviceDetails();
        Thread.sleep(3000);
        Takamol.verifyMedicalDeviceRequestCreatedOrNot();
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
