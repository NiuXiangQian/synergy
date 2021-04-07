package cn.laoniu.synergy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties
public class SynergyApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SynergyApplication.class, args);
    }

}
