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

import static com.skyward.pagestatus.PageStatusValue.DATE_ERROR;
import static com.skyward.pagestatus.PageStatusValue.EMPTY_CART;
import static com.skyward.pagestatus.PageStatusValue.EMPTY_DATA;
import static com.skyward.pagestatus.PageStatusValue.EMPTY_MSG;
import static com.skyward.pagestatus.PageStatusValue.EMPTY_ORDER;
import static com.skyward.pagestatus.PageStatusValue.LOADING;
import static com.skyward.pagestatus.PageStatusValue.LOADING_SUCCESS;
import static com.skyward.pagestatus.PageStatusValue.NETWORK_ERROR;


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
    private LinearLayout mEmptyDataLayout;
    private ImageView mEmptyDataImage;
    private TextView mEmptyDataTipText;

    private LinearLayout mNetworkErrorLayout;
    private ImageView mNetworkErrorImage;
    private TextView mNetworkErrorTipText;
    private Button btnRetry;

    private LinearLayout mDataErrorLayout;
    private ImageView mDataErrorImage;
    private TextView mDataErrorTipText;

    private LinearLayout mEmptyOrderLayout;
    private ImageView mEmptyOrderImage;
    private TextView mEmptyOrderTipText;

    private LinearLayout mEmptyMsgLayout;
    private ImageView mEmptyMsgImage;
    private TextView mEmptyMsgTipText;

    private LinearLayout mEmptyCartLayout;
    private ImageView mEmptyCartImage;
    private TextView mEmptyCartTipText;


    private Context mContext;
    /**
     * 数据加载中提示文本
     */
    private String loadingTipTStr;
    /**
     * 数据为空提示文本
     */
    private String emptyDataTipStr;
    /**
     * 网络错误提示文本
     */
    private String networkErrorTipStr;
    /**
     * 网络错误点击按钮提示文本
     */
    private String btnRetryStr;
    /**
     * 数据错误提示文本
     */
    private String dataErrorTipStr;
    /**
     * 没有订单提示文本
     */
    private String emptyOrderStr;
    /**
     * 没有消息提示文本
     */
    private String emptyMsgStr;
    /**
     * 购物车为空提示文本
     */
    private String emptyCartStr;
    /**
     * PageStatus 包含的布局是否可见，默认可见，改为false，被它包含的布局不可见
     */
    private boolean isVisibleContent = true;

    /**
     * 数据错误提示图片
     */
    private int dataErrorImageAttr;
    /**
     * 网络错误提示图片
     */
    private int networkErrorImageAttr;
    /**
     * 数据为空提示图片
     */
    private int emptyDataImageAttr;
    /**
     * 订单为空提示图片
     */
    private int emptyOrderImageAttr;
    /**
     * 消息为空提示图片
     */
    private int emptyMsgImageAttr;
    /**
     * 购物车为空提示图片
     */
    private int emptyCartImageAttr;

    /**
     * 数据加载中提示文本颜色
     */
    private int loadingTipTextColor;
    /**
     * 数据为空提示文本颜色
     */
    private int emptyDataTipTextColor;
    /**
     * 网络错误提示文本颜色
     */
    private int networkErrorTipTextColor;
    /**
     * 网络错误点击按钮提示文本颜色
     */
    private int btnRetryTextColor;
    /**
     * 数据错误提示文本颜色
     */
    private int dataErrorTipTextColor;
    /**
     * 订单为空提示文本颜色
     */
    private int emptyOrderTextColor;
    /**
     * 消息为空提示文本颜色
     */
    private int emptyMsgTextColor;
    /**
     * 购物车为空提示文本颜色
     */
    private int emptyCartTextColor;
    private int background;

    private static String builderLoadingTipText;
    private static String builderEmptyDataTipText;
    private static String builderNetworkErrorTipText;
    private static String builderBtnRetryText;
    private static String builderDataErrorTipText;
    private static String builderEmptyOrderText;
    private static String builderEmptyMsgText;
    private static String builderEmptyCartText;

    private static @DrawableRes
    int builderEmptyDataImage = 0;
    private static @DrawableRes
    int builderNetworkErrorImage = 0;
    private static @DrawableRes
    int builderDataErrorImage = 0;
    private static @DrawableRes
    int builderEmptyOrderImage = 0;
    private static @DrawableRes
    int builderEmptyMsgImage = 0;
    private static @DrawableRes
    int builderEmptyCartImage = 0;

    private static @ColorRes
    int builderNetworkErrorTipTextColor = 0;
    private static @ColorRes
    int builderProgressBarTipTextColor = 0;
    private static @ColorRes
    int builderEmptyDataTipTextColor = 0;
    private static @ColorRes
    int builderBtnRetryTextColor = 0;
    private static @ColorRes
    int builderDataErrorTipTextColor = 0;
    private static @ColorRes
    int builderBackgroundColor = 0;
    private static @ColorRes
    int builderEmptyOrderColor = 0;
    private static @ColorRes
    int builderEmptyMsgColor = 0;
    private static @ColorRes
    int builderEmptyCartColor = 0;

    private OnRetryListener mOnRetryListener;


    public static class Builder {

        /**
         * 设置加载中文本
         * @param text text
         * @return Builder
         */
        public Builder setLoadingTipText(String text) {
            PageStatus.builderLoadingTipText = text;
            return this;
        }
        /**
         * 设置数据为空文本
         * @param text text
         * @return Builder
         */
        public Builder setEmptyDataTipText(String text) {
            PageStatus.builderEmptyDataTipText = text;
            return this;
        }
        /**
         * 设置网络错误文本
         * @param text text
         * @return Builder
         */
        public Builder setNetworkErrorTipText(String text) {
            PageStatus.builderNetworkErrorTipText = text;
            return this;
        }

        /**
         * 设置网络错误点击按钮提示文本
         * @param text text
         * @return Builder
         */
        public Builder setBtnRetryText(String text) {
            PageStatus.builderBtnRetryText = text;
            return this;
        }

        /**
         * 设置数据错误文本
         * @param text text
         * @return Builder
         */
        public Builder setDataErrorTipText(String text) {
            PageStatus.builderDataErrorTipText = text;
            return this;
        }

        /**
         * 设置订单为空文本
         * @param text text
         * @return Builder
         */
        public Builder setEmptyOrderTipText(String text) {
            PageStatus.builderEmptyOrderText = text;
            return this;
        }

        /**
         * 设置消息为空文本
         * @param text text
         * @return Builder
         */
        public Builder setEmptyMsgTipText(String text) {
            PageStatus.builderEmptyMsgText = text;
            return this;
        }

        /**
         * 设置购物车为空文本
         * @param text text
         * @return Builder
         */
        public Builder setEmptyCartTipText(String text) {
            PageStatus.builderEmptyCartText = text;
            return this;
        }

        /**
         * 设置数据为空图片
         * @param drawable drawable
         * @return Builder
         */
        public Builder setEmptyDataImage(@DrawableRes int drawable) {
            PageStatus.builderEmptyDataImage = drawable;
            return this;
        }

        /**
         * 设置网络错误图片
         * @param drawable drawable
         * @return Builder
         */
        public Builder setNetworkErrorImage(@DrawableRes int drawable) {
            PageStatus.builderNetworkErrorImage = drawable;
            return this;
        }

        /**
         * 设置数据错误图片
         * @param drawable drawable
         * @return Builder
         */
        public Builder setDataErrorImage(@DrawableRes int drawable) {
            PageStatus.builderDataErrorImage = drawable;
            return this;
        }
        /**
         * 设置订单为空图片
         * @param drawable drawable
         * @return Builder
         */
        public Builder setEmptyOrderImage(@DrawableRes int drawable) {
            PageStatus.builderEmptyOrderImage = drawable;
            return this;
        }

        /**
         * 设置消息为空图片
         * @param drawable drawable
         * @return Builder
         */
        public Builder setEmptyMsgImage(@DrawableRes int drawable) {
            PageStatus.builderEmptyMsgImage = drawable;
            return this;
        }
        /**
         * 设置购物车为空图片
         * @param drawable drawable
         * @return Builder
         */
        public Builder setEmptyCartImage(@DrawableRes int drawable) {
            PageStatus.builderEmptyCartImage = drawable;
            return this;
        }
        /**
         * 设置加载进度文本颜色
         * @param color color
         * @return Builder
         */
        public Builder setProgressBarTipTextColor(@ColorRes int color) {
            PageStatus.builderProgressBarTipTextColor = color;
            return this;
        }
        /**
         * 设置网络错误文本颜色
         * @param color color
         * @return Builder
         */
        public Builder setNetworkErrorTextColor(@ColorRes int color) {
            PageStatus.builderNetworkErrorTipTextColor = color;
            return this;
        }
        /**
         * 设置数据为空文本颜色
         * @param color color
         * @return Builder
         */
        public Builder setEmptyDataTipTextColor(@ColorRes int color) {
            PageStatus.builderEmptyDataTipTextColor = color;
            return this;
        }

        /**
         * 设置点我重试按钮文本颜色
         * @param color color
         * @return Builder
         */
        public Builder setBtnRetryTextColor(@ColorRes int color) {
            PageStatus.builderBtnRetryTextColor = color;
            return this;
        }
        /**
         * 设置数据错误文本颜色
         * @param color color
         * @return Builder
         */
        public Builder setDataErrorTipTextColor(@ColorRes int color) {
            PageStatus.builderDataErrorTipTextColor = color;
            return this;
        }
        /**
         * 设置订单为空文本颜色
         * @param color color
         * @return Builder
         */
        public Builder setEmptyOrderTextColor(@ColorRes int color) {
            PageStatus.builderEmptyOrderColor = color;
            return this;
        }
        /**
         * 设置消息为空文本颜色
         * @param color color
         * @return Builder
         */
        public Builder setEmptyMsgTextColor(@ColorRes int color) {
            PageStatus.builderEmptyMsgColor = color;
            return this;
        }
        /**
         * 设置购物车为空文本颜色
         * @param color color
         * @return Builder
         */
        public Builder setEmptyCartTextColor(@ColorRes int color) {
            PageStatus.builderEmptyCartColor = color;
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
        loadingTipTStr = typedArray.getString(R.styleable.PageStatus_LoadingTipText);
        emptyDataTipStr = typedArray.getString(R.styleable.PageStatus_emptyDataTipText);
        networkErrorTipStr = typedArray.getString(R.styleable.PageStatus_networkErrorTipText);
        btnRetryStr = typedArray.getString(R.styleable.PageStatus_btnRetryText);
        dataErrorTipStr = typedArray.getString(R.styleable.PageStatus_dataErrorTipText);
        emptyOrderStr = typedArray.getString(R.styleable.PageStatus_emptyOrderText);
        emptyMsgStr = typedArray.getString(R.styleable.PageStatus_emptyMsgText);
        emptyCartStr = typedArray.getString(R.styleable.PageStatus_emptyCartText);

        emptyDataImageAttr = typedArray.getResourceId(R.styleable.PageStatus_emptyDataImage, R.drawable.no_data_icon);
        networkErrorImageAttr = typedArray.getResourceId(R.styleable.PageStatus_networkErrorImage, R.drawable.internet_error);
        dataErrorImageAttr = typedArray.getResourceId(R.styleable.PageStatus_dataErrorImage, R.drawable.error_icon);
        emptyOrderImageAttr = typedArray.getResourceId(R.styleable.PageStatus_emptyOrderImage, R.drawable.no_order_icon);
        emptyMsgImageAttr = typedArray.getResourceId(R.styleable.PageStatus_emptyMsgImage, R.drawable.no_message_icon);
        emptyCartImageAttr = typedArray.getResourceId(R.styleable.PageStatus_emptyCartImage, R.drawable.empty_cart_icon);

        loadingTipTextColor = typedArray.getColor(R.styleable.PageStatus_LoadingTipTextColor, ContextCompat.getColor(mContext, R.color.grey));
        emptyDataTipTextColor = typedArray.getColor(R.styleable.PageStatus_emptyDataTipTextColor, ContextCompat.getColor(mContext, R.color.grey));
        networkErrorTipTextColor = typedArray.getColor(R.styleable.PageStatus_networkErrorTipTextColor, ContextCompat.getColor(mContext, R.color.grey));
        btnRetryTextColor = typedArray.getColor(R.styleable.PageStatus_btnRetryTextColor, ContextCompat.getColor(mContext, R.color.grey));
        dataErrorTipTextColor = typedArray.getColor(R.styleable.PageStatus_dataErrorTipTextColor, ContextCompat.getColor(mContext, R.color.grey));
        emptyOrderTextColor = typedArray.getColor(R.styleable.PageStatus_emptyOrderTextColor, ContextCompat.getColor(mContext, R.color.grey));
        emptyMsgTextColor = typedArray.getColor(R.styleable.PageStatus_emptyMsgTextColor, ContextCompat.getColor(mContext, R.color.grey));
        emptyCartTextColor = typedArray.getColor(R.styleable.PageStatus_emptyCartTextColor, ContextCompat.getColor(mContext, R.color.grey));

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
        mEmptyDataLayout = mView.findViewById(R.id.no_data_layout);
        mEmptyDataImage = mView.findViewById(R.id.no_data_image);
        mEmptyDataTipText = mView.findViewById(R.id.no_data_tip);
        mNetworkErrorLayout = mView.findViewById(R.id.internet_error_layout);
        mNetworkErrorImage = mView.findViewById(R.id.internet_error_image);
        mNetworkErrorTipText = mView.findViewById(R.id.internet_error_tip);
        btnRetry = mView.findViewById(R.id.btn_retry);
        mDataErrorLayout = mView.findViewById(R.id.error_layout);
        mDataErrorImage = mView.findViewById(R.id.error_image);
        mDataErrorTipText = mView.findViewById(R.id.error_tip);

        mEmptyOrderLayout = mView.findViewById(R.id.empty_order_layout);
        mEmptyOrderImage = mView.findViewById(R.id.empty_order_image);
        mEmptyOrderTipText = mView.findViewById(R.id.empty_order_tip);

        mEmptyMsgLayout = mView.findViewById(R.id.empty_msg_layout);
        mEmptyMsgImage = mView.findViewById(R.id.empty_msg_image);
        mEmptyMsgTipText = mView.findViewById(R.id.empty_msg_tip);

        mEmptyCartLayout = mView.findViewById(R.id.empty_cart_layout);
        mEmptyCartImage = mView.findViewById(R.id.empty_cart_image);
        mEmptyCartTipText = mView.findViewById(R.id.empty_cart_tip);



        if (TextUtils.isEmpty(builderLoadingTipText)) {
            mProgressBarTipText.setText(loadingTipTStr);
        } else {
            mProgressBarTipText.setText(builderLoadingTipText);
        }

        if (TextUtils.isEmpty(builderEmptyDataTipText)) {
            mEmptyDataTipText.setText(emptyDataTipStr);
        } else {
            mEmptyDataTipText.setText(builderEmptyDataTipText);
        }

        if (TextUtils.isEmpty(builderNetworkErrorTipText)) {
            mNetworkErrorTipText.setText(networkErrorTipStr);
        } else {
            mNetworkErrorTipText.setText(builderNetworkErrorTipText);
        }

        if (TextUtils.isEmpty(builderBtnRetryText)) {
            btnRetry.setText(btnRetryStr);
        } else {
            btnRetry.setText(builderBtnRetryText);
        }

        if (TextUtils.isEmpty(builderDataErrorTipText)) {
            mDataErrorTipText.setText(dataErrorTipStr);
        } else {
            mDataErrorTipText.setText(builderDataErrorTipText);
        }

        if (TextUtils.isEmpty(builderEmptyOrderText)) {
            mEmptyOrderTipText.setText(emptyOrderStr);
        } else {
            mEmptyOrderTipText.setText(builderEmptyOrderText);
        }

        if (TextUtils.isEmpty(builderEmptyMsgText)) {
            mEmptyMsgTipText.setText(emptyMsgStr);
        } else {
            mEmptyMsgTipText.setText(builderEmptyMsgText);
        }

        if (TextUtils.isEmpty(builderEmptyCartText)) {
            mEmptyCartTipText.setText(emptyCartStr);
        } else {
            mEmptyCartTipText.setText(builderEmptyCartText);
        }


        mEmptyDataImage.setImageResource(builderEmptyDataImage == 0 ? emptyDataImageAttr : builderEmptyDataImage);
        mNetworkErrorImage.setImageResource(builderNetworkErrorImage == 0 ? networkErrorImageAttr : builderNetworkErrorImage);
        mDataErrorImage.setImageResource(builderDataErrorImage == 0 ? dataErrorImageAttr : builderDataErrorImage);
        mEmptyOrderImage.setImageResource(builderEmptyOrderImage == 0 ? emptyOrderImageAttr : builderEmptyOrderImage);
        mEmptyMsgImage.setImageResource(builderEmptyMsgImage == 0 ? emptyMsgImageAttr : builderEmptyMsgImage);
        mEmptyCartImage.setImageResource(builderEmptyCartImage == 0 ? emptyCartImageAttr : builderEmptyCartImage);

        mProgressBarTipText.setTextColor(builderProgressBarTipTextColor == 0 ? loadingTipTextColor : ContextCompat.getColor(mContext, builderProgressBarTipTextColor));
        mEmptyDataTipText.setTextColor(builderEmptyDataTipTextColor == 0 ? emptyDataTipTextColor : ContextCompat.getColor(mContext, builderEmptyDataTipTextColor));
        mNetworkErrorTipText.setTextColor(builderNetworkErrorTipTextColor == 0 ? networkErrorTipTextColor : ContextCompat.getColor(mContext, builderNetworkErrorTipTextColor));
        btnRetry.setTextColor(builderBtnRetryTextColor == 0 ? btnRetryTextColor : ContextCompat.getColor(mContext, builderBtnRetryTextColor));
        mDataErrorTipText.setTextColor(builderDataErrorTipTextColor == 0 ? dataErrorTipTextColor : ContextCompat.getColor(mContext, builderDataErrorTipTextColor));
        mEmptyOrderTipText.setTextColor(builderEmptyOrderColor == 0 ? emptyOrderTextColor : ContextCompat.getColor(mContext, builderEmptyOrderColor));
        mEmptyMsgTipText.setTextColor(builderEmptyMsgColor == 0 ? emptyMsgTextColor : ContextCompat.getColor(mContext, builderEmptyMsgColor));
        mEmptyCartTipText.setTextColor(builderEmptyCartColor == 0 ? emptyCartTextColor : ContextCompat.getColor(mContext, builderEmptyCartColor));

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


    /**
     * 根据状态显示相应的页面状态提示
     * @param pageStatus 页面状态码
     */
    public void setPageStatus(int pageStatus) {
        switch (pageStatus) {
            case LOADING:
                mPageStatusLayout.setVisibility(VISIBLE);
                mStartLoadingLayout.setVisibility(VISIBLE);
                mEmptyDataLayout.setVisibility(GONE);
                mNetworkErrorLayout.setVisibility(GONE);
                mDataErrorLayout.setVisibility(GONE);
                mEmptyOrderLayout.setVisibility(GONE);
                mEmptyMsgLayout.setVisibility(GONE);
                mEmptyCartLayout.setVisibility(GONE);
                break;
            case LOADING_SUCCESS:
                mPageStatusLayout.setVisibility(GONE);
                break;
            case NETWORK_ERROR:
                mPageStatusLayout.setVisibility(VISIBLE);
                mStartLoadingLayout.setVisibility(GONE);
                mEmptyDataLayout.setVisibility(GONE);
                mNetworkErrorLayout.setVisibility(VISIBLE);
                mDataErrorLayout.setVisibility(GONE);
                mEmptyOrderLayout.setVisibility(GONE);
                mEmptyMsgLayout.setVisibility(GONE);
                mEmptyCartLayout.setVisibility(GONE);
                break;
            case EMPTY_DATA:
                mPageStatusLayout.setVisibility(VISIBLE);
                mStartLoadingLayout.setVisibility(GONE);
                mEmptyDataLayout.setVisibility(VISIBLE);
                mNetworkErrorLayout.setVisibility(GONE);
                mDataErrorLayout.setVisibility(GONE);
                mEmptyOrderLayout.setVisibility(GONE);
                mEmptyMsgLayout.setVisibility(GONE);
                mEmptyCartLayout.setVisibility(GONE);
                break;
            case DATE_ERROR:
                mPageStatusLayout.setVisibility(VISIBLE);
                mStartLoadingLayout.setVisibility(GONE);
                mEmptyDataLayout.setVisibility(GONE);
                mNetworkErrorLayout.setVisibility(GONE);
                mDataErrorLayout.setVisibility(VISIBLE);
                mEmptyOrderLayout.setVisibility(GONE);
                mEmptyMsgLayout.setVisibility(GONE);
                mEmptyCartLayout.setVisibility(GONE);
                break;
            case EMPTY_CART:
                mPageStatusLayout.setVisibility(VISIBLE);
                mStartLoadingLayout.setVisibility(GONE);
                mEmptyDataLayout.setVisibility(GONE);
                mNetworkErrorLayout.setVisibility(GONE);
                mDataErrorLayout.setVisibility(GONE);
                mEmptyOrderLayout.setVisibility(GONE);
                mEmptyMsgLayout.setVisibility(GONE);
                mEmptyCartLayout.setVisibility(VISIBLE);
                break;
            case EMPTY_ORDER:
                mPageStatusLayout.setVisibility(VISIBLE);
                mStartLoadingLayout.setVisibility(GONE);
                mEmptyDataLayout.setVisibility(GONE);
                mNetworkErrorLayout.setVisibility(GONE);
                mDataErrorLayout.setVisibility(GONE);
                mEmptyOrderLayout.setVisibility(VISIBLE);
                mEmptyMsgLayout.setVisibility(GONE);
                mEmptyCartLayout.setVisibility(GONE);
                break;
            case EMPTY_MSG:
                mPageStatusLayout.setVisibility(VISIBLE);
                mStartLoadingLayout.setVisibility(GONE);
                mEmptyDataLayout.setVisibility(GONE);
                mNetworkErrorLayout.setVisibility(GONE);
                mDataErrorLayout.setVisibility(GONE);
                mEmptyOrderLayout.setVisibility(GONE);
                mEmptyMsgLayout.setVisibility(VISIBLE);
                mEmptyCartLayout.setVisibility(GONE);
                break;
            default:
                break;
        }
    }


}
