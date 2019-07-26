package top.huangliusong2019.spring.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Configuration properties for FileSecurityProperties.
 * @author huangliusong
 * @since 2019/7/5
 * {@link FileSecurityProperties}
 */
@Configuration
@EnableConfigurationProperties(FileSecurityProperties.class)
public class FileSecurityAutoConfiguration {
}
