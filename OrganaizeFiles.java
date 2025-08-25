import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OrganaizeFiles{
	public static void main(String[] args) throws IOException{

		String path = FileOrganizingFunctions.getPath();
		File[] thingsInDir = FileOrganizingFunctions.getThingsInDir(path);
		if(thingsInDir == null){
			System.out.println("The directory is empty !");
		}
		else{
				System.out.println("Doing Organization: ---");
		}
	}
}


class FileOrganizingFunctions{

	public static String getPath(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Path: ");
		String path = scanner.nextLine();
		System.out.println("----------------");
		scanner.close();
		return path;
	}

	public static File[] getThingsInDir(String path) throws IOException{
		File file = new File(path);
		if(file.exists() && file.isDirectory()){
			File[] thingsInDir = file.listFiles();
			for(File f : thingsInDir){
				System.out.println(f.getName());
			}
			System.out.println("Number of the things in the dir path:" + thingsInDir.length);
			return thingsInDir;
		}
		else{
			throw new IOException("The path is not right, or this is not a directory");
		}
	}
}