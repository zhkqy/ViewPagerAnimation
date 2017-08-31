package com.yilong.viewpageranimation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.yilong.viewpageranimation.adpater.KaoQinViewPageAdapter;
import com.yilong.viewpageranimation.fragment.AttendGrowthFragment1;
import com.yilong.viewpageranimation.fragment.AttendGrowthFragment2;
import com.yilong.viewpageranimation.fragment.AttendGrowthFragment3;
import com.yilong.viewpageranimation.fragment.AttendGrowthFragment4;
import com.yilong.viewpageranimation.fragment.AttendGrowthFragment5;
import com.yilong.viewpageranimation.fragment.BaseKaoQinFragment;
import com.yilong.viewpageranimation.transformer.TimeAxisTransformer;
import com.yilong.viewpageranimation.view.AttendGrowthViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements AttendGrowthViewPager.AttendGrowthListener, ViewPager.OnPageChangeListener {

    private AttendGrowthViewPager viewpager;
    private List<BaseKaoQinFragment> fragments = new ArrayList<>();
    private KaoQinViewPageAdapter adapter;
    private TimeAxisTransformer timeAxisTransformer;

    private boolean flag = true;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        viewpager = findViewById(R.id.viewpager);

        viewpager.setOnPageChangeListener(this);
        viewpager.setVisibility(View.INVISIBLE);
        timeAxisTransformer = new TimeAxisTransformer(this);
        viewpager.setOffscreenPageLimit(10);
        fragments.add(new AttendGrowthFragment1());
        fragments.add(new AttendGrowthFragment2());
        fragments.add(new AttendGrowthFragment3());
        fragments.add(new AttendGrowthFragment4());
        fragments.add(new AttendGrowthFragment5());
        timeAxisTransformer.setCount(fragments.size());
        adapter = new KaoQinViewPageAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);
        viewpager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        viewpager.setAttendGrowthListener(this);
    }

    @Override
    public void afterOnLayout() {
        if (flag) {
            flag = false;
            viewpager.setCurrentItem(fragments.size() - 1);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (viewpager != null) {
                        viewpager.setVisibility(View.VISIBLE);
                    }
                }
            }, 400);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (timeAxisTransformer != null) {
            final int scrollX = viewpager.getScrollX();
            final int childCount = viewpager.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = viewpager.getChildAt(i);
                Log.e("zzzzzzz", "position =  " + i + "     child.getLeft() = " + child.getLeft() + "   scrollX = " + scrollX);
                timeAxisTransformer.transformPage(i, child, scrollX);
            }
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
