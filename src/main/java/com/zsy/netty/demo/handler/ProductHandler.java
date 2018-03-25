package com.zsy.netty.demo.handler;

import com.zsy.netty.demo.Product;
import com.zsy.netty.demo.core.Response;
import org.springframework.stereotype.Component;

/**
 * Created by Lidd on 2018/3/25.
 */
@Component
public class ProductHandler implements  Handler<Product>{

    public Response handle(Product product) {
        return null;
    }
}
