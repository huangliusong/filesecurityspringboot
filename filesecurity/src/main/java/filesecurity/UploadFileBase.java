package filesecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huangliusong
 * @since 2019/7/24
 * {@link LoggerFactory}
 */
public class UploadFileBase {
    private static final Logger logger=LoggerFactory.getLogger(UploadFileBase.class);

    /**
     * Upload suffix whitelist
     */
    private String uploadPrefixWhiteList;

    /**
     * Upload suffix blacklist
     */
    private String uploadPrefixBlackList;

    /**
     * Upload a file MIME type whitelist
     */
    private String uploadMIMEWhiteList;

    /**
     * Upload file MIME type blacklist
     */
    private String uploadMimeBlackList;

    /**
     * File Hash value validation
     */
    private String hashCodeValidate;

    public void checkFile(){

    }

}
