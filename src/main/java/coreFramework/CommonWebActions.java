package coreFramework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.DriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists of all the common methods required to perform actions on
 * web application
 * 
 * @author Kamil Parvez
 * @version 1.0
 */
public class CommonWebActions extends ReportUtil {

	public static WebDriver wd;
	static RemoteWebDriver remoteWD;
	static boolean isElementDisplayed;
	static JavascriptExecutor javaScriptDriver;
	public static ChromeDriverService service;

	private static int passedTestCasesCount = 0;

	private static int failedTestCasesCount = 0;

	private static int skippedTestCasesCount = 0;
	private static String currentDirectory = ".";
	private static String suiteName;

	private static String browserType;

	private static String osType;

	private static String fileSeperator = System.getProperty("file.separator");

	private static final String TEST_SCREENSHOT_PATH = currentDirectory + fileSeperator + "TestsScreenshots";

	private static final String TEST_OUTPUT_PATH = currentDirectory + fileSeperator + "TestOutput";

	private static final String TEST_SCREENSHOT_PATH_ZIP = currentDirectory + fileSeperator + "TestsScreenshots.zip";

	private static final String TEST_OUTPUT_PATH_ZIP = currentDirectory + fileSeperator + "TestOutput.zip";
	
	private static final Logger LOGGER = Logger.getLogger(CommonWebActions.class.getName());
	/**
	 * This method is used to launch the application.
	 * 
	 * @author Kamil Parvez
	 * @param strURL
	 *            This is the URL of the AUT
	 * @throws IOException
	 */

	public static void launch(String strEnvURL) throws IOException {
		if (OSValidator.isWindows()) {
			launchWin(strEnvURL);
		}
		if (OSValidator.isUnix()) {
			launchLinux(strEnvURL);
		}
		if (OSValidator.isMac()) {
			launchLinux(strEnvURL);
		}
	}

	public static void launchWin(String strEnvURL) {

		try {
			ReportUtil.startReporting();

			String browserType = ORUtil.getConfigValue("BrowserType");
			String browserDimension = ORUtil.getConfigValue("BrowserDimension");
			String x = browserDimension.split(",")[0].trim();
			String y = browserDimension.split(",")[1].trim();
			int num1 = Integer.parseInt(x);
			int num2 = Integer.parseInt(y);
			System.out.println("Set Browser Dimesion--->" + num1 + "," + num2);
			String url = strEnvURL;
			String implicitWait = ORUtil.getConfigValue("Implicit_Wait");
			int waitTime = Integer.parseInt(implicitWait);

			if (browserType.equalsIgnoreCase("firefox")) {
				wd = new FirefoxDriver();
				javaScriptDriver = (JavascriptExecutor) wd;
			} else if (browserType.equalsIgnoreCase("iexplore")) {
				WebDriverManager.iedriver().setup();
				wd = new InternetExplorerDriver();
			} else if (browserType.equalsIgnoreCase("chrome")) {

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
//				options.addArguments("--headless");
				WebDriverManager.chromedriver().setup();
				options.addArguments("--disable-infobars");
				options.addArguments("--ignore-ssl-errors=yes");
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("--remote-allow-origins=*");
				wd = new ChromeDriver(options);

			} else if (browserType.equalsIgnoreCase("edge")) {

				WebDriverManager.edgedriver().setup();
				wd = new EdgeDriver();
			}

			webImplicitWait(wd, waitTime);
			org.openqa.selenium.Dimension d = new org.openqa.selenium.Dimension(num1, num2);
			// Dimension d=new Dimension(700, 480);
			wd.manage().window().setSize(d);
			wd.get(url);
			wd.manage().window().maximize();
			ReportUtil.reporterEvent("pass", "Launched browser [ " + browserType + " ] with url [ " + url + " ]");
		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.reporterEvent("fatal", "Unable to launch the application" + captureScreenshotAsBase64());
		}
	}

	// ---Here we are launch the browser in linux machine

