package mp.sdk.core;

import com.alibaba.fastjson.JSONObject;
import common.TestBase;

public class EmpByIdSDK  extends  MPSDKBase {

    //添加头
    public EmpByIdSDK(){
        headMap.put("","");
    }

    public String  getNameById(String empId) {
//        getData.put("name",empID);
        String[] uriParameters = {empId};
        return get(URI_FIND_EMP_BY_ID,getData,uriParameters,bodyData).getJSONObject("data").getString("empName");
//        post(uri,getData,urlParameters,bodyData);

    }

    public  JSONObject  getEmpJson(String id){
        String[] uriParameters = {id+""};
        return   get(URI_FIND_EMP_BY_ID,getData,uriParameters,bodyData);
    }

    public  String getName(String id){
        JSONObject  json =  getEmpJson(id);
        return   json.getJSONObject("data").getString("empName");
    }

    public static void main(String[] args) {
        TestBase.env="qa";
//       JSONObject obj =  new EmpByIdSDK().getNameById("1");
//        System.out.println("data:"+obj);
//        String empName =  obj.getJSONObject("data").getString("empName");
//        System.out.println("empName:"+empName);
//        String empName =  new EmpByIdSDK().getNameById("1");
//        System.out.println("empName:"+empName);
       JSONObject json =  new EmpByIdSDK().getEmpJson("1");
        System.out.println("empName:"+json);
        System.out.println("___________________");
        System.out.println(new EmpByIdSDK().getName("1"));
    }
}
