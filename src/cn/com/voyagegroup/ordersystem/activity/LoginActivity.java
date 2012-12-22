package cn.com.voyagegroup.ordersystem.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import cn.com.voyagegroup.ordersystem.R;
import cn.com.voyagegroup.ordersystem.entity.User;
import cn.com.voyagegroup.ordersystem.utils.Constants;
import cn.com.voyagegroup.ordersystem.utils.SharedPreferencesUtils;
import cn.com.voyagegroup.ordersystem.web.LoginService;

public class LoginActivity extends Activity {

    private EditText mEditText;
    private LoginService mService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String userId = SharedPreferencesUtils.getStringSaveData(this,
                Constants.PREF_FILE_APP_INFO, Constants.PREF_KEY_USER_ID);
        if (TextUtils.isEmpty(userId)) {
            setContentView(R.layout.activity_login);
            mEditText = (EditText) findViewById(R.id.name_text);
            mService = new LoginService();
        } else {
            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void login(View view) {
        String userName = mEditText.getText().toString();
        User user = new User();
        user.setUserName(userName);
        try {
            String userId = mService.login(user);
            SharedPreferencesUtils.setStringSaveData(this, Constants.PREF_FILE_APP_INFO,
                    Constants.PREF_KEY_USER_ID, userId);
            SharedPreferencesUtils.setStringSaveData(this, Constants.PREF_FILE_APP_INFO,
                    Constants.PREF_KEY_USER_NAME, userName);
            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
