package mp.emp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import common.HttpMethod;
import example.t1.TestCase;
import lombok.extern.slf4j.Slf4j;
import mp.AssertConstant;
import mp.MpTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class EmpFindAllTest extends MpTest {

    public String uri = "/kkx/emp/test6";
    public HttpMethod method = HttpMethod.GET;
//    private static final Logger logger = LoggerFactory.getLogger(EmpFindAllTest.class);

    @BeforeClass
    public void beforeClass() {
        mpHttp.setHttpInfo(uri, method);
    }

//    @BeforeMethod
//    public void beforeMethod() {
//
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//
//    }
    @Test(description = "示例",groups = {"smoke","function"})
    public void testNormal() throws JSONException {
        String[] uriParameters = {};
        //     postDataMap.put("Id", post_Id);
        JSONObject result = mpHttp.restfulRequest(getDataMap,uriParameters,postDataMap);
//        String data = result.getString("data");
        //断言--写在代码中的方式
//        Assert.assertEquals(result.getIntValue("httpcode"),"200","code不对");
        Assert.assertEquals(AssertConstant.OK_CODE,"200","code不对");
        JSONArray data = result.getJSONArray("data");
        Assert.assertEquals(data.size(),10,"返回长度不对");
        String  name =  data.getJSONObject(0).getString("empName");
        Assert.assertEquals(name,"CC","名字错误");
        System.out.println(data);
//        logger.info("AAAA");
        log.info("AAA");
    }
}
