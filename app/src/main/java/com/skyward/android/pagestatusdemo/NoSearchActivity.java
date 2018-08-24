package com.skyward.android.pagestatusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.skyward.pagestatus.OnSearchClick;
import com.skyward.pagestatus.PageStatus;
import com.skyward.pagestatus.PageStatusValue;

public class NoSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_search);

        final PageStatus mPageStatus = findViewById(R.id.page_status);

        mPageStatus.setPageStatus(PageStatusValue.NO_SEARCH_RESULT);



        mPageStatus.setOnSearchListener(new OnSearchClick() {
            @Override
            public void onSearchClick(View v) {
                Toast.makeText(getApplicationContext(),"你点击了换关键字按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
