package cn.com.voyagegroup.ordersystem.web;

import java.util.List;

import android.util.Log;
import cn.com.voyagegroup.ordersystem.entity.Group;
import cn.com.voyagegroup.ordersystem.utils.CommonUtil;
import cn.com.voyagegroup.ordersystem.utils.Constants;

public class GroupService extends BaseService {
    private static final String TAG = "LoginService";

    public List<Group> listGroups() {
        String groupJson = postData(Constants.GET_GROUP_URL, null);
        if (groupJson != null) {
            return CommonUtil.gson.fromJson(groupJson, List.class);
        }
        return null;
    }

    public int addGroup(Group group) {
        String groupJson = postData(Constants.GET_GROUP_URL, group);
        try {
            return Integer.parseInt(groupJson);
        } catch (NumberFormatException e) {
            Log.e(TAG, "addGroup : NumberFormatException is " + e.getLocalizedMessage());
        }
        return -1;
    }
}