	public static void launchLinux(String strEnvURL) {

		try {
			ReportUtil.startReporting();

			String browserType = ORUtil.getConfigValue("BrowserType");
			String browserDimension = ORUtil.getConfigValue("BrowserDimension");
			String x = browserDimension.split(",")[0].trim();
			String y = browserDimension.split(",")[1].trim();
			int num1 = Integer.parseInt(x);
			int num2 = Integer.parseInt(y);
			System.out.println("Set Browser Dimesion--->" + num1 + "," + num2);
			String proxyURL = ORUtil.getConfigValue("ProxyURL");
			String url = ORUtil.getConfigValue(strEnvURL);

			String implicitWait = ORUtil.getConfigValue("Implicit_Wait");
			int waitTime = Integer.parseInt(implicitWait);

			String chromeDriverPath = "/usr/bin/chromedriver";

			if (browserType.equalsIgnoreCase("firefox")) {
				wd = new FirefoxDriver();
				javaScriptDriver = (JavascriptExecutor) wd;
			} else if (browserType.equalsIgnoreCase("iexplore")) {

				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.google.com/");
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				ieCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				ieCapabilities.setCapability("ignoreZoomSetting", true);
				ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
				wd = new InternetExplorerDriver(ieCapabilities);
				javaScriptDriver = (JavascriptExecutor) wd;

			} else if (browserType.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("--headless");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments(proxyURL);
				// options.addArguments(new String[] { "--proxy-server=" +
				// proxyURL });
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(ChromeOptions.CAPABILITY, options);
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability("platform", Platform.LINUX);

				service = new ChromeDriverService.Builder().usingDriverExecutable(new File(chromeDriverPath))
						.usingPort(9515).build();
				service.start();
				System.out.println(service.getUrl());
				wd = new RemoteWebDriver(service.getUrl(), cap);
				javaScriptDriver = (JavascriptExecutor) wd;

			}

			webImplicitWait(wd, waitTime);
			org.openqa.selenium.Dimension d = new org.openqa.selenium.Dimension(num1, num2);
			wd.manage().window().setSize(d);
			wd.get(url);
			wd.manage().window().maximize();
			ReportUtil.reporterEvent("pass", "Launched browser [ " + browserType + " ] with url [ " + url + " ]");
		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.reporterEvent("fatal", "Unable to launch the application" + captureScreenshotAsBase64());
		}
	}

	public static void reLaunchURL(String strLaunchURL) {
		try {
			String url = ORUtil.getConfigValue(strLaunchURL);
			wd.navigate().to(url);
			ReportUtil.reporterEvent("pass", "Launched application with url [ " + strLaunchURL + " ]");
		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.reporterEvent("fatal", "Unable to launch the application" + captureScreenshotAsBase64());
		}
	}

	/**
	 * This method is used to locate the web object in the application.
	 * 
	 * @author Kamil Parvez
	 * @param objLogicalName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 * @return WebElement This returns the WebElement if web object is found in
	 *         the AUT
	 */
	public static WebElement getWebElement(String objLogicalName) {

		String ORValue = null;
		WebElement webEle = null;
		try {
			ORValue = ORUtil.getValue(objLogicalName);
			String propType = null;
			String propActVal = null;
			if (ORValue.equals("ELEMENTNOTFOUND")) {
				ReportUtil.reporterEvent("fail", "Object with logical name [ " + objLogicalName
						+ " ] not found in Object Repository. Please check...");
				Assert.assertEquals(ORValue.equals("ELEMENTNOTFOUND"), false);
			} else {

				String[] parts = ORValue.split(":=");
				propType = parts[0];
				propActVal = parts[1];

				if (propType.equalsIgnoreCase("id")) {
					webEle = wd.findElement(By.id(propActVal));
				} else if (propType.equalsIgnoreCase("name")) {
					webEle = wd.findElement(By.name(propActVal));
				} else if (propType.equalsIgnoreCase("xpath")) {
					webEle = wd.findElement(By.xpath(propActVal));
				} else if (propType.equalsIgnoreCase("linktext")) {
					webEle = wd.findElement(By.linkText(propActVal));
				} else if (propType.equalsIgnoreCase("cssselector")) {
					webEle = wd.findElement(By.cssSelector(propActVal));
				} else if (propType.equalsIgnoreCase("partiallinktext")) {
					webEle = wd.findElement(By.partialLinkText(propActVal));
				} else if (propType.equalsIgnoreCase("classname")) {
					webEle = wd.findElement(By.className(propActVal));
				} else {
					ReportUtil.reporterEvent("fail",
							"Invalid property type defined in Object Repository for web element [ " + objLogicalName
									+ " ]");
				}
			}

		} catch (NoSuchElementException e) {

		} catch (IOException e) {

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception" + ORValue);
		}
		return webEle;
	}

