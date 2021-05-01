/**
 * @author Dale Butt
 *
 * This file is the Datastore class and is used to store data
 * using getAsync ( to retrive data ), setAsync ( to replace current
 * text with new text ), updateAsync ( to add onto the end of the text )
 * and appendAsync ( to modify a specific line of data ).
 * 
 * 
 */
 
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader; 

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner; 
 
public class Datastore  {
	
	// GetAsync is a method which returns a string of the content of a file
	public static String getAsync(String filename) throws IOException {
		FileReader thisFile = fileRead(filename);
		String textContent = "";
		
		int ch;
		while ( (ch = thisFile.read()) != -1 ) {
			textContent = textContent + "" + ((char)ch) + "";
            //System.out.print((char)singleChar); // tests to print it out man
		}
		
		thisFile.close();
		return textContent;
	}
	
	// SetAsync is a method which sets the content of the file as newValue
	public static void setAsync(String filename, String newValue)  throws IOException { // wrap into error /throw tests
		FileWriter thisFile = fileWrite(filename);
		thisFile.write(newValue); 
		thisFile.flush();
		thisFile.close();
	}
	
	// UpdateAsync is a method which appends texts to the end of the file
	public static void updateAsync(String filename, String data)  throws IOException {  // wrap into error /throw tests
		String currentContent = Datastore.getAsync(filename);
		String spacer = System.getProperty("line.separator");
		Datastore.setAsync(filename, currentContent + spacer + data);
	}
	
	// AppendAsync is a method to select a specific line & to alter it
		// queryLookUp is what we use to search the file for
		// once we know exactly which line is selected
		// update it to the new replacement value
		// spacer is a paragraph key (save using /n on string formation)
	public static void appendAsync(String filename, String queryLookUp, String replacement) throws IOException {
		String[] packageData = fileSearch(filename, queryLookUp);
		String spacer = System.getProperty("line.separator");
		
		Datastore.setAsync(filename, packageData[0] + spacer + packageData[1] + spacer + packageData[2]);
	}
	
	// EXTRA OPERATIONS	
	//
	//
	
	// fileWrite is a method which returns a file which can be written to; it checks fie existence and errors otherwise.
	private static FileWriter fileWrite(String filename) throws IOException {
		// creates a FileWriter Object
		FileWriter writer = null;

		// Handle the exception just in case the file doesn't exist
		try {
			writer = new FileWriter(new File(filename)); 

		} catch (FileNotFoundException e) {
			System.out.println("Cannot open: " + filename);
			System.exit(0);
		}
		
		return writer;
	}
	
	// fileRead is a method which returns a file which can be read from; it checks fie existence and errors otherwise.
	private static FileReader fileRead(String filename) throws IOException {
		// Creates a FileReader Object
		FileReader reader = null;
		
		// Handle the exception just in case the file doesn't exist
		try {
			reader = new FileReader(new File(filename)); 

		} catch (FileNotFoundException e) {
			System.out.println("Cannot open: " + filename);
			System.exit(0);
		}
		
		return reader;
	}
	
	private static String[] fileSearch(String filename, String key) throws FileNotFoundException {
		String[] data = new String[3]; //0 is front, 1 is middle, 2 is back
		data[0] = ""; data[1] = ""; data[2] = ""; // set data to empty string to remove null
		
		//BufferedReader reader = new BufferedReader(fileRead(filename));
		Scanner dataFile = new Scanner(new File(filename));
		Boolean foundLine = false;
		
		while (dataFile.hasNextLine()) {
			String currentLine = dataFile.nextLine();
			
			if (currentLine.contains(key)) {				
				data[1] = currentLine;
				foundLine = true;
				
			} else if (foundLine == false) {
				data[0] = data[0] + currentLine;
					
			} else if (foundLine == true) {
				data[2] = data[2] + currentLine;
			}
		}
		
		dataFile.close();
		return data;
	}
}