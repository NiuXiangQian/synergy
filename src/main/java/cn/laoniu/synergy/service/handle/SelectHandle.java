package cn.laoniu.synergy.service.handle;

import cn.laoniu.synergy.conf.netty.MyChannelHandlerPool;
import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 选择处理器
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 6:25 下午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 6:25 下午
 * @updateRemark:
 * @version: 1.0
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
            //@todo 区分markdown excel word ppt

            contentHandle.handle(ctx, frame);
        }
    }


}
