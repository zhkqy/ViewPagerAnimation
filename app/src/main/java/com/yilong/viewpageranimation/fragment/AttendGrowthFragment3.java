package com.yilong.viewpageranimation.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yilong.viewpageranimation.R;

public class AttendGrowthFragment3 extends BaseKaoQinFragment {
    private View rootView;// 缓存Fragment view


    public AttendGrowthFragment3() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.attend_growth_fragment3, container,
                    false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public String getTitle() {
        return null;
    }


}
