package com.qh.matthew.matthew.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

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
 *
 * Created by Matthew , 2016-11-23
 */
public class GuidePagerAdapter extends PagerAdapter{
    /*
    *  适配器一般要素：
    *  1.上下文
    *  2.构造器
    *  3.数据源
    *  4.视图填充--viewHolder(最典型)
    * */
    private List<ImageView> mList = new ArrayList<>();

    public GuidePagerAdapter (List<ImageView> list){
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mList.get(position));
        return mList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position));//在视图切换中消除隐藏的。
    }
}
