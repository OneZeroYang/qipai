package com.meiji.ysj.youxidating.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.meiji.yangshijie.myapplication_test.R;
import com.meiji.yangshijie.myapplication_test.view.BaesDialog;
import com.meiji.utils.IsBeginSoundEffectUtils;
import com.meiji.ysj.youxidating.adapter.RecyclerViewAdapter;
import com.meiji.utils.DialogUtils;

/**
 * 描述：消息
 * 时间：2018/8/10 11:36
 **/

public class NewsDialog extends BaesDialog implements View.OnClickListener {
    private ImageView btNewsXx;
    private RecyclerView rlvNewsList;
    private RecyclerViewAdapter adapter;


    private Context context;

    public NewsDialog(@NonNull Context context) {
        super(context);
        this.context = context;
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


        initData();

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

    private void initData() {

        final String[] s1 = new String[10];
        final String[] s2 = new String[10];
        for (int a = 0; a < 10; a++) {
            s1[a] = "恭喜您成为代理";
            s2[a] = "2018.8.17-15:10";
        }


       final View view=null;
        adapter = new RecyclerViewAdapter(context, s1.length) {
            @Override
            protected View setView(View parent, int viewType) {
                LayoutInflater inflater = getLayoutInflater();
                final View inflate = inflater.inflate(R.layout.news_list_, null);
               // view=inflate;
                return inflate;
            }

            @Override
            protected void initViews(RecyclerViewAdapter.MyHolder holder, final int position) {

                holder.textView1.setText(s1[position]);
                holder.textView2.setText(s2[position]);

                holder.news_list_rl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //列表点击事件
                        IsBeginSoundEffectUtils.Begin(context);
                        MessageDetailsDialog.Show(context);

                    }
                });



            }
        };

        rlvNewsList.setAdapter(adapter);

        rlvNewsList.setLayoutManager(new LinearLayoutManager(context));


    }

    @Override
    public void onClick(View view) {
        IsBeginSoundEffectUtils.Begin(context);
        switch (view.getId()) {
            case R.id.bt_news_xx://关闭
                this.dismiss();
                break;
        }
    }

    public static void Show(Context context) {
        NewsDialog newsDialog = new NewsDialog(context);
        DialogUtils.Show(newsDialog);
    }
}
