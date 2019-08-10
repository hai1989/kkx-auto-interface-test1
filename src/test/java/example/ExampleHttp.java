package example;

import common.BaseHttp;
import common.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.Tool;

import java.util.Map;

/**
 * Created by zhaowei2 on 2016/12/29.
 */
public class ExampleHttp extends BaseHttp {
    private String exampleUrl;

    public ExampleHttp(String env) {
        setEnv(env);
        ps = Tool.getProperties("Example.properties",ExampleHttp.class);
        this.exampleUrl = ps.getProperty(env + "_example_url");
    }


    public void setHttpInfo(String uri, HttpMethod method){
        setUrl(exampleUrl+uri);
        setMethod(method);
    }
}
