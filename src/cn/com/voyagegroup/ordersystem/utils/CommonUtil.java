package cn.com.voyagegroup.ordersystem.utils;

import java.util.Map;

import com.google.gson.Gson;

public class CommonUtil {

	public static Gson gson = new Gson();

	public static String mapToJson(Map dataMap) {
		return null;
	}

	/**
	 * parse object to json string.
	 */
	public static String parseToJson(Object object) {
		return gson.toJson(object);
	}
}