	/**
	 * This method is used to locate the web object in the application.
	 * 
	 * @author Kamil Parvez
	 * @param objLogicalName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 * @return List This returns the WebElements if web object is found in the
	 *         AUT
	 */
	public static List<WebElement> getWebElements(String objLogicalName) {

		List<WebElement> webEle = null;
		try {
			String ORValue = ORUtil.getValue(objLogicalName);
			String propType = null;
			String propActVal = null;
			if (ORValue.equals("ELEMENTNOTFOUND")) {
				ReportUtil.reporterEvent("fail", "Object with logical name [ " + objLogicalName
						+ " ] not found in Object Repository. Please check...");
				Assert.assertEquals(ORValue.equals("ELEMENTNOTFOUND"), false);
			} else {
				String[] parts = ORValue.split(":=");
				propType = parts[0];
				propActVal = parts[1];

				if (propType.equalsIgnoreCase("id")) {
					webEle = wd.findElements(By.id(propActVal));
				} else if (propType.equalsIgnoreCase("name")) {

					webEle = wd.findElements(By.name(propActVal));
				} else if (propType.equalsIgnoreCase("xpath")) {

					webEle = wd.findElements(By.xpath(propActVal));
				} else if (propType.equalsIgnoreCase("linktext")) {
					webEle = wd.findElements(By.linkText(propActVal));
				} else if (propType.equalsIgnoreCase("cssselector")) {
					webEle = wd.findElements(By.cssSelector(propActVal));
				} else if (propType.equalsIgnoreCase("partiallinktext")) {
					webEle = wd.findElements(By.partialLinkText(propActVal));
				} else if (propType.equalsIgnoreCase("classname")) {
					webEle = wd.findElements(By.className(propActVal));
				} else {
					ReportUtil.reporterEvent("fail",
							"Invalid property type defined in Object Repository for web element [ " + objLogicalName
									+ " ]");
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return webEle;
	}

	/**
	 * This method is used to check Strings is matches to given Regular
	 * Expression
	 * 
	 * @author Kamil Parvez
	 * @param element
	 *            This is the WebElement
	 * @return returns true if matches else false
	 */
	public static boolean stringMatchesToRegExp(String str, String regExp) {
		boolean flag;
		if (str.matches(regExp))
			flag = true;
		else
			flag = false;
		return flag;

	}

	public static void setValuesInPropertyFile(String name, String values) throws IOException {

		Properties props = new Properties();
		FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + ORUtil.strObjectRepoFilePath);
		props.setProperty(name, values);
		props.store(out, null);
		out.close();
	}

	/**
	 * This method is used to check if the elements exists or not
	 * 
	 * @author Kamil Parvez
	 * @param element
	 *            This is the WebElement
	 * @return returns true if object exists else false
	 */
	public static boolean webExists(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static void clickWebElement(String xpath1) throws InterruptedException {

		wd.findElement(By.xpath(xpath1)).click();

	}

	/**
	 * This method is used to click on the specified web element
	 * 
	 * @author Kamil Parvez
	 * @param objName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 */
	public static void webClick(String objName) throws NoSuchElementException {
		WebElement lwebElement = null;
		try {
			lwebElement = getWebElement(objName);
			lwebElement.click();
			ReportUtil.reporterEvent("info", "Clicked on [ " + objName + " ] web element");
		} catch (NoSuchElementException e) {
			if (lwebElement == null)
				ReportUtil.reporterEvent("info",
						"Web Element [ " + objName + " ] NOT FOUND on UI" + captureScreenshotAsBase64());
		}

		catch (ElementNotVisibleException e) {
			System.out.println("Contact List Edit section");
		} catch (NullPointerException ex) {
			System.out.println(objName + "Not displayed");
			ReportUtil.reporterEvent("info",
					"Web Element [ " + objName + " ] NOT FOUND on UI" + captureScreenshotAsBase64());
		}

	}

	public static void webClick(WebElement objName) {

		try {

			objName.click();
			ReportUtil.reporterEvent("info", "Clicked on [ " + objName + " ] web element");
		} catch (ElementNotVisibleException e) {
			ReportUtil.reporterEvent("fail",
					"Web Element [ " + objName + " ] NOT FOUND on UI" + captureScreenshotAsBase64());

		}
	}

	public static void webClickActionClass(WebElement objName) {

		try {
			Actions act = new Actions(wd);
			act.moveToElement(objName).click().perform();
			ReportUtil.reporterEvent("info", "Clicked on [ " + objName + " ] web element");
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail",
					"Web Element [ " + objName + " ] NOT FOUND on UI" + captureScreenshotAsBase64());
		}

	}

	/**
	 * This method is used to enter value in the text box
	 * 
	 * @author Kamil Parvez
	 * @param objName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 * @param strTextToSend
	 *            This is the text to be entered or the column name in the test
	 *            data sheet
	 */
	public static void webSet(String objName, String strTextToSend) {
		WebElement lwebElement = null;
		try {
			lwebElement = getWebElement(objName);
			lwebElement.sendKeys(strTextToSend);
			ReportUtil.reporterEvent("info",
					"Text [ " + strTextToSend + " ] entered in the web element [ " + objName + " ]");

		} catch (Exception e) {

			ReportUtil.reporterEvent("fail",
					"Web Element [ " + objName + " ] NOT FOUND on UI" + captureScreenshotAsBase64());
		}

	}

	public static void webSetText(String objName, String strTextToSend) {
		WebElement lwebElement = null;
		try {
			lwebElement = getWebElement(objName);
			lwebElement.clear();
			lwebElement.sendKeys(strTextToSend);
			ReportUtil.reporterEvent("info",
					"Text [ " + strTextToSend + " ] entered in the web element [ " + objName + " ]");
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail",
					"Web Element [ " + objName + " ] NOT FOUND on UI" + captureScreenshotAsBase64());
		}

	}

	/**
	 * This method is used to verify inner text of an element
	 * 
	 * @author Kamil Parvez
	 * @param objName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 * @param expectedInnerText
	 *            This is the inner text to be verified or the column name in
	 *            the test data sheet
	 * @return returns true if the inner text matches or else returns false
	 */
	public static boolean webVerifyInnerText(String objName, String expectedInnerText) {
		boolean lResultFlag = false;
		try {
			WebElement lwebElement = getWebElement(objName);
			System.out.println("Expected UserName: " + expectedInnerText);
			String actualInnerText = lwebElement.getText();
			System.out.println("Actual Name: " + actualInnerText);
			System.out.println("expectedInnerText: " + expectedInnerText);
			System.out.println("actualInnerText: " + actualInnerText);
			if (actualInnerText.equals(expectedInnerText)) {

				ReportUtil.reporterEvent("pass", "For [ " + objName + " ] actual text [ " + actualInnerText
						+ "] same as expected [ " + expectedInnerText + " ]" + captureScreenshotAsBase64());
				lResultFlag = true;
			} else {

				ReportUtil.reporterEvent("fail", "For [ " + objName + " ] actual text [" + actualInnerText
						+ "] is not same as expected [" + expectedInnerText + "]" + captureScreenshotAsBase64());
				lResultFlag = false;
			}
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail",
					"Web Element [ " + objName + " ] NOT FOUND on UI" + captureScreenshotAsBase64());
		}
		return lResultFlag;
	}

