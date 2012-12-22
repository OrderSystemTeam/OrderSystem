package cn.com.voyagegroup.ordersystem.activity;

import cn.com.voyagegroup.ordersystem.R;
import cn.com.voyagegroup.ordersystem.R.layout;
import cn.com.voyagegroup.ordersystem.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LoginActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
