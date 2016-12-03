package com.qh.matthew.matthew.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.qh.matthew.matthew.R;

/*
* Created by Matthew , 2016-11-22
* */

public class WelcomeActivity extends BaseActivity {

    private static final int FIRST_START = 1;//第一次
    private static final int NO_FIRST_START = 0; //不是第一次
    private static final String TAG = "WelcomeActivity";
    private Context mContext = this;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                    finish();
                    break;
                case 1:
                    //GuideActivity是引导页：进行手动滑动。
                    startActivity(new Intent(WelcomeActivity.this, GuideActivity.class));
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        /*
        * 启动线程发送消息；
        */
        if (mHandler != null) {
            if (isFirstOpen(this))
                mHandler.sendEmptyMessageDelayed(0, 2000);
            else {
                mHandler.sendEmptyMessageDelayed(1, 2000);
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mHandler != null) {
            if (isFirstOpen(this))
                mHandler.sendEmptyMessageDelayed(0, 2000);
            else {
                mHandler.sendEmptyMessageDelayed(1, 2000);
            }
        }
    }

    //当首次进入时和非首次进入时的不同处理；
    private boolean isFirstOpen(Context context) {
        SharedPreferences sharePrefence = context.getSharedPreferences("isFirst", Context.MODE_PRIVATE);
        boolean isFirst = sharePrefence.getBoolean("isFirst", false);
        //如果不是第一次使用
        if (!isFirst) {
            //是第一次使用，通过SharePreferences 进行存储。
            sharePrefence.edit().putBoolean("isFirst", true).commit();
            return false;
        }
        return isFirst;

    }
}
