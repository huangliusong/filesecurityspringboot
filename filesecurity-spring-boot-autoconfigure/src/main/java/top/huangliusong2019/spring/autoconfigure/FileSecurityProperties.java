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
    static final String FILE_SECURITY_PREFIX = "file";

    /**
     * Upload suffix whitelist
     */
    private String uploadSuffixWhiteList;
    /**
     * Upload suffix blacklist
     */
    private String uploadSuffixBlackList;
    /**
     * Upload a file, MIME type whitelist
     */
    private String uploadMIMEWhiteList;
    /**
     * Upload a file MIME, type blacklist
     */
    private String uploadMimeBlackList;
    /**
     * The  Hash of file  validate value.
     */
    private String hashCodeValidate;

    public static String getFileSecurityPrefix() {
        return FILE_SECURITY_PREFIX;
    }

    public String getUploadSuffixWhiteList() {
        return uploadSuffixWhiteList;
    }

    public void setUploadSuffixWhiteList(String uploadSuffixWhiteList) {
        this.uploadSuffixWhiteList = uploadSuffixWhiteList;
    }

    public String getUploadSuffixBlackList() {
        return uploadSuffixBlackList;
    }

    public void setUploadSuffixBlackList(String uploadSuffixBlackList) {
        this.uploadSuffixBlackList = uploadSuffixBlackList;
    }

    public String getUploadMIMEWhiteList() {
        return uploadMIMEWhiteList;
    }

    public void setUploadMIMEWhiteList(String uploadMIMEWhiteList) {
        this.uploadMIMEWhiteList = uploadMIMEWhiteList;
    }

    public String getUploadMimeBlackList() {
        return uploadMimeBlackList;
    }

    public void setUploadMimeBlackList(String uploadMimeBlackList) {
        this.uploadMimeBlackList = uploadMimeBlackList;
    }

    public String getHashCodeValidate() {
        return hashCodeValidate;
    }

    public void setHashCodeValidate(String hashCodeValidate) {
        this.hashCodeValidate = hashCodeValidate;
    }

    @Override
    public String toString() {
        return "FileSecurityProperties{" +
                "uploadSuffixWhiteList='" + uploadSuffixWhiteList + '\'' +
                ", uploadSuffixBlackList='" + uploadSuffixBlackList + '\'' +
                ", uploadMIMEWhiteList='" + uploadMIMEWhiteList + '\'' +
                ", uploadMimeBlackList='" + uploadMimeBlackList + '\'' +
                ", hashCodeValidate='" + hashCodeValidate + '\'' +
                '}';
    }
}
