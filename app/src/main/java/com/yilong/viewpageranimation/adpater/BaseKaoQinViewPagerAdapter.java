package com.yilong.viewpageranimation.adpater;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;

import com.yilong.viewpageranimation.fragment.BaseKaoQinFragment;

public abstract class BaseKaoQinViewPagerAdapter extends PagerAdapter {


    public BaseKaoQinViewPagerAdapter(FragmentManager fm) {
    }

    @Override
    public int getCount() {
        return 0;
    }

    public abstract BaseKaoQinFragment getFragment(int position);

}