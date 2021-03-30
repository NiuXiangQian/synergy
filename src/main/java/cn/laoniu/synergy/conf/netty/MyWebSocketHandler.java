package cn.laoniu.synergy.conf.netty;

import cn.laoniu.synergy.service.handle.SelectHandle;
import cn.laoniu.synergy.service.handle.WebSocketReadHandle;
import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/***
 *
 * @author nxq email: niuxiangqian163@163.com
 * @version 1.0
 * @since 2021/3/30 4:47 下午
 **/
@Component //接入spring管理
@ChannelHandler.Sharable
public class MyWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Autowired
    private SelectHandle selectHandle;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端建立连接，通道开启！");
        //添加到channelGroup通道组
        MyChannelHandlerPool.channelGroup.add(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("与客户端断开连接，通道关闭！");
        MyChannelHandlerPool.unBindGroupChannel(ctx.channel());
        MyChannelHandlerPool.channelGroup.remove(ctx.channel());

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //选择性处理
        selectHandle.handle(ctx, msg);
        super.channelRead(ctx, msg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {

    }

}

