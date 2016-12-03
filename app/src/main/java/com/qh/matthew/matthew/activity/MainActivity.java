package com.qh.matthew.matthew.activity;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.qh.matthew.matthew.R;
import com.qh.matthew.matthew.fragment.HomePageFragment;
import com.qh.matthew.matthew.fragment.HomePageFragmentBeauty;
import com.qh.matthew.matthew.fragment.HomePageFragmentHome;
import com.qh.matthew.matthew.fragment.HomePageFragmentHouse;
import com.qh.matthew.matthew.fragment.HomePageFragmentInfant;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @Bind(R.id.linearLayout_main_bottom)
    LinearLayout mLinearLayoutMainBottom;
    /*
        *  在这个类中做两件事：
        *  1.对Fragment进行切换。
        *
        *  2.对底部进行监听。
        *
        * */
    private Context mContext = this;
    private List<Fragment> mTotalList = new ArrayList<>();
    private FragmentManager mManager = null;
    private int currentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initView() {
    }

    private void initData() {
        mTotalList.add(HomePageFragment.newInstance());
        mTotalList.add(HomePageFragmentHome.newInstance());
        mTotalList.add(HomePageFragmentBeauty.newInstance());
        mTotalList.add(HomePageFragmentHouse.newInstance());
        mTotalList.add(HomePageFragmentInfant.newInstance());
    }

    public void onClickView(View view) {
        switch (view.getId()) {

        }
    }

    /*
    *  管理碎片
    *
    * */

    private void switchFragment(int tabIndex) {
        Fragment currentFragment = mTotalList.get(currentIndex);
        Fragment toFragment = mTotalList.get(tabIndex);
        FragmentTransaction transaction = mManager.beginTransaction();
        if (toFragment.isAdded()) { //若干已经添加全部
            transaction.hide(currentFragment).show(toFragment);
        } else {
            if (currentIndex == 0 && tabIndex == 0) {
                transaction.add(R.id.linearLayout_main_container, mTotalList.get(1));
                transaction.hide(mTotalList.get(1)).add(R.id.linearLayout_main_container, toFragment);
            } else {
                transaction.hide(currentFragment).add(R.id.linearLayout_main_container, toFragment);
            }
        }
        transaction.commit();
        currentIndex = tabIndex;
    }
/*
*   监听返回键，当点击返回键是弹出确认退出的对话框
*
* */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("确定退出吗？")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).show();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
