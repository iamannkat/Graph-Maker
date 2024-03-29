package utils;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Simple CSV reader
 * 
 * Shamelessly stolen from mykong
 * @author mykong https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
 *
 */
public class SimpleCSVReader{

	public ArrayList<String[]> load(String fileName) {

		ArrayList<String[]> lines = new ArrayList<String []>();

		        BufferedReader br = null;
		        String line = "";
		        String cvsSplitBy = ",";

		        try {

		            br = new BufferedReader(new FileReader(fileName));
		            while ((line = br.readLine()) != null) {

		                // use comma as separator
		                String[] element = line.split(cvsSplitBy);
		                lines.add(element);
		            }

		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            if (br != null) {
		                try {
		                    br.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		
	
		return lines;
	}//end load

}//end class