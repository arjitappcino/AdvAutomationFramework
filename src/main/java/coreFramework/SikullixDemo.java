package coreFramework;

import java.io.File;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

public class SikullixDemo {
	
	static Screen applicationScreen = new Screen();
	static Pattern controlImage = null;
	static String currDir = System.getProperty("user.dir");
	static String imageRepoLocation = Constants.IMAGEREPOLOCATION;

	public static void main(String[] args) throws FindFailed {
		controlImage = new Pattern(Constants.CONTROLIMAGE);
		applicationScreen.click(controlImage);
	}
	
	
	/**
	 * This method is used to click on windows controls or anything displayed on the GUI
	 * 
	 * @author Kamil 
	 * @param  imageLocationInRepository This is the logical name of the of the location of the image in the Image Repo
	 */
	public static void winClick(String imageLocationInRepository){
		try{
			String actualImageLocation = ORUtil.getImageLocationValue(imageLocationInRepository);
			checkImageValueExistsForKey(actualImageLocation);
			actualImageLocation = currDir + imageRepoLocation + actualImageLocation + ".PNG";
			controlImage = new Pattern(actualImageLocation);
			applicationScreen.click(controlImage);
			CommonWebActions.msgbox("click done");
			ReportUtil.reporterEvent("info", "Clicked on [ " + imageLocationInRepository + " ]");
		}catch(Exception e){
			ReportUtil.reporterEvent("fail", "Image/Control [ " + imageLocationInRepository + " ] NOT FOUND on UI" + CommonWebActions.captureScreenshotAsBase64());
		}
	}

	
	/**
	 * This method is used to enter text on windows text boxes or any text boxes
	 * 
	 * @author Kamil 
	 * @param  imageLocationInRepository This is the logical name of the of the location of the image in the Image Repo
	 * @param  textToEnter This is the text to be entered
	 */
	public static void winSet(String imageLocationInRepository, String textToEnter){
		try{
			String actualImageLocation = ORUtil.getImageLocationValue(imageLocationInRepository);
			checkImageValueExistsForKey(actualImageLocation);
			actualImageLocation = currDir + actualImageLocation;
			controlImage = new Pattern(actualImageLocation);
			applicationScreen.type(textToEnter);
			ReportUtil.reporterEvent("info", "Text [ " + textToEnter + " ] entered in the web element [ " + imageLocationInRepository + " ]" );
		}catch(Exception e){
			ReportUtil.reporterEvent("fail", "Text box [ " + imageLocationInRepository + " ] NOT FOUND on UI" + CommonWebActions.captureScreenshotAsBase64());
		}
	}
	
	/**
	 * This method is used to check if the image name is present in the image repository
	 * 
	 * @author Kamil
	 * @param  imageKeyValue This is the logical name of the image in the repository
	 */
	public static void checkImageValueExistsForKey(String imageKeyValue){
		if (imageKeyValue.equals("IMAGELOCATIONNOTFOUND")) {
			ReportUtil.reporterEvent("fail","Image's logical name [ " + imageKeyValue + " ] not found in Image Repository. Please check...");
			Assert.assertEquals(imageKeyValue.equals("IMAGELOCATIONNOTFOUND"), false);
		}		
	}
   
	public static void fileAttachment(String browse,String fileName,String open,String filePath) throws FindFailed, InterruptedException
	{
		Pattern pbrowse=new Pattern(browse);
		Pattern pfileName=new Pattern(fileName);
		Pattern popen=new Pattern(open);
		File file = new File(filePath);
		filePath = file.toString();
		Screen scr=new Screen();
		scr.setAutoWaitTimeout(50);
		scr.click(pbrowse);
		Thread.sleep(2000);
		scr.click(pfileName);
		scr.type(pfileName, filePath);
		Thread.sleep(2000);
		scr.click(popen);
		ReportUtil.reporterEvent("info", "File is attached");
		
	}
	
	public static void fileAttachmentTakamol(String fileName,String open,String filePath) throws FindFailed, InterruptedException
	{
		Pattern pfileName=new Pattern(fileName);
		Pattern popen=new Pattern(open);
		File file = new File(filePath);
		filePath = file.toString();
		Screen scr=new Screen();
		scr.setAutoWaitTimeout(50);
		Thread.sleep(2000);
		scr.click(pfileName);
		scr.type(pfileName, filePath);
		Thread.sleep(2000);
		scr.click(popen);
		ReportUtil.reporterEvent("info", "File is attached");
		
	}


}

