package com.zsy.netty.demo;

import org.springframework.stereotype.Service;

/**
 * Created by Lidd on 2018/3/24.
 */
@Service
public class UserService {

    public void save(User user) {
        System.out.println("保存用户:" + user.getName());
    }
}
