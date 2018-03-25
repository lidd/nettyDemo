package com.zsy.netty.demo.handler;

import com.zsy.netty.demo.Message;
import com.zsy.netty.demo.core.Response;

/**
 * Created by Lidd on 2018/3/25.
 */
public interface Handler<T extends Message>{

    public Response handle(T t);
}
