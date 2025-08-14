import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import javax.swing.JFrame;

public class OneTimePad{

	private static final String allAlphas = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	public static void main(String[] args){

		//JFrame frame = new JFrame("XO");

		//int index = (int)(Math.random() * allAlphas.length() + 1);
		//System.out.println(allAlphas.length());
		//System.out.println(index);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Entext text to encrypt: ");
		String text = scanner.nextLine();

		System.out.println("Your text is: " + text);
		String randomKey = generateKey(stringWithoutSpaces(text).length());

		System.out.println("Ur random key: " + randomKey);

		//List<String> resultEncrypted = new ArrayList<String>();
		//resultEncrypted = encrypt(text);

		//System.out.println("The encrypted message is: " + resultEncrypted.get(0) + " the key is: " + resultEncrypted.get(1));

		//String decrepteddText = decryptText(resultEncrypted.get(0), resultEncrypted.get(1));
		
		//System.out.println("The decrypted message is: " + decrepteddText);

	}

	public static List<String> encrypt(String toEncryptText){

		String key = generateKey(stringWithoutSpaces(toEncryptText).length());
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

		//int index = (int)Math.random() * 100 + 1;

		String result = "";
		
		int counter = textSize;
		while(counter > 0){
			int index = getRandomIndex();
			result = result.concat(Character.toString(allAlphas.charAt(index)));
			counter--;
		}
	
		return result;
	}

	public static String encrypt(String toEncryptText, String key){

		String result = "";


		return result;
	}

	public static String decrypt(String encryptedText, String key){
		
		String result = " ";

		return result;
	}

	public static int getRandomIndex(){
		return (int)(Math.random() * allAlphas.length() + 1) - 1;
	}

	public static String stringWithoutSpaces(String txt){
		String result = "";
		for(char t : txt.toCharArray()){
			if(!Character.isWhitespace(t)){
				result = result.concat(Character.toString(t));
			}
		}
		System.out.println("String wihtout any spaces: " + result);
		return result;
	}
 
}

