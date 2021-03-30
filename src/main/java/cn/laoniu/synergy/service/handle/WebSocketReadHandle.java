package cn.laoniu.synergy.service.handle;

import io.netty.channel.ChannelHandlerContext;

/**
 * @description:
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 6:26 下午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 6:26 下午
 * @updateRemark:
 * @version: 1.0
 **/
public interface WebSocketReadHandle {

    void handle(ChannelHandlerContext ctx, Object msg) throws Exception;
}
