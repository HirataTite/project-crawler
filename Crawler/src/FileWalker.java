
import java.io.File;
import java.util.*;

public class FileWalker {

	public void walk(String... args) {
		File root = new File(args[0]);
		File[] list = root.listFiles();

		if (list == null) {
			return;
		}

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
				System.out.println("Directory: " + f.getAbsolutePath());
			} else {
				System.out.println("File: " + f.getAbsoluteFile());
			}
		}
	}
}
