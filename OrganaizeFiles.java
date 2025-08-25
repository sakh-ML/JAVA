import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.List;


public class OrganaizeFiles{

	public static final Map<String, List<String>> FILE_TYPES = new HashMap<>();
	static{
		FILE_TYPES.put("Photos", Arrays.asList("png", "jpg", "jpeg", "webp", "bmp", "gif", "tiff", "svg", "heic"));
		FILE_TYPES.put("Documents", Arrays.asList("pdf", "doc", "docx", "odt", "txt", "rtf", "md", "tex"));
		FILE_TYPES.put("Spreadsheets", Arrays.asList("xls", "xlsx", "ods", "csv"));
		FILE_TYPES.put("Presentations", Arrays.asList("ppt", "pptx", "odp"));
		FILE_TYPES.put("Archives", Arrays.asList("zip", "rar", "7z", "tar", "gz", "bz2", "xz", "iso"));
		FILE_TYPES.put("Videos", Arrays.asList("mp4", "mkv", "mov", "avi", "flv", "wmv", "webm"));
		FILE_TYPES.put("Audio", Arrays.asList("mp3", "wav", "flac", "aac", "ogg", "m4a"));
		FILE_TYPES.put("Code", Arrays.asList("py", "c", "cpp", "java", "js", "ts", "html", "css", "php", "rb", "go", "rs", "swift", "kt", "cs", "pl", "lua", "scala", "h", "hpp"));
		FILE_TYPES.put("Scripts", Arrays.asList("sh", "bat", "ps1", "cmd"));
		FILE_TYPES.put("Executables", Arrays.asList("exe", "msi", "apk", "bin", "appimage", "jar", "deb", "rpm"));
		FILE_TYPES.put("Fonts", Arrays.asList("ttf", "otf", "woff", "woff2"));
		FILE_TYPES.put("Database", Arrays.asList("sql", "db", "sqlite", "mdb", "accdb"));
		FILE_TYPES.put("3DModels", Arrays.asList("obj", "fbx", "stl", "blend", "dae"));
		FILE_TYPES.put("Design", Arrays.asList("psd", "ai", "xd", "sketch", "fig"));
		FILE_TYPES.put("Ebooks", Arrays.asList("epub", "mobi", "azw3", "djvu"));
	}

	public static void main(String[] args) throws IOException{

		String path = FileOrganizingFunctions.getPath();
		File[] thingsInDir = FileOrganizingFunctions.getThingsInDir(path);

		for(File f : thingsInDir){
			FileOrganizingFunctions.moveFileToRightPlace(f);
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
			if(thingsInDir != null){
				for(File f : thingsInDir){
					System.out.println(f.getName());
				}
				System.out.println("Number of the things in the dir path:" + thingsInDir.length);
				return thingsInDir;
			}
			throw new IOException("The dirs have nothing");
		}
		else{
			throw new IOException("The path is not right, or this is not a directory");
		}
	}

	public static void moveFileToRightPlace(File f){

		String exct = getFileExtension(f.getName());
	}

	private static String getFileExtension(String fileName){
		if(fileName == null || fileName.isEmpty()){
			return "";
		}
		else{
			int lastIndexOfDot = fileName.lastIndexOf('.');
			if(lastIndexOfDot > 0 || lastIndexOfDot < fileName.length() - 1){
				return fileName.substring(lastIndexOfDot + 1);
			}
			else{
				return "";
			}
		}
	}
}