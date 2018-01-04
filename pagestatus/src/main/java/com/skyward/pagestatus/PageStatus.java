package com.skyward.pagestatus;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.skyward.pagestatus.PageStatusValue.internetError;
import static com.skyward.pagestatus.PageStatusValue.loading;
import static com.skyward.pagestatus.PageStatusValue.loadingError;
import static com.skyward.pagestatus.PageStatusValue.loadingSuccess;
import static com.skyward.pagestatus.PageStatusValue.noData;


/**
 * @author: skyward
 * date: 2017/11/8 0008
 * desc:
 */
public class PageStatus extends FrameLayout {


    private View mView;
    private FrameLayout mPageStatusLayout;
    private LinearLayout mStartLoadingLayout;

    private TextView mProgressBarTipText;
    private LinearLayout mNoDataLayout;
    private ImageView mNoDataImageView;
    private TextView mNoDataTip;

    private LinearLayout mInternetErrorLayout;
    private ImageView mInternetErrorImageView;
    private TextView mInternetErrorTipText;
    private Button btnRetry;

    private LinearLayout mErrorLayout;
    private ImageView errorImageView;
    private TextView mErrorTipText;

    private Context mContext;

    private String loadingTipText;
    private int noDataImage;
    private String noDataTipText;
    private int internetErrorImage;
    private String internetErrorTipText;
    private String btnRetryText;
    private String errorTipText;
    private int errorImage;
    private int loadingTipTextColor;
    private int noDataTipTextColor;
    private int internetErrorTipTextColor;
    private int btnRetryTextColor;
    private int errorTipTextColor;

    private OnRetryListener mOnRetryListener;

    private static PageStatusBuilder mStatusBuilder = new PageStatusBuilder();


    public PageStatus(Context context) {
        super(context);
        this.mContext = context;
    }

    public PageStatus(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initTypeArray(context, attrs);
    }

    public void setOnRetryListener(OnRetryListener onRetryListener) {
        this.mOnRetryListener = onRetryListener;
    }

    private void initTypeArray(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PageStatus);
        loadingTipText = typedArray.getString(R.styleable.PageStatus_LoadingTipText);
        noDataTipText = typedArray.getString(R.styleable.PageStatus_noDataTipText);
        internetErrorTipText = typedArray.getString(R.styleable.PageStatus_internetErrorTipText);
        btnRetryText = typedArray.getString(R.styleable.PageStatus_btnRetryText);
        errorTipText = typedArray.getString(R.styleable.PageStatus_errorTipText);

        noDataImage = typedArray.getResourceId(R.styleable.PageStatus_noDataImage, R.drawable.no_data_icon);
        internetErrorImage = typedArray.getResourceId(R.styleable.PageStatus_internetErrorImage, R.drawable.internet_error);
        errorImage = typedArray.getResourceId(R.styleable.PageStatus_errorImage, R.drawable.error_icon);

        loadingTipTextColor = typedArray.getColor(R.styleable.PageStatus_LoadingTipTextColor, ContextCompat.getColor(mContext, R.color.grey));
        noDataTipTextColor = typedArray.getColor(R.styleable.PageStatus_noDataTipTextColor, getResources().getColor(R.color.grey));
        internetErrorTipTextColor = typedArray.getColor(R.styleable.PageStatus_internetErrorTipTextColor, getResources().getColor(R.color.grey));
        btnRetryTextColor = typedArray.getColor(R.styleable.PageStatus_btnRetryTextColor, getResources().getColor(R.color.grey));
        errorTipTextColor = typedArray.getColor(R.styleable.PageStatus_errorTipTextColor, getResources().getColor(R.color.grey));

        typedArray.recycle();


        if (mStatusBuilder.noDataImage != 0) {
            this.noDataImage = mStatusBuilder.noDataImage;
        }

        if (mStatusBuilder.errorImage != 0) {
            this.errorImage = mStatusBuilder.errorImage;
        }

