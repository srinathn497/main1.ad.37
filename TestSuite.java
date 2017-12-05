package testsuite;




import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.FirstTest;
import test.SecondTest;
import test.ThirdTest;



@RunWith(Suite.class)
@Suite.SuiteClasses({ FirstTest.class, SecondTest.class,ThirdTest.class})

public class TestSuite {

}
