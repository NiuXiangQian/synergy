package cn.laoniu.synergy.service.handle;

import cn.laoniu.synergy.conf.netty.MyChannelHandlerPool;
import cn.laoniu.synergy.service.storage.DocStorage;
import cn.laoniu.synergy.service.storage.model.DocModel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 6:35 下午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 6:35 下午
 * @updateRemark:
 * @version: 1.0
 **/
@Component
public class MarkDownContentHandle implements ContentHandle {
    @Autowired
    private DocStorage docStorage;

    @Override
    public void handle(ChannelHandlerContext ctx, TextWebSocketFrame frame) throws Exception {
        //            //正常的TEXT消息类型
        String gId = MyChannelHandlerPool.Channel_ATTR.get(ctx.channel());
        String data = frame.text();
        DocModel docModel = docStorage.get(gId);
        docModel.setData(data);

        //发送至分组
        sendToGroup(gId, data);
    }

    /***
     * 发送至指定分组
     * @author nxq
     * @param gId:
     * @param message:
     * @return void
     */
    private void sendToGroup(String gId, String message) {

        MyChannelHandlerPool.channelGroup.writeAndFlush(
                new TextWebSocketFrame(message), channel -> MyChannelHandlerPool.contains(gId, channel));

    }
}
