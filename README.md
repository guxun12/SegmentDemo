SegmentDemo
===========

仿iossegment controller的一个demo
=================================
使用SegmentButton时候记得在根布局写上 xmlns:attr="http://schemas.android.com/apk/res/+segmentbutton对应的包名"
例如：
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:attr="http://schemas.android.com/apk/res/com.example.segmentbutton"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="10dp" >

    <com.example.segmentbutton.SegmentButton
        android:id="@+id/segment_button"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        attr:buttonContent="第一页;第二页;第三页;"
        attr:textSize="20" />

    <FrameLayout
        android:id="@+id/fl_content"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="9" >
    </FrameLayout>

</LinearLayout>

=================================
使用注解进行findviewbyid 要注意在setContentView 之后Injector.get(this).inject() 否则会报错

=================================

![image](https://github.com/guxun12/SegmentDemo/raw/master/segment_demo.gif)


