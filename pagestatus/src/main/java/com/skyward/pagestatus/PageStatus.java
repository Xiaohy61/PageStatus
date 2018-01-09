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
    private static String loadingTipText;
    private String noDataTipText;
    private static String internetErrorTipText;
    private String btnRetryText;
    private String errorTipText;
    private boolean isVisibleContent = true;

    private int errorImage;
    private int internetErrorImage;
    private int noDataImage;

    private int loadingTipTextColor;
    private int noDataTipTextColor;
    private int internetErrorTipTextColor;
    private int btnRetryTextColor;
    private int errorTipTextColor;
    private int background;

    private static String builderLoadingTipText;
    private static String builderNoDataTipText;
    private static String builderInternetErrorTipText;
    private static String builderBtnRetryText;
    private static String builderErrorTipText;

    private static @DrawableRes
    int builderNoDataImage = 0;
    private static @DrawableRes
    int builderInternetErrorImage = 0;
    private static @DrawableRes
    int builderErrorImage = 0;

    private static @ColorRes
    int builderInternetErrorTipTextColor = 0;
    private static @ColorRes
    int builderProgressBarTipTextColor = 0;
    private static @ColorRes
    int builderNoDataTipTextColor = 0;
    private static @ColorRes
    int builderBtnRetryTextColor = 0;
    private static @ColorRes
    int builderErrorTipTextColor = 0;
    private static @ColorRes
    int builderBackgroundColor = 0;

    private OnRetryListener mOnRetryListener;


    public static class Builder {

        public Builder setLoadingTipText(String text) {
            PageStatus.builderLoadingTipText = text;
            return this;
        }

        public Builder setNoDataTipText(String text) {
            PageStatus.builderNoDataTipText = text;
            return this;
        }

        public Builder setInternetErrorText(String text) {
            PageStatus.builderInternetErrorTipText = text;
            return this;
        }

        public Builder setBtnRetryText(String text) {
            PageStatus.builderBtnRetryText = text;
            return this;
        }

        public Builder setErrorTipText(String text) {
            PageStatus.builderErrorTipText = text;
            return this;
        }


        public Builder setNoDataImage(@DrawableRes int drawable) {
            PageStatus.builderNoDataImage = drawable;
            return this;
        }

        public Builder setInternetErrorImage(@DrawableRes int drawable) {
            PageStatus.builderInternetErrorImage = drawable;
            return this;
        }

        public Builder setErrorImage(@DrawableRes int drawable) {
            PageStatus.builderErrorImage = drawable;
            return this;
        }

        public Builder setProgressBarTipTextColor(@ColorRes int color) {
            PageStatus.builderProgressBarTipTextColor = color;
            return this;
        }

        public Builder setInterNetErrorTextColor(@ColorRes int color) {
            PageStatus.builderInternetErrorTipTextColor = color;
            return this;
        }

        public Builder setNoDataTipTextColor(@ColorRes int color) {
            PageStatus.builderNoDataTipTextColor = color;
            return this;
        }

        public Builder setBtnRetryTextColor(@ColorRes int color) {
            PageStatus.builderBtnRetryTextColor = color;
            return this;
        }

        public Builder setErrorTipTextColor(@ColorRes int color) {
            PageStatus.builderErrorTipTextColor = color;
            return this;
        }

        public Builder setBackgroundColor(@ColorRes int color) {
            PageStatus.builderBackgroundColor = color;
            return this;
        }

    }


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
        noDataTipTextColor = typedArray.getColor(R.styleable.PageStatus_noDataTipTextColor, ContextCompat.getColor(mContext, R.color.grey));
        internetErrorTipTextColor = typedArray.getColor(R.styleable.PageStatus_internetErrorTipTextColor, ContextCompat.getColor(mContext, R.color.grey));
        btnRetryTextColor = typedArray.getColor(R.styleable.PageStatus_btnRetryTextColor, ContextCompat.getColor(mContext, R.color.grey));
        errorTipTextColor = typedArray.getColor(R.styleable.PageStatus_errorTipTextColor, ContextCompat.getColor(mContext, R.color.grey));
        background = typedArray.getColor(R.styleable.PageStatus_pageStatusBackground, ContextCompat.getColor(mContext, R.color.white));
        isVisibleContent = typedArray.getBoolean(R.styleable.PageStatus_isVisibleContent, true);
        typedArray.recycle();

    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mView = LayoutInflater.from(mContext).inflate(R.layout.page_status, null);
        if (isVisibleContent) {
            mView.setVisibility(GONE);
        } else {
            mView.setVisibility(VISIBLE);
        }

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

        mProgressBarTipText.setText(TextUtils.isEmpty(builderLoadingTipText) == true ? loadingTipText : builderLoadingTipText);
        mNoDataTip.setText(TextUtils.isEmpty(builderNoDataTipText) == true ? noDataTipText : builderNoDataTipText);
        mInternetErrorTipText.setText(TextUtils.isEmpty(builderInternetErrorTipText) == true ? internetErrorTipText : builderInternetErrorTipText);
        btnRetry.setText(TextUtils.isEmpty(builderBtnRetryText) == true ? btnRetryText : builderBtnRetryText);
        mErrorTipText.setText(TextUtils.isEmpty(builderErrorTipText) == true ? errorTipText : builderErrorTipText);

        mNoDataImageView.setImageResource(builderNoDataImage == 0 ? noDataImage : builderErrorImage);
        mInternetErrorImageView.setImageResource(builderInternetErrorImage == 0 ? internetErrorImage : builderInternetErrorImage);
        errorImageView.setImageResource(builderErrorImage == 0 ? errorImage : builderErrorImage);

        mProgressBarTipText.setTextColor(builderProgressBarTipTextColor == 0 ? loadingTipTextColor : ContextCompat.getColor(mContext, builderProgressBarTipTextColor));
        mNoDataTip.setTextColor(builderNoDataTipTextColor == 0 ? noDataTipTextColor : ContextCompat.getColor(mContext, builderNoDataTipTextColor));
        mInternetErrorTipText.setTextColor(builderInternetErrorTipTextColor == 0 ? internetErrorTipTextColor : ContextCompat.getColor(mContext, builderInternetErrorTipTextColor));
        btnRetry.setTextColor(builderBtnRetryTextColor == 0 ? btnRetryTextColor : ContextCompat.getColor(mContext, builderBtnRetryTextColor));
        mErrorTipText.setTextColor(builderErrorTipTextColor == 0 ? errorTipTextColor : ContextCompat.getColor(mContext, builderErrorTipTextColor));

        mPageStatusLayout.setBackgroundColor(builderBackgroundColor == 0 ? background : ContextCompat.getColor(mContext, builderBackgroundColor));

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


}
