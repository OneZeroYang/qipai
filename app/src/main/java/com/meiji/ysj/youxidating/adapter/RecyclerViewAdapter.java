package com.meiji.ysj.youxidating.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.meiji.yangshijie.login.R;


/**
  *  描述：RecyclerView 自定义适配器
  *  时间：2018/8/10 13:23
  **/
public abstract class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    private Context context;
    private int coun;


    public RecyclerViewAdapter(Context context,int coun){
        this.context=context;
        this.coun=coun;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = setView(parent, viewType);
        return new MyHolder(view);
    }

    protected abstract View setView(View parent, int viewType);

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        initViews(holder,position);





    }

    protected abstract void initViews(MyHolder holder, int position);

    @Override
    public int getItemCount() {
        return coun;
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        public TextView textView1 ;
        public TextView textView2 ;
        public RelativeLayout news_list_rl;


        public MyHolder(View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.news_list_tv1);
            textView2=itemView.findViewById(R.id.news_list_tv2);
            news_list_rl=itemView.findViewById(R.id.news_list_rl);

        }
    }



}
