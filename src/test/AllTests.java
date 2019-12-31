package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FilterDatasetTest.class,RetrieveDatasetTest.class, RegisterDatasetTest.class, GetDatasetProjectionTest.class}) //put the rest 2
public class AllTests {
	//no need to add sth here. The above directives simply run all tests
} 
