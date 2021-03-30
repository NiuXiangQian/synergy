package cn.laoniu.synergy.service.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/***
 *
 * @author nxq email: niuxiangqian163@163.com
 * @version 1.0
 * @since 2021/3/30 4:47 下午
 **/
public interface ContentHandle {
    void handle(ChannelHandlerContext ctx, TextWebSocketFrame textWebSocketFrame) throws Exception;

}
