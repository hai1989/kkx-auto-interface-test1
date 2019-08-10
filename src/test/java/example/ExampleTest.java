package example;

import com.alibaba.fastjson.JSONException;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

/**
 * Created by zhaowei2 on 2016/12/29.
 */
public class ExampleTest extends TestBase {

    public ExampleHttp exampleHttp;

    @BeforeClass(groups = {"smoke", "function"})
    @Parameters("env")
    public void aBeforeClass(String env) throws Exception {
//        String env = "qa";
        TestBase.env = env;
        exampleHttp = new ExampleHttp(env);
    }

    @BeforeMethod
    public void AbeforeMethod() {
        clearDataMap();
    }

}
