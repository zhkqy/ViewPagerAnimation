package com.yilong.viewpageranimation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;

/**
 * Created by chenlei on 2017/5/31.
 */
public abstract class BaseKaoQinFragment extends Fragment {
    protected String title = "";
    protected String keyid = "";
    protected String index = "";
    protected int type = 0;

    public static int PAY_RECEIVER_PLAN = 1101;
    public static int PAY_RECEIVER_RECORD = 1102;
    public static int FA_PIAO_RECORD = 1103;


    public boolean isHaveSubFragment = false;

    public BaseKaoQinFragment() {

    }

    protected BaseKaoQinFragment(String title) {
        initData(title, "", "", 0);
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        this.setArguments(bundle);
    }

    protected BaseKaoQinFragment(String title, String keyid) {
        initData(title, keyid, "", 0);
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("keyid", keyid);
        this.setArguments(bundle);
    }


    protected BaseKaoQinFragment(String title, String keyid, int type) {
        initData(title, keyid, "", type);
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("keyid", keyid);
        bundle.putInt("type", type);
        this.setArguments(bundle);
    }


    public boolean isHaveSubFragment() {
        return isHaveSubFragment;
    }

    public void setHaveSubFragment(boolean haveSubFragment) {
        isHaveSubFragment = haveSubFragment;
        Bundle bundle = getArguments();
        bundle.putBoolean("havesub", isHaveSubFragment);
        setArguments(bundle);
    }

    protected BaseKaoQinFragment(String title, String keyid, String index) {
        initData(title, keyid, index, 0);
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("keyid", keyid);
        bundle.putString("index", index);
        this.setArguments(bundle);
    }

    protected BaseKaoQinFragment(String title, String keyid, String index, int type) {
        initData(title, keyid, index, type);
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("keyid", keyid);
        bundle.putString("index", index);
        bundle.putInt("type", type);
        this.setArguments(bundle);
    }

    public abstract String getTitle();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        if (b != null) {
            title = b.getString("title", "");
            keyid = b.getString("keyid", "");
            index = b.getString("index", "");
            type = b.getInt("type", 0);
            isHaveSubFragment = b.getBoolean("havesub", false);
        }
    }

    public void initData(String title, String keyid, String index, int type) {
        if (!TextUtils.isEmpty(title)) {
            this.title = title;
        }
        if (!TextUtils.isEmpty(keyid)) {
            this.keyid = keyid;
        }
        if (!TextUtils.isEmpty(index)) {
            this.index = index;
        }
        this.type = type;
    }

    public ViewPager getViewPager() {
        return null;
    }

    public void setPagerCurrentItem() {


    }
}
