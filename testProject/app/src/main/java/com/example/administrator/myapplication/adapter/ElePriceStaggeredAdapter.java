package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.bean.ElePriceTableModel;

import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */

public class ElePriceStaggeredAdapter extends RecyclerView.Adapter<ElePriceStaggeredAdapter.ViewHolder> {
    private Context mContext;
    private List<ElePriceTableModel> mData;
    private int mColumn;

    public ElePriceStaggeredAdapter(Context context, List<ElePriceTableModel> data) {
        mContext = context;
        mData = data;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_elec_price, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ElePriceTableModel item = mData.get(position);
        holder.mContent.setText(item.getContent());
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder.mContent.getLayoutParams();

        if (item.getHeightMultiple() == -1) { //表头
            lp.height = mContext.getResources().getDimensionPixelOffset(R.dimen.height_50dp);
            lp.rightMargin = (position + 1 == getColumn()) ? 0 : mContext.getResources().getDimensionPixelOffset(R.dimen.height_1dp);
            holder.mContent.setLayoutParams(lp);
//            holder.mContent.setTextColor(mContext.getResources().getColor(R.color.color_999));
        } else {
            if (item.getHeightMultiple() > 1) {
                lp.height = item.getHeightMultiple() * mContext.getResources().getDimensionPixelOffset(R.dimen.height_35dp)
                        + (item.getHeightMultiple() - 1) * mContext.getResources().getDimensionPixelOffset(R.dimen.height_1dp);
            } else {
                lp.height = mContext.getResources().getDimensionPixelOffset(R.dimen.height_35dp);
            }
            lp.rightMargin = item.isHighlight() ? 0 : mContext.getResources().getDimensionPixelOffset(R.dimen.height_1dp);
            holder.mContent.setLayoutParams(lp);
//            holder.mContent.setTextColor(mContext.getResources().getColor(item.isHighlight() ? R.color.common_blue : R.color.text_black_standard));
        }
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mContent;

        public ViewHolder(View view) {
            super(view);
            mContent = (TextView) view.findViewById(R.id.text_content);
        }
    }

    public List<ElePriceTableModel> getData() {
        return mData;
    }

    public Context getContext() {
        return mContext;
    }

    public int getColumn() {
        return mColumn;
    }

    public void setColumn(int column) {
        mColumn = column;
    }
}
