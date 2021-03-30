package cn.laoniu.synergy.service.handle;

import io.netty.channel.ChannelHandlerContext;

/***
 *
 * @author nxq email: niuxiangqian163@163.com
 * @version 1.0
 * @since 2021/3/30 2021/3/30 6:26 下午
 **/

public interface WebSocketReadHandle {

    void handle(ChannelHandlerContext ctx, Object msg) throws Exception;
}
