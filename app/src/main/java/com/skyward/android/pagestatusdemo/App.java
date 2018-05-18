package com.skyward.android.pagestatusdemo;

import android.app.Application;

import com.skyward.pagestatus.PageStatus;

/**
 * @author: skyward
 * date: 2018/1/4 0004
 * desc:
 * gradlew install
 * gradlew bintrayUpload
 * <p>
 * 更新版本号：gradlew clean build bintrayUpload -PdryRun=false
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        new PageStatus.Builder()
                .setLoadingTipText("数据加载中...")
                .setNetworkErrorTipText("网络出现错误...")
                .setBtnRetryText("点我重试")
                .setDataErrorTipText("发生错误...")
                .setEmptyDataTipText("抱歉暂无相关数据!")
                .setEmptyOrderTipText("还没有相关订单")
                .setEmptyMsgTipText("还没有相关消息呢")
                .setEmptyCartTipText("购物车还是空的哦~");
    }
}
