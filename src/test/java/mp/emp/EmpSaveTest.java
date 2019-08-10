package mp.emp;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import common.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import mp.AssertConstant;
import mp.MpTest;
import mp.sdk.core.EmpByIdSDK;
import mp.sdk.core.EmpByNameSDK;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.ParameterUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class EmpSaveTest  extends MpTest {



    public String uri = "/kkx/emp/add";
    public HttpMethod method = HttpMethod.POST;
    private EmpByNameSDK   empByNameSDK  ;

//    private static final Logger logger = LoggerFactory.getLogger(EmpPageTest.class);

    @BeforeClass
    public void beforeClass() {

        mpHttp.setHttpInfo(uri, method);
        empByNameSDK  =  new EmpByNameSDK();
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
    public void testNormal(String id,String desc,String post_empName,String post_salary,String post_hiredate) throws JSONException {
//    public void testNormal(String id,String desc,String current,String size) throws JSONException {
        String[] uriParameters = {};
        mpHttp.setIsJson(true);//要传json时设置
        //     postDataMap.put("Id", post_Id);
//        getDataMap.put("current",current);
//        getDataMap.put("size",size);
        setData(post_empName,post_salary,post_hiredate);
        JSONObject result = mpHttp.restfulRequest(getDataMap,uriParameters,postDataMap);
//        String data = result.getString("data");
        //断言--写在代码中的方式
//        Assert.assertEquals(result.getIntValue("httpcode"),"200","code不对");
        Assert.assertEquals(AssertConstant.OK_CODE,"200","code不对");
//        JSONObject data = result.getJSONObject("data");


        System.out.println("--------"+result.toString());
        log.info("AAAAA");

        //调用接口做验证----sdk的

        List<String> list = empByNameSDK.getNames(post_empName);
        System.out.println("调用接口做验证----"+list.size());
        Assert.assertTrue(list.size()>0,"数据没有插入成功");
    }

    //get_current - 分隔符，get或是post，current必须和参数一致
    @Test(description = "反向测试",dataProvider = "testData" ,groups = {"smoke","function"})
    public void testFail(String id,String desc,String post_empName,String post_salary,String post_hiredate,String message) throws JSONException {
//    public void testNormal(String id,String desc,String current,String size) throws JSONException {
        String[] uriParameters = {};
        mpHttp.setIsJson(true);//要传json时设置
        //     postDataMap.put("Id", post_Id);
//        getDataMap.put("current",current);
//        getDataMap.put("size",size);
        setData(post_empName,post_salary,post_hiredate);
        JSONObject result = mpHttp.restfulRequest(getDataMap,uriParameters,postDataMap);
//        String data = result.getString("data");
        //断言--写在代码中的方式
//        Assert.assertEquals(result.getIntValue("httpcode"),"200","code不对");
        Assert.assertEquals(AssertConstant.OK_CODE,"200","code不对");
        JSONObject data = result.getJSONObject("data");

        Assert.assertEquals(data.getString("msg"),message,"提示信息错误");
        System.out.println("--------"+data.toString());
        log.info("AAAAA");
    }


    @Test(description = "参数测试",dataProvider = "testData" ,groups = {"smoke","function"})
    public void testParam(String id,String desc,String post_empName,String post_salary,String post_hiredate) throws JSONException {
        String[] uriParameters = {};
        mpHttp.setIsJson(true);//要传json时设置
        post_empName = ParameterUtil.replaceParameter(post_empName);
        post_salary = ParameterUtil.replaceParameter(post_salary);
        setData(post_empName,post_salary,post_hiredate);
        JSONObject result = mpHttp.restfulRequest(getDataMap,uriParameters,postDataMap);

        Assert.assertEquals(AssertConstant.OK_CODE,"200","code不对");
//        JSONObject data = result.getJSONObject("data");

//        Assert.assertEquals(data.getString("msg"),message,"提示信息错误");
//        System.out.println("--------"+data.toString());
        System.out.println(result.toString());
        log.info("AAAAA");
    }


    @Test(description = "参数测试2",dataProvider = "testData" ,groups = {"smoke","function"})
    public void testParam2(String id,String desc,String post_empName,String post_salary,String post_hiredate) throws JSONException {
        String[] uriParameters = {};
        mpHttp.setIsJson(true);//要传json时设置
        post_empName = ParameterUtil.replaceParameter(post_empName);
        post_salary = ParameterUtil.replaceParameter(post_salary);
        setData(post_empName,post_salary,post_hiredate);
        JSONObject result = mpHttp.restfulRequest(getDataMap,uriParameters,postDataMap);

        Assert.assertEquals(AssertConstant.OK_CODE,"200","code不对");
//        JSONObject data = result.getJSONObject("data");

//        Assert.assertEquals(data.getString("msg"),message,"提示信息错误");
//        System.out.println("--------"+data.toString());
        System.out.println(result.toString());
        log.info("AAAAA");
    }



    @Test(description = "参数测试2",dataProvider = "testData" ,groups = {"smoke","function"})
    public void testParam3(String id,String desc,String post_empName,String post_salary,String post_hiredate) throws JSONException {
        String[] uriParameters = {};
        mpHttp.setIsJson(true);//要传json时设置
        Map<String,String> map = new HashMap<>();
        map.put("xx","pan");
        map.put("yy","zhen");

        post_empName = ParameterUtil.replaceParameter(post_empName,map);
        //转义：{"aa":"55","bb":"66"}
        String json  =  "{\"aa\":\"55\",\"bb\":\"66\"}";
        post_salary = ParameterUtil.replaceParameter(post_salary,json);
        setData(post_empName,post_salary,post_hiredate);
        JSONObject result = mpHttp.restfulRequest(getDataMap,uriParameters,postDataMap);

        Assert.assertEquals(AssertConstant.OK_CODE,"200","code不对");
//        JSONObject data = result.getJSONObject("data");

//        Assert.assertEquals(data.getString("msg"),message,"提示信息错误");
//        System.out.println("--------"+data.toString());
        System.out.println(result.toString());
        log.info("AAAAA");
    }
}
