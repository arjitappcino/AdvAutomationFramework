package coreFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of methods to connect to a property file
 * 
 * @author  Kamil
 * @version 1.0
 */
public class ORUtil {

	static Properties ObjectRepo = null;
	static Properties ConfigFile = null;
	static Properties ImageRepo = null;
	public static String strObjectRepoFilePath;
	static String strConfigFilePath = Constants.STRCONFIGFILEPATH;
	static String strImageRepoFilePath = Constants.STRIMAGEREPOFILEPATH;
	
	/**
	 * This method is used to connect to a property file
	 * 
	 * @author Kamil
	 * @param  strFilePath This is the file path
	 */
	public static Properties ConnectToFile(String strFilePath) throws IOException {
		String currDir = System.getProperty("user.dir");
		String path = currDir + strFilePath;
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		return prop;		
	}

	/**
	 * This method is used to get value from the property file
	 * 
	 * @author Kamil
	 * @param  key This is the key name (logical name)
	 * @return String This returns the value from property file
	 */
	public static String getValue(String key) throws IOException{
		ObjectRepo = ConnectToFile(strObjectRepoFilePath);
		String objectPropertyVal = ObjectRepo.getProperty(key,"ELEMENTNOTFOUND");
		return objectPropertyVal;	
	}

	/**
	 * This method is used to set value from the property file
	 * 
	 * @author Kamil 
	 * @param  key This is the key name (logical name)
	 * @param valueToSet This is the value to be set in the property file
	 */
	public static void setValue(String key, String valueToSet) throws IOException{
		ObjectRepo = ConnectToFile(strObjectRepoFilePath);
		ObjectRepo.setProperty(key, valueToSet);
	}

	/**
	 * This method is used to get value from the property file
	 * 
	 * @author Kamil  
	 * @param  key This is the key name
	 * @return String This returns the value from property file
	 */
	public static String getConfigValue(String key) throws IOException{
		ConfigFile = ConnectToFile(strConfigFilePath);
		String configValue = ConfigFile.getProperty(key);
		return configValue;	
	}

	/**
	 * This method is used to set value from the property file
	 * 
	 * @author Kamil 
	 * @param  key This is the key name
	 * @param valueToSet This is the value to be set in the property file
	 */
	public static void setConfigValue(String key, String valueToSet) throws IOException{
		ConfigFile = ConnectToFile(strConfigFilePath);
		ConfigFile.setProperty(key, valueToSet);
	}
	
	/**
	 * This method is used to get value from the Image Location Repository property file
	 * 
	 * @author Kamil 
	 * @param  key This is the key name
	 * @return String This returns the value from property file
	 */
	public static String getImageLocationValue(String key) throws IOException{
		ConfigFile = ConnectToFile(strImageRepoFilePath);
		String configValue = ConfigFile.getProperty(key,"IMAGELOCATIONNOTFOUND");
		return configValue;	
	}
	
	
}
