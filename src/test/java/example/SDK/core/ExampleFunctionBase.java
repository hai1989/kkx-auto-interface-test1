package example.SDK.core;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by zhaowei on 2017/1/11.
 */
public class ExampleFunctionBase extends ExampleSDKBase {
    public ExampleFunctionBase(){
        headMap.put("","");
    }
    public JSONObject getParentInfo() {
       return get(EXAMPLE_URI,getData,null,bodyData);
    }
}
