package cn.laoniu.synergy;

import cn.laoniu.synergy.conf.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SynergyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SynergyApplication.class, args);
        try {
            new NettyServer(12345).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
