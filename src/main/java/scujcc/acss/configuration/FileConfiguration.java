package scujcc.acss.configuration;/**
 * @author CZM
 * @create 2018-10-20 下午 10:49
 */

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 *@ClassNmae FileConfiguration
 *@Description 上传文件的配置类
 *@Author CZM
 *@Date 2018/10/20 下午 10:49
 *@Version 1.0
 **/
public class FileConfiguration {
    @Bean
    /**
     * @Author CZM
     * @Description 配置上传文件的相关信息，如上传大小
     * @Date 下午 10:56 2018/10/20
     * @Param []
     * @return javax.servlet.MultipartConfigElement
     **/
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("1024MB");
        factory.setMaxRequestSize("20148MB");
        return factory.createMultipartConfig();
    }
}
