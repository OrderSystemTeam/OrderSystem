package cn.com.voyagegroup.ordersystem.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import cn.com.voyagegroup.ordersystem.R;
import cn.com.voyagegroup.ordersystem.entity.User;
import cn.com.voyagegroup.ordersystem.utils.Constants;
import cn.com.voyagegroup.ordersystem.utils.SharedPreferencesUtils;
import cn.com.voyagegroup.ordersystem.web.LoginService;

public class LoginActivity extends Activity {
	private static final String TAG = "LoginActivity";

	private Context mContext;
	private EditText mEditText;
	private LoginService mService;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;

		String userId = SharedPreferencesUtils.getStringSaveData(this,
				Constants.PREF_FILE_APP_INFO, Constants.PREF_KEY_USER_ID);
		if (TextUtils.isEmpty(userId)) {
			setContentView(R.layout.activity_login);
			mEditText = (EditText) findViewById(R.id.name_text);
			mService = new LoginService();
		} else {
			Log.d(TAG, userId);
			Intent intent = new Intent(this, GroupActivity.class);
			startActivity(intent);
			finish();
		}
	}

	public void login(View view) {
		String userName = mEditText.getText().toString();

		new LoginThread(userName).execute();

	}

	class LoginThread extends AsyncTask<String, Void, String> {

		private String userName;

		public LoginThread(String userName) {
			this.userName = userName;
		}

		@Override
		protected String doInBackground(String... params) {
			User user = new User();
			user.setUserName(userName);
			try {
				String userId = mService.login(user);
				return userId;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if (result != null) {
				SharedPreferencesUtils.setStringSaveData(mContext,
						Constants.PREF_FILE_APP_INFO,
						Constants.PREF_KEY_USER_ID, result);
				SharedPreferencesUtils.setStringSaveData(mContext,
						Constants.PREF_FILE_APP_INFO,
						Constants.PREF_KEY_USER_NAME, userName);
				Intent intent = new Intent(mContext, GroupActivity.class);
				startActivity(intent);
				finish();
			}
		}

	}
}
