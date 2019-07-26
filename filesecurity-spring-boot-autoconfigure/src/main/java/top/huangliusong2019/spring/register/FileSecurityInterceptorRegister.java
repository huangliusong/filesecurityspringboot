package top.huangliusong2019.spring.register;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.huangliusong2019.spring.autoconfigure.FileSecurityProperties;
import top.huangliusong2019.spring.handler.FileSecurityInterceptor;

/**
 * FileSecurity AutoConfiguration
 *
 * @author huangliusong
 * @version 1.0.0
 * @since 2019/7/5
 * {@link WebMvcConfigurer}
 * {@link FileSecurityInterceptor}
 * {@link FileSecurityProperties}
 */
@Configuration
public class FileSecurityInterceptorRegister implements WebMvcConfigurer {

    /**
     * application.properties
     * key:value
     */
    @Autowired
    private FileSecurityProperties fileSecurityProperties;


    @Bean
    public FileSecurityInterceptor fileSecurityInterceptor() {
        return new FileSecurityInterceptor(fileSecurityProperties);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(fileSecurityInterceptor());
    }
}
