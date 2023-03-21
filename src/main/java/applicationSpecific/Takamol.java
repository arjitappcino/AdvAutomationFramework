package applicationSpecific;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.impl.schema.SoapEncSchemaTypeSystem;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import coreFramework.CommonWebActions;
import coreFramework.ExcelUtilForLinkNavs;
import coreFramework.ORUtil;
import coreFramework.ReportUtil;
import coreFramework.SikullixDemo;

public class Takamol {
	
	
	public static boolean validateLetterPageScreen(){
		try{
			 if(CommonWebActions.webExists(CommonWebActions.getWebElement("Certificate"))){
				if(CommonWebActions.webExists(CommonWebActions.getWebElement("DownloadButton"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SendCerticateToEmail"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("RequestConfirmMsg")))
				  {
				  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
			      return true;						
			    }
			   else
			   ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			   return false;

		      }
		  }
		  catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			return false;
		  }
		return false;
   }
	public static boolean validateLLCCertificatePageScreen(){
		try{
			 if(CommonWebActions.webExists(CommonWebActions.getWebElement("IIC_CertificateMsg"))){
				if(CommonWebActions.webExists(CommonWebActions.getWebElement("DownloadButton"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SendCerticateToEmail")))
				  {
				  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
			      return true;						
			    }
			   else
			   ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			   return false;

		      }
		  }
		  catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			return false;
		  }
		return false;
   }
	
	
	
	
	public static boolean domesticLabourServiceScreen(){
		try{
			 if(CommonWebActions.webExists(CommonWebActions.getWebElement("Domestic_Header"))){
				if(CommonWebActions.webExists(CommonWebActions.getWebElement("IssueButton"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("BackButton")))
				  {
				  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
			      return true;						
			    }
			   else
			   ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			   return false;

		      }
		  }
		  catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			return false;
		  }
		return false;
   }
	
	
	public static boolean domesticLabourEmailScreen(){
		try{
			 if(CommonWebActions.webExists(CommonWebActions.getWebElement("Domestic_Heading"))){
				if(CommonWebActions.webExists(CommonWebActions.getWebElement("DownloadButton"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SendDecisionToEmail")))
				  {
				  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
			      return true;						
			    }
			   else
			   ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			   return false;

		      }
		  }
		  catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			return false;
		  }
		return false;
   }
	
	public static void selectIssueOfDisabledDetails() {
        try {
            CommonWebActions.webExplicitWait("ChooseTheBeneficiary", 120);
            if (CommonWebActions.webExists(CommonWebActions.getWebElement("ChooseTheBeneficiary"))) {
                Thread.sleep(1000);
                CommonWebActions.webClick("ChooseTheBeneficiary");
                Thread.sleep(1000);
                CommonWebActions.webClick("ChooseTheBeneficiaryValue");
                Thread.sleep(2000);
                CommonWebActions.webClick("PayingAuthority_dropdown");
                Thread.sleep(1000);
                CommonWebActions.webClick("PayingAuthority_dropdownValue2");
                Thread.sleep(1000);
                CommonWebActions.webClick("SizeYes");
                Thread.sleep(1000);
                CommonWebActions.webClick("NextButton");
                Thread.sleep(1000);
                ReportUtil.reporterEvent("pass",
                        "Details are selected " + CommonWebActions.captureScreenshotAsBase64());
            } else
                ReportUtil.reporterEvent("fail",
                        "Details not selected " + CommonWebActions.captureScreenshotAsBase64());
        }
        catch (Exception e) {
            e.printStackTrace();
            ReportUtil.reporterEvent("fail", "Details not selected " + CommonWebActions.captureScreenshotAsBase64());
        }
    }
	
	public static void uploadImageBySendKeys(String uploadLocation, String fileName){
		try {
        String strPath = System.getProperty("user.dir");
        String fileLoc = strPath + "/src/test/resources/testData/" + fileName + "";
        CommonWebActions.wd.findElement(By.xpath("//*[contains(text(),'"+uploadLocation+"')]/following::input")).sendKeys(fileLoc);
		Thread.sleep(1000);
	} catch (Exception e) {
		e.printStackTrace();
		ReportUtil.reporterEvent("fail", "File Uploaded Successfully" + CommonWebActions.captureScreenshotAsBase64());
	}
    }
	
	
	public static void uploadImagesInBulk(String uploadLocation, String fileName){
		try {
        String strPath = System.getProperty("user.dir");
        String fileLoc = strPath + "/src/test/resources/testData/" + fileName + "";
        ((WebElement) CommonWebActions.wd.findElements(By.xpath("//button[contains(text(),'Upload')]"))).sendKeys(fileLoc);
		Thread.sleep(1000);
	} catch (Exception e) {
		e.printStackTrace();
		ReportUtil.reporterEvent("fail", "File Uploaded Successfully" + CommonWebActions.captureScreenshotAsBase64());
	}
    }
	
	
	public void logOff() {
		try {
			CommonWebActions.webExplicitWait("LogoutButtonImage", 180);
			CommonWebActions.webClick("LogoutButtonImage");
			CommonWebActions.webClick("LogoutButtonText");
			CommonWebActions.webExplicitWait("LogoutMessage", 180);
			if (CommonWebActions.webExists(CommonWebActions.getWebElement("LogoutMessage"))) {
				ReportUtil.reporterEvent("pass", "Logoff Successful, [You have been Logged out] messgae displayed"
						+ CommonWebActions.captureScreenshotAsBase64());
			} else {
				ReportUtil.reporterEvent("fail",
						"Unable to logoff successfully" + CommonWebActions.captureScreenshotAsBase64());
			}

		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Logoff failure" + CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void selectEducationLORDetails(){
		try{
			CommonWebActions.webExplicitWait("ChooseTheOrphan", 120);
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("ChooseTheOrphan"))){
				CommonWebActions.webClick("ChooseTheOrphan");
				CommonWebActions.webClick("ChooseTheOrphanValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("LetterPurpose_dropdown");
				Thread.sleep(1000);
				CommonWebActions.webClick("LetterPurpose_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("SemsterDropdown");
				Thread.sleep(1000);	
				CommonWebActions.webClick("SemsterDropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("AreaDropdown");
				Thread.sleep(1000);
				CommonWebActions.webClick("AreaDropdownValue");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("AuthorityNameTextBox").sendKeys("Test");
				Thread.sleep(1000);
				CommonWebActions.webClick("NextButton");
				
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void selectHealthLORDetails(){
		try{
			CommonWebActions.webExplicitWait("ChooseTheOrphan", 120);
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("ChooseTheOrphan"))){
				CommonWebActions.webClick("ChooseTheOrphan");
				CommonWebActions.webClick("ChooseTheOrphanValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("LetterPurpose_dropdown");
				Thread.sleep(1000);
				CommonWebActions.webClick("LetterPurpose_dropdownValue1");
				Thread.sleep(1000);
				CommonWebActions.webClick("AreaDropdownHealth");
				Thread.sleep(1000);
				CommonWebActions.webClick("AreaDropdownValue");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("AuthorityNameTextBox").sendKeys("Test");
				CommonWebActions.webClick("NextButton");
				
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void selectOtherLORDetails(){
		try{
			CommonWebActions.webExplicitWait("ChooseTheOrphan", 120);
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("ChooseTheOrphan"))){
				CommonWebActions.webClick("ChooseTheOrphan");
				CommonWebActions.webClick("ChooseTheOrphanValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("LetterPurpose_dropdown");
				Thread.sleep(1000);
				CommonWebActions.webClick("LetterPurpose_dropdownValue2");
				Thread.sleep(1000);
				CommonWebActions.webClick("AreaDropdownHealth");
				Thread.sleep(1000);
				CommonWebActions.webClick("AreaDropdownValue");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("AuthorityNameTextBox").sendKeys("Test");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("LetterSubject").sendKeys("Automation");
				Thread.sleep(1000);//LetterBody
				CommonWebActions.getWebElement("LetterBody").sendKeys("This is automation test");
				Thread.sleep(2000);
				CommonWebActions.webClick("SendRequestButton");
				Thread.sleep(5000);
				
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void createRequestForRenewPassportAppian(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("CreateRequestButton"))){
				CommonWebActions.webClick("CreateRequestButton");
				AUT.validateBreadCrumb("CreateRequestHeader", "create request page appian header ");
				CommonWebActions.webClick("OrphanButton");
				Thread.sleep(3000);
				AUT.validateBreadCrumb("ServiceOrphanHeader", "Orphan page appian header ");
				CommonWebActions.webClick("RequestPassportLink");
				Thread.sleep(2000);
				AUT.validateBreadCrumb("SearchBeneficiaryHeader", "Beneficiary serach appian header ");
				CommonWebActions.getWebElement("Appian_NationalIDTextBox").sendKeys("9775812800");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("Appian_NationalIDTextBox").sendKeys(Keys.TAB);
				CommonWebActions.webClick("NationalIDSearchButton");
				Thread.sleep(1000);
				CommonWebActions.webClick("SelectFirstRecord");
				CommonWebActions.webClick("RequestNxtButton");
				AUT.validateBreadCrumb("ServiceRequestFormHeader", "Request form header ");
				verifyAppianServiceRequestFormScreen();
				CommonWebActions.webClick("RenewPassport");
				Thread.sleep(1000);
		        CommonWebActions.scrollIntoWebElement_ActionClass("MMP_SubmitButton");
				/*CommonWebActions.webClick("FosterUploadButtonOne");
				Takamol.attachAndVerifyFilesForTakamol("TestImage.png");*/
		        Takamol.uploadImageBySendKeys("BIRTH CERTIFICATE", "TestImage.png");
		        String expectedFile ="TestImage";
				String actualFile = CommonWebActions.getWebElement("AttachedFileAppian").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				
				Thread.sleep(1000);
				CommonWebActions.webClick("MMP_SubmitButton");
				Thread.sleep(1000);
				AUT.validateBreadCrumb("RenewPassportPopup", "Renew passport popup header ");
				CommonWebActions.webClick("ConfirmRequest_YesButton");
				Thread.sleep(1000);
				ReportUtil.reporterEvent("pass", "request created "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "request not created "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "request not created "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	
	
	public static boolean verifyRequestCreatedOrNot() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("RequestCreatedHeader").getText();
				System.out.println(s1);
				if(s1.contains("Recommendation Letter No REQ")){
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("OkButton"))
					  &&CommonWebActions.webExists(CommonWebActions.getWebElement("OkButton"))){
					  ReportUtil.reporterEvent("pass", "Request created "+CommonWebActions.captureScreenshotAsBase64());
                      CommonWebActions.webClick("OkButton");
					  Thread.sleep(2000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				else{
					 ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
					   return false;
				}
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean verifyRenewPassportRequestCreatedOrNot() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("Medical_RequestCreatedHeader").getText();
				if(s1.contains("Request No")){
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("SuccessPopup"))
					  &&CommonWebActions.webExists(CommonWebActions.getWebElement("MinistryApproval_CloseButton"))){
					  ReportUtil.reporterEvent("pass", "Request created for renew passport"+CommonWebActions.captureScreenshotAsBase64());
				       CommonWebActions.webClick("MinistryApproval_CloseButton");
						Thread.sleep(2000);

				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Request not created for renew passport "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				else{
					 ReportUtil.reporterEvent("fail", "Request not created for renew passport "+CommonWebActions.captureScreenshotAsBase64());
					   return false;
				}
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not created for renew passport "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	public static boolean verifyRenewPassportRequestSentToDirector() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("RenewRequestForReview").getText();
				if(s1.contains("sent for review")){
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("SuccessPopup"))
					  &&CommonWebActions.webExists(CommonWebActions.getWebElement("MinistryApproval_CloseButton"))){
					  ReportUtil.reporterEvent("pass", "Request sent to director for review"+CommonWebActions.captureScreenshotAsBase64());
				       CommonWebActions.webClick("MinistryApproval_CloseButton");
						Thread.sleep(4000);

				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Request not sent to director for review "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				else{
					 ReportUtil.reporterEvent("fail", "Request not sent to director for review "+CommonWebActions.captureScreenshotAsBase64());
					   return false;
				}
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not sent to director for review "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean verifyRenewPassportRequestCompleted() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("ConfirmRenewRequest").getText();
				if(s1.contains("has been completed")){
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("SuccessPopup"))
					  &&CommonWebActions.webExists(CommonWebActions.getWebElement("MinistryApproval_CloseButton"))){
					  ReportUtil.reporterEvent("pass", "Request completed"+CommonWebActions.captureScreenshotAsBase64());
				       CommonWebActions.webClick("MinistryApproval_CloseButton");
						Thread.sleep(4000);

				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Request not completed "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				else{
					 ReportUtil.reporterEvent("fail", "Request not completed "+CommonWebActions.captureScreenshotAsBase64());
					   return false;
				}
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not completed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static void createRequestForIdentificationPapersAppian(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("CreateRequestButton"))){
				CommonWebActions.webClick("CreateRequestButton");
				AUT.validateBreadCrumb("CreateRequestHeader", "create request page appian header ");
				CommonWebActions.webClick("OrphanButton");
				Thread.sleep(3000);
				AUT.validateBreadCrumb("ServiceOrphanHeader", "Orphan page appian header ");
				CommonWebActions.webClick("IdentificationPapersLink");
				Thread.sleep(2000);
				AUT.validateBreadCrumb("SearchApplicantHeader", "Applicant search appian header ");
				CommonWebActions.getWebElement("SRNTextBox").sendKeys("SRN2200000789");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("SRNTextBox").sendKeys(Keys.TAB);
				CommonWebActions.webClick("AppianSearchIcon");
				Thread.sleep(1000);
				CommonWebActions.webClick("SelectFirstRecord");
				CommonWebActions.webClick("RequestNxtButton");
				AUT.validateBreadCrumb("IPRequestFormHeader", "Request form header ");
				AUT.validateBreadCrumb("CreateRequestHeader", "Create request header ");
				//verifyIdentificationPapersRequestFormScreen();
				CommonWebActions.webClick("IPSelectOrphanTypeDropdown");
				CommonWebActions.webClick("IPOrphanType1");
				Thread.sleep(2000);
		        //CommonWebActions.scrollIntoWebElement_ActionClass("MMP_SubmitButton");
				/*CommonWebActions.webClick("FosterUploadButtonOne");
				Takamol.attachAndVerifyFilesForTakamol("TestImage.png");*/
				
		        Takamol.uploadMultipleFileBySendKeys("*", "TestImage.png");
		        
				//Takamol.uploadImageBySendKeys("DNA TEST RESULT OF THE ADOPTED AND WHO’S CLAIMING THAT SHE IS THE MOTHER AND CONFIRM IT", "TestImage.png");
		        String expectedFile ="TestImage";
				String actualFile = CommonWebActions.getWebElement("AttachedFileAppian").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				
				Thread.sleep(1000);
				CommonWebActions.webClick("IPSubmitButton");
				Thread.sleep(1000);
				CommonWebActions.webClick("ConfirmRequest_YesButton");
				AUT.validateBreadCrumb("SuccessPopup", "Success Pop-up IP");
				Thread.sleep(1000);
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static boolean verifyIdentificationPapersRequestCreatedOrNot() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("IPRequestForReview").getText();
				if(s1.contains("Request No")){
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("SuccessPopup"))
					  &&CommonWebActions.webExists(CommonWebActions.getWebElement("MinistryApproval_CloseButton"))){
					  ReportUtil.reporterEvent("pass", "Request created for Request to Issue Identification Papers"+CommonWebActions.captureScreenshotAsBase64());
				       CommonWebActions.webClick("MinistryApproval_CloseButton");
						Thread.sleep(5000);

				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Request not created for Request to Issue Identification Papers "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				else{
					 ReportUtil.reporterEvent("fail", "Request not created for Request to Issue Identification Papers "+CommonWebActions.captureScreenshotAsBase64());
					   return false;
				}
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not created for Request to Issue Identification Papers "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean verifyIdentificationPapersRequestCompletedOrNot() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("IPRequestCompleted").getText();
				if(s1.contains("Request No")){
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("SuccessPopup"))
					  &&CommonWebActions.webExists(CommonWebActions.getWebElement("MinistryApproval_CloseButton"))){
					  ReportUtil.reporterEvent("pass", "Request created for Request to Issue Identification Papers"+CommonWebActions.captureScreenshotAsBase64());
				       CommonWebActions.webClick("MinistryApproval_CloseButton");
						Thread.sleep(5000);

				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Request not created for Request to Issue Identification Papers "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				else{
					 ReportUtil.reporterEvent("fail", "Request not created for Request to Issue Identification Papers "+CommonWebActions.captureScreenshotAsBase64());
					   return false;
				}
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not created for Request to Issue Identification Papers "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static void navigateOnAppian(String strEnvURL){
	
		try {
			String  strEnv= ORUtil.getConfigValue(strEnvURL);
			CommonWebActions.wd.navigate().to(strEnv);
		} catch (Exception e) {
			e.printStackTrace();
		
		
		}
	}
	
//	public static void uploadMultipleFileBySendKeys(String uploadLocation, String fileName){
//        try {
//        String strPath = System.getProperty("user.dir");
//        String fileLoc = strPath + "/src/test/resources/testData/" + fileName + "";
//        List<WebElement> list = CommonWebActions.wd.findElements(By.xpath("//*[contains(text(),'"+uploadLocation+"')]"));
//        ((WebElement) list).sendKeys(fileLoc);
//        Thread.sleep(1000);
//    } catch (Exception e) {
//        e.printStackTrace();
//        ReportUtil.reporterEvent("fail", "File Uploaded Successfully" + CommonWebActions.captureScreenshotAsBase64());
//    }
//    }
		public static List<WebElement> uploadMultipleFileBySendKeys(String uploadLocation, String fileName){
	        try {
	        String strPath = System.getProperty("user.dir");
	        String fileLoc = strPath + "/src/test/resources/testData/" + fileName + "";
	        List<WebElement> list = CommonWebActions.wd.findElements(By.xpath("//*[contains(text(),'"+uploadLocation+"')]/following::input"));
	       // ((WebElement) list).sendKeys(fileLoc);
	        System.out.println(list);
	        System.out.println(list.size());
	        for(int i=1;i<list.size();i++)
	         {
	            list.get(i).sendKeys(fileLoc);
	         }
	        
	         return list;
	    } catch (Exception e) {
	        e.printStackTrace();
	        ReportUtil.reporterEvent("fail", "File Uploaded Successfully" + CommonWebActions.captureScreenshotAsBase64());
	    }
	        return null;
	    }
	
	public static void loginInAppian() {
		try {

			Thread.sleep(1000);
			CommonWebActions.getWebElement("Appian_UnTextBox").sendKeys("MinistryEmployee");
			Thread.sleep(1000);
			CommonWebActions.getWebElement("Appian_PwdTextBox").sendKeys("MinistryEmployee123");
            CommonWebActions.webClick("Appian_SignIn");

			CommonWebActions.webVerifyPageTitle("AppianPageTitle", true);
			CommonWebActions.webExplicitWait("Appian_UserNameText", 180);
			
			String expectedUserName ="Ministry Employee";
			String actualUserName = CommonWebActions.getWebElement("Appian_UserNameText").getText();
			if (actualUserName.contains(expectedUserName)) {

				ReportUtil.reporterEvent("pass", " UserName name displayed");
			} else {

				ReportUtil.reporterEvent("fail", " UserName not matched");

			}

			

		} catch (Exception e) {
			e.printStackTrace();

			ReportUtil.reporterEvent("fatal", "Login failure" + CommonWebActions.captureScreenshotAsBase64());

		}
	}
	
	public static boolean approveRequestFromMinistry() {
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromMinistry"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                      CommonWebActions.webClick("ReviewFromMinistry");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("Appian_ServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
                      CommonWebActions.webClick("ApproveReq_Yes");
					  Thread.sleep(1000);
                      //CommonWebActions.scrollIntoWebElement_new("Appian_SendRequestButton");
                      CommonWebActions.webClick("Appian_SendRequestButton");
					  Thread.sleep(1000);
                      sendMinistryApprovalConfirm();
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("ApprovalConfirmationHeader", "Ministry emp.confirm page header ");
					  CommonWebActions.webClick("MinistryApproval_CloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to director "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request sent to director "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean reviewFromMinistryBranchSpecialist() {
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromMinistrySpecialist"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                      CommonWebActions.webClick("ReviewFromMinistrySpecialist");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("MinistrySpecialistPage", "Ministry specialist page header ");
				      CommonWebActions.scrollIntoWebElement_ActionClass("Disability_SendButton");
					  Thread.sleep(1000);
                      CommonWebActions.webClick("MinistrySpecialistAcceptButton");
					  Thread.sleep(1000);
                      CommonWebActions.webClick("Disability_SendButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("Confirm_MinistrySpecialist", "Ministry specialist confirm popup ");
					  CommonWebActions.webClick("ConfirmRequest_YesButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request review from ministry specialist "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not review from ministry specialist "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean confirmRequestFromMinistryBranchSpecialist() {
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ConfirmFromMinistryBranch"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                      CommonWebActions.webClick("ConfirmFromMinistryBranch");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("UpdateRequestStatusPage", "Request update status page header ");
				      CommonWebActions.scrollIntoWebElement_ActionClass("MMP_SubmitButton");
					  Thread.sleep(2000);
					   /*CommonWebActions.webClick("FosterUploadButtonOne");
						Takamol.attachAndVerifyFilesForTakamol("TestImage.png");*/
					  Takamol.uploadImageBySendKeys("LETTER TO APPLICANT", "TestImage.png");
					  Thread.sleep(1000);
				        String expectedFile ="TestImage";
						String actualFile = CommonWebActions.getWebElement("AttachedFileAppian").getText();
						if (actualFile.contains(expectedFile)) {

							ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
						} else {

							ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

						}
												
						CommonWebActions.webClick("UpdateStatusRequestDropDown");
						Thread.sleep(2000);
						CommonWebActions.webClick("SelectCompleteStatus");
						Thread.sleep(2000);
						CommonWebActions.webClick("MMP_SubmitButton");

					  AUT.validateBreadCrumb("Confirm_RequestHeader", "Confirm popup ");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("ConfirmRequest_YesButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request confirmed from ministry "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not confirmed from ministry "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean reviewFromDirector() {
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("RenewRequestForDirector"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                      CommonWebActions.webClick("RenewRequestForDirector");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("GeneralDirectorPage", "General director page header ");
				      CommonWebActions.scrollIntoWebElement_ActionClass("Disability_SendButton");
					  Thread.sleep(1000);
                      CommonWebActions.webClick("MinistrySpecialistAcceptButton");
					  Thread.sleep(1000);
                      CommonWebActions.webClick("Disability_SendButton");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("ConfirmRequest_YesButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent for final approval "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request sent final approval "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean sendMinistryApprovalConfirm() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("Appian_MinistryConfirmHeaderPopup").getText();
				System.out.println(s1);
				if(s1.contains("Are you sure")){
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ConfirmRequest_YesButton"))
					  &&CommonWebActions.webExists(CommonWebActions.getWebElement("ConfirmRequest_NoButton"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                      CommonWebActions.webClick("ConfirmRequest_YesButton");
					  Thread.sleep(2000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Request sent to director "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				else{
					 ReportUtil.reporterEvent("fail", "Request sent to director "+CommonWebActions.captureScreenshotAsBase64());
					   return false;
				}
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not sent to director "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	public static boolean approveRequestFromDirector() {
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromDirector"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                      CommonWebActions.webClick("ReviewFromDirector");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("Appian_ServiceHeaderDetailPage", "Appian service detail page header ");
                      CommonWebActions.webClick("DirectApproveButton");
					  Thread.sleep(1000);
					  confirmApprovalFromDirector();
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("ApprovalConfirmationHeader", "Ministry emp.confirm page header ");
					  CommonWebActions.webClick("MinistryApproval_CloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Request sent to director "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request sent to director "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean confirmApprovalFromDirector() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("Appian_DirectorConfirmHeaderPopup").getText();
				System.out.println(s1);
				if(s1.contains("Are you sure")){
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ConfirmRequest_YesButton"))
					  &&CommonWebActions.webExists(CommonWebActions.getWebElement("ConfirmRequest_NoButton"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                      CommonWebActions.webClick("ConfirmRequest_YesButton");
					  Thread.sleep(2000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Request sent to director "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				else{
					 ReportUtil.reporterEvent("fail", "Request sent to director "+CommonWebActions.captureScreenshotAsBase64());
					   return false;
				}
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not sent to director "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean verifyTakamolHomePage(){
		try{
			 if(CommonWebActions.webExists(CommonWebActions.getWebElement("DashboardModule"))){
				if(CommonWebActions.webExists(CommonWebActions.getWebElement("CertificatesCards"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("MyRequest"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SocialRecords")))
				  {
				  ReportUtil.reporterEvent("pass", "All elements are present on home page "+CommonWebActions.captureScreenshotAsBase64());
			      return true;						
			    }
			   else
			   ReportUtil.reporterEvent("fail", "All elements are not present on home page "+CommonWebActions.captureScreenshotAsBase64());
			   return false;

		      }
		  }
		  catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			return false;
		  }
		return false;
  }
		
	public static boolean verifyAppianServiceRequestFormScreen(){
		try{
			 if(CommonWebActions.webExists(CommonWebActions.getWebElement("IssuePassport"))){
				if(CommonWebActions.webExists(CommonWebActions.getWebElement("IssuePassport"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("RenewPassport"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("TravelPermit")))
				  {
				  ReportUtil.reporterEvent("pass", "All elements are present on request form "+CommonWebActions.captureScreenshotAsBase64());
			      return true;						
			    }
			   else
			   ReportUtil.reporterEvent("fail", "All elements are not present on request form "+CommonWebActions.captureScreenshotAsBase64());
			   return false;

		      }
		  }
		  catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			return false;
		  }
		return false;
  }
	
	public static boolean verifyIdentificationPapersRequestFormScreen(){
		try{
			 if(CommonWebActions.webExists(CommonWebActions.getWebElement("IPBackButton"))){
				if(CommonWebActions.webExists(CommonWebActions.getWebElement("IPCancelButton"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("IPSaveAsDraft"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("IPSubmitButton")))
				  {
				  ReportUtil.reporterEvent("pass", "All elements are present on request form "+CommonWebActions.captureScreenshotAsBase64());
			      return true;						
			    }
			   else
			   ReportUtil.reporterEvent("fail", "All elements are not present on request form "+CommonWebActions.captureScreenshotAsBase64());
			   return false;

		      }
		  }
		  catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			return false;
		  }
		return false;
  }
	
	public static boolean reviewFromEmployeeGeneralAdministration() {
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromEmployeeGeneralAdmin"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                   CommonWebActions.webClick("ReviewFromEmployeeGeneralAdmin");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("ReviewDetailsPageHeading", "Review Details Heading ");
					  AUT.validateBreadCrumb("ReviewDetailsPageButton", "Review Details button ");
					  AUT.validateBreadCrumb("OrphanTypeHeading", "Orphan Type Button ");
					  AUT.validateBreadCrumb("OrphanTypeText", "Orphan Type Text ");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("RemarksTextBox", "Remarks Text Box ");
				      CommonWebActions.scrollIntoWebElement_ActionClass("IPSubmitButton");
					  Thread.sleep(2000);
					  CommonWebActions.webClick("AcceptRadioButton");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("RemarksTextBox");
					  Thread.sleep(2000);
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Accepting the request");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("IPSubmitButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SubmitPopUp", "Submit confirmation Pop-up ");
					  CommonWebActions.webClick("ConfirmRequest_YesButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request review from Employee of General Administrator successful "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request review from Employee of General Administrator Failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean reviewFromUnderSecretaryIP() {
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromUndersecretary"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                CommonWebActions.webClick("ReviewFromUndersecretary");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("ReviewDetailsPageHeading", "Review Details Heading ");
					  AUT.validateBreadCrumb("ReviewDetailsPageButton", "Review Details button ");
					  AUT.validateBreadCrumb("OrphanTypeHeading", "Orphan Type Button ");
					  AUT.validateBreadCrumb("OrphanTypeText", "Orphan Type Text ");
					  AUT.validateBreadCrumb("GeneratedLetterHeading", "Civil Ahwal Letter heading ");
					  AUT.validateBreadCrumb("GeneratedLetterFile", "Civil Ahwal Letter Downloadable file ");
					  AUT.validateBreadCrumb("AcceptRadioButton", "Accept Radio Button ");
					  AUT.validateBreadCrumb("RejectRadioButton", "Reject Radio Button ");
					  AUT.validateBreadCrumb("ReturnRadioButton", "Return Radio Button ");
					  
					  Thread.sleep(1000);
					  CommonWebActions.webClick("DocumentTab");
					  AUT.validateBreadCrumb("GeneratedLetterHeading", "Civil Ahwal Letter heading ");
					  AUT.validateBreadCrumb("GeneratedLetterFile", "Civil Ahwal Letter Downloadable file ");
					  Thread.sleep(1000);
					  
				//	  CommonWebActions.webClick("AcceptRadioButton");
				//	  Thread.sleep(1000);
					  CommonWebActions.webClick("RequestRemarksTab");
					  
					  
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AppianRemarksTextBox", "Remarks Text Box ");
				      CommonWebActions.scrollIntoWebElement_ActionClass("IPSubmitButton");
					  Thread.sleep(2000);
					  CommonWebActions.webClick("AcceptRadioButton");
					  Thread.sleep(1000);
				//	  CommonWebActions.webClick("AppianRemarksTextBox");
					//  Thread.sleep(2000);
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Accepting the request");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("IPSubmitButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SubmitPopUp", "Submit confirmation Pop-up ");
					  CommonWebActions.webClick("ConfirmRequest_YesButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request review from Undersecretary successful "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request review from Undersecretary Failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean requestCompletionFromEmployeeOfGeneralAdminIP() {
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromEmployeeGeneralAdmin"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
             CommonWebActions.webClick("ReviewFromEmployeeGeneralAdmin");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("ReviewDetailsPageHeading", "Review Details Heading ");
					  AUT.validateBreadCrumb("ReviewDetailsPageButton", "Review Details button ");
					  AUT.validateBreadCrumb("OrphanTypeHeading", "Orphan Type Button ");
					  AUT.validateBreadCrumb("OrphanTypeText", "Orphan Type Text ");
					  AUT.validateBreadCrumb("GeneratedLetterHeading", "Civil Ahwal Letter heading ");
					  AUT.validateBreadCrumb("GeneratedLetterFile", "Civil Ahwal Letter Downloadable file ");
					  
					  Thread.sleep(1000);
					  CommonWebActions.webClick("DocumentTab");
					  AUT.validateBreadCrumb("GeneratedLetterHeading", "Civil Ahwal Letter heading ");
					  AUT.validateBreadCrumb("GeneratedLetterFile", "Civil Ahwal Letter Downloadable file ");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("RequestRemarksTab");
					  
					  
					  Thread.sleep(2000);
					  CommonWebActions.webClick("IPSubmitButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SubmitPopupComplete", "Complete confirmation Pop-up ");
					  CommonWebActions.webClick("ConfirmRequest_YesButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request completed from Employee of General Admin "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request could not complete from Employee of General Admin "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean validateHeaderList(String coulumnNames){
		try{
		List<WebElement>headerName=new ArrayList<WebElement>();
		headerName=CommonWebActions.getWebElements("HeaderList");
		int count=0;
		int failCount=0;
		for(WebElement header:headerName){
			count=count+1;
			if(count==headerName.size())break;
			String headerlist=header.getText();
			if(coulumnNames.contains(headerlist)){
				ReportUtil.reporterEvent("pass", "Displayed Column header: "+headerlist);
			}else failCount++;
		}if(failCount!=0)return false;
			
		else return true;
	}catch(Exception e){
		ReportUtil.reporterEvent("fail", "Web Element [ " + " ] NOT FOUND on UI" + CommonWebActions.captureScreenshotAsBase64());
		e.printStackTrace();
		return false;
	}
}
	public static boolean validateHeaderListForStateFeeBearingProgram(String coulumnNames){
		try{
		List<WebElement>headerName=new ArrayList<WebElement>();
		headerName=CommonWebActions.getWebElements("HeaderListSFBP");
		int count=0;
		int failCount=0;
		for(WebElement header:headerName){
			count=count+1;
			if(count==headerName.size())break;
			String headerlist=header.getText();
			if(coulumnNames.contains(headerlist)){
				ReportUtil.reporterEvent("pass", "Displayed Column header: "+headerlist);
			}else failCount++;
		}if(failCount!=0)return false;
			
		else return true;
	}catch(Exception e){
		ReportUtil.reporterEvent("fail", "Web Element [ " + " ] NOT FOUND on UI" + CommonWebActions.captureScreenshotAsBase64());
		e.printStackTrace();
		return false;
	}
}
	
	public static boolean validateMMPPageScreen(){
		try{
			 if(CommonWebActions.webExists(CommonWebActions.getWebElement("MMP_UploadButton"))){
				if(CommonWebActions.webExists(CommonWebActions.getWebElement("MMP_PreviousButton"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("NextButton"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("MMP_SaveButton")))
				  {
				  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
			      return true;						
			    }
			   else
			   ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			   return false;

		      }
		  }
		  catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			return false;
		  }
		return false;
   }
	
	public static void attachAndVerifyFiles(String str) {

		String strPath = System.getProperty("user.dir");
		System.out.println(strPath);
		String fileLoc = strPath + "/src/test/resources/testData/" + str + "";
		String browse = strPath + "/src/test/resources/testData/Upload.PNG";
		String name = strPath + "/src/test/resources/testData/name.PNG";
		String open = strPath + "/src/test/resources/testData/open.PNG";
		String strFilename[] = str.split("/.");
		System.out.println("str----" + str);
		System.out.println(strFilename[0]);
		try {
			SikullixDemo.fileAttachment(browse, name, open, fileLoc);
		} catch (Exception ex) {

		}
		

	}
	
	public static void attachAndVerifyFilesForTakamol(String str) {
        
		String strPath = System.getProperty("user.dir");
		System.out.println(strPath);
		String fileLoc = strPath + "/src/test/resources/testData/" + str + "";
		//String browse = strPath + "/src/test/resources/testData/Upload.PNG";
		String name = strPath + "/src/test/resources/testData/name.PNG";
		String open = strPath + "/src/test/resources/testData/open.PNG";
		String strFilename[] = str.split("/.");
		System.out.println("str----" + str);
		System.out.println(strFilename[0]);
		try {
			SikullixDemo.fileAttachmentTakamol( name, open, fileLoc);
		} catch (Exception ex) {

		}
		

	}
	
	public static void selectMMRHostingDetails(){
		try{
			CommonWebActions.webExplicitWait("HoastingDate_dropdown", 120);
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("HoastingDate_dropdown"))){
				CommonWebActions.webClick("HoastingDate_dropdown");
				CommonWebActions.webClick("HoastingDate_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("HoastingReason_dropdown");
				CommonWebActions.webClick("HoastingReason_dropdownValue");
				Thread.sleep(1000);
				/*CommonWebActions.webClick("RequiredAgeOrphan_dropdown");
				CommonWebActions.webClick("RequiredAgeOrphan_dropdownValue");
				Thread.sleep(1000);*/
				CommonWebActions.webClick("GenderOrphan_dropdown");
				CommonWebActions.webClick("GenderAgeOrphan_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("HoastingQuestion_dropdown");
				CommonWebActions.webClick("HoastingQuestion_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("NextButton");
				
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void selectFFPHostingDetails(){
		try{
			CommonWebActions.webExplicitWait("HoastingDate_dropdown", 120);
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("HoastingDate_dropdown"))){
				CommonWebActions.webClick("HoastingDate_dropdown");
				CommonWebActions.webClick("HoastingDate_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("HoastingReason_dropdown");
				CommonWebActions.webClick("HoastingReason_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("RequiredAgeOrphan_dropdown");
				CommonWebActions.webClick("RequiredAgeOrphan_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("GenderOrphan_dropdown");
				CommonWebActions.webClick("GenderAgeOrphan_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("HoastingQuestion_dropdown");
				CommonWebActions.webClick("HoastingQuestion_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("NextButton");
				
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void selectFosterFamilyDetailsForIncubation(){
		try{
			CommonWebActions.webExplicitWait("ChildReqIncubationDropDown", 120);
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("ChildReqIncubationDropDown"))){
				CommonWebActions.webClick("ChildReqIncubationDropDown");
				CommonWebActions.webClick("RequiredAgeOrphan_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("HealthDropDown");
				CommonWebActions.webClick("HealthConditionValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("GenderOrphan_dropdown");
				CommonWebActions.webClick("GenderAgeOrphan_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("RequestingIcubation");
				CommonWebActions.webClick("RequestingIcubationValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("NextButton");
				
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
/*	public static void selectDisabilityAssessmentDetails(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("SizeYes"))){
				CommonWebActions.webClick("SizeYes");
				CommonWebActions.webClick("RegistrationFieldDropdown");
				Thread.sleep(1000);
				CommonWebActions.webClick("RegionNameValue");
				CommonWebActions.webClick("AhilCenterDropDown");
				Thread.sleep(1000);
				CommonWebActions.webClick("HospitalValue");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("DateTextField").sendKeys("08/11/2022");
				//Takamol.attachAndVerifyFiles("Test.pdf");
		        Takamol.uploadImageBySendKeys("Medical Report Attachment", "Test.pdf");
		        String expectedFile ="Test.pdf";
				String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
		        CommonWebActions.scrollIntoWebElement_ActionClass("NextButton");
		        Thread.sleep(1000);
				CommonWebActions.webClick("NextButton");
		        Thread.sleep(1000);
		        AUT.validateBreadCrumb("Disability_UndertakingAndDeclarationHeader", "Declaration header ");
		        CommonWebActions.scrollIntoWebElement_ActionClass("Disability_SendButton");
				CommonWebActions.webClick("ApprovalCheckBox");
				CommonWebActions.webClick("Disability_SendButton");
		        Thread.sleep(1000);
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}*/
	
	public static void selectObjectionServiceDetails(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("ObjectionTypeDropDown"))){
				CommonWebActions.webClick("ObjectionTypeDropDown");
				Thread.sleep(1000);
				CommonWebActions.webClick("ObjectionTypeValue");				
				Thread.sleep(1000);
				CommonWebActions.getWebElement("ReasonForObjection").sendKeys("Automation Test");
				Thread.sleep(1000);
				/*CommonWebActions.webClick("UploadButtonOne");
				Takamol.attachAndVerifyFilesForTakamol("TestImage.png");*/
				 Takamol.uploadImageBySendKeys("Medical Reports", "TestImage.png");
		        String expectedFile ="TestImage";
				String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				Thread.sleep(1000);
				/*CommonWebActions.webClick("UploadButtonTwo");
				Takamol.attachAndVerifyFilesForTakamol("TestImage.png");*/
				 Takamol.uploadImageBySendKeys("Attach proof of the validity of the objection", "TestImage.png");
		        String expFile ="TestImage";
				String actFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actFile.contains(expFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				CommonWebActions.webClick("SubmitRequest");
		        Thread.sleep(1000);
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static boolean verifyMMRRequestSubmitOrNot() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("MMP_RequestCreatedHeader").getText();
				if(s1.contains("REQ")){
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("OkButton"))
					  &&CommonWebActions.webExists(CommonWebActions.getWebElement("OkButton"))){
					  ReportUtil.reporterEvent("pass", "Request created "+CommonWebActions.captureScreenshotAsBase64());
                      CommonWebActions.webClick("OkButton");
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Request created "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				else{
					 ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
					   return false;
				}
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	public static boolean verifySocialRecordsComponents(){
		try{
			 if(CommonWebActions.webExists(CommonWebActions.getWebElement("SR_Personal"))){
				if(CommonWebActions.webExists(CommonWebActions.getWebElement("SR_Personal"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SR_Father"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SR_Mother"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SR_Education"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SR_Beneficiary"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SR_Dependency"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SR_Address"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SR_Children"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SR_Spouse"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SR_Financial"))
				  &&CommonWebActions.webExists(CommonWebActions.getWebElement("SR_AppData")))
				  {
				  ReportUtil.reporterEvent("pass", "All modules are present on social records page "+CommonWebActions.captureScreenshotAsBase64());
			      return true;						
			    }
			   else
			   ReportUtil.reporterEvent("fail", "All modules are not present on social records page "+CommonWebActions.captureScreenshotAsBase64());
			   return false;

		      }
		  }
		  catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Elements are not present "+CommonWebActions.captureScreenshotAsBase64());
			return false;
		  }
		return false;
  }
	
	public static boolean verifyDeleteImagePopup() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("DeleteImagePopup").getText();
				if(s1.contains("Do you want to delete the file?")){
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ConfirmRequest_YesButton"))
					  &&CommonWebActions.webExists(CommonWebActions.getWebElement("ConfirmRequest_YesButton"))){
				        Thread.sleep(1000);
						CommonWebActions.webClick("ConfirmRequest_YesButton");
					  ReportUtil.reporterEvent("pass", "Image deleted successfully "+CommonWebActions.captureScreenshotAsBase64());
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Image not deleted  "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				else{
					 ReportUtil.reporterEvent("fail", "Image not deleted "+CommonWebActions.captureScreenshotAsBase64());
					   return false;
				}
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Image not deleted "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	public static boolean confirmPersonalRecords() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("SR_PersonalDataUpdatePopup").getText();
				if(s1.contains("The beneficiary's data has been updated")){
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("OkButton"))
					  &&CommonWebActions.webExists(CommonWebActions.getWebElement("OkButton"))){
						CommonWebActions.webClick("OkButton");
					  ReportUtil.reporterEvent("pass", "Records updated successfully "+CommonWebActions.captureScreenshotAsBase64());
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Records not updated  "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				else{
					 ReportUtil.reporterEvent("fail", "Records not updated "+CommonWebActions.captureScreenshotAsBase64());
					   return false;
				}
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Records not updated "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static void updateSocialRecordsFatherData(){
		try{
			CommonWebActions.webClick("SR_Father");
	        Thread.sleep(1000);
	        AUT.validateBreadCrumb("SR_FatherHeader", "Social father records header ");
	        CommonWebActions.webClick("FatherNameTextBox");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("FatherNameTextBox").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("FatherNameTextBox").sendKeys("Test");
	        Thread.sleep(1000);
	        CommonWebActions.scrollIntoWebElement_ActionClass("MMP_SaveButton");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("SRAcceptCheckBox");
	        CommonWebActions.webClick("MMP_SaveButton");
	        Thread.sleep(1000);
	        confirmPersonalRecords();
	        Thread.sleep(1000);
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Issue with records "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	public static void updateSocialRecordsMotherData(){
		try{
			CommonWebActions.webClick("SR_Mother");
	        Thread.sleep(1000);
	        AUT.validateBreadCrumb("SR_MotherHeader", "Social mother records header ");
	        CommonWebActions.webClick("FatherNameTextBox");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("FatherNameTextBox").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("FatherNameTextBox").sendKeys("Test");
	        Thread.sleep(1000);
	        CommonWebActions.scrollIntoWebElement_ActionClass("MMP_SaveButton");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("SRAcceptCheckBox");
	        CommonWebActions.webClick("MMP_SaveButton");
	        Thread.sleep(2000);
	        confirmPersonalRecords();
	        Thread.sleep(1000);
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Issue with records "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	public static void updateSocialRecordsEducationData(){
		try{
			CommonWebActions.webClick("SR_Education");
	        Thread.sleep(1000);
	        AUT.validateBreadCrumb("SR_EducationHeader", "Social education records header ");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("SRAcceptCheckBox");
	        CommonWebActions.webClick("MMP_SaveButton");
	        Thread.sleep(1000);
	        confirmPersonalRecords();
	        Thread.sleep(1000);
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Issue with records "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	public static void updateBeneficiarySocialData(){
		try{
			CommonWebActions.webClick("SR_Beneficiary");
	        Thread.sleep(1000);
	        AUT.validateBreadCrumb("SR_BeneficiaryHeader", "Beneficiary Social education records header ");
	       /* CommonWebActions.webClick("SocialRelationshipDropdown");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("SocialRelationshipDropdownValue");
	        Thread.sleep(1000);*/
	        CommonWebActions.getWebElement("NumberPersonLiving").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("NumberPersonLiving").sendKeys("4");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("NumberOfChild_NO");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("SRAcceptCheckBox");
	        CommonWebActions.webClick("MMP_SaveButton");
	        Thread.sleep(1000);
            confirmPersonalRecords();
	        Thread.sleep(1000);
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Issue with records "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void updateDependencyData(){
		try{
			CommonWebActions.webClick("SR_Dependency");
	        Thread.sleep(1000);
	        AUT.validateBreadCrumb("SR_DependencyHeader", "Social dependency records header ");
	        CommonWebActions.webClick("SRAcceptCheckBox");
	        CommonWebActions.webClick("MMP_SaveButton");
	        Thread.sleep(2000);
	        confirmPersonalRecords();
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Issue with records "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void updateAddressData(){
		try{
			CommonWebActions.webClick("SR_Address");
	        Thread.sleep(1000);
	        AUT.validateBreadCrumb("SR_AddressHeader", "Social Address records header ");
	        CommonWebActions.webClick("AddBuildingNumber");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("AddBuildingNumber").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        CommonWebActions.getWebElement("AddBuildingNumber").sendKeys("Test");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("AdditionalNumber").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        CommonWebActions.getWebElement("AdditionalNumber").sendKeys("123456");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("ZipCode").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        CommonWebActions.getWebElement("ZipCode").sendKeys("123456");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("StreetName").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        CommonWebActions.getWebElement("StreetName").sendKeys("Test");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("DistName").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        CommonWebActions.getWebElement("DistName").sendKeys("Test");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("UnitCode").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        CommonWebActions.getWebElement("UnitCode").sendKeys("123456");
	        Thread.sleep(1000);
	        /*CommonWebActions.getWebElement("CityName").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        CommonWebActions.getWebElement("CityName").sendKeys("Test");
	        Thread.sleep(1000);
	        /*CommonWebActions.webClick("AccomDropdown");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("AccomDropdownValue");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("HousingPassDropdown");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("HousingPassDropdownValue");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("IndependentDropdown");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("IndependentDropdownValue");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("AddRegionDropdown");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("AddRegionDropdownValue");
	        Thread.sleep(1000);*/
	        CommonWebActions.webClick("SameAsAddRadioButton");
	        Thread.sleep(1000);
	        CommonWebActions.scrollIntoWebElement_ActionClass("MMP_SaveButton");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("SRAcceptCheckBox");
	        CommonWebActions.webClick("MMP_SaveButton");
	        Thread.sleep(1000);
	        confirmPersonalRecords();
	        Thread.sleep(1000);
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Issue with records "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void updateChildData(){
		try{
			CommonWebActions.webClick("SR_Children");
	        Thread.sleep(1000);
	        AUT.validateBreadCrumb("SR_ChildrenHeader", "Child records header ");
	        CommonWebActions.webClick("SRChildCount");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("SRChildCount").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("SRChildCount").sendKeys("1");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("JuvCount").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("JuvCount").sendKeys("1");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("DisabledChildrenCount").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("DisabledChildrenCount").sendKeys("1");
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("ChronicChildrenCount").sendKeys(Keys.CONTROL,"a" , Keys.CONTROL.DELETE);
	        Thread.sleep(1000);
	        CommonWebActions.getWebElement("ChronicChildrenCount").sendKeys("1");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("SRAcceptCheckBox");
	        CommonWebActions.webClick("MMP_SaveButton");
	        Takamol.confirmPersonalRecords();
	        Thread.sleep(1000);
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Issue with records "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	public static void updateFinancialData(){
		try{
			CommonWebActions.webClick("SR_Financial");
	        Thread.sleep(1000);
	        AUT.validateBreadCrumb("SR_FinancialHeader", "Financial records header ");
	        Thread.sleep(1000);
	        CommonWebActions.scrollIntoWebElement_ActionClass("MMP_SaveButton");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("SRAcceptCheckBox");
	        CommonWebActions.webClick("MMP_SaveButton");
	        Thread.sleep(1000);
	        confirmPersonalRecords();
	        Thread.sleep(1000);
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Issue with records "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	public static void updateAppData(){
		try{
			CommonWebActions.webClick("SR_AppData");
	        Thread.sleep(1000);
	        AUT.validateBreadCrumb("SR_AppDataHeader", "Application data header ");
	        Thread.sleep(1000);
	        CommonWebActions.webClick("SRAcceptCheckBox");
	        CommonWebActions.webClick("MMP_SaveButton");
	        Thread.sleep(1000);
	        confirmPersonalRecords();
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Issue with records "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	
	public static void selectMedicalOrSupportiveHeadphoneDetails(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("Medical_Weight"))){
				CommonWebActions.getWebElement("Medical_Weight").sendKeys("82");
		        Thread.sleep(1000);
				CommonWebActions.getWebElement("Medical_Height").sendKeys("58");
				Thread.sleep(1000);
				CommonWebActions.webClick("DeviceClassificationDropDown");
				Thread.sleep(1000);
				CommonWebActions.webClick("DeviceClassificationDropDownValue");
				CommonWebActions.webClick("InternalDeviceRadioButton");
				Thread.sleep(1000);
				CommonWebActions.webClick("DeviceNameDropdown");
				CommonWebActions.webClick("DeviceNameDropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("PickAddFromSM");
				Thread.sleep(1000);
				CommonWebActions.scrollIntoWebElement_ActionClass("NextButton");
				Thread.sleep(2000);
				//Takamol.attachAndVerifyFiles("TestImage.png");
				Takamol.uploadImageBySendKeys("Attach the audiogram ", "Test.pdf");
		        String expectedFile ="Test";
				String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				Thread.sleep(1000);
				CommonWebActions.scrollIntoWebElement_ActionClass("NextButton");
				CommonWebActions.webClick("NextButton");
		        AUT.validateBreadCrumb("MedicalServiceRequestPage_Header", "Request summary header ");
				CommonWebActions.scrollIntoWebElement_ActionClass("MMP_SubmitButton");
				CommonWebActions.webClick("MMP_SubmitButton");

				
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void selectFinancialAidRequestServiceDetails(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("FinancialAidRadioButton"))){
				CommonWebActions.webClick("FinancialAidRadioButton");
				Thread.sleep(1000);
			//	Takamol.attachAndVerifyFiles("TestImage.png");
				Takamol.uploadImageBySendKeys("Attach the salary identification document*", "Test.pdf");
		        String expectedFile ="Test.pdf";
				String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				CommonWebActions.scrollIntoWebElement_ActionClass("Appian_SendRequestButton");
				CommonWebActions.webClick("ApprovalDeclarationAndAckCheckbox");
				Thread.sleep(1000);
				CommonWebActions.webClick("Appian_SendRequestButton");
				Thread.sleep(3000);

				
				ReportUtil.reporterEvent("pass", "Request Created  "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Request not Created  "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Request not Created "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void selectMedicalOrSupportiveRegularDeviceDetails(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("Medical_Weight"))){
				CommonWebActions.getWebElement("Medical_Weight").sendKeys("82");
		        Thread.sleep(1000);
				CommonWebActions.getWebElement("Medical_Height").sendKeys("58");
				Thread.sleep(1000);
				CommonWebActions.webClick("DeviceClassificationDropDown");
				Thread.sleep(1000);
				CommonWebActions.webClick("DeviceClassificationDropDownValue1");
				Thread.sleep(1000);
				CommonWebActions.webClick("DeviceNameDropdown");
				CommonWebActions.webClick("DeviceNameDropdownValue1");
				Thread.sleep(2000);
				CommonWebActions.webClick("PickAddFromSM");
				Thread.sleep(2000);
				CommonWebActions.scrollIntoWebElement_ActionClass("NextButton");
				Thread.sleep(1000);
				CommonWebActions.webClick("NextButton");
				Thread.sleep(1000);
		        AUT.validateBreadCrumb("RegularDeviceRequestHeader", "Regular device request header ");
				Thread.sleep(2000);
				CommonWebActions.webClick("SizeYes");
				Thread.sleep(1000);
				CommonWebActions.webClick("MedicalBeneficiary_dropdown");
				Thread.sleep(1000);
				CommonWebActions.webClick("PhotoSizeValue");
                CommonWebActions.webClick("NextButton");
		        AUT.validateBreadCrumb("MedicalServiceRequestPage_Header", "Request summary header ");
		        CommonWebActions.scrollIntoWebElement_ActionClass("MMP_SubmitButton");
				CommonWebActions.webClick("MMP_SubmitButton");
				
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void selectStateFeeBearingProgramDetails(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("StateRegionDropDown"))){
				CommonWebActions.webClick("StateRegionDropDown");
				Thread.sleep(1000);
				CommonWebActions.webClick("StateRegionDropDownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("StateCityDropDown");
				Thread.sleep(1000);
				CommonWebActions.webClick("StateCityDropDownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("RegistrationFieldDropdown");
				Thread.sleep(1000);
				CommonWebActions.webClick("RegistrationFieldDropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("HoastingQuestion_dropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("StateFeeAhilCenterDropDown");
				Thread.sleep(1000);
				CommonWebActions.webClick("StateFeeAhilCenterDropDownValue");
				Thread.sleep(1000);
				CommonWebActions.scrollIntoWebElement_ActionClass("UploadButtonOne");
				Thread.sleep(1000);
				/*CommonWebActions.webClick("UploadButtonOne");
				Thread.sleep(1000);
				Takamol.attachAndVerifyFilesForTakamol("TestImage.png");*/
				Takamol.uploadImageBySendKeys("NON-employment document", "TestImage.png");
		        String expectedFile ="TestImage";
				String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				Thread.sleep(1000);
				/*CommonWebActions.webClick("UploadButtonTwo");
				Thread.sleep(1000);
				Takamol.attachAndVerifyFilesForTakamol("TestImage.png");*/
				Takamol.uploadImageBySendKeys("Attach proof of non-enrollment in education programs or special education institutes*", "TestImage.png");
		        String expFile ="TestImage";
				String actFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actFile.contains(expFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				Thread.sleep(1000);
				CommonWebActions.scrollIntoWebElement_ActionClass("ApplyRequestButton");
				CommonWebActions.webClick("ApprovalDeclarationAndUndertakingCheckbox");
				Thread.sleep(1000);
				CommonWebActions.webClick("ApplyRequestButton");
				Thread.sleep(1000);

				ReportUtil.reporterEvent("pass", "Request Created  "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Request Not Created "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Request Not Created "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void uploadDocsForFoasterFamily(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("FosterUploadButtonOne"))){
				/*CommonWebActions.webClick("FosterUploadButtonOne");
				Takamol.attachAndVerifyFilesForTakamol("TestImage.png");*/
				Takamol.uploadImageBySendKeys("Incubator Medical Report", "TestImage.png");
		        String expectedFile ="TestImage";
				String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				Thread.sleep(1000);
				/*CommonWebActions.webClick("FosterUploadButtonTwo");
				Takamol.attachAndVerifyFilesForTakamol("TestImage.png");*/
				Takamol.uploadImageBySendKeys("Medical Report For Family Members", "TestImage.png");
		        String expFile ="TestImage";
				String actFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actFile.contains(expFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				Thread.sleep(1000);
				/*CommonWebActions.webClick("FosterUploadButtonThree");
				Takamol.attachAndVerifyFilesForTakamol("TestImage.png");*/
				Takamol.uploadImageBySendKeys("Financial Capacity", "TestImage.png");
		        String expFile1 ="TestImage";
				String actFile1 = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actFile1.contains(expFile1)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				Thread.sleep(1000);
				/*CommonWebActions.webClick("FosterUploadButtonFour");
				Takamol.attachAndVerifyFilesForTakamol("TestImage.png");*/
				Takamol.uploadImageBySendKeys("Non-Criminal Record Certificate", "TestImage.png");
		        String expFile2 ="TestImage";
				String actFile2 = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actFile2.contains(expFile2)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				CommonWebActions.webClick("NextButton");
				Thread.sleep(1000);


				ReportUtil.reporterEvent("pass", "Details are selected  "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static boolean verifyMedicalDeviceRequestCreatedOrNot() {
		
		   try{
			  
				String s1 = CommonWebActions.getWebElement("Medical_RequestCreatedHeader").getText();
				System.out.println(s1);
				if(s1.contains("submitted")){
					
					  ReportUtil.reporterEvent("pass", "Request created  "+CommonWebActions.captureScreenshotAsBase64());
                   
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("fail", "Request not created  "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      }
				
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not created  "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FFPapproveRequestFromSocialWorker1() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromSocialWorker"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                   CommonWebActions.webClick("ReviewFromSocialWorker");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
                   CommonWebActions.webClick("ApproveReqFFP_Yes");
					  Thread.sleep(1000);
					CommonWebActions.getWebElement("ToxicologyCenterTextBox").sendKeys("XYZ Toxicology Center");
				      Thread.sleep(1000);
				      CommonWebActions.webClick("FFPSendDetailsButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptFFP_Popup", "Send to");
                      Thread.sleep(1000);
                      CommonWebActions.webClick("FFP_Yes");
                      Thread.sleep(1000);
                      AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Social Worker "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FFPapproveRequestFromSocialWorker2() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromSocialWorker"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                CommonWebActions.webClick("ReviewFromSocialWorker");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				       Thread.sleep(2000);	
					  Takamol.uploadImageBySendKeys("TOXICOLOGY TEST REPORT", "TestImage.png");
				        String expectedFile ="TestImage";
				        String actualFile = CommonWebActions.getWebElement("ToxicologyFile").getText();
				        if (actualFile.contains(expectedFile)) {

				            ReportUtil.reporterEvent("pass", "File uploaded"+CommonWebActions.captureScreenshotAsBase64());
				        } else {

				            ReportUtil.reporterEvent("fail", "File not uploaded"+CommonWebActions.captureScreenshotAsBase64());

				        }
				         Thread.sleep(5000);
                CommonWebActions.webClick("ApproveReqFFP_Yes");
					  Thread.sleep(1000);
				CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");   
				       Thread.sleep(1000);
				      CommonWebActions.webClick("FFPSendButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptFFP_Popup1", "Send details");
                   Thread.sleep(1000);
                   CommonWebActions.webClick("FFP_Yes");
                   Thread.sleep(1000);
                   AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Attribution Manager "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}

	public static boolean FFPapproveRequestFromAttributionManager1() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromAttributionManager"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                CommonWebActions.webClick("ReviewFromAttributionManager");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
                CommonWebActions.webClick("ApproveReqFFP_Accept");
					  Thread.sleep(1000);
				CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
				      CommonWebActions.webClick("FFPSendButton1");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptFFP_Popup1", "Send to");
                   Thread.sleep(1000);
                   CommonWebActions.webClick("FFP_Yes");
                   Thread.sleep(1000);
                   AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Applicant "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FFPapproveRequestFromApplicant() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("OpenTaskFFP"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
             CommonWebActions.webClick("OpenTaskFFP");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("TaskNameFFP", "Task Name");
					  Thread.sleep(2000);
			/*	DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
					Date date = new Date();
					CommonWebActions.getWebElement("AppointmentDate").sendKeys(dateFormat.format(date));
					ReportUtil.reporterEvent("pass", "Date Added "+CommonWebActions.captureScreenshotAsBase64()); */
				CommonWebActions.getWebElement("AppointmentDate").sendKeys("02/28/2024");  
				      Thread.sleep(1000);
				      CommonWebActions.webClick("PeriodDropdown");
						Thread.sleep(1000);	
		              CommonWebActions.webClick("PeriodDropdownValue");
						Thread.sleep(1000);
					ReportUtil.reporterEvent("pass", "Date Added "+CommonWebActions.captureScreenshotAsBase64());
				      CommonWebActions.webClick("SendRequestButtonSmall");
					  Thread.sleep(1000);
				AUT.validateBreadCrumb("MMP_RequestCreatedHeader", "has been submitted");
                Thread.sleep(1000);
                CommonWebActions.webClick("OkButton");
                Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Social Worker "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FFPapproveRequestFromSocialWorker3() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("SocialWorkerHomeAssessment"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
             CommonWebActions.webClick("SocialWorkerHomeAssessment");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
				CommonWebActions.webClick("FillRecForm");
					  Thread.sleep(3000);
				List<WebElement> list = CommonWebActions.wd.findElements(By.xpath("(//input[@type='text'])"));
				      System.out.println(list);
				 //     System.out.println(list.size());
				        for(int i=0;i<11;i++)
				         {
				            list.get(i).sendKeys("Text entered by Automation");
				         }
				 //   CommonWebActions.webClick("TeamHome");
				    CommonWebActions.getWebElement("TeamHome").sendKeys("Social"); 
				    CommonWebActions.getWebElement("TeamHome").sendKeys(Keys.BACK_SPACE); 
				    Thread.sleep(5000);
				    CommonWebActions.webClick("SelectTeamHome");
				      Thread.sleep(2000); 
				    CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				       Thread.sleep(2000);	   
				    CommonWebActions.webClick("RequestNxtButton");
					 Thread.sleep(2000);  
					CommonWebActions.webClick("OTPCheckBox");
				      Thread.sleep(1000); 
				    CommonWebActions.webClick("SendOTP");
					  Thread.sleep(2000);  
					CommonWebActions.getWebElement("EnterOTP").sendKeys("123456");   
				      Thread.sleep(1000); 
				    CommonWebActions.webClick("VerifyButton");
					  Thread.sleep(1000);   
					ReportUtil.reporterEvent("pass", "OTP verified "+CommonWebActions.captureScreenshotAsBase64());  
					CommonWebActions.scrollIntoWebElement_ActionClass("FFPSendButton");
			        Thread.sleep(1000);
			        CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				       Thread.sleep(2000);	
					CommonWebActions.webClick("FFPSendButton");
					  Thread.sleep(1000); 
					AUT.validateBreadCrumb("AcceptFFP_Popup1", "Send to");
	                   Thread.sleep(1000);
	                   CommonWebActions.webClick("FFP_Yes");
	                   Thread.sleep(1000);
	                AUT.validateBreadCrumb("SuccessFFP", "Success");
						  CommonWebActions.webClick("FFPCloseButton");
						  Thread.sleep(1000);
				      return true;				
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Attribution Manager "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FFPapproveRequestFromAttributionManager2() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromAttributionManager1"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
             CommonWebActions.webClick("ReviewFromAttributionManager1");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
			CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);	
             CommonWebActions.webClick("ApproveReqFFP_Accept");
					  Thread.sleep(1000);
				CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
				      CommonWebActions.webClick("FFPSendButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptFFP_Popup1", "Send to");
                Thread.sleep(1000);
                CommonWebActions.webClick("FFP_Yes");
                Thread.sleep(1000);
                AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Committee Member "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FFPapproveRequestFromCommitteeMember() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromCommitteeMember"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
          CommonWebActions.webClick("ReviewFromCommitteeMember");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
			CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);	
          CommonWebActions.webClick("ApproveReqFFP_Accept");
					  Thread.sleep(1000);
				CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
				      CommonWebActions.webClick("FFPSendButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptFFP_Popup1", "Send to");
             Thread.sleep(1000);
             CommonWebActions.webClick("FFP_Yes");
             Thread.sleep(1000);
             AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Committee Chairman "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FFPapproveRequestFromCommitteeChairman() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromCommitteeChariman"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
       CommonWebActions.webClick("ReviewFromCommitteeChariman");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
			CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);	
       CommonWebActions.webClick("ApproveReqFFP_Accept");
					  Thread.sleep(1000);
				CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
				      CommonWebActions.webClick("FFPSendButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptFFP_Popup1", "Send to");
          Thread.sleep(1000);
          CommonWebActions.webClick("FFP_Yes");
          Thread.sleep(1000);
          AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to UnderSecretary "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FFPapproveRequestFromUnderSecretary() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromUnderSecretary"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
    CommonWebActions.webClick("ReviewFromUnderSecretary");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
			CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);	
    CommonWebActions.webClick("UnderSecretaryAccept");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptRequestPopup", "Accept Request");
       Thread.sleep(1000);
       CommonWebActions.webClick("FFP_Yes");
       Thread.sleep(1000);
       AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request Completed "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FinancialAidapproveRequestSubsidyEmployee() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromSubsidyEmployee"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
             CommonWebActions.webClick("ReviewFromSubsidyEmployee");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
             CommonWebActions.webClick("ApproveReqFFP_Accept");
					  Thread.sleep(1000);
				      CommonWebActions.webClick("AppianSubmitButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptRequestPopup", "Accept Request");
                Thread.sleep(1000);
                CommonWebActions.webClick("AppianYesButton");
                Thread.sleep(1000);
                AUT.validateBreadCrumb("AppianSuccessScreen", "Success");
					  CommonWebActions.webClick("AppianCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request Completed"+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FinancialAidapproveRequestFromCommitteeMember() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromCommitteeMemberFinancialAid"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
       CommonWebActions.webClick("ReviewFromCommitteeMemberFinancialAid");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
			CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);	
       CommonWebActions.webClick("ApproveReqFFP_Accept");
					  Thread.sleep(1000);
				CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
				      CommonWebActions.webClick("FFPSendButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptFFP_Popup1", "Send to");
          Thread.sleep(1000);
          CommonWebActions.webClick("FFP_Yes");
          Thread.sleep(1000);
          AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Committee Chairman "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FinancialAidapproveRequestFromCommitteeChairman() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromCommitteeCharimanFinancialAid"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
    CommonWebActions.webClick("ReviewFromCommitteeCharimanFinancialAid");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
			CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);	
    CommonWebActions.webClick("ApproveReqFFP_Accept");
					  Thread.sleep(1000);
				CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
				      CommonWebActions.webClick("FFPSendButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptFFP_Popup1", "Send to");
       Thread.sleep(1000);
       CommonWebActions.webClick("FFP_Yes");
       Thread.sleep(1000);
       AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to UnderSecretary "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean FinancialAidapproveRequestFromUnderSecretary() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromUnderSecretaryFinancialAid"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("ReviewFromUnderSecretaryFinancialAid");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);	
				      CommonWebActions.webClick("ApproveReqFFP_Accept");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("AppianSubmitButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptRequestPopup", "Accept Request");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("FFP_Yes");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request Completed "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static void createRequestForLOREducation(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("CreateRequestButton"))){
				CommonWebActions.webClick("CreateRequestButton");
				AUT.validateBreadCrumb("CreateRequestHeader", "create request page appian header ");
				CommonWebActions.webClick("OrphanButton");
				Thread.sleep(3000);
				AUT.validateBreadCrumb("ServiceOrphanHeader", "Orphan page appian header ");
				CommonWebActions.webClick("RequestLORLink");
				Thread.sleep(2000);
				AUT.validateBreadCrumb("SearchBeneficiaryHeader", "Beneficiary serach appian header ");
				CommonWebActions.getWebElement("FirstNameTextBox").sendKeys("Automation");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("FirstNameTextBox").sendKeys(Keys.TAB);
				CommonWebActions.webClick("NationalIDSearchButton");
				Thread.sleep(1000);
				CommonWebActions.webClick("SelectFirstRecord");
				CommonWebActions.webClick("RequestNxtButton");
				AUT.validateBreadCrumb("ServiceRequestFormHeader", "Request form header ");
				CommonWebActions.getWebElement("AppianAuthorityNameTextBox").sendKeys("Text entered by automation");
				Thread.sleep(1000);
				CommonWebActions.webClick("AppianAreaDropdown");
				Thread.sleep(1000);
				CommonWebActions.webClick("AppianAreaDropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("AppianSemsterDropdown");
				Thread.sleep(1000);	
				CommonWebActions.webClick("AppianSemsterDropdownValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("RequestNxtButton");
				Thread.sleep(1000);
				CommonWebActions.webClick("Issuebutton");
				Thread.sleep(1000);
				AUT.validateBreadCrumb("AppianIssuePopup", "Are you sure you want to proceed?");
			    Thread.sleep(1000);
			    CommonWebActions.webClick("FFP_Yes");
			    Thread.sleep(1000);
			    CommonWebActions.webClick("AppianSendEmail");
				Thread.sleep(1000);
				AUT.validateBreadCrumb("SuccessFFP", "Success");
				CommonWebActions.webClick("FFPCloseButton");
				Thread.sleep(1000);
				ReportUtil.reporterEvent("pass", "Request Created "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void createRequestForLOROther(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("CreateRequestButton"))){
				CommonWebActions.webClick("CreateRequestButton");
				AUT.validateBreadCrumb("CreateRequestHeader", "create request page appian header ");
				CommonWebActions.webClick("OrphanButton");
				Thread.sleep(3000);
				AUT.validateBreadCrumb("ServiceOrphanHeader", "Orphan page appian header ");
				CommonWebActions.webClick("RequestLORLink");
				Thread.sleep(2000);
				AUT.validateBreadCrumb("SearchBeneficiaryHeader", "Beneficiary serach appian header ");
				CommonWebActions.getWebElement("FirstNameTextBox").sendKeys("Automation");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("FirstNameTextBox").sendKeys(Keys.TAB);
				CommonWebActions.webClick("NationalIDSearchButton");
				Thread.sleep(1000);
				CommonWebActions.webClick("SelectFirstRecord");
				CommonWebActions.webClick("RequestNxtButton");
				AUT.validateBreadCrumb("ServiceRequestFormHeader", "Request form header ");
				CommonWebActions.webClick("AppianEducationDropdown");
				Thread.sleep(1000);
				CommonWebActions.webClick("AppianEducationDropdownValue");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("AppianAuthorityNameTextBox").sendKeys("Text entered by automation");
				Thread.sleep(1000);
				CommonWebActions.webClick("AppianAreaDropdown");
				Thread.sleep(1000);
				CommonWebActions.webClick("AppianAreaDropdownValue");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("AppianLetterSubjectTextBox").sendKeys("Letter Subject entered by automation");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("AppianLetterBodyTextBox").sendKeys("Letter Body entered by automation");
				Thread.sleep(1000);
				CommonWebActions.webClick("Appian_SendRequestButton");
				Thread.sleep(1000);
				AUT.validateBreadCrumb("SuccessFFP", "Success");
			/*	String requestPopup = CommonWebActions.getWebElement("LOROtherSuccessScreen").getText();
				String requestNumber=requestPopup.substring(35,51);
				System.out.println("Request number is "+requestNumber);	
				CommonWebActions.webClick("FFPCloseButton");*/
				Thread.sleep(1000);
				ReportUtil.reporterEvent("pass", "Request Created "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void createRequestForObjectionServiceAppian(){
        try{
            if(CommonWebActions.webExists(CommonWebActions.getWebElement("CreateRequestButton"))){
                 {
                        
                        CommonWebActions.webClick("CreateRequestButton");
                        AUT.validateBreadCrumb("CreateRequestHeader", "create request page appian header ");
                        CommonWebActions.webClick("DisabilityButton");
                        Thread.sleep(3000);
                        CommonWebActions.webClick("ObjectionforDisabilityAssessment");
                        Thread.sleep(3000);
                        AUT.validateBreadCrumb("SearchBeneficiaryHeader", "Beneficiary serach appian header ");
                        CommonWebActions.getWebElement("NationalIDTextBox").sendKeys("8000000003");
                        Thread.sleep(1000);
                        CommonWebActions.webClick("NationalIDSearchButtonSS");
                        Thread.sleep(1000);
                        CommonWebActions.webClick("SelectFirstRecord");
                        Thread.sleep(4000);
                        CommonWebActions.webClick("RequestNxtButton");
                        Thread.sleep(1000);
                        CommonWebActions.webClick("OS_Objectiontype_dropdown");
                        Thread.sleep(1000);
                        CommonWebActions.webClick("OS_Objectiontype_value");
                        Thread.sleep(1000);
                        CommonWebActions.getWebElement("Reasonforobjection").sendKeys("Not valid");
                        Thread.sleep(1000);
                        }
                         
                        Takamol.uploadImageBySendKeys("Medical Reports", "TestImage.png");
                        Thread.sleep(3000);
                        CommonWebActions.webClick("Submit");
                        Thread.sleep(3000);
                        //AUT.validateBreadCrumb("OS_POPUP", " has been submitted");
                         //Thread.sleep(1000);
                         //CommonWebActions.webClick("Closebutton");
                        }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            ReportUtil.endReporter();    
        }    
      }
	
	public static boolean verifyObjectionRequestCreatedOrNot() {
        
        try{
           
             String s1 = CommonWebActions.getWebElement("RequestCreatedHeader_objection").getText();
             System.out.println(s1);
             if(s1.contains("has been submitted")){
                 if(CommonWebActions.webExists(CommonWebActions.getWebElement("Closebutton"))
                   &&CommonWebActions.webExists(CommonWebActions.getWebElement("Closebutton"))){
                   ReportUtil.reporterEvent("pass", "Request created "+CommonWebActions.captureScreenshotAsBase64());
                   CommonWebActions.webClick("Closebutton");
                   Thread.sleep(2000);
                   return true;                        
                 }
                else
                ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
                return false;

               }
             else{
                  ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
                    return false;
             }
           }
           catch(Exception e){
             e.printStackTrace();
             ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
             return false;
         }
     }
	
	public static boolean approveRequestFromCommitteeMemeber() {
        
        try{
           
             
                 if(CommonWebActions.webExists(CommonWebActions.getWebElement("Pending_ReviewFromCommitteeMembers"))){
                   ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
                CommonWebActions.webClick("Pending_ReviewFromCommitteeMembers");
                   Thread.sleep(2000);
                   AUT.validateBreadCrumb("Appian_ObjectionServiceHeader", "Appian service page header ");
                   Thread.sleep(2000);
                CommonWebActions.webClick("ApproveReq_Accept");
                   Thread.sleep(2000);
                   CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Good");
                   Thread.sleep(1000);
               //    CommonWebActions.getWebElement("IQ").sendKeys("80");
                //CommonWebActions.scrollIntoWebElement_new("Appian_SendRequestButton");
                   CommonWebActions.webClick("ApproveReq_checkbox");
                   Thread.sleep(1000);
                CommonWebActions.webClick("Submit");
                   Thread.sleep(1000);
                   AUT.validateBreadCrumb("Accept_Popup", "Are you sure");
                   Thread.sleep(1000);
                   CommonWebActions.webClick("Yes_button");
                   
                
                   Thread.sleep(1000);
                   AUT.validateBreadCrumb("Success_PopUp", "has been completed ");
                   CommonWebActions.webClick("Success_CloseButton");
                   Thread.sleep(1000);
                   return true;                        
                 }
                else
                ReportUtil.reporterEvent("Pass", "Request approved from Ministry employee "+CommonWebActions.captureScreenshotAsBase64());
                return false;

               
             
           }
           catch(Exception e){
             e.printStackTrace();
             ReportUtil.reporterEvent("fail", "Request not approved from Ministry employee "+CommonWebActions.captureScreenshotAsBase64());
             return false;
         }
     }
	
	public static void createRequestForIIC(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("CreateRequestButton"))){
				CommonWebActions.webClick("CreateRequestButton");
				AUT.validateBreadCrumb("CreateRequestHeader", "create request page appian header ");
				CommonWebActions.webClick("OrphanButton");
				Thread.sleep(3000);
				AUT.validateBreadCrumb("ServiceOrphanHeader", "Orphan page appian header ");
				CommonWebActions.webClick("IICLinkAppian");
				Thread.sleep(2000);
				AUT.validateBreadCrumb("SearchBeneficiaryHeader", "Beneficiary serach appian header ");
				CommonWebActions.getWebElement("FirstNameTextBox").sendKeys("Automation");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("FirstNameTextBox").sendKeys(Keys.TAB);
				CommonWebActions.webClick("NationalIDSearchButton");
				Thread.sleep(1000);
				CommonWebActions.webClick("SelectFirstRecord");
				CommonWebActions.webClick("RequestNxtButton");
				AUT.validateBreadCrumb("IICRequestHeader", "Request form header ");
				Thread.sleep(1000);
				CommonWebActions.webClick("RequestNxtButton");
				Thread.sleep(1000);
				AUT.validateBreadCrumb("IICRequestSummaryHeader", "Request Summary Page ");
				CommonWebActions.webClick("Issuebutton");
				Thread.sleep(1000);
				AUT.validateBreadCrumb("AppianIssuePopup", "Are you sure you want to proceed?");
			    Thread.sleep(1000);
			    CommonWebActions.webClick("FFP_Yes");
			    Thread.sleep(1000);
			    CommonWebActions.webClick("AppianSendEmail");
				Thread.sleep(1000);
				AUT.validateBreadCrumb("SuccessFFP", "Success");
				CommonWebActions.webClick("FFPCloseButton");
				Thread.sleep(1000);
				ReportUtil.reporterEvent("pass", "Request Created "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static boolean SubsidyFFFEmployeeApproval() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("FFFReviewFromEmployee"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("FFFReviewFromEmployee");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFFServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
					  CommonWebActions.webClick("ApproveReqFFP_Accept");
					  Thread.sleep(1000);
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
				      CommonWebActions.webClick("FFPSendButton1");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("FFFAcceptRequestPopup", "Accept Request");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("AppianYesButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AppianSuccessScreen", "Success");
					  CommonWebActions.webClick("AppianCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request Completed"+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean SubsidyFFFUndersecretaryApproval() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("FFFReviewFromUndersecretary"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("FFFReviewFromUndersecretary");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFFServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
					  CommonWebActions.webClick("ApproveReqFFP_Accept");
					  Thread.sleep(1000);
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
				      CommonWebActions.webClick("AppianSubmitButtonCaps");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("FFFUndersecretaryPopUp", "Accept Request");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("AppianYesButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AppianSuccessScreen", "Success");
					  CommonWebActions.webClick("AppianCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request Completed"+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static void OnlineAppointmentBookingDetails() {
        try {
            CommonWebActions.getWebElement("OFullName").sendKeys("Automation Services Taheel Test");
            CommonWebActions.getWebElement("OMobileNumber").sendKeys("333100000");
            CommonWebActions.webClick("ORegionValue");
            Thread.sleep(1000);
            CommonWebActions.webClick("ORegionDropdown_Value");
            Thread.sleep(1000);
            CommonWebActions.webClick("OCityValue");
            Thread.sleep(1000);
            CommonWebActions.webClick("OCityDropdown_Value");
            Thread.sleep(1000);
            CommonWebActions.webClick("OUnitValue");
            Thread.sleep(1000);
            CommonWebActions.webClick("OUnitDropdown_Value");
            Thread.sleep(1000);
         /*   CommonWebActions.webClick("ODatePicker");
            Thread.sleep(1000);
            CommonWebActions.webClick("OPickTheDate");
            Thread.sleep(1000);*/
          //  CommonWebActions.webSetText("OAppointmentBooking", "19/02/2023");
            CommonWebActions.getWebElement("OAppointmentBooking").sendKeys("22/08/2023");  
            Thread.sleep(1000);
            CommonWebActions.webClick("OAppointmentTimeValue");
            Thread.sleep(2000);
            CommonWebActions.webClick("OAppointmentDropdown_Value");
            Thread.sleep(1000);
            CommonWebActions.webClick("OAppointmentReasonValue");
            Thread.sleep(1000);
            CommonWebActions.webClick("OAppointmentReasonDropdown_Value");
            Thread.sleep(1000);
            CommonWebActions.webClick("OCheckbox");
            AUT.validateBreadCrumb("AppointmentBookingButton", "Form");
            Thread.sleep(1000);    
        }
        catch (Exception e) {
            e.printStackTrace();
            ReportUtil.reporterEvent("fail", "Details not selected " + CommonWebActions.captureScreenshotAsBase64());
        }

}
	public static boolean approveRequestFromUnitEmployee() {
        try {
            if (CommonWebActions.webExists(CommonWebActions.getWebElement("VisitAppointment"))) {
                ReportUtil.reporterEvent("pass",
                        "Elements are present " + CommonWebActions.captureScreenshotAsBase64());
                CommonWebActions.webClick("VisitAppointment");
                Thread.sleep(2000);
                AUT.validateBreadCrumb("Appointment_CompletioneHeader", "Appian service page header ");
                Thread.sleep(2000);
                CommonWebActions.webClick("BeneficiaryArrive_Yes");
                Thread.sleep(1000);
                CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys(" Applicant Present ");
                Thread.sleep(1000);
                AUT.validateBreadCrumb("Appain_ClosedAppointmentButton", "Form");
                CommonWebActions.webClick("Appain_ClosedAppointmentButton");
                Thread.sleep(1000);
                CommonWebActions.webClick("ConfirmRequest_YesButton");
                Thread.sleep(1000);
                AUT.validateBreadCrumb("AppianSuccessScreen", "Success");
                Thread.sleep(1000);
                CommonWebActions.webClick("MinistryApproval_CloseButton");
                return true;
            } else
                ReportUtil.reporterEvent("Pass",
                        "Request sent to director " + CommonWebActions.captureScreenshotAsBase64());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            ReportUtil.reporterEvent("fail",
                    "Request sent to director " + CommonWebActions.captureScreenshotAsBase64());
            return false;
        }
    }
	
	public static void selectMyRoleModel(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("MyRoleModelProgramType"))){
				CommonWebActions.webClick("MyRoleModelNextButton");
				Thread.sleep(2000);
				AUT.validateBreadCrumb("MyRoleModelHeader", "My Role Model Program header ");
				CommonWebActions.getWebElement("DateofHandOver").sendKeys("20/12/2023");  
	            Thread.sleep(1000);
	            CommonWebActions.getWebElement("OrphanReturnTime").sendKeys("20:00");  
	            Thread.sleep(1000);
	           // CommonWebActions.getWebElement("HostComments").sendKeys("Text enter by Automation for My Role Model");  
	           // Thread.sleep(1000);
	            CommonWebActions.webClick("SubmitRequest");
				Thread.sleep(1000);
				ReportUtil.reporterEvent("pass", "Request Created "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static void selectFriendlyFamilyProgram() {
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("FriendlyFamilyProgramType"))){
				CommonWebActions.webClick("FriendlyFamilyProgramNextButton");
				Thread.sleep(2000);
				AUT.validateBreadCrumb("FriendlyFamilyProgramHeader", "Friendly Family Program header ");
				CommonWebActions.getWebElement("DateofHandOver").sendKeys("20/12/2023");  
	            Thread.sleep(1000);
	            CommonWebActions.webClick("HostingPeriod");
				Thread.sleep(1000);
				CommonWebActions.webClick("HostingPeriodValue");
				Thread.sleep(1000);
	            CommonWebActions.getWebElement("HostingPeriodNo").sendKeys("1");  
	            Thread.sleep(1000);
	            CommonWebActions.webClick("SubmitRequest");
				Thread.sleep(1000);
				ReportUtil.reporterEvent("pass", "Request Created "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
		}
		
	}
	
	public static boolean HostingReqSocialWorker1() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("HostReviewFromSocailWorker1"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("HostReviewFromSocailWorker1");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("HostingAppianHeader", "Appian service page header ");
					  Thread.sleep(2000);
					  CommonWebActions.webClick("ApproveReqFFP_Accept");
					  Thread.sleep(1000);
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
				      CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);	
				      AUT.validateBreadCrumb("AppianSubmitButton", "Form");
				      CommonWebActions.webClick("AppianSubmitButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptFFP_Popup1", "Send to Social Worker");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("AppianYesButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Socail Worker "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
		
	public static boolean HostingReqSocialWorker2() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("HostReviewFromSocailWorker2"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("HostReviewFromSocailWorker2");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("HostingAppianHeader", "Appian service page header ");
					  Thread.sleep(2000);
					  CommonWebActions.webClick("OpinionOnVacationDropDown");
			          Thread.sleep(1000);
			          CommonWebActions.webClick("OpinionOnVacationDropDownValue");
			          Thread.sleep(1000);
			          CommonWebActions.webClick("InjuryDropDown");
			          Thread.sleep(1000);
			          CommonWebActions.webClick("InjuryDropDownValue");
			          Thread.sleep(1000);
			          CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);
			          CommonWebActions.webClick("HostCheckBox");
			          Thread.sleep(1000);
			          AUT.validateBreadCrumb("HostCheckBox", "Form");
			          CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
					  CommonWebActions.webClick("AppianSubmitButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("AcceptFFP_Popup1", "Send to Social Worker");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("AppianYesButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Socail Worker "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean HostingReqSocialWorker3() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("HostReviewFromSocailWorker3"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("HostReviewFromSocailWorker3");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("HostingAppianHeader", "Appian service page header ");
					  Thread.sleep(2000);
					  CommonWebActions.getWebElement("HostDate").sendKeys("12/21/2023");  
			          Thread.sleep(1000);
					  CommonWebActions.webClick("OpinionOnVacationDropDown");
			          Thread.sleep(1000);
			          CommonWebActions.webClick("DelayDropDownValue");
			          Thread.sleep(1000);
			          CommonWebActions.webClick("InjuryDropDown");
			          Thread.sleep(1000);
			          CommonWebActions.webClick("InjuryDropDownValue");
			          Thread.sleep(1000);
			          WebElement element = CommonWebActions.wd.findElement(By.xpath("//label[contains(text(),'No')]"));
			          JavascriptExecutor js= (JavascriptExecutor)CommonWebActions.wd;
			          js.executeScript("arguments[0].click();", element);
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Orphan Returned");  
				      Thread.sleep(1000);	
				      AUT.validateBreadCrumb("AppianRemarksTextBox", "Form");
				      CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);
					  CommonWebActions.webClick("AppianSubmitButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("HostingSubmitPopup", "Complete Request");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("AppianYesButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request Completed "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static void selectInvestmentAccountEnquiry() {
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("InvestmentEnquiryLink"))){
				CommonWebActions.webClick("InvestmentEnquiryLink");
				Thread.sleep(2000);
				AUT.validateBreadCrumb("InvestmentEnquiryHeader", "Investment Account Enquiry");
				Takamol.uploadImageBySendKeys("Investment Account Services Request Form*", "Test.pdf");
		        String expectedFile ="Test";
				String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				Thread.sleep(1000);
				AUT.validateBreadCrumb("InvestmentEnquiryHeader", "Investment Account Enquiry");
	            CommonWebActions.webClick("SendRequestButton");
				Thread.sleep(1000);
				
				ReportUtil.reporterEvent("pass", "Request Created Enquiry "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
		}
		
	}
	
	public static void selectInvestmentAccountWithdraw() {
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("InvestmentWithdrawLink"))){
				CommonWebActions.webClick("InvestmentWithdrawLink");
				Thread.sleep(2000);
				AUT.validateBreadCrumb("InvestmentWithdrawHeader", "Investment Account Withdraw");
				CommonWebActions.webClick("BalanceCheckBox");
				Thread.sleep(3000);
				CommonWebActions.getWebElement("BalanceAmount").sendKeys("1");  
			    Thread.sleep(1000);	
			    CommonWebActions.getWebElement("JustificationforWithdraw").sendKeys("Text entered by automation");  
			    Thread.sleep(1000);	
				Takamol.uploadImageBySendKeys("Investment Account Services Request Form*", "Test.pdf");
		        String expectedFile ="Test";
				String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				Thread.sleep(1000);
				AUT.validateBreadCrumb("InvestmentWithdrawHeader", "Investment Account Withdraw");
	            CommonWebActions.webClick("SendRequestButton");
				Thread.sleep(1000);
				
				ReportUtil.reporterEvent("pass", "Request Created for Withdraw "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
		}
		
	}
	
	public static boolean EndOfIncubationTransactionModule() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("OtherServicesTab"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("OtherServicesTab");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("SubsidyDisbursementServices", "Other Services Header ");
					  Thread.sleep(2000);
					  CommonWebActions.webClick("SubsidyDisbursementServices");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("ChooseServiceDropDown");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("EOIChooseServiceDropDownValue");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("RequestNxtButton", "Choose Service");
					  CommonWebActions.webClick("RequestNxtButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("PrepareDisbursementDecisionButton", "Beneficiaries Details");
					  CommonWebActions.webClick("PrepareDisbursementDecisionButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("RequestNxtButton", "Disbursement Decision Preparation Draft Page");
					  CommonWebActions.webClick("RequestNxtButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("IssueDisbursementDecision", "Disbursement Decision Preparation Result");
					  CommonWebActions.webClick("IssueDisbursementDecision");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("IssuePopUp", "You are about to prepare the disbursement decision, are you sure?");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("FFP_Yes");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Social Worker "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean EOIApprovalfromDirectorOfTheSubsidyDepartment() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromDirectorOfTheSubsidyDepartment"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("ReviewFromDirectorOfTheSubsidyDepartment");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("TransactionModuleApprovalHeader", "Transaction Module page header ");
					  Thread.sleep(1000);
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
					  Thread.sleep(2000);
				      CommonWebActions.webClick("AppianApproveButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Applicant "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean EOIIssueDataFileFromEmployeeOfTheSubsidyDepartment() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromEmployeeOfTheSubsidyDepartment"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("ReviewFromEmployeeOfTheSubsidyDepartment");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("IssueDataFileHeader", "Issue Data File page header ");
					  Thread.sleep(1000);
				      CommonWebActions.webClick("IssueDataFileButton");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("EOISendEmail");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Applicant "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean EOIAttachPaymentReceiptByEmployeeOfTheSubsidyDepartment() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("ReviewFromEmployeeOfTheSubsidyDepartment1"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("ReviewFromEmployeeOfTheSubsidyDepartment1");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("PaymentReceiptHeader", "Payment Receipt page header ");
					  Thread.sleep(1000);
					  Takamol.uploadImageBySendKeys("ATTACH PAYMENT RECEIPT", "Test.pdf");
				        String expectedFile ="Test";
				        String actualFile = CommonWebActions.getWebElement("AppianTestPDFUpload").getText();
				        if (actualFile.contains(expectedFile)) {

				            ReportUtil.reporterEvent("pass", "File uploaded"+CommonWebActions.captureScreenshotAsBase64());
				        } else {

				            ReportUtil.reporterEvent("fail", "File not uploaded"+CommonWebActions.captureScreenshotAsBase64());

				        }
				      Thread.sleep(5000);
				      CommonWebActions.webClick("AppianSubmitButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Applicant "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static void selectDisabilityAssessmentDetails(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("Option_Yes"))){
				CommonWebActions.webClick("Option_Yes");
				
				Thread.sleep(1000);
				CommonWebActions.webClick("RegionName_dropdown");
				Thread.sleep(1000);
				CommonWebActions.webClick("RegionNameValue");
				Thread.sleep(1000);
				CommonWebActions.webClick("AhilCenterDropDown");
				Thread.sleep(1000);
				CommonWebActions.webClick("HospitalValue");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("DateTextField").sendKeys("08/11/2022");
				//Takamol.attachAndVerifyFiles("Test.pdf");
		        Takamol.uploadImageBySendKeys("Medical Report Attachment", "Test.pdf");
		        String expectedFile ="Test.pdf";
				String actualFile = CommonWebActions.getWebElement("AttachedFile").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
		        CommonWebActions.scrollIntoWebElement_ActionClass("NextButton");
		        Thread.sleep(1000);
				CommonWebActions.webClick("NextButton");
		        Thread.sleep(1000);
		        AUT.validateBreadCrumb("Disability_UndertakingAndDeclarationHeader", "Declaration header ");
		        CommonWebActions.scrollIntoWebElement_ActionClass("Disability_SendButton");
				CommonWebActions.webClick("ApprovalCheckBox");
				CommonWebActions.webClick("Disability_SendButton");
		        Thread.sleep(1000);
				ReportUtil.reporterEvent("pass", "Details are selected "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Details not selected "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static boolean approveDisabilityAseessmentRequestFromVerifier()
	{
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("Waiting_forVerifier"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
	            CommonWebActions.webClick("Waiting_forVerifier");
					  Thread.sleep(3000);
					  AUT.validateBreadCrumb("Appian_DAS_HeaderVerifier", "Appian service page header");
					  Thread.sleep(1000);
	            CommonWebActions.webClick("ReferRequest");
					  Thread.sleep(1000);
					  
					  
	            //CommonWebActions.scrollIntoWebElement_new("Appian_SendRequestButton");
					  
				AUT.validateBreadCrumb("DASSuccess_PopUp1", "transferred to the Data Entry Clerk ");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request approved from Verifier "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not approved from Verifier "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean approveDisabilityAseessmentRequestFromDataEntryClerk()
	{
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("Waiting_forDataEntry"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
	            CommonWebActions.webClick("Waiting_forDataEntry");
					  Thread.sleep(3000);
					  AUT.validateBreadCrumb("Appian_DAS_HeaderDEC", "Appian service page header");
					  Thread.sleep(2000);
					  WebElement element =   CommonWebActions.wd.findElement(By.xpath("//button[contains(text(),'Add Disability')]"));
					  JavascriptExecutor js= (JavascriptExecutor)CommonWebActions.wd;
					  js.executeScript("arguments[0].click();", element);
					  //CommonWebActions.webClick("AddDisbility");
					  Thread.sleep(1000);
	            CommonWebActions.webClick("MedicalAssessmentofDisability_dropdown");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("MedicalAssessmentofDisability_dropdown_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("MedicalAssessmentofDisability_dropdown2");
					  Thread.sleep(1000);
					  
					 CommonWebActions.webClick("MedicalAssessmentofDisability_dropdown2_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("AffectedArea");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("AffectedArea_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("PermanenceofDisability");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("PermanenceofDisability_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Adherence_ToTheTreatmentPlan");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Adherence_ToTheTreatmentPlan_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("TypeOfDisability");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("TypeOfDisability_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Cause_ofDisabilityLevel1");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Cause_ofDisabilityLevel1_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Cause_ofDisabilityLevel2");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Cause_ofDisabilityLevel2_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("CurrentRelianceOn_MedicalDevices");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("CurrentRelianceOn_MedicalDevices_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("TheNeedFor_AssistiveDevices");
					  Thread.sleep(1000);
//					  CommonWebActions.getWebElement("IQ_DAS").sendKeys("80");
					  CommonWebActions.webClick("Doesheorshesuffer_behavioraldisordersthat_affecthimandothers?");
					  Thread.sleep(1000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("RefertoPhysician");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("SendRequest");
					  Thread.sleep(1000);
					  
				AUT.validateBreadCrumb("DASSuccess_PopUp2", "referred to the Physician.");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request approved from Verifier "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not approved from Verifier "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean approveDisabilityAseessmentRequestFromPhysician()
	{
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("Waiting_forPhysicianReview"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
	            CommonWebActions.webClick("Waiting_forPhysicianReview");
					  Thread.sleep(3000);
					  AUT.validateBreadCrumb("Appian_DAS_HeaderPhysician", "Appian service page header");
					  Thread.sleep(1000);
	            CommonWebActions.webClick("Doesthebeneficiarytake_medicationsthataffect_his/herconsciousness?");
					  Thread.sleep(1000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Doesthebeneficiarysuffer_anycontagiousor_infectiousdisease?");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Isthereany_medicaldevices_connectedtohim/her?");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("SendtheRequest");
					  Thread.sleep(1000);
	            //CommonWebActions.scrollIntoWebElement_new("Appian_SendRequestButton");
					  
				AUT.validateBreadCrumb("DASSuccess_PopUp3", " transferred to the social worker");
				 Thread.sleep(1000);
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request approved from Verifier "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not approved from Verifier "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean approveDisabilityAseessmentRequestFromSocialWorker()
	{
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("Waiting_forSocialWorker"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
	            CommonWebActions.webClick("Waiting_forSocialWorker");
					  Thread.sleep(3000);
					  AUT.validateBreadCrumb("Appian_DAS_HeaderSocialWorker", "Appian service page header");
					  Thread.sleep(1000);
	            CommonWebActions.webClick("Functional_Assessment");
					  Thread.sleep(1000);
					  List<WebElement> list = CommonWebActions.wd.findElements(By.xpath("//label[@class='RadioSelect---choice_label']"));
                      System.out.println(list);
                 //     System.out.println(list.size());
                        for(int i=0;i<96;i+=3)
                         {
                        	
                            list.get(i).click();
                         }
                        CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
					  
                        Thread.sleep(30000);
                       
                        CommonWebActions.webClick("Evaluate");
  					  Thread.sleep(1000); 
  					CommonWebActions.webClick("Work_Capacity");
					  Thread.sleep(1000); 
					  CommonWebActions.webClick("Work_Capacity_dropdown");
					  Thread.sleep(1000); 
  					CommonWebActions.webClick("Submit");
					  Thread.sleep(1000); 
				AUT.validateBreadCrumb("DASSuccess_PopUp4", "done successfully ");
				 Thread.sleep(1000);
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request approved from Verifier "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not approved from Verifier "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean OMBReviewFromEmployee() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("OMBReviewEmployee"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("OMBReviewEmployee");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);	
				      CommonWebActions.webClick("ApproveReqFFP_Accept");
          			  Thread.sleep(1000);
          			  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
				      CommonWebActions.webClick("AppianSubmitButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("OMBAcceptPopup", "Send");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("FFP_Yes");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Committee Member "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean OMBReviewFromManagerGeneral() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("OMBReviewManagerGeneral"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("OMBReviewManagerGeneral");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("FFPServiceHeader", "Appian service page header ");
					  Thread.sleep(2000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
				      Thread.sleep(2000);	
				      CommonWebActions.webClick("ApproveReqFFP_Accept");
       			  Thread.sleep(1000);
       			  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
				      Thread.sleep(1000);
				      CommonWebActions.webClick("AppianSubmitButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("Accept_Popup", "Accept Request?");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("FFP_Yes");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Committee Member "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean OMBTransactionModule() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("OtherServicesTab"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("OtherServicesTab");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("SubsidyDisbursementServices", "Other Services Header ");
					  Thread.sleep(2000);
					  CommonWebActions.webClick("SubsidyDisbursementServices");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("ChooseServiceDropDown");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("OMBChooseServiceDropDownValue");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("RequestNxtButton", "Choose Service");
					  CommonWebActions.webClick("RequestNxtButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("PrepareDisbursementDecisionButton", "Beneficiaries Details");
					  CommonWebActions.webClick("PrepareDisbursementDecisionButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("RequestNxtButton", "Disbursement Decision Preparation Draft Page");
					  CommonWebActions.webClick("RequestNxtButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("IssueDisbursementDecision", "Disbursement Decision Preparation Result");
					  CommonWebActions.webClick("IssueDisbursementDecision");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("IssuePopUp", "You are about to prepare the disbursement decision, are you sure?");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("FFP_Yes");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Social Worker "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean OMBApprovalfromGeneralManagerTM() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("OMBApprovalfromGeneralManagerTM"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("OMBApprovalfromGeneralManagerTM");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("TransactionModuleApprovalHeader", "Transaction Module page header ");
					  Thread.sleep(1000);
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");  
					  Thread.sleep(2000);
				      CommonWebActions.webClick("AppianApproveButton");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Applicant "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean OMBIssueDataFileFromGeneralManager() {
		
		   try{
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("OMBApprovalfromGeneralManagerTM"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
					  CommonWebActions.webClick("OMBApprovalfromGeneralManagerTM");
					  Thread.sleep(2000);
					  AUT.validateBreadCrumb("OMBIssueDataFileHeader", "Issue Data File page header ");
					  Thread.sleep(1000);
					  Takamol.uploadImageBySendKeys("ATTACH SIGNED DISBURSEMENT DECISION", "Test.pdf");
				      String expectedFile ="Test";
				      String actualFile = CommonWebActions.getWebElement("AppianTestPDFUpload").getText();
				      if (actualFile.contains(expectedFile)) {

				            ReportUtil.reporterEvent("pass", "File uploaded"+CommonWebActions.captureScreenshotAsBase64());
				        } else {

				            ReportUtil.reporterEvent("fail", "File not uploaded"+CommonWebActions.captureScreenshotAsBase64());

				        }
				      Thread.sleep(5000);
				      CommonWebActions.webClick("IssueDataFileButton");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("EOISendEmail");
					  Thread.sleep(1000);
					  AUT.validateBreadCrumb("SuccessFFP", "Success");
					  CommonWebActions.webClick("FFPCloseButton");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request sent to Applicant "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request failed "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static void createRequestForOMB(){
		try{
			if(CommonWebActions.webExists(CommonWebActions.getWebElement("CreateRequestButton"))){
				CommonWebActions.webClick("CreateRequestButton");
				AUT.validateBreadCrumb("CreateRequestHeader", "create request page appian header ");
				CommonWebActions.webClick("OrphanButton");
				Thread.sleep(3000);
				AUT.validateBreadCrumb("ServiceOrphanHeader", "Orphan page appian header ");
				CommonWebActions.webClick("RequestOMBLink");
				Thread.sleep(2000);
				AUT.validateBreadCrumb("SearchBeneficiaryHeader", "Beneficiary serach appian header ");
				CommonWebActions.getWebElement("Appian_NationalIDTextBox").sendKeys("8000000003");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("Appian_NationalIDTextBox").sendKeys(Keys.TAB);
				CommonWebActions.webClick("NationalIDSearchButton");
				Thread.sleep(1000);
				CommonWebActions.webClick("SelectFirstRecord");
				CommonWebActions.webClick("RequestNxtButton");
				AUT.validateBreadCrumb("OMBRequestFormHeader", "OMB Request form header ");
				Thread.sleep(1000);
				CommonWebActions.getWebElement("AppianDocumentNo").sendKeys("78789");
		        Thread.sleep(1000);
		        CommonWebActions.webClick("OMB_Verifybutton");
		        Thread.sleep(1000);
		        CommonWebActions.getWebElement("AppianDate").sendKeys("01/20/2023");
		        Thread.sleep(1000);
		        CommonWebActions.webClick("AppianOMB_Documentstaus_dropdown");
		        Thread.sleep(1000);
		        CommonWebActions.webClick("OMB_Documentstaus_value");
		        CommonWebActions.getWebElement("AppianIDNo").sendKeys("1234");
		        Thread.sleep(1000);
		        CommonWebActions.getWebElement("AppianIDType").sendKeys("Passport");
		        Thread.sleep(1000);
		        CommonWebActions.scrollIntoWebElement_ActionClass("AppianSubmitButton");
			    Thread.sleep(1000);	 
			    WebElement element = CommonWebActions.wd.findElement(By.xpath("(//input[@placeholder='mm/dd/yyyy'])[2]"));
                JavascriptExecutor js= (JavascriptExecutor)CommonWebActions.wd;
                js.executeScript("arguments[0].value='01/20/2000';", element);
		  //      CommonWebActions.getWebElement("AppianDateofbirth").sendKeys("01/20/2000");
		  //      Thread.sleep(1000);
		        CommonWebActions.getWebElement("AppianName").sendKeys("Text Entered by Automation");
		        Thread.sleep(1000);
		        CommonWebActions.webClick("AppianSaudiradiobutton");
		        Thread.sleep(1000);
		        CommonWebActions.webClick("AppianMaleradiobutton");
		        Thread.sleep(5000);
		        Takamol.uploadImageBySendKeys("A COPY OF THE MARRIAGE CONTRACT DOCUMENT", "TestImage.png");
		        String expectedFile ="TestImage";
				String actualFile = CommonWebActions.getWebElement("AttachedFileAppian").getText();
				if (actualFile.contains(expectedFile)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				 Thread.sleep(1000);
				Takamol.uploadImageBySendKeys("A COPY OF NATIONAL ID", "TestImage.png");
		        String expectedFile1 ="TestImage";
				String actualFile1 = CommonWebActions.getWebElement("AttachedFileAppian").getText();
				if (actualFile1.contains(expectedFile1)) {

					ReportUtil.reporterEvent("pass", "Verified attached file"+CommonWebActions.captureScreenshotAsBase64());
				} else {

					ReportUtil.reporterEvent("fail", "Attached file is not verified"+CommonWebActions.captureScreenshotAsBase64());

				}
				Thread.sleep(4000);
				//AUT.validateBreadCrumb("AppianSubmitButton", "OMB Form");
				WebElement element1 =   CommonWebActions.wd.findElement(By.xpath("//button[text()='Submit']"));
                JavascriptExecutor js1= (JavascriptExecutor)CommonWebActions.wd;
                js1.executeScript("arguments[0].click();", element1);
			//	CommonWebActions.webClick("AppianSubmitButton");
				Thread.sleep(1000);
				AUT.validateBreadCrumb("Confirm_RequestHeader", "Confirm Submit?");
			    Thread.sleep(1000);
			    CommonWebActions.webClick("FFP_Yes");
			    Thread.sleep(1000);
				AUT.validateBreadCrumb("SuccessFFP", "Success");
				Thread.sleep(1000);
				ReportUtil.reporterEvent("pass", "Request Created "+CommonWebActions.captureScreenshotAsBase64());
				}
			 else
				ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
				
			}
		    catch(Exception e){
			e.printStackTrace();
			ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	public static boolean VocationalAdditionalApprovalRequestFromTechnicalCommitteeMemeber()
	{
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("Waiting_forTechnicalCommitteeReview"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
	            CommonWebActions.webClick("Waiting_forTechnicalCommitteeReview");
					  Thread.sleep(3000);
					  AUT.validateBreadCrumb("Appian_VocationalServiceHeader", "Appian service page header");
					  Thread.sleep(3000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
	                  Thread.sleep(2000);
	            CommonWebActions.webClick("Define_thebeneficiarycategory");
					  Thread.sleep(3000);
					  CommonWebActions.webClick("Definethebeneficiarycategory_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Decision_dropdown");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Decision_AdditionalApproval");
					  Thread.sleep(1000);
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Need additonal approval");
					  Thread.sleep(1000);
					
					  
	            //CommonWebActions.scrollIntoWebElement_new("Appian_SendRequestButton");
					  
					  Thread.sleep(1000);
	            CommonWebActions.webClick("Confirm_button");
					  Thread.sleep(1000);
					 
	            
					 
					  AUT.validateBreadCrumb("Success_PopUp4", "Has been transferred  ");
					  CommonWebActions.webClick("Success_CloseButton2");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request has been transfered to Director "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request has not been transfered to Director "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean VocationalApproveRequestFromDirectorofVocationalRehabilation()
	{
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("Waiting_forDirectoroftheVocationalRehabilitationReview"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
	            CommonWebActions.webClick("Waiting_forDirectoroftheVocationalRehabilitationReview");
					  Thread.sleep(3000);
					  AUT.validateBreadCrumb("Appian_DirectorServiceHeader", "Appian service page header");
					  Thread.sleep(1000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
	                  Thread.sleep(2000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("AppianRemarksTextBox");
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");
					 

					  Thread.sleep(1000);
					 // CommonWebActions.webClick("AcceptRequest");
						 

					  WebElement element =   CommonWebActions.wd.findElement(By.xpath("//button[contains(text(),'Accept Request')]"));
					  JavascriptExecutor js= (JavascriptExecutor)CommonWebActions.wd;
					  js.executeScript("arguments[0].click();", element);
					  Thread.sleep(1000);
					 
	            
					 
					  AUT.validateBreadCrumb("Success_PopUp5", "Has been transferred To Undersecretary ");
					  CommonWebActions.webClick("Success_CloseButton2");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request has been transfered to Undersecretay "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request has been transfered to Undersecretay "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean VocationalApproveRequestFromUndersecretary()
	{
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("Waiting_forUndersecretaryReview"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
	            CommonWebActions.webClick("Waiting_forUndersecretaryReview");
					  Thread.sleep(3000);
					  AUT.validateBreadCrumb("Appian_Undersecretarypageheader", "Appian service page header");
					  Thread.sleep(1000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
	                  Thread.sleep(2000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("AppianRemarksTextBox");
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Approved");
					  Thread.sleep(1000);
					
					  
	            //CommonWebActions.scrollIntoWebElement_new("Appian_SendRequestButton");
					  
					  Thread.sleep(1000);
	            //CommonWebActions.webClick("AcceptRequest");
					  WebElement element =   CommonWebActions.wd.findElement(By.xpath("//button[contains(text(),'Accept Request')]"));
					  JavascriptExecutor js= (JavascriptExecutor)CommonWebActions.wd;
					  js.executeScript("arguments[0].click();", element);
					 
					  Thread.sleep(1000);
					 
	            
					 
					  AUT.validateBreadCrumb("Success_PopUp6", " has been successfully accepted  ");
					  CommonWebActions.webClick("Success_CloseButton2");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request has been transfered to Undersecretay "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request has been transfered to Undersecretay "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}
	
	public static boolean rejectVocationalRequestFromTechnicalCommitteeMemeber()
	{
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("Waiting_forTechnicalCommitteeReview"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
	            CommonWebActions.webClick("Waiting_forTechnicalCommitteeReview");
					  Thread.sleep(3000);
					  AUT.validateBreadCrumb("Appian_VocationalServiceHeader", "Appian service page header");
					  Thread.sleep(3000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
	                  Thread.sleep(2000);
	            CommonWebActions.webClick("Define_thebeneficiarycategory");
					  Thread.sleep(3000);
					  CommonWebActions.webClick("Definethebeneficiarycategory_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Decision_dropdown");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Decision_Valuereject");
					  CommonWebActions.getWebElement("AppianRemarksTextBox").sendKeys("Not approved");
	            //CommonWebActions.scrollIntoWebElement_new("Appian_SendRequestButton");
					  
					  Thread.sleep(1000);
	            CommonWebActions.webClick("Confirm_button");
					  Thread.sleep(1000);
					 
	            
					 
					  AUT.validateBreadCrumb("Success_PopUp2", "request was rejected ");
					  CommonWebActions.webClick("Success_CloseButton1");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request rejected from Technical commitee "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request not rejected from Technical commitee "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}

	public static boolean approveVocationalRequestFromTechnicalCommitteeMemeber()
	{
		
		   try{
			  
				
					if(CommonWebActions.webExists(CommonWebActions.getWebElement("Waiting_forTechnicalCommitteeReview"))){
					  ReportUtil.reporterEvent("pass", "Elements are present "+CommonWebActions.captureScreenshotAsBase64());
	            CommonWebActions.webClick("Waiting_forTechnicalCommitteeReview");
					  Thread.sleep(3000);
					  AUT.validateBreadCrumb("Appian_VocationalServiceHeader", "Appian service page header");
					  Thread.sleep(1000);
					  CommonWebActions.scrollIntoWebElement_ActionClass("CopyRight");
	                  Thread.sleep(2000);
	            CommonWebActions.webClick("Define_thebeneficiarycategory");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Definethebeneficiarycategory_Value");
					  Thread.sleep(1000);
					  CommonWebActions.webClick("Decision_dropdown");
					  Thread.sleep(2000);
					  CommonWebActions.webClick("Decision_Value");
					   Thread.sleep(1000);
	            CommonWebActions.webClick("Confirm_button");
					  Thread.sleep(1000);
					 AUT.validateBreadCrumb("Success_PopUp1", "has been accepted ");
					  CommonWebActions.webClick("Success_CloseButton1");
					  Thread.sleep(1000);
				      return true;						
				    }
				   else
				   ReportUtil.reporterEvent("Pass", "Request approved from Technical commitee "+CommonWebActions.captureScreenshotAsBase64());
				   return false;

			      
				
			  }
			  catch(Exception e){
				e.printStackTrace();
				ReportUtil.reporterEvent("fail", "Request approved from Technical commitee "+CommonWebActions.captureScreenshotAsBase64());
				return false;
			}
		}

	public static boolean verifyVocationalRequestCreatedOrNot() {
	        
	        try{
	           
	             String s1 = CommonWebActions.getWebElement("RequestCreatedHeader_VTS").getText();
	             System.out.println(s1);
	             if(s1.contains("has been sent successfully")){
	                 if(CommonWebActions.webExists(CommonWebActions.getWebElement("OkButton"))
	                   &&CommonWebActions.webExists(CommonWebActions.getWebElement("OkButton"))){
	                   ReportUtil.reporterEvent("pass", "Request created "+CommonWebActions.captureScreenshotAsBase64());
	                   CommonWebActions.webClick("OkButton");
	                   Thread.sleep(2000);
	                   return true;                        
	                 }
	                else
	                ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
	                return false;

	               }
	             else{
	                  ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
	                    return false;
	             }
	           }
	           catch(Exception e){
	             e.printStackTrace();
	             ReportUtil.reporterEvent("fail", "Request not created "+CommonWebActions.captureScreenshotAsBase64());
	             return false;
	         }
	     }
	
}
	
