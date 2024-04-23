package principiante;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(LibroTest.class);
		suite.addTestSuite(PersonaTest.class);
		suite.addTestSuite(MiBibliotecaTest.class);
		//$JUnit-END$
		return suite;
	}

}
