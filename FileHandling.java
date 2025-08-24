import java.io.File;
import java.io.IOException;

//file handling project

public class FileHandling{
	public static void main(String[] args){
		System.out.println("Ey");
		createFile("HEy.txt");
	}

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
}
