package cn.com.voyagegroup.ordersystem.activity;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import cn.com.voyagegroup.ordersystem.R;
import cn.com.voyagegroup.ordersystem.entity.Group;
import cn.com.voyagegroup.ordersystem.web.GroupService;

public class GroupActivity extends Activity {
    private GroupService mGroupService;
    private ListView mListView;
    private List<Group> mGroupList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mGroupService = new GroupService();
        setContentView(R.layout.activity_group);

        mListView = (ListView) findViewById(R.id.list_view);
        mListView.addFooterView(createFooterView());
        new GetGroupThead().execute();
    }

    private View createFooterView() {
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.footer_layout, null);
        return view;
    }

    private class GetGroupThead extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            mGroupList = mGroupService.listGroups();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

        }
    }
}
