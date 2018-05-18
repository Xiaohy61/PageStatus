package com.skyward.pagestatus;

/**
 * @author: skyward
 * date: 2017/11/9 0009
 * desc:
 */
public class PageStatusValue {
    /**
     * 数据加载中
     */
    public final static int LOADING = 1;
    /**
     * 数据加载完成
     */
    public final static int LOADING_SUCCESS = 2;
    /**
     * 网络错误
     */
    public final static int NETWORK_ERROR=3;
    /**
     * 没有数据
     */
    public final static int EMPTY_DATA = 4;
    /**
     * 数据错误
     */
    public final static int DATE_ERROR =5;
    /**
     * 购物车为空
     */
    public final static int EMPTY_CART =6;
    /**
     * 订单为空
     */
    public final static int EMPTY_ORDER =7;
    /**
     * 消息为空
     */
    public final static int EMPTY_MSG = 8;
}
