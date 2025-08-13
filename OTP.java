import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OTP{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		String text = scanner.nextLine();

		System.out.println("Your text is: " + text);

		List<String> resultEncrypted = new ArrayList<String>();
		resultEncrypted = encrypt(text);

		System.out.println("The encrypted message is: " + resultEncrypted.get(0) + " the key is: " + resultEncrypted.get(1));

		String decrepteddText = decryptText(resultEncrypted.get(0), resultEncrypted.get(1));
		
		System.out.println("The decrypted message is: " + decrepteddText);

	}

	public static List<String> encrypt(String toEncryptText){

		String key = generateKey(toEncryptText.length());
		String encryptedText = encrypt(toEncryptText, key);
		
		List<String> result = new ArrayList<String>();
		result.add(key);
		result.add(encryptedText);
		
		return result;
	}

	public static String decryptText(String encryptedText, String key){

		String decryptedText = decrypt(encryptedText, key);

		return decryptedText;
	}

	public static String generateKey(int textSize){
		String key = "";


		return key;
	}

	public static String encrypt(String toEncryptText, String key){

		String result = "";


		return result;
	}

	public static String decrypt(String encryptedText, String key){
		
		String result = " ";

		return result;
	}
 
}
