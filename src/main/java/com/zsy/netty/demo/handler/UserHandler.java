package com.zsy.netty.demo.handler;

import com.zsy.netty.demo.User;
import com.zsy.netty.demo.core.Response;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * Created by Lidd on 2018/3/25.
 */
@Component
public class UserHandler implements Handler<User>{

    public Response handle(User user) {
        return null;
    }
}
