# PageStatus
效果图



### 依赖：
``` xml
  dependencies {
  
   compile 'com.skyward.pagestatus:pagestatus:1.0.0'
   
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
        PageStatus.pageStatusConfig()
                .errorImage(R.drawable.error_icon)
                .buttonRetryText("点我重试")
                .loadingTipText("")
                .internetErrorTipText("网络出现错误...")
                .noDataTipText("抱歉，暂无相关数据...")
                .errorTipText("出错啦...");
    }
}
```
2.或者在xml中配置：
```xml
 <com.skyward.pagestatus.PageStatus
        android:id="@+id/page_status_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:noDataTipText="抱歉，暂无数据">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello World!"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent"/>
    </com.skyward.pagestatus.PageStatus>
```
