package com.localworld.ishop;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.configuration.Configuration;
import com.igerm.android.lib.net.core.configuration.Constant;
import com.localworld.ishop.common.manager.account.LoginManager;



public class ISHOPApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initNetwork();
        initLogin();
        initImageCenter();
//        initLeakCanary();
    }

    private void initNetwork() {
        Configuration netConfiguration = new Configuration.Builder()
                .baseUrl(Constant.DEFAULT_APP_SERVER_URL)
                .appVersionString(BuildConfig.VERSION_NAME)
                .build();
        HdlCore.getInstance().init(getApplicationContext(), netConfiguration);
    }

    private void initImageCenter() {
        Fresco.initialize(getApplicationContext());
    }

//    private void initLeakCanary() {
//        if (!BuildConfig.DEBUG) {
//            return;
//        }
//        if (LeakCanary.isInAnalyzerProcess(getApplicationContext())) {
//            return;
//        }
//        LeakCanary.install(this);
//    }

    private void initLogin(){
        LoginManager.getInstance().init(getApplicationContext());
    }
}
