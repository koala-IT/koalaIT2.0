package com.koalaIT.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class MY_JSONUtils {
    public static JSONObject nameAndValue(String name, Object value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("value", value);
        return jsonObject;
    }

    public static JSONObject getItemByStreetName(JSONArray jsonArray, String streetName) {
        for (Object item : jsonArray) {
            if (item instanceof JSONObject) {
                JSONObject jsItem = (JSONObject) item;
                if (jsItem.getString("StreetName") == null)
                    continue;
                return jsItem;
            }
        }
        return null;
    }
}
