package cn.laoniu.synergy.configurer.netty.bean;

import java.nio.channels.Channel;

/***
 * channel通道绑定的属性bean
 * @author niuxiangqian
 * @version 1.0
 * @since 2021/4/8 5:06 下午
 **/
public class ChannelAttrBean {
    /**
     * 当前通道
     */
    private Channel channel;
    /**
     * 分组的gid
     */
    private String gid;
    /**
     * 该通道的用户名
     */
    private String username;
    /**
     * 该通道所渲染的颜色颜色
     */
    private String color;
    /**
     * 用户的token
     */
    private String token;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
