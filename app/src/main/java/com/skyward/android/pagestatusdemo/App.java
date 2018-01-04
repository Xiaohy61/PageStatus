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

        PageStatus.pageStatusConfig()
                .buttonRetryText("点我重试")
                .loadingTipText("")
                .internetErrorTipText("网络出现错误...")
                .noDataTipText("抱歉，暂无相关数据...")
                .errorTipText("出错啦...");
    }
}
