package com.skyward.android.pagestatusdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.skyward.pagestatus.PageStatus;
import com.skyward.pagestatus.PageStatusValue;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        final PageStatus mPageStatus = findViewById(R.id.page_status);
        mPageStatus.setPageStatus(PageStatusValue.LOADING);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPageStatus.setPageStatus(PageStatusValue.LOADING_SUCCESS);
            }
        },2000);
    }
}
