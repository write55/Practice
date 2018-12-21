import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;

public class FileHandler {

	public static void createFile(String name, String extension) {
		File output = new File(name + "." + extension);
	}

	public static File getFile(String path) {
		return new File(path);
	}

	public static void addInfo(ArrayList<String> input) throws IOException {
		Path file = Paths.get("test.txt");
		Files.write(file, input, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
	}

	public static File changeExtension(File f, String newExtension) {
		int i = f.getName().lastIndexOf('.');
		String name = f.getName().substring(0, i);
		return new File(f.getParent() + "/" + name + newExtension);
	}

	public static void main(String[] args) throws IOException {
		ArrayList<String> test = new ArrayList<String>();
		createFile("test", "txt");
		test.add("First value[]");
		test.add("Second Value");
		addInfo(test);
		changeExtension(getFile("test.txt"), "zip");
		System.out.println("Complete");
	}
}
