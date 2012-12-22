package cn.com.voyagegroup.ordersystem.activity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import cn.com.voyagegroup.ordersystem.R;
import cn.com.voyagegroup.ordersystem.web.GroupService;

public class GroupActivity extends Activity {

    private ListView mListView;
    private MyAdapter mAdapter;
    private ArrayList mData;
    private GroupService mGroupService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        mGroupService = new GroupService();
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.addFooterView(createFooterView());

        mData = new ArrayList();
        try {
            mGroupService.listGroups();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mAdapter = new MyAdapter();
        mListView.setAdapter(mAdapter);
    }

    private View createFooterView() {
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.footer_layout, null);
        return view;
    }

    public void createGroup(View view) {
        Intent intent = new Intent(this, RegisterGroupActivity.class);
        startActivity(intent);
    }

    class MyAdapter extends BaseAdapter {

        public int getCount() {
            return 0;
        }

        public Object getItem(int arg0) {
            return null;
        }

        public long getItemId(int arg0) {
            return 0;
        }

        public View getView(int arg0, View arg1, ViewGroup arg2) {
            return null;
        }

    }
}
