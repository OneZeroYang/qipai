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
import com.meiji.ysj.youxidating.ui.DetailOfRechargeDialog;

import java.util.List;

import static com.meiji.utils.IsBeginSoundEffectUtils.Begin;


/**
  *  描述：充值记录适配器
  *  时间：2018/8/20 16:13
  **/
public class RechargeRecyclerViewAdapter extends RecyclerView.Adapter<RechargeRecyclerViewAdapter.MyHoder> {

    private Context context;
    private List<String[]> list;
    public RechargeRecyclerViewAdapter(Context context, List<String[]> list){

        this.context=context;
        this.list=list;
    }


    @NonNull
    @Override
    public MyHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View inflate = inflater.inflate(R.layout.recharge_list, null);
        return new MyHoder(inflate);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull MyHoder holder, int position) {
        if (list.get(1)[position].equals("充值失败!")){
            holder.tv2.setTextColor(context.getColor(R.color.recharge_list_tv));
        }
        holder.tv1.setText(list.get(0)[position]);
        holder.tv2.setText(list.get(1)[position]);
        holder.tv3.setText(list.get(2)[position]);

        holder.rl_recharge_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击事件

                Begin(context);
                DetailOfRechargeDialog.Show(context);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.get(0).length;
    }

    class MyHoder extends RecyclerView.ViewHolder {
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        private RelativeLayout rl_recharge_list;
        public MyHoder(View itemView) {
            super(itemView);

            tv1=itemView.findViewById(R.id.recharge_list_tv1);
            tv2=itemView.findViewById(R.id.recharge_list_tv2);
            tv3=itemView.findViewById(R.id.recharge_list_tv3);
            rl_recharge_list=itemView.findViewById(R.id.rl_recharge_list);

        }
    }

}
