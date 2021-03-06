package model;

import java.util.ArrayList;
import java.util.List;

import util.UtilFile;

public enum MyPersonModelProvider {
	// INSTANCE;
	INSTANCE(getFilePath()); // Call a constructor with a parameter. 

	private List<MyPerson> persons;

          // Load the data sets from a file dynamically. 
	private MyPersonModelProvider(String inputdata) {
		List<String> contents = UtilFile.readFile(inputdata);
		List<List<String>> tableContents = UtilFile.convertTableContents(contents);

		persons = new ArrayList<MyPerson>();
		for (List<String> iList : tableContents) {                        
			persons.add(new MyPerson(iList.get(0), iList.get(1), iList.get(2), Boolean.valueOf(iList.get(3))));
		}
	}

	private static String getFilePath() {
		return "C:/Users/unouser/eclipse-workspace/workspaceCSCI4980/workspaceCSCI4980bonthu/project0911-fieldAssist-bonthu/src/inputdata.txt";
	}

	public List<MyPerson> getPersons() {
		return persons;
	}
}