package com.sh.vertx;

import com.google.gson.Gson;
import io.vertx.core.json.JsonObject;

/**
 * @author sh
 * @date 2019-11-13 20:42
 */
public class Test {
    public static void main(String[] args) {
        String str = "{\"check_result\":{\"matching_messages\":[{\"a\":\"b\"},{\"c\":\"d\"}]}}";
        JsonObject entries = new JsonObject(str);
        System.out.println(entries.getJsonObject("check_result").getJsonArray("matching_messages").getJsonObject(0).getString("a"));
        Gson gson = new Gson();
    }
}
