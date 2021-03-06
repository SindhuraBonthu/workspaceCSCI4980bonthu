 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class ReadShowHandler {
	@Execute
	 public void execute(Shell shell) {
	      // A format of file "config.txt" consists of a key-value pair.
	      List<String> contents = ReadShowHandler.readFile("/Users/unouser/Documents/config.txt");
	      for (int i = 0; i < contents.size(); i++) {
	         String line = contents.get(i);
	         System.out.println("[DBG] Line " + i + " - " + line);

	         String name = line.split(":")[1].trim();
	         System.out.println("[DBG] \tName: " + name);
	         MessageDialog.openInformation(shell, "Title", name);
	      }
	   }

	   public static List<String> readFile(String filePath) {
	      List<String> contents = new ArrayList<String>();
	      File file = new File(filePath);
	      Scanner scanner = null;
	      try {
	         scanner = new Scanner(file);
	         while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            contents.add(line);
	         }
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } finally {
	         if (scanner != null)
	            scanner.close();
	      }
	      return contents;
	   }
		
}