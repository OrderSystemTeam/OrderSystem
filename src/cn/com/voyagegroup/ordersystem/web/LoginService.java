package cn.com.voyagegroup.ordersystem.web;

import cn.com.voyagegroup.ordersystem.entity.User;
import cn.com.voyagegroup.ordersystem.utils.Constants;

public class LoginService extends BaseService {
    private static final String TAG = "LoginService";

    public String login(User user) {
        return postData(Constants.LOGIN_URL, user);
    }
}
