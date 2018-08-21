package com.meiji.ysj.youxidating.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.meiji.yangshijie.login.R;
import com.meiji.ysj.youxidating.ui.DetailsOfConsumptionDialog;

import java.util.List;
import java.util.logging.Handler;

import static com.meiji.utils.IsBeginSoundEffectUtils.Begin;

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
        LayoutInflater inflater=LayoutInflater.from(context);
        View inflate = inflater.inflate(R.layout.recordsofconsumption_list, null);
        return new MyHolder(inflate);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {



        if (list.get(1)[position].substring(1,2).equals("损")){
            holder.recordsListTv2.setTextColor(context.getColor(R.color.recharge_list_tv));
        }
        holder.recordsListTv1.setText(list.get(0)[position]);
        holder.recordsListTv2.setText(list.get(1)[position]);
        holder.recordsListTv3.setText(list.get(2)[position]);
        holder.records_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击事件
                Begin(context);
                DetailsOfConsumptionDialog.Show(context);



            }
        });



    }

    @Override
    public int getItemCount() {
        return list.get(0).length;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private TextView recordsListTv1;
        private TextView recordsListTv2;
        private TextView recordsListTv3;
        private RelativeLayout records_rl;


        public MyHolder(View itemView) {
            super(itemView);
            recordsListTv1 = itemView.findViewById(R.id.records_list_tv1);
            recordsListTv2 =itemView.findViewById(R.id.records_list_tv2);
            recordsListTv3 = itemView. findViewById(R.id.records_list_tv3);
            records_rl=itemView.findViewById(R.id.records_rl);
        }
    }
}
