package com.github.maxwell.nc.library.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * 多列列表数据适配器
 */
public abstract class ColumnsRecyclerViewAdapter<L extends RecyclerView.ViewHolder, R extends RecyclerView.ViewHolder> {

    public abstract View getTopLeftView();

    public abstract View getTopRightView();

    public abstract int getItemCount();

    public abstract L onCreateLeftHolder(ViewGroup parent, int viewType);

    public abstract void onBindLeftHolder(L holder, int position);

    public abstract R onCreateRightHolder(ViewGroup parent, int viewType);

    public abstract void onBindRightHolder(R holder, int position);

}
