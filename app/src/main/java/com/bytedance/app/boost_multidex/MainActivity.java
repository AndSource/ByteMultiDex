package com.bytedance.app.boost_multidex;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import scala.math.BigDecimal;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView tv = findViewById(R.id.sample_text);
        tv.setText("Hello BoostMultiDex!");


        try {
            Object object = Class.class.getDeclaredMethod("getDex").invoke(BigDecimal.class);
            Log.d("sanbo.MainActivity", "dex bytes is " + object);
        } catch (Throwable tr) {
            tr.printStackTrace();
        }
    }

}
