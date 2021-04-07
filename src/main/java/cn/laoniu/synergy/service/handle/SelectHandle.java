package cn.laoniu.synergy.service.handle;

import cn.laoniu.synergy.common.constant.Constant;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 * 选择处理器
 * @author nxq email: niuxiangqian163@163.com
 * @version 1.0
 * @since 2021/3/30 6:25 下午
 **/

@Component
public class SelectHandle implements WebSocketReadHandle {

    @Autowired
    private FirstConnectHandle firstConnectHandle;
    @Autowired
    private MarkDownContentHandle contentHandle;

    @Override
    public void handle(ChannelHandlerContext ctx, Object msg) throws Exception {

        //首次连接是FullHttpRequest，处理参数
        if (msg instanceof FullHttpRequest) {
            firstConnectHandle.handle(ctx, msg);
            //接收消息
        } else if (msg instanceof TextWebSocketFrame) {
            TextWebSocketFrame frame = (TextWebSocketFrame) msg;
            //todo 区分markdown excel word ppt
            //心跳检查
            if (Constant.PING.equals(frame.text())) {
                return;
            }
            contentHandle.handle(ctx, frame);
        }
    }


}
