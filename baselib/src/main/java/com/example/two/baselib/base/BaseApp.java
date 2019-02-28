package com.example.two.baselib.base;

import android.app.Application;

import com.example.two.baselib.BuildConfig;
import com.example.two.baselib.impl.IDataManager;
import com.example.two.baselib.impl.IUserManager;
import com.example.two.baselib.mode.DataManager;
import com.example.two.baselib.mode.UserManager;
import com.xuexiang.xipc.XIPC;

/**
 * Created by fytworks on 2019/2/28.
 */

public class BaseApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        initXIPC();
    }

    //初始化
    private void initXIPC() {
        XIPC.init(this);
        XIPC.debug(BuildConfig.DEBUG);
//        XIPC.register(UserManager.class);
//        XIPC.register(IUserManager.class);


        XIPC.register(DataManager.class);
        XIPC.register(IDataManager.class);

        //注册包名下的所有定义的接口or实现
//        XIPC.register("com.example.two.twoapp.baselib.impl");
    }

}
