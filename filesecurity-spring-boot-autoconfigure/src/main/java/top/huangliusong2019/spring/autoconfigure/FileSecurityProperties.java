package top.huangliusong2019.spring.autoconfigure;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration properties for  FileSecurity.
 * <code>@PropertySource("classpath:application.yml")</code>
 *
 * @author huangliusong
 * @since 2019/7/5
 * {@link ConfigurationProperties}
 * {@link EnableAutoConfiguration Auto-configuration}
 * {@link Configuration}
 */
@Configuration
@ConfigurationProperties(prefix = FileSecurityProperties.FILE_SECURITY_PREFIX)
public class FileSecurityProperties {
    public static final String FILE_SECURITY_PREFIX = "file";

    /**
     * WhiteList
     */
    private String uploadPrefixWhiteList;

    /**
     * BlackList
     */
    private String uploadPrefixBlackList;

    public String getUploadPrefixWhiteList() {
        return uploadPrefixWhiteList;
    }

    public void setUploadPrefixWhiteList(String uploadPrefixWhiteList) {
        this.uploadPrefixWhiteList = uploadPrefixWhiteList;
    }

    public String getUploadPrefixBlackList() {
        return uploadPrefixBlackList;
    }

    public void setUploadPrefixBlackList(String uploadPrefixBlackList) {
        this.uploadPrefixBlackList = uploadPrefixBlackList;
    }

    @Override
    public String toString() {
        return "FileSecurityProperties{" +
                "uploadPrefixWhiteList='" + uploadPrefixWhiteList + '\'' +
                ", uploadPrefixBlackList='" + uploadPrefixBlackList + '\'' +
                '}';
    }
}
