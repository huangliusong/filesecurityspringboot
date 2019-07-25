package filesecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huangliusong
 * @since 2019/7/24
 * {@link LoggerFactory}
 */
public class UploadFileBase {
    private static final Logger logger = LoggerFactory.getLogger(UploadFileBase.class);

    /**
     * Upload suffix whitelist
     */
    private String uploadPrefixWhiteList;

    /**
     * Upload suffix blacklist
     */
    private String uploadPrefixBlackList;

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

    public void checkFile(String contentType) {
        logger.info("check file start");
        if(!checkFileMIME(contentType)){

        }
    }

    private boolean checkFileMIME(String contentType){
        return false;
    }

}
