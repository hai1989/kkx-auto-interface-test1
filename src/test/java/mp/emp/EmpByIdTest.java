package mp.emp;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import common.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import mp.AssertConstant;
import mp.MpTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.ParameterUtil;

@Slf4j
public class EmpByIdTest  extends MpTest {

    public String uri = "/kkx/emp/find/%s";
    public HttpMethod method = HttpMethod.GET;

    @BeforeClass
    public void beforeClass() {
        mpHttp.setHttpInfo(uri, method);
    }

    @Test(description = "正向测试",dataProvider = "testData" ,groups = {"smoke","function"})
    public void testNormal(String id,String desc,String empId) throws JSONException {
        String[] uriParameters = {empId};
        JSONObject result = mpHttp.restfulRequest(getDataMap,uriParameters,postDataMap);

        Assert.assertEquals(AssertConstant.OK_CODE,"200","code不对");

        System.out.println("--------"+result.toString());
        log.info("AAAAA");
    }

}
