package infinite.OtpApp;

public class KeyTest {
	public static String generateResetKey() {
		int len=10;
		  String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			         + "0123456789"
			         + "abcdefghijklmnopqrstuvxyz";
			  StringBuilder sb = new StringBuilder(len);
			  for (int i=0;i<len;i++) {
			   int index = (int)(AlphaNumericString.length()
			      * Math.random());
			   sb.append(AlphaNumericString
			      .charAt(index));
			  }
			  return sb.toString();
	}

	public static void main(String[] args) {
		KeyTest obj = new KeyTest();
		String key = obj.generateResetKey();
		System.out.println(key);
	}

}
