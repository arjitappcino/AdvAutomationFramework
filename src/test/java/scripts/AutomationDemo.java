package scripts;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import applicationSpecific.AUT;
import coreFramework.CommonWebActions;
import coreFramework.Constants;
import coreFramework.ORUtil;
import coreFramework.ReportUtil;

public class AutomationDemo extends CommonWebActions{
	
	@BeforeClass
	public void beforeSuite() throws IOException {

		ORUtil.strObjectRepoFilePath = Constants.TESTARTIFACTSPATH + ORUtil.getConfigValue("Locators");

	}
	
	@Test
	@Parameters({"TestCaseName","Url","UserName","Password"})
	public void testCaseFlow(String strTcName, String strUrl, String strUserName, String strPassword) throws InterruptedException, IOException {
		try {
		ReportUtil.startReporting();
		AUT.timeStamp();
		ReportUtil.reporterEvent("info", "This automation script covers Test Case Name: "+strTcName);		
			AUT.login(strUrl,strUserName,strPassword);
			AUT.closeBrowserWindow();
		
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
		}else if(result.getStatus()==ITestResult.SUCCESS){
			ReportUtil.reporterEvent("fatal", "Test case complete");
			ReportUtil.endReporter();
		}
	}

}
