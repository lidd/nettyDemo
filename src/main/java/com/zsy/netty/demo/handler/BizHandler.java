package com.zsy.netty.demo.handler;

import com.alibaba.fastjson.JSONObject;
import com.zsy.netty.demo.Message;
import com.zsy.netty.demo.enumeration.Binder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Lidd on 2018/3/24.
 */
@Component
public class BizHandler extends ChannelInboundHandlerAdapter {

    @Resource
    private UserHandler userHandler;

    @Resource
    private ProductHandler productHandler;

    @Resource
    private ApplicationContext context;

    public Handler getHandler(String type) {
        Binder binder = Binder.getBinder(type);
        Handler handler = (Handler) context.getBean(binder.getHandlerClass());
        if (handler == null){
            return null;
        }
        return handler;
    }

}
