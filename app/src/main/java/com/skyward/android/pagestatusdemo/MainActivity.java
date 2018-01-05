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
    private Runnable runnable;
    private Handler handler;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        page_status_layout = findViewById(R.id.page_status_layout);

        page_status_layout.setPageStatus(PageStatusValue.loading);


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                switch (count) {
                    case 0:
                        page_status_layout.setPageStatus(PageStatusValue.loadingSuccess);
                        break;
                    case 1:
                        page_status_layout.setPageStatus(PageStatusValue.loadingError);
                        break;
                    case 2:
                        page_status_layout.setPageStatus(PageStatusValue.noData);
                        break;
                    case 3:
                        page_status_layout.setPageStatus(PageStatusValue.internetError);
                        break;
                    default:
                        break;

                }
                count++;
                if (count > 4) {
                    handler.removeCallbacks(runnable);
                    return;
                }
                handler.postDelayed(this, 2000);

            }
        };

        handler.postDelayed(runnable, 2000);

        page_status_layout.setOnRetryListener(new OnRetryListener() {
            @Override
            public void retry(View v) {
                page_status_layout.setPageStatus(PageStatusValue.loadingSuccess);
            }
        });

    }
}
