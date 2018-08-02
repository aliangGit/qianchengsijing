package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.administrator.myapplication.adapter.ElePriceStaggeredAdapter;
import com.example.administrator.myapplication.bean.ElePriceTableModel;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity
{
    private RecyclerView mTableContent;
    private ElePriceStaggeredAdapter mStaggeredAdapter;
    List<ElePriceTableModel> mData=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        init();
    }


    private void init() {
        List<String> mTitleST=new ArrayList<>();
        mTitleST.add("周期");
        mTitleST.add("分时");
        mTitleST.add("阶梯/n(度/户-月)");
        mTitleST.add("电价（元/度）");
        mData.clear();
        for (String resId : mTitleST) { //表头数据
            mData.add(new ElePriceTableModel(resId, -1));
        }
        mData.add(new ElePriceTableModel("1~6月", 4));
        mData.add(new ElePriceTableModel("0~12", 2));
        mData.add(new ElePriceTableModel("0~10", 1));
        mData.add(new ElePriceTableModel("0.92", 1, true));
        mData.add(new ElePriceTableModel("10~100", 1));
        mData.add(new ElePriceTableModel("0.83", 1, true));
        mData.add(new ElePriceTableModel("12~24", 2));
        mData.add(new ElePriceTableModel("0~10", 1));
        mData.add(new ElePriceTableModel("0.99", 1, true));
        mData.add(new ElePriceTableModel("10~100", 1));
        mData.add(new ElePriceTableModel("1.12", 1, true));
        mData.add(new ElePriceTableModel("7~12月", 4));
        mData.add(new ElePriceTableModel("0~12", 2));
        mData.add(new ElePriceTableModel("0~10", 1));
        mData.add(new ElePriceTableModel("0.93", 1, true));
        mData.add(new ElePriceTableModel("10~100", 1));
        mData.add(new ElePriceTableModel("0.83", 1, true));
        mData.add(new ElePriceTableModel("12~24", 2));
        mData.add(new ElePriceTableModel("0~100", 1));
        mData.add(new ElePriceTableModel("1.01", 1, true));
        mData.add(new ElePriceTableModel("10~100", 1));
        mData.add(new ElePriceTableModel("1.17", 1, true));
        mStaggeredAdapter = new ElePriceStaggeredAdapter(this, mData);
        mTableContent = (RecyclerView) findViewById(R.id.price_table_content);
        mTableContent.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        mStaggeredAdapter.setColumn(4);
        mTableContent.setAdapter(mStaggeredAdapter);
        mTableContent.setHasFixedSize(true);
    }
}
