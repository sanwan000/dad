package com.example.slidingmenu;

import com.example.slidingmenu.fragment.OneFragment;
import com.example.slidingmenu.fragment.TwoFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.os.Bundle;
import android.app.Activity;
import android.drm.DrmStore.RightsStatus;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends SlidingFragmentActivity implements OnClickListener {
	private SlidingMenu mSlidingMenu;
	private OneFragment mOneFragment;
	private TwoFragment twoFragment;
	private Button one,two;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSlidingMenu=getSlidingMenu();
		//设置布局
		setBehindContentView(R.layout.left);
		//触摸滑动时间：全屏
		mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		//滑动方向
		mSlidingMenu.setMode(SlidingMenu.LEFT);
		mSlidingMenu.setBehindWidth(500);
		
		
		one=(Button) findViewById(R.id.one);
		two=(Button) findViewById(R.id.two);
		one.setOnClickListener(this);
		two.setOnClickListener(this);

		mOneFragment=new OneFragment();
		twoFragment=new TwoFragment();
	
		getSupportFragmentManager().beginTransaction().add(R.id.container, mOneFragment).commit();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
		switch (v.getId()) {
		case R.id.one:
			beginTransaction.replace(R.id.container, mOneFragment);
			break;
	case R.id.two:
		beginTransaction.replace(R.id.container, twoFragment);

			break;

		default:
			break;
		}
		beginTransaction.commit();
		mSlidingMenu.showContent();
	}


}