	/**
	 * This method is used to verify page title
	 * 
	 * @author Kamil Parvez
	 * @param expectedPageTitle
	 *            This is the expected page title
	 * @param continueExecution
	 *            <b>true</b> if you want to continue the execution or else
	 *            <b>false</b> to stop the execution
	 */
	public static void webVerifyPageTitle(String expectedPageTitle, Boolean continueExecution) {
		try {
			String actualTitle = wd.getTitle();
			if (expectedPageTitle.equals(actualTitle)) {
				ReportUtil.reporterEvent("pass", " Actual page title [ " + actualTitle + " ] same as expected title [ "
						+ expectedPageTitle + " ]" + captureScreenshotAsBase64());
			} else {
				ReportUtil.reporterEvent("fail", "Actual page title [ " + actualTitle
						+ " ] not same as expected title [ " + expectedPageTitle + " ]" + captureScreenshotAsBase64());
				if (continueExecution.equals(false)) {
					Assert.assertEquals(actualTitle, expectedPageTitle);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to enter secured value in the text box
	 * 
	 * @author Kamil Parvez
	 * @param objName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 * @param strEncodedTextToSend
	 *            This is the encrypted text to be entered
	 */
	public static void webSecureSet(String objName, String strEncodedTextToSend) {
		WebElement lwebElement = null;
		try {
			lwebElement = getWebElement(objName);
			String decodedValue = EncryptUtil.decryption(strEncodedTextToSend);
			lwebElement.sendKeys(decodedValue);
			ReportUtil.reporterEvent("info",
					"Secure Text [ " + strEncodedTextToSend + " ] entered in the web element [ " + objName + " ]");
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail",
					"Web Element [ " + objName + " ] NOT FOUND on UI" + captureScreenshotAsBase64());
		}
	}

	/**
	 * This method is used to mouse hover on web element
	 * 
	 * @author Kamil Parvez
	 * @param elementName
	 *            This is the logical name of the web object in property file
	 *            (OR)
	 */
	public static void webMouseHover(String elementName) {
		WebElement lwebElement = null;
		try {
			lwebElement = getWebElement(elementName);
			Actions action = new Actions(wd);
			action.moveToElement(lwebElement).perform();
			ReportUtil.reporterEvent("info", "Mouse hover done on element [ " + elementName + " ]");
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail",
					"Web Element [ " + elementName + " ] NOT FOUND on UI" + captureScreenshotAsBase64());
		}
	}

	/**
	 * This method is used to drag and drop an element
	 * 
	 * 
	 * @param sorceObjectName
	 *            This is the source element name
	 * @param targetObjectName
	 *            This is the target element name
	 * @author
	 */
	public static void webDragAndDrop(String sorceObjectName, String targetObjectName) {
		WebElement lwebElement1 = null;
		WebElement lwebElement2 = null;
		try {
			lwebElement1 = getWebElement(sorceObjectName);
			lwebElement2 = getWebElement(targetObjectName);
			Actions action = new Actions(wd);
			action.dragAndDrop(lwebElement1, lwebElement2).perform();
			ReportUtil.reporterEvent("info", "Element [ " + sorceObjectName
					+ " ] dragged and dropped in the web element [ " + targetObjectName + " ]");
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail", "Web Element [ " + sorceObjectName + " ] and [ " + targetObjectName
					+ " ] NOT FOUND on UI" + captureScreenshotAsBase64());
		}
	}

	/**
	 * This method is used to close the browser
	 * 
	 * @author Kamil Parvez
	 */
	public static void closeBrowser() {
		wd.close();
		ReportUtil.reporterEvent("info", "Closed the browser window");
	}

	/**
	 * This method is used to switch to a particular frame
	 * 
	 * @param frameNameOrID
	 *            frame ID
	 * @author Kamil
	 */
	public static void switchToFrameWithType(String frameType) {
		try {
			wd.switchTo().frame(frameType);
			ReportUtil.reporterEvent("pass", "Switched to Frame with Type [ " + frameType + " ]");
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail",
					"Frame with Type [ " + frameType + " ] NOT FOUND" + captureScreenshotAsBase64());
		}
	}

	/**
	 * This method is used to switch to a particular window
	 * 
	 * @param windowNameOrHandle
	 *            This is a window name or window handle
	 * @author Kamil Parvez
	 */
	public static void switchToWindow(String windowNameOrHandle) {
		try {
			wd.switchTo().window(windowNameOrHandle);
			ReportUtil.reporterEvent("pass",
					"Switched to Window with Name/Handle [ " + windowNameOrHandle + " ]" + captureScreenshotAsBase64());
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail", "Unable to switch to Window with Name/Handle [ " + windowNameOrHandle
					+ " ]" + captureScreenshotAsBase64());
		}
	}

	/**
	 * This method is used to get all the window handles
	 * 
	 * @return returns an array of window handles
	 * @author Kamil Parvez
	 */
	public static Set<String> getAllWindowHandles() {
		Set<String> winhandles = null;
		try {
			winhandles = wd.getWindowHandles();
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail", "Unable to retrive window handles");
		}
		return winhandles;
	}

	/**
	 * This method is used to get current window handle
	 * 
	 * @return returns current window handle
	 * @author Kamil
	 */
	public static String getCurrentWindowHandle() {
		String winhandle = null;
		try {
			winhandle = wd.getWindowHandle();
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail", "Unable to retrive current window handle");
		}
		return winhandle;
	}

	/**
	 * This method is used to capture screen shot as BASE 64
	 * 
	 * 
	 * @author Kamil Parvez
	 */
	public static String captureScreenshotAsBase64() {
		String screenshotBase64 = ((TakesScreenshot) wd).getScreenshotAs(OutputType.BASE64);
		screenshotBase64 = "data:image/gif;base64," + screenshotBase64;
		String imageInBase64 = logger.addScreenCapture(screenshotBase64);
		return imageInBase64;
	}

	/**
	 * This method is used to get run time value from the AUT
	 * 
	 * @param objectLogicalName
	 *            Logical name of the object in OR
	 * @param attributeName
	 *            Name of the attribute to be captured
	 * @return returns the captured value
	 * @author Kamil Parvez
	 */
	public static String webGetAttribute(String objectLogicalName, String attributeName) {
		String attributeValue = null;
		try {
			WebElement lwebElement = getWebElement(objectLogicalName);
			attributeValue = lwebElement.getAttribute(attributeName);
			ReportUtil.reporterEvent("info",
					"Value [ " + attributeValue + " ] retrived from web element [ " + objectLogicalName + " ]");
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail",
					"Web Element [ " + objectLogicalName + " ] NOT FOUND on UI" + captureScreenshotAsBase64());
		}
		return attributeValue;
	}

