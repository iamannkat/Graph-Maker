package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import server.*;
import utils.*;

public class RetrieveDatasetTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//this runs once, before _all_ tests. Nothing to do here
	}

	@Before
	public void setUp() throws Exception {
		DatasetManager test = new DatasetManager();
		
		//before implementing the above, try having just the following fail.
		//Run the test and see that it fails indeed.
		//Then build your test.
		//fail("Intentional failure. Not yet implemented");
		
	}
	
	@Test
	public void initiateTest() {
		DatasetManager test = new DatasetManager();
		
        String datasetName = "NBA3";
		ArrayList<String[]> testArray = new ArrayList<String[]>();
        SimpleCSVReader readerTest = new SimpleCSVReader();

        testArray = readerTest.load("C:\\Users\\user\\Desktop\\project\\Resources\\NBA_team_stats.csv");
        test.registerDataset(datasetName, "C:\\Users\\user\\Desktop\\project\\Resources\\NBA_team_stats.csv");
        String[] actual = test.retrieveDataset(datasetName,testArray);
        
        String[] expected = {"SeasonEnd", "Team", "Playoffs", "W", "PTS", "oppPTS", "FG", "FGA", "2P", "2PA", "3P", "3PA", "FT", "FTA", "ORB", "DRB", "AST", "STL", "BLK", "TOV"};
        
        for (int i = 0; i < actual.length; i++) {
        	if (expected[i].equals(actual[i])) {
        		System.out.println("Passed! The Dataset has ben retrieved");
        	}
        }
        //assertNotNull([message,] object);	
        //assertNotNull([message,] object);
	}
}