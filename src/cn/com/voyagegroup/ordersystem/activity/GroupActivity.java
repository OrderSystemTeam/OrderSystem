package cn.com.voyagegroup.ordersystem.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import cn.com.voyagegroup.ordersystem.R;

public class GroupActivity extends Activity {

	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group);

		mListView = (ListView) findViewById(R.id.list_view);
		mListView.addFooterView(createFooterView());
	}

	private View createFooterView() {
		LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = mInflater.inflate(R.layout.footer_layout, null);
		return view;
	}
}
