package demo.anonymous.example.com.baseactivity.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.anonymous.example.com.baseactivity.utils.AppUtil;

/**
 * Created by Anonymous on 2017/6/9.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener{

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getActivity()).inflate(getContentView(), null);
        initView(rootView);
        setListener();
        getData();
        initData();
        return rootView;
    }

    /**
     * 解析子类的布局
     *
     * @return
     */
    protected abstract int getContentView();

    /**
     * 初始化子类的布局
     *
     * @param rootView
     */
    protected abstract void initView(View rootView);

    /**
     * 设置子类的OnClickListener事件
     */
    protected abstract void setListener();

    /**
     * 子类获取对象
     * 一、获取网络请求
     * 二、获取传递的数据
     */
    protected abstract void getData();

    /**
     * 子类对象赋值
     * 网络请求或者是传递的数据赋值
     */
    protected abstract void initData();
    /**
     * 显示Toast
     *
     * @param massage
     */
    public void showToast(String massage) {
        AppUtil.showToast(massage);
    }
}
