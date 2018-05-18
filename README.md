# PageStatus Android 页面状态管理
效果图

<img width="50%" height="50%" src="https://github.com/Xiaohy61/PageStatus/blob/master/1526645528622mzskyward.gif"/>

### 依赖：

``` xml
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
``` xml
  dependencies {

	      implementation 'com.github.Xiaohy61:PageStatus:1.0.2'

	}

```

### 配置
1. 可以在application全局配置：

```xml
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //图片，文字，文字颜色都可以自己配置，或者只配置文字
         new PageStatus.Builder()
                .setLoadingTipText("数据加载中...")
                .setNetworkErrorTipText("网络出现错误...")
                .setBtnRetryText("点我重试")
                .setDataErrorTipText("发生错误...")
                .setEmptyDataTipText("抱歉暂无相关数据!")
                .setEmptyOrderTipText("还没有相关订单")
                .setEmptyMsgTipText("还没有相关消息呢")
                .setEmptyCartTipText("购物车还是空的哦~")
                .setDataErrorImage(R.drawable.no_data_icon)
                .setEmptyCartTextColor(R.color.grey);
    }
}
```
2.或者在xml中配置：
    app:isVisibleContent="true"  PageStatus 包含的布局是否可见，默认可见，改为false，被它包含的布局不可见
```xml
  <com.skyward.pagestatus.PageStatus
        android:id="@+id/page_status"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:emptyDataTipText="没有数据"
        app:isVisibleContent="true"
        >
        <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_centerInParent="true"
                android:text="hello word"/>
        </RelativeLayout>
    </com.skyward.pagestatus.PageStatus>
```
3.使用
```xml
   PageStatus mPageStatus = findViewById(R.id.page_status);
   mPageStatus.setPageStatus(PageStatusValue.LOADING);
```
4.PageStatusValue 参数说明
```xml
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
```
