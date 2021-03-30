package cn.laoniu.synergy.service.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * @description:
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 6:21 下午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 6:21 下午
 * @updateRemark:
 * @version: 1.0
 **/
public interface ContentHandle {
    void handle(ChannelHandlerContext ctx, TextWebSocketFrame textWebSocketFrame) throws Exception;


}
