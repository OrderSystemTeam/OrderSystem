package cn.com.voyagegroup.ordersystem.utils;

import com.google.gson.Gson;

public class CommonUtil {

    public static Gson gson = new Gson();

    /**
     * parse object to json string.
     */
    public static String parseToJson(Object object) {
        return gson.toJson(object);
    }

}
