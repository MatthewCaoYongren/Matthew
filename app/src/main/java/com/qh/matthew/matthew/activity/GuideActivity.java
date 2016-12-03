package com.qh.matthew.matthew.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qh.matthew.matthew.R;
import com.qh.matthew.matthew.adapter.GuidePagerAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
public class GuideActivity extends BaseActivity {

    @Bind(R.id.viewpager_guide)
    ViewPager viewpagerGuide;
    @Bind(R.id.radioGroup_guide)
    RadioGroup mRadioGroupGuide;
    private TypedArray mTypedArray;
    private Context mContext = this;
    private GuidePagerAdapter mGuidePagerAdapter;
    private ArrayList<ImageView> mTotallist = new ArrayList<>();
    private RadioButton[] mRadioarray;
    private ImageView mImageViewIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initData();
        initView();
        initDots();
    }

    public void initView() {
        mGuidePagerAdapter = new GuidePagerAdapter(mTotallist);
        /*
        * viewPager 通过适配器然后添加监听事件。--- >>然后滑动到最后一张就跳转到主页面；
        *
        * */
        viewpagerGuide.setAdapter(mGuidePagerAdapter);
        viewpagerGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            public void onPageSelected(int position) {
                mRadioarray[position].setChecked(true);
//                if (position == 4)
                if (mImageViewIntent != null) {    //这里进行监听：因为在最后一页如果使用点击事件，会自动跳转到MainActivity.
                    //通常在这里进行判断是否是最后一页，然后进行跳转到mainActivity
                    mImageViewIntent.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(GuideActivity.this, MainActivity.class));
                            finish();
                        }
                    });
                }
            }

            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void initData() {
        mTypedArray = getResources().obtainTypedArray(R.array.arrImages);
        for (int i = 0; i < mTypedArray.length(); i++) {
            ImageView imageview = new ImageView(mContext);
            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Drawable drawable = mTypedArray.getDrawable(i);
            imageview.setImageDrawable(drawable);
            if (i == 3) {
                mImageViewIntent = imageview;
            }
            imageview.setScaleType(ImageView.ScaleType.FIT_XY);
            mTotallist.add(imageview);
        }
    }

    @OnClick(R.id.radioGroup_guide)
    public void onClick() {
    }

    private void initDots() {
        mRadioarray = new RadioButton[mTypedArray.length()];
        for (int i = 0; i < mTypedArray.length(); i++) {
            RadioButton radionbutton = new RadioButton(mContext);
            radionbutton.setButtonDrawable(R.drawable.dots);
            mRadioarray[i] = radionbutton;
            mRadioGroupGuide.addView(radionbutton);
        }
        mRadioarray[0].setChecked(true);

        mRadioGroupGuide.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < mTypedArray.length(); i++) {
                    if (mRadioarray[i].getId() == checkedId) {
                        viewpagerGuide.setCurrentItem(i);
                    }
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
