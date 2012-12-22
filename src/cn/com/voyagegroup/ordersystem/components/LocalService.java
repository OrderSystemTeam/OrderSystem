package cn.com.voyagegroup.ordersystem.components;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class LocalService extends Service {

	private static AlarmManager am = null;
	private static PendingIntent mInsPendingIntent = null;
	private static PendingIntent mUsePendingIntent = null;
	private static PendingIntent mNoticePendingIntent = null;

	private static final long INTERVAL_ONE_DAY = 1000 * 60 * 60 * 24;
	private static final long INTERVAL_SEVEN_DAYS = 1000 * 60 * 60 * 24 * 7;

	private NotificationManager mNM;

	@Override
	public void onCreate() {
		mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		
		openAlarm(this);
	}

	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		
		return START_STICKY;
	}

	@Override
	public void onDestroy() {


	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	

	public static void openAlarm(Context context) {
		Intent operation = null;

//		operation = new Intent(context, SendInsAppReceiver.class);
//		operation.setAction(SendInsAppReceiver.SEND_INS_ACTION);
//		mInsPendingIntent = PendingIntent.getBroadcast(context, 0, operation, 0);
//
//		operation = new Intent(context, SendUseAppReceiver.class);
//		operation.setAction(SendUseAppReceiver.SEND_USE_ACTION);
//		mUsePendingIntent = PendingIntent.getBroadcast(context, 0, operation, 0);
//
//		operation = new Intent(context, NoticeMessageReceiver.class);
//		operation.setAction(NoticeMessageReceiver.NOTIFI_ACTION);
//		mNoticePendingIntent = PendingIntent
//				.getBroadcast(context, 0, operation, 0);
//
//		long currentTime = System.currentTimeMillis();
//
//		am = (AlarmManager) (context.getSystemService(ALARM_SERVICE));
//		am.setRepeating(AlarmManager.RTC_WAKEUP, currentTime, INTERVAL_ONE_DAY,
//				mInsPendingIntent);
//		am.setRepeating(AlarmManager.RTC_WAKEUP, currentTime, INTERVAL_ONE_DAY,
//				mUsePendingIntent);
//		am.setRepeating(AlarmManager.RTC_WAKEUP, currentTime + INTERVAL_SEVEN_DAYS,
//				INTERVAL_SEVEN_DAYS, mNoticePendingIntent);
	}
	
	public void stopAlarm() {
		if (am != null) {
			am.cancel(mInsPendingIntent);
			am.cancel(mUsePendingIntent);
			am.cancel(mNoticePendingIntent);
		}
	}
	
}
