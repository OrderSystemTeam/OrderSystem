package cn.com.voyagegroup.ordersystem.web;

import java.io.UnsupportedEncodingException;

import android.util.Log;
import cn.com.voyagegroup.ordersystem.entity.Group;
import cn.com.voyagegroup.ordersystem.utils.CommonUtil;
import cn.com.voyagegroup.ordersystem.utils.Constants;

public class GroupService extends BaseService {
    private static final String TAG = "LoginService";

    public Group listGroups() throws UnsupportedEncodingException {
        String groupJson = postData(Constants.GET_GROUP_URL, null);
        if (groupJson != null) {
            return CommonUtil.gson.fromJson(groupJson, Group.class);
        }
        return null;
    }

    public int addGroup(Group group) throws UnsupportedEncodingException {
        String groupJson = postData(Constants.GET_GROUP_URL, group);
        try {
            return Integer.parseInt(groupJson);
        } catch (NumberFormatException e) {
            Log.e(TAG, "addGroup : NumberFormatException is " + e.getLocalizedMessage());
        }
        return -1;
    }
}
