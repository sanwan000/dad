package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.fragment.ForeFragment;
import com.example.fragment.OneFragment;
import com.example.fragment.ThreeFragment;
import com.example.fragment.TwoFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

public class MainActivity extends FragmentActivity implements OnClickListener {
	private List<RadioButton> btn_list;
	private ViewPager mViewPager;
	private List<Fragment> frag_list;
	private RadioButton btn1, btn2, btn3, btn4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initMoudle();
		mViewPager.setAdapter(new FragAdapter(getSupportFragmentManager()));
		mViewPager.setOnPageChangeListener(aa);
	}

	public void initMoudle() {
		mViewPager = (ViewPager) findViewById(R.id.viewPager_fragmnet);
		btn1 = (RadioButton) findViewById(R.id.one);
		btn2 = (RadioButton) findViewById(R.id.two);
		btn3 = (RadioButton) findViewById(R.id.three);
		btn4 = (RadioButton) findViewById(R.id.fore);
		btn_list = new ArrayList<RadioButton>();
		btn_list.add(btn1);
		btn_list.add(btn2);
		btn_list.add(btn3);
		btn_list.add(btn4);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		frag_list = new ArrayList<Fragment>();
		frag_list.add(new OneFragment());
		frag_list.add(new TwoFragment());
		frag_list.add(new ThreeFragment());
		frag_list.add(new ForeFragment());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.one:
			selectBtn(0);
			mViewPager.setCurrentItem(0);
			break;
		case R.id.two:
			selectBtn(1);
			mViewPager.setCurrentItem(1);
			break;
		case R.id.three:
			selectBtn(2);
			mViewPager.setCurrentItem(2);
			break;
		case R.id.fore:
			selectBtn(3);
			mViewPager.setCurrentItem(3);
			break;
		}
	}

	OnPageChangeListener aa = new OnPageChangeListener() {
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			selectBtn(arg0);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}
	};

	class FragAdapter extends FragmentPagerAdapter {

		public FragAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return frag_list.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return frag_list.size();
		}

	}

	private void selectBtn(int position) {
		for (int i = 0; i < btn_list.size(); i++) {
			if (i == position) {
				btn_list.get(i).setBackgroundColor(Color.BLUE);
			} else {
				btn_list.get(i).setBackgroundColor(Color.WHITE);
			}
		}
	}
}
