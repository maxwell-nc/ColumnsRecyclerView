package com.github.maxwell.nc.library.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * 联动横向滚动View
 */
public class LinkedHorizontalScrollView extends HorizontalScrollView {

    private HorizontalScrollView mLinkedScrollView;

    public LinkedHorizontalScrollView(Context context) {
        super(context);
    }

    public LinkedHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinkedHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mLinkedScrollView != null) {
            mLinkedScrollView.scrollTo(l, t);
        }
    }

    public void setLinkedView(HorizontalScrollView scrollView) {
        mLinkedScrollView = scrollView;
    }
}
