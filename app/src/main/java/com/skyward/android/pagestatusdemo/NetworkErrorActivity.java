package com.skyward.android.pagestatusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.skyward.pagestatus.OnRetryListener;
import com.skyward.pagestatus.PageStatus;
import com.skyward.pagestatus.PageStatusValue;

public class NetworkErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_error);

        final PageStatus mPageStatus = findViewById(R.id.page_status);

        mPageStatus.setPageStatus(PageStatusValue.NETWORK_ERROR);

        mPageStatus.setOnRetryListener(new OnRetryListener() {
            @Override
            public void retry(View v) {
                Toast.makeText(getApplicationContext(),"你点击了点我重试,数据加载成功",Toast.LENGTH_SHORT).show();
                mPageStatus.setPageStatus(PageStatusValue.LOADING_SUCCESS);
            }
        });


    }
}
