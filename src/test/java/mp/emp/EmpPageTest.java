package mp.emp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import common.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import mp.AssertConstant;
import mp.MpTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.CheckUtil;

@Slf4j
public class EmpPageTest  extends MpTest {


    public String uri = "/kkx/emp/page2";
    public HttpMethod method = HttpMethod.GET;
//    private static final Logger logger = LoggerFactory.getLogger(EmpPageTest.class);

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

    //get_current - 分隔符，get或是post，current必须和参数一致
    @Test(description = "正向测试",dataProvider = "testData" ,groups = {"smoke","function"})
    public void testNormal(String id,String desc,String get_current,String get_size,String check) throws JSONException {
//    public void testNormal(String id,String desc,String current,String size) throws JSONException {
        String[] uriParameters = {};
        //     postDataMap.put("Id", post_Id);
//        getDataMap.put("current",current);
//        getDataMap.put("size",size);
        setData(get_current,get_size);
        JSONObject result = mpHttp.restfulRequest(getDataMap,uriParameters,postDataMap);
//        String data = result.getString("data");
        //断言--写在代码中的方式
//        Assert.assertEquals(result.getIntValue("httpcode"),"200","code不对");
        Assert.assertEquals(AssertConstant.OK_CODE,"200","code不对");
        JSONObject data = result.getJSONObject("data");
        CheckUtil.check(data.toString(),check);
        System.out.println("--------"+data);
        log.info("AAAAA");
    }

}
