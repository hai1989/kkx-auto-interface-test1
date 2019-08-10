package mp.sdk.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.TestBase;

import java.util.ArrayList;
import java.util.List;

public class EmpByNameSDK extends   MPSDKBase {
    //添加头
    public EmpByNameSDK(){
        headMap.put("","");
    }
    public JSONObject getName(String name) {
        getData.put("name",name);
        return get(URI_FIND_EMP_BY_NAME,getData,null,bodyData);
//        post(uri,getData,urlParameters,bodyData);

    }

    public JSONArray  getEmps(String name){
        JSONObject json =  getName(name);
        return   json.getJSONArray("data");
    }

    public  List<String>  getNames(String name){
        JSONArray   jsonArray =  getEmps(name);
        List<String>  list =  new ArrayList<String>();
        jsonArray.stream().forEach(json->{
            list.add(((JSONObject)json).getString("empName"));
        });

//        for(int i=0 ;i<jsonArray.size();i++){
//            JSONObject  json =  jsonArray.getJSONObject(i);
//            list.add(json.getString("empName"));
//        }
        return   list;
    }


    public static void main(String[] args) {
        TestBase.env="qa";
//        System.out.println(new EmpByNameSDK().getName("mm"));
        System.out.println(new EmpByNameSDK().getNames("展示三"));
    }
}
