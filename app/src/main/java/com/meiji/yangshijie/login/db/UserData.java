package com.meiji.yangshijie.login.db;

import org.litepal.crud.DataSupport;

/**
  *  描述：数据库实体类
  *  时间：2018/8/2 9:50
  **/

public class UserData extends DataSupport {

    private int id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
