package com.yilong.viewpageranimation.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by chenlei on 2017/8/30.
 */
public class AttendGrowthViewPager extends ViewPager {

    AttendGrowthListener attendGrowthListener;


    public AttendGrowthViewPager(Context context) {
        super(context);
    }

    public AttendGrowthViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        if (attendGrowthListener != null) {
            attendGrowthListener.afterOnLayout();
        }
    }

    public AttendGrowthListener getAttendGrowthListener() {
        return attendGrowthListener;
    }

    public void setAttendGrowthListener(AttendGrowthListener attendGrowthListener) {
        this.attendGrowthListener = attendGrowthListener;
    }

    public interface AttendGrowthListener {

        public void afterOnLayout();

    }
}
