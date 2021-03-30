package cn.laoniu.synergy.conf.netty;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 5:16 下午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 5:16 下午
 * @updateRemark:
 * @vrsion: 1.0
 **/
@Component
public class NettyInit implements CommandLineRunner {
    @Autowired
    private NettyServer nettyServer;


    public void init() {
        try {
            nettyServer.start();
            //new NettyServer(12345).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run(String... args) throws Exception {
        init();
    }
}
