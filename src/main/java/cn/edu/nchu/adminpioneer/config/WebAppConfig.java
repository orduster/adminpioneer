package cn.edu.nchu.adminpioneer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * 文件上传配置
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Value("${file.path}")
    private String filePath;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB，MB
        factory.setMaxFileSize("100MB");
        //设置总上传数据大小
        factory.setMaxRequestSize("100MB");
        return factory.createMultipartConfig();
    }

    // 访问图片方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = "file:" + filePath;//file:E:/files/
        /*以下两个为图片资源映射处理*/
        registry.addResourceHandler("/images/**").addResourceLocations(path);
        registry.addResourceHandler("/adminpioneer/images/**").addResourceLocations(path);
        registry.addResourceHandler("/adminpioneer/admin/images/**").addResourceLocations(path);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
