package mp.sdk.core;

import common.HttpSDKBase;
import common.TestBase;
import example.ExampleHttp;
import mp.MPHttp;
import mp.sdk.implement.MPUriconstant;

public class MPSDKBase  extends HttpSDKBase  implements MPUriconstant {

    public MPSDKBase(){
        baseHttp = new MPHttp(TestBase.env);
    }
}
