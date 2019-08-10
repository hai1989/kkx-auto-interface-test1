package example.SDK.core;

import common.HttpSDKBase;
import common.TestBase;
import example.ExampleHttp;
import example.SDK.implement.ExampleUriConstant;

/**
 * Created by zhaowei on 2017/1/11.
 */
public class ExampleSDKBase extends HttpSDKBase implements ExampleUriConstant {
    public ExampleSDKBase(){
        baseHttp = new ExampleHttp(TestBase.env);
    }
}
