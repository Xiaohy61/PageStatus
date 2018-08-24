package com.skyward.pagestatus;

import android.view.View;

/**
 * @author: skyward
 * date: 2018/1/4 0004
 * desc:
 */
public interface OnRetryListener {
    /**
     * 网络断开，点击重试
     * @param v view
     */
    void retry(View v);


}
