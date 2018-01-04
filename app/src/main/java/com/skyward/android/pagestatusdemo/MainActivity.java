package com.skyward.android.pagestatusdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.skyward.pagestatus.OnRetryListener;
import com.skyward.pagestatus.PageStatus;
import com.skyward.pagestatus.PageStatusValue;

public class MainActivity extends AppCompatActivity {

    private PageStatus page_status_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        page_status_layout = findViewById(R.id.page_status_layout);

        page_status_layout.setPageStatus(PageStatusValue.loading);

        page_status_layout.setOnRetryListener(new OnRetryListener() {
            @Override
            public void retry(View v) {
                page_status_layout.setPageStatus(PageStatusValue.loadingSuccess);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page_status_layout.setPageStatus(PageStatusValue.loadingSuccess);

            }
        },2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page_status_layout.setPageStatus(PageStatusValue.loadingError);

            }
        },4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page_status_layout.setPageStatus(PageStatusValue.noData);

            }
        },6000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page_status_layout.setPageStatus(PageStatusValue.internetError);

            }
        },8000);
    }
}
