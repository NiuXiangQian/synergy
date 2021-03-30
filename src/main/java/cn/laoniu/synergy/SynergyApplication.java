package cn.laoniu.synergy;

import cn.laoniu.synergy.conf.netty.NettyInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SynergyApplication {


    public static void main(String[] args) {
        SpringApplication.run(SynergyApplication.class, args);
    }

}
