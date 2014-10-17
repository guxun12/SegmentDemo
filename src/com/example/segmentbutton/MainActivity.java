package com.example.segmentbutton;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

import com.example.fragment.Fragment01;
import com.example.fragment.Fragment02;
import com.example.fragment.Fragment03;

public class MainActivity extends FragmentActivity {

	private SegmentButton segment_button;
	private Fragment01 fragment01;
	private Fragment02 fragment02;
	private Fragment03 fragment03;
	/**
	 * 用于对Fragment进行管理
	 */
	private android.support.v4.app.FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fragmentManager = getSupportFragmentManager();
		// 第一次启动时选中第1个tab
		setTabSelection(1);
		segment_button = (SegmentButton) findViewById(R.id.segment_button);
		segment_button
				.setOnCheckedChangeListener(new SegmentButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(int position, Button button) {
						setTabSelection(position+1);
						Log.i("position", position+1+"");
					}

				});
	}
	/**
	 * 根据传入的index参数来设置选中的tab页。
	 * 
	 * @param index
	 *            每个tab页对应的下标。2表示主页，1表示房源信息。
	 */
	private void setTabSelection(int index) {
		// 开启一个Fragment事务
		android.support.v4.app.FragmentTransaction transaction = fragmentManager
				.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		hideFragments(transaction);
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		// transaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
		switch (index) {
		case 1:
			if (fragment01 == null) {
				// 如果fragment01为空，则创建一个并添加到界面上
				fragment01 = new Fragment01();
				transaction.add(R.id.fl_content, fragment01);
			} else {
				// 如果fragment01不为空，则直接将它显示出来
				transaction.show(fragment01);
			}
			break;
		case 2:
			if (fragment02 == null) {
				fragment02 = new Fragment02();
				transaction.add(R.id.fl_content, fragment02);
			} else {
				transaction.show(fragment02);
			}
			break;
		case 3:
			if (fragment03 == null) {
				fragment03 = new Fragment03();
				transaction.add(R.id.fl_content, fragment03);
			} else {
				transaction.show(fragment03);
			}
			break;
		}
		transaction.commit();
	}
	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * 
	 * @param transaction
	 *            用于对Fragment执行操作的事务
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (fragment01!= null) {
			transaction.hide(fragment01);
		}
		if (fragment02 != null) {
			transaction.hide(fragment02);
		}
		if (fragment03 != null) {
			transaction.hide(fragment03);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
