package cn.com.voyagegroup.ordersystem.web;

import cn.com.voyagegroup.ordersystem.entity.Group;
import cn.com.voyagegroup.ordersystem.utils.CommonUtil;
import cn.com.voyagegroup.ordersystem.utils.Constants;

public class GroupService extends BaseService {
    private static final String TAG = "LoginService";

    public Group listGroups() {
        String groupJson = executeUrl(Constants.GET_GROUP_URL, null);
        if (groupJson != null || !"".equals(groupJson)) {
            return CommonUtil.gson.fromJson(groupJson, Group.class);
        }
        return null;
    }
}
