package cn.com.voyagegroup.ordersystem.activity;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.com.voyagegroup.ordersystem.R;
import cn.com.voyagegroup.ordersystem.entity.Group;
import cn.com.voyagegroup.ordersystem.utils.Constants;
import cn.com.voyagegroup.ordersystem.utils.SharedPreferencesUtils;
import cn.com.voyagegroup.ordersystem.web.GroupService;

public class RegisterGroupActivity extends Activity {
    private EditText mNameEditText;
    private EditText mNumberEditText;
    private GroupService mGroupService;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.mContext = this;
        setContentView(R.layout.activity_register);
        Button registerButton = (Button) findViewById(R.id.button1);
        mNameEditText = (EditText) findViewById(R.id.name_text);
        mNumberEditText = (EditText) findViewById(R.id.number_text);
        mGroupService = new GroupService();
        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Group group = new Group();
                group.setCreateId(Integer.parseInt(SharedPreferencesUtils.getStringSaveData(
                        mContext, Constants.PREF_FILE_APP_INFO, Constants.PREF_KEY_USER_NAME), 0));
                group.setGroupName(mNameEditText.getText().toString());
                group.setLimit(mNumberEditText.getText().toString());
                new AddGroupThead(group).execute();
            }
        });

    }

    private class AddGroupThead extends AsyncTask<Void, Void, Void> {
        private Group mGroup;

        private AddGroupThead(Group group) {
            mGroup = group;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                mGroupService.addGroup(mGroup);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
