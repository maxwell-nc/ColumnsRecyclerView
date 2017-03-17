package com.github.maxwell.nc.columnsrecyclerview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.maxwell.nc.library.adapter.ColumnsRecyclerViewAdapter;
import com.github.maxwell.nc.library.view.ColumnsRecyclerView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBody();
    }

    private void initBody() {
        ColumnsRecyclerView rvContainer = (ColumnsRecyclerView) findViewById(R.id.rv_container);
        rvContainer.setAdapter(new SampleAdapter(this));
    }

    private class SampleAdapter extends ColumnsRecyclerViewAdapter<SampleAdapter.LeftHolder, SampleAdapter.RightHolder> {

        private Context mContext;

        public SampleAdapter(Context context) {
            this.mContext = context;
        }

        @Override
        public View getTopLeftView() {
            return View.inflate(mContext, R.layout.layout_top_left, null);
        }

        @Override
        public View getTopRightView() {
            return View.inflate(mContext, R.layout.layout_top_right, null);
        }

        @Override
        public int getItemCount() {
            return 100;
        }

        @Override
        public LeftHolder onCreateLeftHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left, parent, false);
            return new LeftHolder(view);
        }

        @Override
        public void onBindLeftHolder(LeftHolder holder, int position) {
            holder.tvName.setText("列1行" + (position++));
            holder.tvName.setBackgroundResource(R.color.colorPrimary);
        }

        @Override
        public RightHolder onCreateRightHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_top_right, parent, false);
            return new RightHolder(view);
        }

        @Override
        public void onBindRightHolder(RightHolder holder, int position) {

        }


        class LeftHolder extends RecyclerView.ViewHolder {

            TextView tvName;

            public LeftHolder(View itemView) {
                super(itemView);
                tvName = (TextView) itemView.findViewById(R.id.tv_name);
            }

        }

        class RightHolder extends RecyclerView.ViewHolder {

            TextView tvCol1;
            TextView tvCol2;
            TextView tvCol3;
            TextView tvCol4;
            TextView tvCol5;
            TextView tvCol6;

            public RightHolder(View itemView) {
                super(itemView);
                tvCol1 = (TextView) itemView.findViewById(R.id.tv_col_1);
                tvCol2 = (TextView) itemView.findViewById(R.id.tv_col_2);
                tvCol3 = (TextView) itemView.findViewById(R.id.tv_col_3);
                tvCol4 = (TextView) itemView.findViewById(R.id.tv_col_4);
                tvCol5 = (TextView) itemView.findViewById(R.id.tv_col_5);
                tvCol6 = (TextView) itemView.findViewById(R.id.tv_col_6);
            }

        }

    }
}
