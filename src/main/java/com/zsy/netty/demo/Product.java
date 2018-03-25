package com.zsy.netty.demo;

/**
 * Created by Lidd on 2018/3/24.
 */
public class Product extends Message {
    private int id;

    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String type() {
        return "product";
    }
}
