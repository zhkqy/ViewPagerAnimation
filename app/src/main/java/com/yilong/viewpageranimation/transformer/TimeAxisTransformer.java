package com.yilong.viewpageranimation.transformer;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.yilong.viewpageranimation.utils.DisplayUtil;

public class TimeAxisTransformer {

    public int gap;
    private int screenWidth;

    private int count;
    float dis = 0;

    public TimeAxisTransformer(Context context) {
        this.gap = DisplayUtil.dipToPixels(context, 8);
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        screenWidth = wm.getDefaultDisplay().getWidth();
    }

    public void transformPage(int currentPostion, View view, int scrollX) {

        if (currentPostion == 0) {
            view.setTranslationX(scrollX);
        } else if (currentPostion > 0) {
            setPosition(currentPostion, screenWidth * (currentPostion - 1), screenWidth + screenWidth * (currentPostion - 1), scrollX, view);
        }
    }

    public void setPosition(int currPosition, int startP, int endP, int scrollX, View view) {

        if (scrollX <= startP) {
            dis = 0;//右边相对位置
        } else if (scrollX >= endP) {//左边相对位置
            int tranlW = (count - currPosition + 1 + (currPosition - 1)) * gap;
            dis = -(screenWidth - tranlW);
        } else {//计算滑动偏移量
            int tempW = endP - scrollX;
            float ratio = (float) (screenWidth - tempW) / (screenWidth);
            int tranlW = (count - currPosition + 1 + (currPosition - 1)) * gap;
            dis = -((screenWidth - tranlW) * ratio);
            Log.i("ttttwqwqw", "ratio = " + ratio);
        }
        Log.i("ttttwqwqw", "currPosition = " + currPosition + "   scrollX = " + scrollX + "    dis = " + dis + "    " +
                "startP = " + startP + "   endP =  " + endP);

//        dis向左偏移量
//        剩下的为右边相对位置
        view.setTranslationX(scrollX - ((count - currPosition) * gap) - (screenWidth * (currPosition - 1)) + dis);
    }

    public void setCount(int count) {
        this.count = count;
    }
}