package coreFramework;

import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


/**
 * This class consists of all listners to TestNG
 * 
 * @author  Kamil
 * @version 1.0
 */
public class CoreListener extends TestListenerAdapter {
	
	static IClass testCaseNameListner;
	
	/**
	   * This method is used to get the test case details
	   * 
	   * @author Kamil
	   */
	@Override
	public void onTestStart(ITestResult result) {

		  testCaseNameListner = result.getTestClass();

		}

}