        if (mStatusBuilder.internetErrorImage != 0) {
            this.internetErrorImage = mStatusBuilder.internetErrorImage;
        }

        if (mStatusBuilder.loadingTipTextColor != 0) {
            this.loadingTipTextColor = mStatusBuilder.loadingTipTextColor;
        }
        if (mStatusBuilder.noDataTipTextColor != 0) {
            this.noDataTipTextColor = mStatusBuilder.noDataTipTextColor;
        }
        if (mStatusBuilder.internetErrorTipTextColor != 0) {
            this.internetErrorTipTextColor = mStatusBuilder.internetErrorTipTextColor;
        }
        if (mStatusBuilder.btnRetryTextColor != 0) {
            this.btnRetryTextColor = mStatusBuilder.btnRetryTextColor;
        }
        if (mStatusBuilder.errorTipTextColor != 0) {
            this.errorTipTextColor = mStatusBuilder.errorTipTextColor;
        }

        if (!TextUtils.isEmpty(mStatusBuilder.loadingTipText)) {
            this.loadingTipText = mStatusBuilder.loadingTipText;
        }

        if (!TextUtils.isEmpty(mStatusBuilder.noDataTipText)) {
            this.noDataTipText = mStatusBuilder.noDataTipText;
        }

        if (!TextUtils.isEmpty(mStatusBuilder.internetErrorTipText)) {
            this.internetErrorTipText = mStatusBuilder.internetErrorTipText;
        }
        if (!TextUtils.isEmpty(mStatusBuilder.btnRetryText)) {
            this.btnRetryText = mStatusBuilder.btnRetryText;
        }

        if (!TextUtils.isEmpty(mStatusBuilder.errorTipText)) {
            this.errorTipText = mStatusBuilder.errorTipText;
        }

    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mView = LayoutInflater.from(mContext).inflate(R.layout.page_status, null);
        mPageStatusLayout = mView.findViewById(R.id.page_status_main_layout);
        mStartLoadingLayout = mView.findViewById(R.id.start_loading_layout);
        mProgressBarTipText = mView.findViewById(R.id.progress_bar_tip);
        mNoDataLayout = mView.findViewById(R.id.no_data_layout);
        mNoDataImageView = mView.findViewById(R.id.no_data_image);
        mNoDataTip = mView.findViewById(R.id.no_data_tip);
        mInternetErrorLayout = mView.findViewById(R.id.internet_error_layout);
        mInternetErrorImageView = mView.findViewById(R.id.internet_error_image);
        mInternetErrorTipText = mView.findViewById(R.id.internet_error_tip);
        btnRetry = mView.findViewById(R.id.btn_retry);
        mErrorLayout = mView.findViewById(R.id.error_layout);
        errorImageView = mView.findViewById(R.id.error_image);
        mErrorTipText = mView.findViewById(R.id.error_tip);

        mProgressBarTipText.setText(loadingTipText);
        mNoDataTip.setText(noDataTipText);
        mInternetErrorTipText.setText(internetErrorTipText);
        btnRetry.setText(btnRetryText);
        mErrorTipText.setText(errorTipText);

        mNoDataImageView.setImageResource(noDataImage);
        mInternetErrorImageView.setImageResource(internetErrorImage);
        errorImageView.setImageResource(errorImage);

        mProgressBarTipText.setTextColor(ContextCompat.getColor(mContext, loadingTipTextColor));
        mNoDataTip.setTextColor(ContextCompat.getColor(mContext, noDataTipTextColor));
        mInternetErrorTipText.setTextColor(ContextCompat.getColor(mContext, internetErrorTipTextColor));
        btnRetry.setTextColor(ContextCompat.getColor(mContext, btnRetryTextColor));
        mErrorTipText.setTextColor(ContextCompat.getColor(mContext, errorTipTextColor));


