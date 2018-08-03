package com.meiji.yangshijie.myapplication_test.db;


import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class UserdbUtils {
    /**
      *  描述：新增用户
      *  时间：2018/8/2 10:01
      **/

    public static boolean increasedb(String name,String password){
        UserData data=new UserData();
        data.setName(name);
        data.setPassword(password);
        return  data.save();
    }
/**
  *  描述：查询所用用户和密码
  *  时间：2018/8/2 10:11
  **/
    public static List<UserData> queryAll(){
        List<UserData> list=new ArrayList<>();
        list= DataSupport.findAll(UserData.class);
        return list;
    }
    /**
      *  描述：删除指定ID的用户
      *  时间：2018/8/2 10:17
      **/

    public static int delete(int id){
        int delete = DataSupport.delete(UserData.class, id);
        return delete;
    }
}
