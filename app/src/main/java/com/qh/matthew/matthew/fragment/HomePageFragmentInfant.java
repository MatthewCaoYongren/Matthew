package com.qh.matthew.matthew.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qh.matthew.matthew.R;

/**
 * Created by Matthew on 2016/10/4.
 * Writring by brain , no bug !
 * Big god is here ! Code no bug !
 * ------------------          _ooOoo_
 * ------------------         o8888888o
 * ------------------         88" . "88
 * -----                      (| -_- |)
 * -----                      O\  =  /O
 * -----                   ____/`---'\____
 * -------               .'  \\|     |//  `.
 * ------               /  \\|||  :  |||//  \
 * ---------           /  _||||| -:- |||||-  \
 * ---------           |   | \\\  -  /// |   |
 * ---------           | \_|  ''\---/''  |   |
 * ---------           \  .-\__  `-`  ___/-. /
 * ---------            ___`. .'  /--.--\  `. . __
 * --------          ."" '<  `.___\_<|>_/___.'  >'"".
 * -----         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * -----         \  \ `-.   \_ __\ /__ _/   .-` /  /
 * -----    ======`-.____`-.___\_____/___.-`____.-'======
 * ---                         `=---='
 * --     --^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * ---                   佛祖保佑       永无BUG
 */
public class HomePageFragmentInfant extends Fragment{

    public HomePageFragmentInfant() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page_infant, null, false);
        return view;
    }

    public static HomePageFragmentInfant newInstance() {
        HomePageFragmentInfant fragment = null;
        if (fragment == null) {
            fragment = new HomePageFragmentInfant();
        }
        return fragment;
    }
}
