package cn.laoniu.synergy.conf;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 9:26 上午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 9:26 上午
 * @updateRemark:
 * @version: 1.0
 **/
public class MyWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

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
        //首次连接是FullHttpRequest，处理参数
        if (msg instanceof FullHttpRequest) {
            FullHttpRequest request = (FullHttpRequest) msg;
            String uri = request.uri();

            Map paramMap = getUrlParams(uri);
            System.out.println("接收到的参数是：" + JSON.toJSONString(paramMap));

            //记录群组
            Object gId = paramMap.get("gid");
            MyChannelHandlerPool.bindGroupChannel((String) gId, ctx.channel());
            MyChannelHandlerPool.Channel_ATTR.put(ctx.channel(), (String) gId);

            //如果url包含参数，需要处理
            if (uri.contains("?")) {
                String newUri = uri.substring(0, uri.indexOf("?"));
                System.out.println("newUri = " + newUri);
                request.setUri(newUri);
            }
            //接受消息
        } else if (msg instanceof TextWebSocketFrame) {

            //正常的TEXT消息类型
            TextWebSocketFrame frame = (TextWebSocketFrame) msg;
            String gId = MyChannelHandlerPool.Channel_ATTR.get(ctx.channel());
            //发送至分组
            sendToGroup(gId, frame.text());
        }
        super.channelRead(ctx, msg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {

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


    private static Map getUrlParams(String url) {
        Map<String, String> map = new HashMap<>();
        url = url.replace("?", ";");
        if (!url.contains(";")) {
            return map;
        }
        if (url.split(";").length > 0) {
            String[] arr = url.split(";")[1].split("&");
            for (String s : arr) {
                String key = s.split("=")[0];
                String value = s.split("=")[1];
                map.put(key, value);
            }
            return map;

        } else {
            return map;
        }
    }
}

