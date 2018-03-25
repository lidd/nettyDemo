package com.zsy.netty.demo.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zsy.netty.demo.Message;
import com.zsy.netty.demo.MessageTypeFactory;
import com.zsy.netty.demo.enumeration.Binder;
import com.zsy.netty.demo.handler.BizHandler;
import com.zsy.netty.demo.handler.Handler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lidd on 2018/3/24.
 */
@Component
public class
HeadTailDecoder extends ByteToMessageDecoder {

    private final String head = "@@";

    private final String tail = "|~|~~";

    @Resource
    private BizHandler handlerFactory;

    @Resource
    private ApplicationContext context;

    @Resource
    private MessageTypeFactory messageTypeFactory;

    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        StringBuilder msg = new StringBuilder();
        while (byteBuf.readableBytes() > 0) {
            msg.append((char) byteBuf.readByte());
            int headIdx = msg.indexOf(head);
            int tailIdx = msg.indexOf(tail, headIdx);
            if (headIdx != -1 && tailIdx != -1) {
                String json = msg.substring(headIdx + head.length(), tailIdx);
//                Message m = messageTypeFactory.parse(json);
//                Handler handler = handlerFactory.getHandler(m.type());
                JSONObject jsonObject = JSON.parseObject(json);
                String type = jsonObject.get("type") + "";
                Binder binder = Binder.getBinder(type);
                Class msgClass = binder.getMsgClass();
                Class handlerClass = binder.getHandlerClass();
                Message m = (Message) JSONObject.parseObject(json, msgClass);
                Handler handler = (Handler) context.getBean(handlerClass);
                handler.handle(m);
                break;
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
