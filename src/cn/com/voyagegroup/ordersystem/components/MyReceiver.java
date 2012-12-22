package cn.com.voyagegroup.ordersystem.components;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.com.voyagegroup.ordersystem.activity.MyAlarm;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setClass(context, MyAlarm.class);
		context.startActivity(intent);
	}

}
