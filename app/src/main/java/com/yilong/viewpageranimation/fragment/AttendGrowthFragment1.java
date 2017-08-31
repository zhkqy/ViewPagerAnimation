package com.yilong.viewpageranimation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yilong.viewpageranimation.R;


public class AttendGrowthFragment1 extends BaseKaoQinFragment {
    private View rootView;// 缓存Fragment view

    public AttendGrowthFragment1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.attend_growth_fragment1, container,
                    false);
        }
        return rootView;
    }

    @Override
    public String getTitle() {
        return null;
    }


}