        btnRetry.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnRetryListener != null) {
                    mOnRetryListener.retry(v);
                }
            }
        });

        this.addView(mPageStatusLayout);

    }


    public static PageStatusBuilder pageStatusConfig() {
        return mStatusBuilder;
    }

    public void setPageStatus(int pageStatus) {
        switch (pageStatus) {
            case loading:
                mPageStatusLayout.setVisibility(VISIBLE);
                mStartLoadingLayout.setVisibility(VISIBLE);
                mNoDataLayout.setVisibility(GONE);
                mInternetErrorLayout.setVisibility(GONE);
                mErrorLayout.setVisibility(GONE);
                break;
            case loadingSuccess:
                mPageStatusLayout.setVisibility(GONE);
                break;
            case internetError:
                mPageStatusLayout.setVisibility(VISIBLE);
                mStartLoadingLayout.setVisibility(GONE);
                mNoDataLayout.setVisibility(GONE);
                mInternetErrorLayout.setVisibility(VISIBLE);
                mErrorLayout.setVisibility(GONE);
                break;
            case noData:
                mPageStatusLayout.setVisibility(VISIBLE);
                mStartLoadingLayout.setVisibility(GONE);
                mNoDataLayout.setVisibility(VISIBLE);
                mInternetErrorLayout.setVisibility(GONE);
                mErrorLayout.setVisibility(GONE);
                break;
            case loadingError:
                mPageStatusLayout.setVisibility(VISIBLE);
                mStartLoadingLayout.setVisibility(GONE);
                mNoDataLayout.setVisibility(GONE);
                mInternetErrorLayout.setVisibility(GONE);
                mErrorLayout.setVisibility(VISIBLE);
                break;
            default:
                break;
        }
    }


    public static class PageStatusBuilder {

        private String loadingTipText;
        private String errorTipText;
        private String btnRetryText;
        private String noDataTipText;
        private String internetErrorTipText;

        private @DrawableRes
        int internetErrorImage;
        private @DrawableRes
        int noDataImage;
        private @DrawableRes
        int errorImage;

        private @ColorRes
        int loadingTipTextColor = R.color.grey;
        private @ColorRes
        int noDataTipTextColor = R.color.grey;
        private @ColorRes
        int internetErrorTipTextColor = R.color.grey;
        private @ColorRes
        int btnRetryTextColor = R.color.grey;
        private @ColorRes
        int errorTipTextColor = R.color.grey;

        public PageStatusBuilder loadingTipText(String loadingTip) {
            this.loadingTipText = loadingTip;
            return this;
        }

        public PageStatusBuilder noDataImage(@DrawableRes int image) {
            this.noDataImage = image;
            return this;
        }

        public PageStatusBuilder noDataTipText(String noDataTip) {
            this.noDataTipText = noDataTip;
            return this;
        }

        public PageStatusBuilder internetErrorImage(@DrawableRes int image) {
            this.internetErrorImage = image;
            return this;
        }

        public PageStatusBuilder internetErrorTipText(String internetErrorTip) {
            this.internetErrorTipText = internetErrorTip;
            return this;
        }

        public PageStatusBuilder errorImage(@DrawableRes int error) {
            this.errorImage = error;
            return this;
        }

        public PageStatusBuilder errorTipText(String errorTip) {
            this.errorTipText = errorTip;
            return this;
        }

        public PageStatusBuilder buttonRetryText(String btnRetryText) {
            this.btnRetryText = btnRetryText;
            return this;
        }

        public PageStatusBuilder loadingTipTextColor(@ColorRes int color) {
            this.loadingTipTextColor = color;
            return this;
        }

        public PageStatusBuilder noDataTipTextColor(@ColorRes int color) {
            this.noDataTipTextColor = color;
            return this;
        }

        public PageStatusBuilder internetErrorTipTextColor(@ColorRes int color) {
            this.internetErrorTipTextColor = color;
            return this;
        }

        public PageStatusBuilder btnRetryTextColor(@ColorRes int color) {
            this.btnRetryTextColor = color;
            return this;
        }

        public PageStatusBuilder errorTipTextColor(@ColorRes int color) {
            this.errorTipTextColor = color;
            return this;
        }
    }


}
