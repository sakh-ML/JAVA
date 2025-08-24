import java.io.*;
import java.util.ArrayList;
import java.util.List;

//file handling project

public class FileHandling{
	public static void main(String[] args) throws IOException{
		System.out.println("Ey");
		//createFile("test.txt");
		//FileOpeartions.createFile("test.txt");
		//String fileName = "test.txt";
		//List<Character> fileContent = FileOpeartions.readFileCharForChar(fileName);
		//FileOpeartions.printArrayOfChars(fileContent);
		//FileOpeartions.writeToFile(fileName, "yuyu");
		//fileContent = FileOpeartions.readFileCharForChar(fileName);
		//FileOpeartions.printArrayOfChars(fileContent);
		FileOpeartions.deleteFile("test.txt");

	}
}

class FileOpeartions{

	public static void createFile(String fileName){
		try{
			File file = new File(fileName);

			if(file.createNewFile()){
				System.out.println("File was created: " + file.getName());
				//return true;
			}
			else{
				System.out.println("File already exists");
				//return false;
			}
		}

		catch (IOException e){
			System.out.println("File cannot be created");
			e.printStackTrace();
		}
	}

	public static List<Character> readFileCharForChar(String fileName) throws IOException{

		List<Character> result = new ArrayList<>();

		File file = new File(fileName);
		if(!file.exists()){

			throw new FileNotFoundException("File wasnt found !");
		}
		else{
			FileReader fileReader = new FileReader(file);
			int charachter;
			while((charachter = fileReader.read()) != -1){
				result.add((char) charachter);
			}
			fileReader.close();
		}

		return result;
	}

	public static void writeToFile(String fileName,String text) throws IOException{

		File file = new File(fileName);
		FileWriter fileWriter = new FileWriter(file, true);
		fileWriter.write(text);

		fileWriter.close();

	}

	public static boolean deleteFile(String fileName) throws FileNotFoundException {

		File file = new File(fileName);
		if (file.exists()) {
			return file.delete();
		}
		else{
			throw new FileNotFoundException("File wasnt found");
		}

	}


	public static void printArrayOfChars(List<Character> characters){
		String bettwenResult = "";
		for(char ch : characters){
			bettwenResult += ch;
		}

		System.out.println(bettwenResult);
	}
}