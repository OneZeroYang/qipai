package com.meiji.ysj.youxidating.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
  *  描述：消费记录适配器
  *  时间：2018/8/20 17:45
  **/
public class RecordsOfConsumptionApapter extends RecyclerView.Adapter<RecordsOfConsumptionApapter.MyHolder> {
    private Context context;
    private List<String[]> list;

    public RecordsOfConsumptionApapter(Context context,List<String[]> list){
        this.context=context;
        this.list=list;

    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.get(0).length;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
