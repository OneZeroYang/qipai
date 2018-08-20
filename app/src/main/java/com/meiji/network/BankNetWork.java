package com.meiji.network;

import com.meiji.Interface.NetworkCallk;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import org.json.JSONException;
import org.json.JSONObject;
import okhttp3.Call;
/**
  *  描述：银行卡识别工具类
  *  时间：2018/8/16 17:01
  **/
public class BankNetWork {



/**
  *  描述：银行名称查询
  *  时间：2018/8/16 17:51
  **/

    public static void getBank(String s, final NetworkCallk networkCallk){

        OkHttpUtils
                .get()
                .url(NetApi.BankApi+"?cardNo="+s+"&cardBinCheck=true")
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {


                        networkCallk.Onerror(e.toString());
                    }

                    @Override
                    public void onResponse(String response, int id) {

                        String json=NetApi.Bank;
                        String s1=null;
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String bank = jsonObject.optString("bank");
                            JSONObject jsonObject1=new JSONObject(json);
                            s1 = jsonObject1.optString(bank);

                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                        networkCallk.Onnormal(s1);
                    }


                });
    }





}
