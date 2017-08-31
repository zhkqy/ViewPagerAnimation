package com.yilong.viewpageranimation.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;

import com.yilong.viewpageranimation.fragment.BaseKaoQinFragment;

import java.util.List;

/**
 * Created by chenlei on 2017/5/24.
 */
public class KaoQinViewPageAdapter extends BaseKaoQinViewPagerAdapter {

    private List<BaseKaoQinFragment> fragments = null;

    private FragmentManager manager;

    public KaoQinViewPageAdapter(FragmentManager fm) {
        super(fm);
        manager = fm;
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    public BaseKaoQinFragment getFragment(int position) {
        return fragments.get(position);
    }

    public void setFragments(List<BaseKaoQinFragment> fragments) {
        this.fragments = fragments;
    }

//    @Override
//    public void restoreState(Parcelable arg0, ClassLoader arg1) {
//        //do nothing here! no call to super.restoreState(arg0, arg1);
//    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        if (position < fragments.size()) {
            container.removeView(fragments.get(position).getView());
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = fragments.get(position);
        if (!fragment.isAdded()) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.add(fragment, fragment.getClass().getSimpleName());
            ft.commitAllowingStateLoss();
            manager.executePendingTransactions();
        }
        if (null == fragment.getView().getParent()) {
            container.addView(fragment.getView());
        }
        return fragment.getView();
    }

    @Override
    public String getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