	/**
	 * This method is used to explicitly wait for an element to be clickable
	 * 
	 * @param logicalNameOfObject
	 *            Logical name of the object in OR
	 * @param timeInSeconds
	 *            Time to wait
	 * @author Kamil Parvez
	 */
	public static void webExplicitWait(String logicalNameOfObject, int timeInSeconds) {
		try {
			WebElement lWebElement = null;
			lWebElement = getWebElement(logicalNameOfObject);
			(new WebDriverWait(wd, timeInSeconds)).until(ExpectedConditions.elementToBeClickable(lWebElement));
		} catch (NullPointerException e) {

		} catch (ElementNotVisibleException e) {

		}
	}

	/**
	 * This method is used to check if the web element is enabled or not
	 * 
	 * @param objectLogicalName
	 *            Logical name of the web element in OR
	 * @param expectedValue
	 *            This is a boolean value
	 * @author Kamil Parvez
	 */
	public static void webVerifyIsElementEnabled(String objectLogicalName, Boolean expectedValue) {
		WebElement lWebElement = null;
		Boolean actualValue = null;
		try {
			lWebElement = getWebElement(objectLogicalName);
			actualValue = lWebElement.isEnabled();
			if (actualValue.equals(expectedValue)) {
				ReportUtil.reporterEvent("pass",
						"Web element [ " + objectLogicalName + " ] is as expected" + captureScreenshotAsBase64());
			} else {
				ReportUtil.reporterEvent("fail", "Web element [ " + objectLogicalName + " ] is not same as expected"
						+ captureScreenshotAsBase64());
			}
		} catch (Exception e) {
			ReportUtil.reporterEvent("fail",
					"Web Element [ " + objectLogicalName + " ] NOT FOUND on UI" + captureScreenshotAsBase64());
		}
	}

