package cn.laoniu.synergy.configurer.netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/***
 *
 * @author nxq email: niuxiangqian163@163.com
 * @version 1.0
 * @since 2021/3/30 5:16 下午
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
