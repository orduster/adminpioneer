package cn.edu.nchu.adminpioneer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("cn.edu.nchu.adminpioneer.mapper")
@SpringBootApplication
public class AdminpioneerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AdminpioneerApplication.class, args);
    }

    //为了打包springboot项目
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(AdminpioneerApplication.class);
    }
}