	/**
	 * This method is used for implicit wait
	 * 
	 * @param Driver
	 *            WebDriver instance
	 * @param timeInSeconds
	 *            Time to wait
	 * @author Kamil Parvez
	 */
	public static void webImplicitWait(WebDriver pDriver, int timeInSeconds) {
		wd.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	/**
	 * This method is used abort execution of a test case
	 * 
	 * @param reasonToExit
	 *            This is the reason to abort the test execution
	 * @author Kamil Parvez
	 */
	public static void endTestCaseExecution(String reasonToExit) {
		ReportUtil.reporterEvent("fatal", "Ending test case execution [" + reasonToExit + " ]");
		Assert.assertEquals(true, false);
	}

	/**
	 * This method is used for debugging purpose
	 * 
	 * 
	 * @author Kamil
	 */
	public static void msgbox(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	/**
	 * This method is used highlight an element on GUI
	 * 
	 * @param objLogicalName
	 *            This is the logical name of the object in OR
	 * @author Kamil Parvez
	 */
	public static void highLightElement(String objLogicalName) {

		WebElement lWebElement;
		lWebElement = getWebElement(objLogicalName);

		javaScriptDriver.executeScript("arguments[0].setAttribute('style','border: solid 2px red')", lWebElement);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}
		javaScriptDriver.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", lWebElement);

	}

	/**
	 * This method is used execute java script
	 * 
	 * @param script
	 *            This is the script to be executed
	 * @return Returns an object
	 * @author Kamil Parvez
	 */
	public static Object executeJavaScript(String script) {
		return javaScriptDriver.executeScript(script);
	}

	/**
	 * This method is used wait till the page is completely loaded
	 * 
	 * @author Kamil Parvez
	 */
	public static void waitTillPageIsLoadedFully() {
		try {
			String loading = "return document.readyState";
			Object state = executeJavaScript(loading);
			while (state.toString() != "complete") {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get the properties from OR property file
	 * 
	 * @param objectLogicalName
	 *            This is the logical name of the object in OR
	 * @return Returns command as a string
	 * @author Kamil Parvez
	 */
	public static String getJavaScriptPropertyAndCommand(String objectLogicalName) {
		String script = null;
		try {
			String ORValue = ORUtil.getValue(objectLogicalName);
			String propType = null;
			String propActVal = null;
			if (ORValue.equals("ELEMENTNOTFOUND")) {
				ReportUtil.reporterEvent("fail", "Object with logical name [ " + objectLogicalName
						+ " ] not found in Object Repository. Please check...");
				Assert.assertEquals(ORValue.equals("ELEMENTNOTFOUND"), false);
			} else {
				String[] parts = ORValue.split(":=");
				propType = parts[0];
				propActVal = parts[1];

				if (propType.equalsIgnoreCase("id")) {
					script = "document.getElementById('" + propActVal + "')";
				} else {
					ReportUtil.reporterEvent("fail",
							"Invalid property type defined in Object Repository for web element [ " + objectLogicalName
									+ " ]");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return script;
	}

	/**
	 * This method is used to click on a web element using java script
	 * 
	 * @param objectLogicalName
	 *            This is the logical name of the object in OR
	 * @author Kamil Parvez
	 */
	public static void clickUsingJS(String objectLogicalName) {
		String script = null;
		try {
			script = getJavaScriptPropertyAndCommand(objectLogicalName);
			script = script + ".click();";
			executeJavaScript(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to scroll the web page till the given web element
	 * 
	 * @param objectLogicalName
	 *            This is the logical name of the object in OR
	 * @author Kamil Parvez
	 */
	public static void scrollIntoWebElement(String objectLogicalName) {
		String script = null;
		try {
			script = getJavaScriptPropertyAndCommand(objectLogicalName);
			script = script + ".scrollIntoView(true);";
			executeJavaScript(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollIntoWebElement_new(String objectLogicalName) {
		try {
			javaScriptDriver.executeScript("arguments[0].scrollIntoView(true);",
					CommonWebActions.getWebElement(objectLogicalName));
		} catch (Exception e) {
		}
	}

	public static void scrollIntoWebElement_ActionClass(String objectLogicalName) {

		try {
			Actions a = new Actions(CommonWebActions.wd);
			WebElement el = CommonWebActions.getWebElement(objectLogicalName);
			a.moveToElement(el).build().perform();
		} catch (Exception e) {
		}
	}

	/**
	 * This function will be use to get the text from the webelement
	 * 
	 * @param logicalName
	 *            its a string represent of object name from properties file
	 * @return it will return the value of webelement as String format
	 * @author Kamil
	 */
	public static String getWebElementText(String logicalName) {
		if (webExists(getWebElement(logicalName))) {
			return getWebElement(logicalName).getText();
		} else
			return null;
	}

	/**
	 * This function will be use to get the text from the list of web elements
	 * 
	 * @param logicalName
	 *            its a string represent of object name from properties file
	 * @return it will return the value of web element as list of String
	 * @author Kamil Parvez
	 */
	public static List<String> getWebElementsText(String logicalName) {
		List<String> lstWbElements = new ArrayList<String>();

		if (getWebElements(logicalName) != null) {
			List<WebElement> lst = getWebElements(logicalName);
			System.out.println(lst);
			System.out.println(lst.size());
			for (int i = 0; i < lst.size(); i++) {
				lstWbElements.add(lst.get(i).getText());
			}
			return lstWbElements;
		} else
			return null;
	}

	/**
	 * This function will use to compare the string return boolean value will
	 * return
	 * 
	 * @author Kamil Parvez
	 */
	public static boolean stringMatch(String str1, String str2) {

		if (str1.equals(str2))
			return true;
		else
			return false;
	}

	/**
	 * This function will return list of elements
	 * 
	 * @param element
	 *            List of elements
	 * @return this will return list
	 * @author Kamil Parvez
	 */
	public static List<String> addItemsToList(List<WebElement> element) {
		List<String> listItems = new ArrayList<String>();

		for (WebElement item : element) {

			listItems.add(item.getText().toString());
		}
		return listItems;
	}

	public static void selectTextFromDropdown(String objectLogicalName, String visibleText) {
		WebElement wb = getWebElement(objectLogicalName);
		System.out.println(wb);
		Select sel = new Select(wb);
		List<WebElement> lst = sel.getOptions();
		System.out.println(lst);
	}

	@Parameters({ "toEmailId", "ccEmailId", "fromEmailId", "senderPassword" })
	@AfterSuite(alwaysRun = true)
	public void sendMail(String toEmailId, String ccEmailId, String fromEmailId, String senderPassword) {
		ZipFolder appZip = new ZipFolder();
		appZip.setSourceFolder(TEST_OUTPUT_PATH);
		appZip.setOutputFolder(TEST_OUTPUT_PATH_ZIP);
		appZip.generateFileList(new File(TEST_OUTPUT_PATH));
		appZip.zipIt();

		ZipFolder appZip1 = new ZipFolder();
		appZip1.setSourceFolder(TEST_SCREENSHOT_PATH);
		appZip1.setOutputFolder(TEST_SCREENSHOT_PATH_ZIP);
		appZip1.generateFileList(new File(TEST_SCREENSHOT_PATH));
		appZip1.zipIt();

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmailId, senderPassword);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmailId));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmailId));
			message.setSubject(" Automation Test Report");

			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setContent(createBodyForTheMail(), "text/html; charset=utf-8");

			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename1 = TEST_OUTPUT_PATH_ZIP;
			DataSource dataSource1 = new FileDataSource(filename1);
			messageBodyPart2.setDataHandler(new DataHandler(dataSource1));
			messageBodyPart2.setFileName("TestOutput.zip");

//			MimeBodyPart messageBodyPart3 = new MimeBodyPart();
//			String filename2 = TEST_SCREENSHOT_PATH_ZIP;
//			DataSource dataSource2 = new FileDataSource(filename2);
//			messageBodyPart3.setDataHandler(new DataHandler(dataSource2));
//			messageBodyPart3.setFileName("TestsScreenshots.zip");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);
//			multipart.addBodyPart(messageBodyPart3);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Your Execution Report has been shared over the mail. Please have a look!");
		} catch (Exception ex) {
			System.out.println("Exception: "+ex);
		}

	}
	
	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ReportUtil.reporterEvent("fail", result.getMethod().getMethodName());
			ReportUtil.reporterEvent("fail", result.getThrowable().toString());
//			String screenshotPath;
//			try {
//				screenshotPath = getScreenshot(result.getMethod().getMethodName());
//				logger.addScreenCaptureFromPath(screenshotPath);
//			} catch (IOException e) {
//				LOGGER.info(e.getMessage());
//			}
			failedTestCasesCount++;
		} else if (result.getStatus() == ITestResult.SKIP) {
			ReportUtil.reporterEvent("fail", result.getMethod().getMethodName());
			skippedTestCasesCount++;
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			passedTestCasesCount++;
		}
	}

	private String createBodyForTheMail() {
		
		String os = System.getProperty("os.name");
		String browserName = "CHROME";
		String suiteName = "Appcino Automation-QA";

		StringBuilder sb = new StringBuilder();
		sb.append("Dear Team,");
		sb.append("<br />");
		sb.append("<br />");
		sb.append("Your test suite has just finished its execution. Here is the summary report.");
		sb.append("<br />");
		sb.append("<br />");
		sb.append("<table width=\"600\" border=\"1\">");
		sb.append("<tr>");
		sb.append("<td><b>");
		sb.append("Host Name");
		sb.append("</b></td>");
		sb.append("<td>");
		try {
			sb.append(InetAddress.getLocalHost().getHostName().toUpperCase());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		sb.append("</td>");
		sb.append("</tr>");

		if (browserName != null) {
			sb.append("<tr>");
			sb.append("<td><b>");
			sb.append("Operating System");
			sb.append("</b></td>");
			sb.append("<td>");
			sb.append(System.getProperty("os.name").toUpperCase());
			sb.append("</td>");
			sb.append("</tr>");

			sb.append("<tr>");
			sb.append("<td><b>");
			sb.append("Browser Name");
			sb.append("</b></td>");
			sb.append("<td>");
			sb.append(browserName);
			sb.append("</td>");
			sb.append("</tr>");
		}

		if (os != null) {
			sb.append("<tr>");
			sb.append("<td><b>");
			sb.append("Device Type");
			sb.append("</b></td>");
			sb.append("<td>");
			sb.append(os);
			sb.append("</td>");
			sb.append("</tr>");
		}

		sb.append("<tr>");
		sb.append("<td><b>");
		sb.append("Suite Name");
		sb.append("</b></td>");
		sb.append("<td>");
		sb.append(suiteName);
		sb.append("</td>");
		sb.append("</tr>");

		sb.append("<tr>");
		sb.append("<td><b>");
		sb.append("Result:-");
		sb.append("</b></td>");
		sb.append("</tr>");

		sb.append("<tr>");
		sb.append("<td>");
		sb.append("<font color=\"green\">");
		sb.append("Pass : " + passedTestCasesCount);
		sb.append("</font>");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("<font color=\"red\">");
		sb.append("Fail : " + failedTestCasesCount);
		sb.append("</font>");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("<font color=\"orange\">");
		sb.append("Skip : " + skippedTestCasesCount);
		sb.append("</font>");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table>");

		sb.append("<br />");
		sb.append("This email was sent automatically by Appcino System. Please do not reply.");
		sb.append("<br />");
		sb.append("<br />");
		sb.append("Thanks,");
		sb.append("<br />");
		sb.append("Appcino");

		String tableHTML = String.format(sb.toString());
		return tableHTML;
	}
}
