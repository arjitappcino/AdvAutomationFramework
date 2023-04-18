package coreFramework;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import org.testng.Assert;



/**
 * This class consists of all the common methods required to perform
 * actions on windows controls
 * 
 * @author  Kamil
 * @version 1.0 
 */
public class CommonWindowsActions extends ReportUtil{

//	static Screen applicationScreen = new Screen();
//	static Pattern controlImage = null;
	static String currDir = System.getProperty("user.dir");
	static String imageRepoLocation = Constants.IMAGEREPOLOCATION;
	
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
