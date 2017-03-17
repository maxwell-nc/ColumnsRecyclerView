package com.github.maxwell.nc.library.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.github.maxwell.nc.library.R;
import com.github.maxwell.nc.library.adapter.ColumnsRecyclerViewAdapter;

/**
 * 多列列表
 */
public class ColumnsRecyclerView extends LinearLayout {

    private ColumnsRecyclerViewAdapter mAdapter;

    public ColumnsRecyclerView(Context context) {
        super(context);
        initLayout();
    }

    public ColumnsRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLayout();
    }

    public ColumnsRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout();
    }

    /**
     * 设置数据适配器
     */
    public void setAdapter(ColumnsRecyclerViewAdapter adapter) {
        this.mAdapter = adapter;
        initData();
    }

    private void initLayout() {
        inflate(getContext(), R.layout.layout_columns_recycler_view, this);
    }

    private void initData() {

        if (mAdapter == null) {
            return;
        }

        Context context = getContext();

        View topLeftView = mAdapter.getTopLeftView();
        FrameLayout tlContainer = (FrameLayout) findViewById(R.id.container_tl);
        tlContainer.addView(topLeftView);

        View topRightView = mAdapter.getTopRightView();
        LinkedHorizontalScrollView trContainer = (LinkedHorizontalScrollView) findViewById(R.id.container_tr);
        trContainer.addView(topRightView);

        final RecyclerView rvLeft = (RecyclerView) findViewById(R.id.rv_left);
        LinkedHorizontalScrollView brContainer = (LinkedHorizontalScrollView) findViewById(R.id.container_br);
        final RecyclerView rvRight = (RecyclerView) brContainer.findViewById(R.id.rv_right);

        //绑定联动View
        trContainer.setLinkedView(brContainer);
        brContainer.setLinkedView(trContainer);

        rvLeft.setNestedScrollingEnabled(false);
        rvRight.setNestedScrollingEnabled(false);

        rvLeft.setLayoutManager(new LinearLayoutManager(context));
        rvRight.setLayoutManager(new LinearLayoutManager(context));

        rvLeft.setAdapter(new LeftAdapter(mAdapter));
        rvRight.setAdapter(new RightAdapter(mAdapter));

    }


    private class LeftAdapter extends RecyclerView.Adapter {

        private ColumnsRecyclerViewAdapter mAdapter;

        private LeftAdapter(ColumnsRecyclerViewAdapter adapter) {
            mAdapter = adapter;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return mAdapter.onCreateLeftHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            mAdapter.onBindLeftHolder(holder, position);
        }

        @Override
        public int getItemCount() {
            return mAdapter.getItemCount();
        }

    }

    private class RightAdapter extends RecyclerView.Adapter {

        private ColumnsRecyclerViewAdapter mAdapter;

        private RightAdapter(ColumnsRecyclerViewAdapter adapter) {
            mAdapter = adapter;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return mAdapter.onCreateRightHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            mAdapter.onBindRightHolder(holder, position);
        }

        @Override
        public int getItemCount() {
            return mAdapter.getItemCount();
        }

    }

}
