package com.meiji.ysj.youxidating.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.View.BaesDialog;
import com.meiji.ysj.youxidating.RecyclerViewAdapter;
import com.meiji.ysj.youxidating.utils.DialogUtils;

/**
  *  描述：消息
  *  时间：2018/8/10 11:36
  **/

public class NewsDialog extends BaesDialog implements View.OnClickListener {
    private ImageView btNewsXx;
    private RecyclerView rlvNewsList;
    private RecyclerViewAdapter adapter;





    private Context context;
    public NewsDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public NewsDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected NewsDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected int setView() {
        return R.layout.news_dialog;
    }

    @Override
    protected void init() {
        btNewsXx = (ImageView) findViewById(R.id.bt_news_xx);
        btNewsXx.setOnClickListener(this);
        rlvNewsList = (RecyclerView) findViewById(R.id.rlv_news_list);
//        adapter=new RecyclerViewAdapter(context,0) {
//            @Override
//            protected View setView(View parent, int viewType) {
//
//                return null;
//            }
//
//            @Override
//            protected void initViews(RecyclerViewAdapter.MyHolder holder, int position) {
//
//            }
//        };


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_news_xx://关闭
                this.dismiss();
                break;
        }
    }

    public static void Show(Context context){
        NewsDialog newsDialog=new NewsDialog(context);
        DialogUtils.Show(newsDialog);
    }
}
