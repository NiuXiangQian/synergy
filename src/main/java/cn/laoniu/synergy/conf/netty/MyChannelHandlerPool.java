package cn.laoniu.synergy.conf.netty;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 9:21 上午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 9:21 上午
 * @updateRemark:
 * @version: 1.0
 **/
public class MyChannelHandlerPool {
    public MyChannelHandlerPool() {
    }

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //此处设置群组的id与对应Channel的管理
    private static Map<String, Set<Channel>> GroupChannel = new ConcurrentHashMap<>();
    //此处设置Channel的扩展属性
    public static Map<Channel, String> Channel_ATTR = new ConcurrentHashMap<>();


    /***
     * 绑定群组与channel
     */
    public static void bindGroupChannel(String gId, Channel channel) {
        System.out.println("gId = " + gId);
        Set<Channel> channelSet = GroupChannel.get(gId);
        if (channelSet == null) {
            channelSet = new HashSet<>();
        }
        channelSet.add(channel);
        GroupChannel.put(gId, channelSet);
    }

    public static void unBindGroupChannel(Channel channel) {
        String gid = Channel_ATTR.get(channel);
        Set<Channel> channelSet = GroupChannel.get(gid);
        channelSet.remove(channel);
    }

    /***
     * 取消绑定群组与channel
     */
    public static boolean contains(String gId, Channel channel) {
        Set<Channel> channelSet = GroupChannel.get(gId);
        if (channelSet == null) {
            return false;
        }
        return channelSet.contains(channel);
    }
}
