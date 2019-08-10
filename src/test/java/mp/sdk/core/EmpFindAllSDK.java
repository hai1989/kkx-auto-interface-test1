package mp.sdk.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmpFindAllSDK  extends MPSDKBase {

    public JSONObject   findAll(){
        return   get(URI_FIND_EMP_FIND_ALL,getData,null,bodyData);
    }
    public String   findAll2(){
        return   findAll().toString();
    }

    public List<String>  getIds(){
        List<String> ids =  new ArrayList<>();
        JSONArray  array = findAll().getJSONArray("data");
        for(int i=0;i<array.size();i++){
            ids.add(array.getJSONObject(i).getString("id"));
        }
        return ids;
    }

    //库里面随机找一个随机的 看看重名的行不
    public String     getId(){
        List<String>  ids = getIds();
        System.out.println("size====="+ids.size());
        int index =  new Random().nextInt(ids.size());
        return   ids.get(index);

    }
}
