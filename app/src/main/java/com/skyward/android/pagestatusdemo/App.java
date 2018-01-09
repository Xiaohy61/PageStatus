package com.skyward.android.pagestatusdemo;

import android.app.Application;

import com.skyward.pagestatus.PageStatus;

/**
 * @author: skyward
 * date: 2018/1/4 0004
 * desc:
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        new PageStatus.Builder()
                .setLoadingTipText("数据加载中...")
                .setInternetErrorText("网络出现错误...")
                .setBtnRetryText("点我重试")
                .setErrorTipText("发生错误...")
                .setNoDataTipText("抱歉暂无相关数据!");
    }
}
