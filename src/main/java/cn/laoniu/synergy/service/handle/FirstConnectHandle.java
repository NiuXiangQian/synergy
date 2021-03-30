package cn.laoniu.synergy.service.handle;

import cn.laoniu.synergy.conf.netty.MyChannelHandlerPool;
import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/***
 * 首次连接
 * @author nxq email: niuxiangqian163@163.com
 * @version 1.0
 * @since 2021/3/30 6:23 下午
 **/

@Component
public class FirstConnectHandle implements WebSocketReadHandle {

    public void handle(ChannelHandlerContext ctx, Object msg) throws Exception {
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
    }

    private static Map<String, String> getUrlParams(String url) {
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
