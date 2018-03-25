package com.zsy.netty.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zsy.netty.demo.enumeration.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Lidd on 2018/3/24.
 */

@Component
public class MessageTypeFactory {

    @Resource
    private ApplicationContext context;

    public Message parse(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String type = jsonObject.get("type") + "";
        Binder binder = Binder.getBinder(type);
//        Message message = (Message) context.getBean(binder.getMsgClass());
        Message message = (Message) JSON.parseObject(json, binder.getMsgClass());
        if (message == null){
            return null;
        }
        return  message;
    }
}
