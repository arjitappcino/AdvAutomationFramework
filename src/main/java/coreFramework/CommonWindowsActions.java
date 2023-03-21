package coreFramework;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;



/**
 * This class consists of all the common methods required to perform
 * actions on windows controls
 * 
 * @author  Kamil
 * @version 1.0 
 */
public class CommonWindowsActions extends ReportUtil{

	static Screen applicationScreen = new Screen();
	static Pattern controlImage = null;
	static String currDir = System.getProperty("user.dir");
	static String imageRepoLocation = Constants.IMAGEREPOLOCATION;


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
	 * @param  textToEnter This is the column name in test data excel 
	 */
	public static void winSet(String imageLocationInRepository, String textToEnter){
		try{
			String actualImageLocation = ORUtil.getImageLocationValue(imageLocationInRepository);
			checkImageValueExistsForKey(actualImageLocation);
			textToEnter = ExcelUtil.getDataFromExcel(onlyTestCaseName,textToEnter);
			actualImageLocation = currDir + imageRepoLocation + actualImageLocation + ".PNG";
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
	
	/**
	 * This method is used to set the values in the clipboard which can be pasted as per the requirement
	 * 
	 * @author Kamil
	 * @param  String is the String values which you want to set in the clipboard
	 */
	public static void setTextToClipBoard(String aString){
	    StringSelection stringSelection = new StringSelection(aString);
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(stringSelection, null);
	  }

}
