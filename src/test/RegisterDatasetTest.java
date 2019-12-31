package test;
import server.DatasetManager;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RegisterDatasetTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//this runs once, before _all_ tests. Nothing to do here.
	}

	@Before
	public void setUp() throws Exception {
		//DatasetManager test = new DatasetManager();
	}

	@Test
	public void initiateTest() {
		DatasetManager test = new DatasetManager();

		// First case: Successful
		int i = test.registerDataset("NBA1", "C:\\Users\\user\\Desktop\\project\\Resources\\NBA_player_data_1.csv");
		if (i == 0) {
			System.out.println("#1 Passed! Dataset succesfully registered");
		}else if (i == -10 || i == -1) {
			System.out.println("#1 Not Passed! Something is wrong here...typical");
		}
		
		//Second case: null datasetName
		int j = test.registerDataset(null, "C:\\Users\\user\\Desktop\\project\\Resources\\2014-Budget-GR.csv");
		if (j == -1) {
			System.out.println("#2 Passed! Dataset name is null");
		}else if (j == -10 || j == 0) {
			System.out.println("#2 Not Passed! Something is wrong here...typical");
		}
		
		//Third case: Dataset already exists
		int d = test.registerDataset("NBA3", "C:\\Users\\user\\Desktop\\project\\Resources\\NBA_team_stats.csv");
		int k = test.registerDataset("NBA3", "C:\\Users\\user\\Desktop\\project\\Resources\\NBA_team_stats.csv");
		if (k == -10) {
			System.out.println("#3 Passed! Dataset is already there");
		}else if (k == 0 || k == -1) {
			System.out.println("#3 Not Passed! Something is wrong here...typical");
		}	
		
		//assertNotEquals();
		//assertEquals();
		//fail("Not yet implemented");
	}
}