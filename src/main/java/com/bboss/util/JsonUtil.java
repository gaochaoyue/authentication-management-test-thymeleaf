package com.bboss.util;




import com.alibaba.fastjson.JSON;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtil {
    public static String object2Json(Object obj){
        return JSON.toJSONString(obj);
    }

    /*public static void main(String[] args) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","1111");
        map.put("message","success");

        ClientInfo c1 = new ClientInfo();
        c1.setClientId(100);
        ClientInfo c2 = new ClientInfo();
        c2.setClientId(100);
        List<ClientInfo> list = new ArrayList<ClientInfo>();
        list.add(c1);
        list.add(c2);
        //map.put("data",list);
        System.out.println(object2Json(map));
    }*/
}
