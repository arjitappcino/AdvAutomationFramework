package coreFramework;

import org.apache.commons.codec.binary.Base64;

/**
* This class consists of methods to encrypt and decrypt strings
* 
* @author  Kamil
* @version 1.0
*/
public class EncryptUtil {

	/**
	 * This method is used to encrypt a string
	 * 
	 * @author Kamil
	 * @param  stringToBeEncrypted This is the string which needs to be encrypted
	 */
	public static String encryption(String stringToBeEncrypted){
		System.out.println("Encoded value is ");
		byte[]   bytesEncoded = Base64.encodeBase64(stringToBeEncrypted.getBytes());
		String encodedString = new String(bytesEncoded);
		System.out.println("Encoded value is [ " + encodedString + " ]");
		return encodedString;
	}
	
	
	/**
	 * This method is used to decrypt a encrypted string
	 * 
	 * @author Kamil
	 * @param  stringToBeDecrypted This is the string which needs to be decrypted
	 */
	public static String decryption(String stringToBeDecrypted){
		byte[] valueDecoded= Base64.decodeBase64(stringToBeDecrypted);
		String decodedString = new String(valueDecoded);
		return decodedString;		
	}
}
