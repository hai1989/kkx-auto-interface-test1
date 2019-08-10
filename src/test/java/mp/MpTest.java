package mp;

import common.TestBase;
import example.ExampleHttp;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class MpTest  extends TestBase {


    public MPHttp mpHttp;

    @BeforeClass(groups = {"smoke", "function"})
//    @Parameters("env")
    public void aBeforeClass() throws Exception {
        String env = "qa";
        TestBase.env = env;
        mpHttp = new MPHttp(env);
    }

    @BeforeMethod
    public void AbeforeMethod() {
        clearDataMap();
    }

}
