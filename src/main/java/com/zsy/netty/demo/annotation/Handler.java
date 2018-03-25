package com.zsy.netty.demo.annotation;

import com.zsy.netty.demo.User;
import org.springframework.stereotype.Component;

/**
 * Created by Lidd on 2018/3/25.
 */
@Component
public @interface Handler {
    Class<User> type();
}
