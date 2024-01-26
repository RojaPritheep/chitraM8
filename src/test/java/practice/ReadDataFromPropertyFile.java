package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: Open the document in Java Readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create Obj of Properties Class from Java.util
		Properties p = new Properties();
		
		//Step 3: Load the fis into properties class
		p.load(fis);
		
		//Step 4: Provide key and read the value
		String value = p.getProperty("UN");
		System.out.println(value);
		
	}

}
