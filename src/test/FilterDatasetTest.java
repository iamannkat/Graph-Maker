package test;

import server.*;
//import server.DatasetManagerFactory;

//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class FilterDatasetTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//this runs once, before _all_ tests. Nothing to do here.
	}

	@Before
	public void setUp() throws Exception {
		DatasetManager test = new DatasetManager();
		
	}
	
	@Test
	public void initiateTest() {
		DatasetManager test = new DatasetManager();

		String originalDatasetName = "NBA_team_stats.csv";   //from NBA_team_stats.csv file
	    Dataset dataset = new Dataset(originalDatasetName);
	    String newDatasetName = "TestingFilter";
	    String filterColumnName = "Team";
	    String filterValue = "Los Angeles Lakers";
	    
		int t = test.filterDataset(originalDatasetName, newDatasetName, filterColumnName, filterValue);
		
		if (t == 0) {
			System.out.println("Passed! ");
		}else if (t == -1) {
			System.out.println("the t is :"+t+"Something went wrong!");
		}
	    
		//assertEquals("Passed! ", 0, t);
		//fail("Not yet implemented");

	}

}


