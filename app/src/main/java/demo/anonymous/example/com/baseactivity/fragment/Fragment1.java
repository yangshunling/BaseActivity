package demo.anonymous.example.com.baseactivity.fragment;

import android.view.View;
import android.widget.Button;

import demo.anonymous.example.com.baseactivity.R;
import demo.anonymous.example.com.baseactivity.base.BaseFragment;

/**
 * Created by Anonymous on 2017/6/9.
 */

public class Fragment1 extends BaseFragment {

    private Button mButton,mButton1;

    @Override
    protected int getContentView() {
        return R.layout.fragment1;
    }

    @Override
    protected void initView(View rootView) {
        mButton = (Button) rootView.findViewById(R.id.button);
        mButton1 = (Button) rootView.findViewById(R.id.button1);
    }

    @Override
    protected void setListener() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("1");
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("2");
            }
        });
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
