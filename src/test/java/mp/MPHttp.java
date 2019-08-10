package mp;

import common.BaseHttp;
import common.HttpMethod;
import example.ExampleHttp;
import util.Tool;

public class MPHttp  extends BaseHttp {
    private String mpUrl;

    public MPHttp(String env) {
        setEnv(env);//父类里面的
        ps = Tool.getProperties("mp.properties", MPHttp.class);//ps是父类的
        this.mpUrl = ps.getProperty(env + "_mp_url");
    }


    public void setHttpInfo(String uri, HttpMethod method){
        setUrl(mpUrl+uri);
        setMethod(method);
    }
}
