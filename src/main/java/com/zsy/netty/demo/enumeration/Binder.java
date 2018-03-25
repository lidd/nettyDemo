package com.zsy.netty.demo.enumeration;

import com.zsy.netty.demo.Product;
import com.zsy.netty.demo.User;
import com.zsy.netty.demo.handler.ProductHandler;
import com.zsy.netty.demo.handler.UserHandler;

/**
 * Created by Lidd on 2018/3/25.
 */
public enum Binder {

    USER("user",User.class,UserHandler.class),
    PROD("product",Product.class,ProductHandler.class);

    private String type;
    private Class msgClass;
    private Class handlerClass;

    Binder(String type, Class msgClass, Class handlerClass) {
        this.type = type;
        this.msgClass = msgClass;
        this.handlerClass = handlerClass;
    }

    public static Binder getBinder(String type){
        for (Binder binder : values()) {
            if (binder.getType().equals(type)){
                return binder;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public Class getMsgClass() {
        return msgClass;
    }

    public Class getHandlerClass() {
        return handlerClass;
    }
}
