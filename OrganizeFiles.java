import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * A program that organizes files in a directory into categorized folders
 * based on file extension.
 */
public class OrganizeFiles {

	// Mapping of categories to supported file extensions
	public static final Map<String, List<String>> FILE_TYPES = new HashMap<>();
	static {
		FILE_TYPES.put("Photos", Arrays.asList("png", "jpg", "jpeg", "webp", "bmp", "gif", "tiff", "svg", "heic"));
		FILE_TYPES.put("Documents", Arrays.asList("pdf", "doc", "docx", "odt", "txt", "rtf", "md", "tex"));
		FILE_TYPES.put("Spreadsheets", Arrays.asList("xls", "xlsx", "ods", "csv"));
		FILE_TYPES.put("Presentations", Arrays.asList("ppt", "pptx", "odp"));
		FILE_TYPES.put("Archives", Arrays.asList("zip", "rar", "7z", "tar", "gz", "bz2", "xz", "iso"));
		FILE_TYPES.put("Videos", Arrays.asList("mp4", "mkv", "mov", "avi", "flv", "wmv", "webm"));
		FILE_TYPES.put("Audio", Arrays.asList("mp3", "wav", "flac", "aac", "ogg", "m4a"));
		FILE_TYPES.put("Code", Arrays.asList("py", "c", "cpp", "java", "js", "ts", "html", "css", "php", "rb", "go", "rs", "swift", "kt", "cs", "pl", "lua", "scala", "h", "hpp", "dart"));
		FILE_TYPES.put("Scripts", Arrays.asList("sh", "bat", "ps1", "cmd"));
		FILE_TYPES.put("Executables", Arrays.asList("exe", "msi", "apk", "bin", "appimage", "jar", "deb", "rpm"));
		FILE_TYPES.put("Fonts", Arrays.asList("ttf", "otf", "woff", "woff2"));
		FILE_TYPES.put("Database", Arrays.asList("sql", "db", "sqlite", "mdb", "accdb"));
		FILE_TYPES.put("3DModels", Arrays.asList("obj", "fbx", "stl", "blend", "dae"));
		FILE_TYPES.put("Design", Arrays.asList("psd", "ai", "xd", "sketch", "fig"));
		FILE_TYPES.put("Ebooks", Arrays.asList("epub", "mobi", "azw3", "djvu"));
	}

	public static void main(String[] args) throws IOException {
		String path = FileOrganizingFunctions.getPath();
		File[] thingsInDir = FileOrganizingFunctions.getThingsInDir(path);

		for (File f : thingsInDir) {
			FileOrganizingFunctions.moveFileToRightPlace(f, path);
		}
	}
}


/**
 * Utility class containing functions for file organizing.
 */
class FileOrganizingFunctions {

	/**
	 * Reads the directory path from user input.
	 */
	public static String getPath() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the directory path: ");
		String path = scanner.nextLine();
		System.out.println("----------------");
		scanner.close();
		return path;
	}

	/**
	 * Returns all files and folders inside the given directory path.
	 *
	 * @throws IOException if the path does not exist or is not a directory.
	 */
	public static File[] getThingsInDir(String path) throws IOException {
		File file = new File(path);
		if (file.exists() && file.isDirectory()) {
			File[] thingsInDir = file.listFiles();
			if (thingsInDir != null) {
				return thingsInDir;
			}
			throw new IOException("The directory is empty.");
		} else {
			throw new IOException("Invalid path or not a directory.");
		}
	}

	/**
	 * Moves a file into its corresponding categorized folder.
	 * If the file type is unknown, moves it into an "Others" folder.
	 */
	public static void moveFileToRightPlace(File f, String path) throws IOException {
		if (!f.isFile()) {
			return; // Skip directories
		}

		boolean moved = false;
		String extension = getFileExtension(f.getName()).toLowerCase();

		// Check against known categories
		for (Map.Entry<String, List<String>> entry : OrganizeFiles.FILE_TYPES.entrySet()) {
			if (entry.getValue().contains(extension)) {
				String folderName = entry.getKey();
				String folderPath = path + "/" + folderName;
				File dir = new File(folderPath);

				Path sourcePath = f.toPath();
				Path destPath = Paths.get(folderPath, f.getName());

				System.out.println("Moving: " + sourcePath + " → " + destPath);

				if (dir.exists() || dir.mkdirs()) {
					Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
					moved = true;
					break;
				} else {
					throw new IOException("Directory could not be created: " + folderPath);
				}
			}
		}

		// If no category matched, move to "Others"
		if (!moved) {
			String folderPath = path + "/Others";
			Path sourcePath = f.toPath();
			Path destPath = Paths.get(folderPath, f.getName());
			File dir = new File(folderPath);

			System.out.println("Moving (uncategorized): " + sourcePath + " → " + destPath);

			if (dir.exists() || dir.mkdirs()) {
				Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
			}
		}
	}

	/**
	 * Returns the extension of a given file name.
	 */
	private static String getFileExtension(String fileName) {
		if (fileName == null || fileName.isEmpty()) {
			return "";
		}
		int lastIndexOfDot = fileName.lastIndexOf('.');
		if (lastIndexOfDot > 0 && lastIndexOfDot < fileName.length() - 1) {
			return fileName.substring(lastIndexOfDot + 1);
		} else {
			return "";
		}
	}
}
