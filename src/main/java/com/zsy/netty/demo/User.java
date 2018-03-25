package com.zsy.netty.demo;

/**
 * Created by Lidd on 2018/3/24.
 */
public class User extends Message {
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String type() {
        return "user";
    }
}
