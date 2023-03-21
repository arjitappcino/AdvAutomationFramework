package takamol;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class TC05_TakamolE2E_IssueOfDisabledScense {
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
			ExcelUtil.strFile = ORUtil.getConfigValue("TestTakamol");
			if (ExcelUtil.getDataFromExcel(CommonWebActions.onlyTestCaseName, "Execute").equals("Y")) {
				AUT.login("url_React", "UserName", "Password");
				AUT.CheckLogo("TakamolLogo");
				Takamol.verifyTakamolHomePage();
				CommonWebActions.webClick("TakamolService");
				CommonWebActions.getWebElement("DashboardSearch").sendKeys("Issue of Disabled Scene");
				Thread.sleep(1000);
				
				CommonWebActions.webClick("IssueOfDisabledScense_link");
				Thread.sleep(1000);
				AUT.validateBreadCrumb("IssueOfDisabledScense_Header", "IssueOfDisabledScense header ");
				Thread.sleep(1000);

				Takamol.selectIssueOfDisabledDetails();
				CommonWebActions.webClick("IssueButton");
				Thread.sleep(1000);
			
				CommonWebActions.webClick("SendCerticateToEmail");
				Thread.sleep(2000);
				AUT.validateBreadCrumb("EmailSent_Header", "Email sent page header ");
				Thread.sleep(2000);
				CommonWebActions.webClick("OkButton");
				Thread.sleep(2000);
				// CommonWebActions.webClick("DownloadButton");
				AUT.closeBrowserWindow();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReportUtil.endReporter();
		}

	}

}