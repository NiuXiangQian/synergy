package cn.laoniu.synergy.configurer.netty;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/***
 *
 * @author nxq email: niuxiangqian163@163.com
 * @version 1.0
 * @since 2021/3/30 9:21 上午
 **/
public class ChannelHandlerPool {
    public ChannelHandlerPool() {
    }

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //此处设置群组的id与对应Channel的管理
    private static Map<String, Set<Channel>> GroupChannel = new ConcurrentHashMap<>();
    //此处设置Channel的扩展属性
    public static Map<Channel, String> Channel_ATTR = new ConcurrentHashMap<>();


    /***
      * 获取群组下的chanel
      * @author nxq
      * @param gid:
      * @return java.util.Set<io.netty.channel.Channel>
      */
    public static Set<Channel> getGroupChanel(String gid) {
        Set<Channel> channelSet = GroupChannel.get(gid);
        return channelSet == null ? new HashSet<>() : channelSet;
    }

    /***
     * 绑定群组与channel
     */
    public static void bindGroupChannel(String gId, Channel channel) {
        Set<Channel> channelSet = GroupChannel.get(gId);
        if (channelSet == null) {
            channelSet = new HashSet<>();
        }
        channelSet.add(channel);
        GroupChannel.put(gId, channelSet);
    }

    /***
     * 取消绑定群组与channel
     */
    public static void unBindGroupChannel(Channel channel) {
        String gid = Channel_ATTR.get(channel);
        Set<Channel> channelSet = GroupChannel.get(gid);
        channelSet.remove(channel);
    }


    public static boolean contains(String gId, Channel channel) {
        Set<Channel> channelSet = GroupChannel.get(gId);
        if (channelSet == null) {
            return false;
        }
        return channelSet.contains(channel);
    }
}
