package demo.anonymous.example.com.baseactivity.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Anonymous on 2017/6/9.
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 获取Context
         */
        context = getApplicationContext();
    }

    //获取到全局的Context对象
    public static Context getContext() {
        return context;
    }
}
