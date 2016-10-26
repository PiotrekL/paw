package trello.utils;



public class SecureUtil {

	
	 public static String getHash(String password) {
	        try {
	                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
	                    byte[] tempArray = messageDigest.digest(password.getBytes());
	                    StringBuffer stringBuffer = new StringBuffer();
	                    for (int i = 0; i < tempArray.length; ++i) {
	                        stringBuffer.append(Integer.toHexString((tempArray[i] & 0xFF) | 0x100).substring(1,3));
	                 }
	                    return stringBuffer.toString();
	            } catch (java.security.NoSuchAlgorithmException e) {
	                
	            }
	            return "";
	    }
	 
	 
	
	
}
