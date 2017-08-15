package demo.anonymous.example.com.baseactivity.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;
import demo.anonymous.example.com.baseactivity.R;
import demo.anonymous.example.com.baseactivity.moudle.EventBusBean;
import demo.anonymous.example.com.baseactivity.utils.AppUtil;

/**
 * Created by Anonymous on 2017/6/8.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private ImageView mIvLeft;
    private TextView mTvTitle;
    private ImageView mIvRight;
    private FrameLayout viewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        EventBus.getDefault().register(this);
        statusBar();
        initToolbar();
        initFragment();
        initTitleView();
        initView(savedInstanceState);
        setListener();
        getData();
        initData();
    }

    /**
     * 透明状态栏
     */
    public void statusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 初始化ToolBar
     */
    public void initToolbar() {
        mIvLeft = (ImageView) findViewById(R.id.iv_left);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mIvRight = (ImageView) findViewById(R.id.iv_right);
        mIvLeft.setOnClickListener(this);
        mIvRight.setOnClickListener(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    /**
     * 初始化Fragment
     */
    public void initFragment() {
        viewContent = (FrameLayout) findViewById(R.id.viewContent);
        //将继承 TopBarBaseActivity 的布局解析到 FrameLayout 里面
        LayoutInflater.from(this).inflate(getContentView(), viewContent);
    }

    /**
     * 设置TooBar左边的图标，默认返回按钮
     *
     * @param src
     */
    protected void setLeft(int src) {
        mIvLeft.setImageResource(src);
    }

    /**
     * 设置头部标题
     *
     * @param title
     */
    protected void setTitle(String title) {
        mTvTitle.setText(title);
    }

    /**
     * 设置TooBar右边的图标，默认不显示
     *
     * @param src
     */
    protected void setRight(int src) {
        mIvRight.setImageResource(src);
    }

    /**
     * 显示TooBar
     */
    protected void showToolbar() {
        mToolbar.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏TooBar
     */
    protected void hideToolbar() {
        mToolbar.setVisibility(View.GONE);
    }

    /**
     * 解析子类的布局
     *
     * @return
     */
    protected abstract int getContentView();

    /**
     * 子类初始化头部布局
     */
    protected abstract void initTitleView();

    /**
     * 初始化子类的布局
     *
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

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

    /**
     * 设置监听
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void dialog(EventBusBean bean){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("标题");
        builder.setMessage(bean.getMsg());
        builder.create().show();
    }
}
