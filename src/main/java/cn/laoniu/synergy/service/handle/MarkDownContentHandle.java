package cn.laoniu.synergy.service.handle;

import cn.laoniu.synergy.configurer.netty.ChannelHandlerPool;
import cn.laoniu.synergy.service.storage.DocStorage;
import cn.laoniu.synergy.service.storage.model.DocModel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;


/***
 * todo markdown考虑更换 ['https://prosemirror.xheldon.com/',]
 * @author nxq email: niuxiangqian163@163.com
 * @version 1.0
 * @since 2021/3/30 6:35 下午
 **/
@Component
public class MarkDownContentHandle implements ContentHandle {
    @Autowired
    private DocStorage docStorage;

    @Override
    public void handle(ChannelHandlerContext ctx, TextWebSocketFrame frame) throws Exception {
        // 正常的TEXT消息类型
        String gId = ChannelHandlerPool.Channel_ATTR.get(ctx.channel());
        String data = frame.text();
        DocModel docModel = docStorage.get(gId);
        docModel.setData(data);
        System.out.println(data);
        //发送至分组
        sendToGroup(gId, data, ctx.channel());
    }

    /***
     * 发送至指定分组
     * @author nxq
     * @param gId:
     * @param message:
     * @param exclude:排除当前channel
     *
     */
    private void sendToGroup(String gId, String message, Channel exclude) {
        Set<Channel> groupChanel = ChannelHandlerPool.getGroupChanel(gId);
        System.out.println(groupChanel.size());
        for (Channel channel : groupChanel) {
            if (channel == exclude) continue;
            channel.writeAndFlush(new TextWebSocketFrame(message));
        }

//        ChannelHandlerPool.channelGroup.writeAndFlush(
//                new TextWebSocketFrame(message), channel -> ChannelHandlerPool.contains(gId, channel));

    }
}
