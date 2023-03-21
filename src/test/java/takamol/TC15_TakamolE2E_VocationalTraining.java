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


public class TC15_TakamolE2E_VocationalTraining {
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
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Vocational Training Service");
        Thread.sleep(1000);
       
        CommonWebActions.webClick("VTS_Link");
        Thread.sleep(1000);
        AUT.validateBreadCrumb("VTS_Header", " Vocational Training Service header ");
        Thread.sleep(4000);
        CommonWebActions.webClick("VTS_ChooseTheBeneficiary");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_ChooseTheBeneficiary_value");
        Thread.sleep(1000);
        CommonWebActions.webClick("RegionName_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_RegionName_value");
        CommonWebActions.webClick("CityName_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_CityName_value");
        CommonWebActions.webClick("Testcenter_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_Testcenter_value");
        CommonWebActions.webClick("Program_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_Program_value");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_Checkbox");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_Sendbutton");
        Thread.sleep(1000);
        AUT.validateBreadCrumb("VTS_POPUP", "Your request No.");
       
        Thread.sleep(2000);
		String requestPopup = CommonWebActions.getWebElement("RequestCreatedHeader_VTS").getText();
		String requestNumber=requestPopup.substring(17,33);
		System.out.println("Request number is "+requestNumber);
		Takamol.verifyVocationalRequestCreatedOrNot();
		Takamol.navigateOnAppian("url_Appian");
		Takamol.loginInAppian();
		Thread.sleep(4000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
        Takamol.approveVocationalRequestFromTechnicalCommitteeMemeber();
        Thread.sleep(2000);
    // ####################### Takamol-Vocational simpleapprovalTraining Service #########################
//   Takamol.navigateOnAppian("url_React");
//      AUT.CheckLogo("TakamolLogo");
//       CommonWebActions.webClick("TakamolService");
//       Thread.sleep(1000);
//       CommonWebActions.getWebElement("DashboardSearch").sendKeys("Vocational Training Service");
//       Thread.sleep(1000);
//       CommonWebActions.webClick("VTS_Link");
//       Thread.sleep(1000);
//       AUT.validateBreadCrumb("VTS_Header", " Vocational Training Service header ");
//       Thread.sleep(4000);
//       CommonWebActions.webClick("VTS_ChooseTheBeneficiary");
//       Thread.sleep(1000);
//       CommonWebActions.webClick("VTS_ChooseTheBeneficiary_value");
//       Thread.sleep(1000);
//       CommonWebActions.webClick("RegionName_dropdown");
//       Thread.sleep(1000);
//       CommonWebActions.webClick("VTS_RegionName_value");
//       CommonWebActions.webClick("CityName_dropdown");
//       Thread.sleep(1000);
//       CommonWebActions.webClick("VTS_CityName_value");
//       CommonWebActions.webClick("Testcenter_dropdown");
//       Thread.sleep(1000);
//       CommonWebActions.webClick("VTS_Testcenter_value");
//       CommonWebActions.webClick("Program_dropdown");
//       Thread.sleep(1000);
//       CommonWebActions.webClick("VTS_Program_value");
//       Thread.sleep(1000);
//       CommonWebActions.webClick("VTS_Checkbox");
//       Thread.sleep(1000);
//       CommonWebActions.webClick("VTS_Sendbutton");
//       Thread.sleep(1000);
//       AUT.validateBreadCrumb("VTS_POPUP", "has been sent successfully");
//      
//       Thread.sleep(2000);
//		String requestPopup3 = CommonWebActions.getWebElement("RequestCreatedHeader_VTS").getText();
//		String requestNumber3=requestPopup3.substring(17,33);
//		System.out.println("Request number is "+requestNumber3);
//		Takamol.verifyVocationalRequestCreatedOrNot();
//	
//		Takamol.navigateOnAppian("url_Appian");
//		Takamol.loginInAppian();
//		Thread.sleep(4000);
//		CommonWebActions.wd.navigate().refresh();
//		Thread.sleep(2000);
//		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber3);
//		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		Takamol.VocationalAttendanceRequestFromTechnicalCommitteeMemeber();
//		Thread.sleep(2000);
		
		Takamol.navigateOnAppian("url_React");
		AUT.CheckLogo("TakamolLogo");
        CommonWebActions.webClick("TakamolService");
        Thread.sleep(1000);
        CommonWebActions.getWebElement("DashboardSearch").sendKeys("Vocational Training Service");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_Link");
        Thread.sleep(1000);
        AUT.validateBreadCrumb("VTS_Header", " Vocational Training Service header ");
        Thread.sleep(4000);
        CommonWebActions.webClick("VTS_ChooseTheBeneficiary");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_ChooseTheBeneficiary_value");
        Thread.sleep(1000);
        CommonWebActions.webClick("RegionName_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_RegionName_value");
        CommonWebActions.webClick("CityName_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_CityName_value");
        CommonWebActions.webClick("Testcenter_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_Testcenter_value");
        CommonWebActions.webClick("Program_dropdown");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_Program_value");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_Checkbox");
        Thread.sleep(1000);
        CommonWebActions.webClick("VTS_Sendbutton");
        Thread.sleep(1000);
        AUT.validateBreadCrumb("VTS_POPUP", "has been sent successfully");
    
        Thread.sleep(2000);
		String requestPopup1 = CommonWebActions.getWebElement("RequestCreatedHeader_VTS").getText();
		String requestNumber1=requestPopup1.substring(17,33);
		System.out.println("Request number is "+requestNumber1);
		Takamol.verifyVocationalRequestCreatedOrNot();
		Takamol.navigateOnAppian("url_Appian");
		Thread.sleep(4000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber1);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.VocationalAdditionalApprovalRequestFromTechnicalCommitteeMemeber();
		Thread.sleep(15000);
	    CommonWebActions.wd.navigate().refresh();
	    Thread.sleep(2000);
	    CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber1);
	    Thread.sleep(1000); 
	    CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
		Thread.sleep(15000);
		Takamol.VocationalApproveRequestFromDirectorofVocationalRehabilation();
		Thread.sleep(15000);
	    CommonWebActions.wd.navigate().refresh();
	    Thread.sleep(2000);
	    CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber1);
	    Thread.sleep(1000); 
	    CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    Takamol.VocationalApproveRequestFromUndersecretary();
	    Thread.sleep(2000);
		
	     Takamol.navigateOnAppian("url_React");
	     AUT.CheckLogo("TakamolLogo");
	     CommonWebActions.webClick("TakamolService");
	     Thread.sleep(1000);
	     CommonWebActions.getWebElement("DashboardSearch").sendKeys("Vocational Training Service");
	     Thread.sleep(1000);
	     CommonWebActions.webClick("VTS_Link");
	     Thread.sleep(1000);
	     AUT.validateBreadCrumb("VTS_Header", " Vocational Training Service header ");
	     Thread.sleep(4000);
	     CommonWebActions.webClick("VTS_ChooseTheBeneficiary");
	     Thread.sleep(1000);
	     CommonWebActions.webClick("VTS_ChooseTheBeneficiary_value");
	     Thread.sleep(1000);
	     CommonWebActions.webClick("RegionName_dropdown");
	     Thread.sleep(1000);
	     CommonWebActions.webClick("VTS_RegionName_value");
	     CommonWebActions.webClick("CityName_dropdown");
	     Thread.sleep(1000);
	     CommonWebActions.webClick("VTS_CityName_value");
	     CommonWebActions.webClick("Testcenter_dropdown");
	     Thread.sleep(1000);
	     CommonWebActions.webClick("VTS_Testcenter_value");
	     CommonWebActions.webClick("Program_dropdown");
	     Thread.sleep(1000);
	     CommonWebActions.webClick("VTS_Program_value");
	     Thread.sleep(1000);
	     CommonWebActions.webClick("VTS_Checkbox");
	     Thread.sleep(1000);
	     CommonWebActions.webClick("VTS_Sendbutton");
	     Thread.sleep(1000);
	     AUT.validateBreadCrumb("VTS_POPUP", "has been sent successfully");
    
	     Thread.sleep(2000);
		String requestPopup2 = CommonWebActions.getWebElement("RequestCreatedHeader_VTS").getText();
		String requestNumber2=requestPopup2.substring(17,33);
		System.out.println("Request number is "+requestNumber2);
		Takamol.verifyVocationalRequestCreatedOrNot();
		Takamol.navigateOnAppian("url_Appian");
		Thread.sleep(4000);
		CommonWebActions.wd.navigate().refresh();
		Thread.sleep(2000);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(requestNumber2);
		CommonWebActions.getWebElement("Appian_SearchRequest").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Takamol.rejectVocationalRequestFromTechnicalCommitteeMemeber();
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


		
	
