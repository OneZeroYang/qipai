package com.meiji.yangshijie.login.test;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.meiji.yangshijie.login.R;
import com.meiji.yangshijie.login.view.DialogView;
import com.meiji.yangshijie.login.view.Dialoglogin;
import com.meiji.ysj.youxidating.view.ParallelogramShape;
import com.meiji.ysj.youxidating.view.ShapeImageView;

/**
 * 描述：数据库测试activity
 * 时间：2018/8/2 10:20
 **/
public class TestDatabaseActivity extends AppCompatActivity {

    DialogView dialogView=null;

    private ShapeImageView shapeImageView1;
    private ShapeImageView shapeImageView2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_database);
        shapeImageView1=findViewById(R.id.image1);
        shapeImageView2=findViewById(R.id.image2);
        //创建一个平行四边形的shape
        ParallelogramShape shape = new ParallelogramShape();
        shape.setScale(1);
        ((ShapeImageView) findViewById(R.id.image1)).setShap(shape);




        ParallelogramShape shape1 = new ParallelogramShape();
        shape1.setScale(2);
        ((ShapeImageView) findViewById(R.id.image2)).setShap(shape1);



    }

    public void test(View view) {
        switch (view.getId()) {
            case R.id.button1:

                /**
                  *  描述：数据库测试
                  *  时间：2018/8/3 11:10
                  **/
//                boolean increasedb = UserdbUtils.increasedb("" + (int) (Math.random() * 10), "" + (int) (Math.random() * 10));
//                Log.i("日志", "test: " + increasedb);
                /**
                  *  描述：登录对话框测试
                  *  时间：2018/8/3 11:10
                  **/

//                dialogView=new DialogView(TestDatabaseActivity.this) {
//                    @Override
//                    protected View getView(LayoutInflater inflater) {
//                        View inflate = inflater.inflate(R.layout.dialog_login, null);
//                       // Button button1=inflate.findViewById(R.id.button1);
//                        Button button2=inflate.findViewById(R.id.button_1);
////                        button1.setOnClickListener(new View.OnClickListener() {
////                            @Override
////                            public void onClick(View view) {
////                                ToastUtils.showToast(getApplicationContext(),"wo1");
////                            }
////                        });
//
//                        button2.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                ToastUtils.showToast(getApplicationContext(),"wo2");
//                                if (dialogView!=null){
//                                    dialogView.Stop();
//                                    dialogView=null;
//                                    ShowNewDialog();
//                                }
//                                return;
//                            }
//                        });
//
//
//                        return inflate;
//
//                    }
//                };


                /**
                  *  描述：测试自定义对话框
                  *  时间：2018/8/3 16:03
                  **/

                Dialoglogin dialoglogin=new Dialoglogin(TestDatabaseActivity.this);
                dialoglogin.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialoglogin.show();







                break;
            case R.id.button2:

                /**
                  *  描述：数据库测试
                  *  时间：2018/8/3 11:15
                  **/
//
//                int delete = UserdbUtils.delete(1);
//                Log.i("日志", "test: " + delete);



                /**
                  *  描述：对话框隐藏测试
                  *  时间：2018/8/3 11:16
                  **/



                break;
            case R.id.button3:

//                List<UserData> list = UserdbUtils.queryAll();
//                for (int a = 0; a < list.size(); a++) {
//                    Log.i("日志", "test: name==" + list.get(a).getName() + "password==" + list.get(a).getPassword());
//                }

                break;
        }
    }

    private void ShowNewDialog() {



    }

}
