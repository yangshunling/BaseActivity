package demo.anonymous.example.com.baseactivity.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.git.navmenu.NavMenuLayout;
import com.git.navmenu.PixelUtil;

import java.util.ArrayList;

import demo.anonymous.example.com.baseactivity.R;
import demo.anonymous.example.com.baseactivity.base.BaseActivity;
import demo.anonymous.example.com.baseactivity.fragment.Fragment1;
import demo.anonymous.example.com.baseactivity.fragment.Fragment2;
import demo.anonymous.example.com.baseactivity.fragment.Fragment3;
import demo.anonymous.example.com.baseactivity.fragment.Fragment4;
import demo.anonymous.example.com.baseactivity.utils.DisplayUtil;

public class MainActivity extends BaseActivity {

    private NavMenuLayout mNavMenuLayout;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment mFragment1, mFragment2, mFragment3, mFragment4;

    private int[] iconRes = {R.drawable.schedule_nomal, R.drawable.notify_nomal, R.drawable.manager_nomal, R.drawable.link_nomal};
    private int[] iconResSelected = {R.drawable.schedule_seleted, R.drawable.notify_seleted, R.drawable.manager_seleted, R.drawable.link_seleted};
    private String[] textRes = {"日程", "消息", "工作", "我的"};

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initTitleView() {
        setRight(R.mipmap.ic_launcher);
        setTitle("测试");
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        manager = getSupportFragmentManager();
        //初始化NavMenuLayout
        mNavMenuLayout = (NavMenuLayout) findViewById(R.id.navMenuLayout);
        mNavMenuLayout.setIconRes(iconRes)//设置未选中图标
                .setIconResSelected(iconResSelected)//设置选中图标
                .setTextRes(textRes)//设置文字
                .setIconSize(DisplayUtil.dip2px(MainActivity.this, 25), DisplayUtil.dip2px(MainActivity.this, 25))//设置图标大小
                .setMarginTop(PixelUtil.dpToPx(MainActivity.this, 3))//文字和图标直接的距离
                .setTextColor(Color.parseColor("#878787"))//未选中状态下文字颜色
                .setTextColorSelected(Color.parseColor("#6ebae6"))//选中状态下文字颜色
                .setSelected(0);//设置选中的位置
        setTabSelection(0);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void getData() {

    }

    @Override
    protected void initData() {
        /**
         * BottomTabView点击监听
         */
        mNavMenuLayout.setOnItemSelectedListener(new NavMenuLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                setTabSelection(position);
            }
        });
    }

    /**
     * 切换到相应的Fragment
     *
     * @param position
     */
    private void setTabSelection(int position) {
        transaction = manager.beginTransaction();
        switch (position) {
            case 0:
                if (mFragment1 == null) {
                    mFragment1 = new Fragment1();
                    transaction.add(R.id.ft_container, mFragment1);
                } else {
                    hideAllFragment(transaction);
                    transaction.show(mFragment1);
                }
                break;
            case 1:
                if (mFragment2 == null) {
                    mFragment2 = new Fragment2();
                    transaction.add(R.id.ft_container, mFragment2);
                } else {
                    hideAllFragment(transaction);
                    transaction.show(mFragment2);
                }
                break;
            case 2:
                if (mFragment3 == null) {
                    mFragment3 = new Fragment3();
                    transaction.add(R.id.ft_container, mFragment3);
                } else {
                    hideAllFragment(transaction);
                    transaction.show(mFragment3);
                }
                break;
            case 3:
                if (mFragment4 == null) {
                    mFragment4 = new Fragment4();
                    transaction.add(R.id.ft_container, mFragment4);
                } else {
                    hideAllFragment(transaction);
                    transaction.show(mFragment4);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏所有的Fragment
     *
     * @param transaction
     */
    private void hideAllFragment(FragmentTransaction transaction) {
        if (mFragment1 != null) {
            transaction.hide(mFragment1);
        }
        if (mFragment2 != null) {
            transaction.hide(mFragment2);
        }
        if (mFragment3 != null) {
            transaction.hide(mFragment3);
        }
        if (mFragment4 != null) {
            transaction.hide(mFragment4);
        }
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }

}
