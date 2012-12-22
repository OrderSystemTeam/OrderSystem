package cn.com.voyagegroup.ordersystem.web;

import cn.com.voyagegroup.ordersystem.utils.CommonUtil;
import cn.com.voyagegroup.ordersystem.utils.Constants;

public class GroupService extends BaseService {
    private static final String TAG = "LoginService";

    public String listGroups() {
        CommonUtil.gson.fromJson(json, classOfT)
        parseToObject.pexecuteUrl(Constants.GET_GROUP_URL, null);
    }
}
