package com.skyward.android.pagestatusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.skyward.pagestatus.PageStatus;
import com.skyward.pagestatus.PageStatusValue;

public class SearchingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
        final PageStatus mPageStatus = findViewById(R.id.page_status);

        mPageStatus.setPageStatus(PageStatusValue.SEARCHING);
    }
}
