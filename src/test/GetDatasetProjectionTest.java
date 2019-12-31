package test;

//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import server.DatasetManager;

public class GetDatasetProjectionTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//this runs once, before _all_ tests. Nothing todo here.
	}

	@Before
	public void setUp() throws Exception {
		DatasetManager test = new DatasetManager();
		
	}
	
	@Test
	public void initiateTest(){
		DatasetManager data = new DatasetManager();
		String datasetName = "NBA2";
		data.registerDataset("NBA2","C:\\Users\\user\\Desktop\\project\\Resources\\NBA_team_stats.csv");
		ArrayList<String> attributes = new ArrayList<String>();
		attributes.add("PTS");
		attributes.add("W");
		
		ArrayList<String[]> output = data.getDatasetProjection(datasetName,attributes);
		int k = 0;
		for (int i = 0; i  < output.size(); i++) {
			if (output.get(i) == null) {
				k++;
			}
		}
		if (k == 2) {
			System.out.println("Oops, something went wrong!");
		}else {
			System.out.println("Passed! ");

		}
		
		//assertNull("Oops, something isnt right", output.get(0));
		//assertNull("Oops, something isnt right", output.get(1));
	}

}
