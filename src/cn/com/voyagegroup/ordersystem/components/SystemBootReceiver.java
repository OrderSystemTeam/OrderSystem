package cn.com.voyagegroup.ordersystem.components;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SystemBootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		context.startService(new Intent(context, LocalService.class));
	}

}
