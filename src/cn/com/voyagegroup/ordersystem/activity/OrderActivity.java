package cn.com.voyagegroup.ordersystem.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import cn.com.voyagegroup.ordersystem.R;

public class OrderActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void saveOrder(View view) {

    }

    public void goBack(View view) {
        finish();
    }
}
