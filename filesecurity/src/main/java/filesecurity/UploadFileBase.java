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

    public void checkFile(String contentType, String prefix, String hashCode, byte[] fileBytes) {
        logger.info("check file's MIME");
        if (!checkFileMIME(contentType)) {
            logger.error("[MIME of file type is not support]contentType={}", contentType);
            throw new FileSecurityException(ErrorCode.MIME_FILE_TYPE_ERROR);
        }

        logger.info("check file's prefix");
        if (!checkFilePreFix(prefix)) {
            logger.error("[MIME of file type is not support]>>prefix={}", prefix);
        }

        logger.info("check file's Hash value");
        if (!checkFileDigest(fileBytes, hashCode)) {
            logger.info("[Hash Value was patch]>>hashCode={}", hashCode);
        }

    }

    /**
     * checking File's digest
     *
     * @param fileBytes File byte[]
     * @param hashCode  Hash value
     * @return or not
     */
    private boolean checkFileDigest(byte[] fileBytes, String hashCode) {

        return false;
    }

    /**
     * checking File's MIME
     *
     * @param contentType File's MIME type
     * @return or not
     */
    private boolean checkFileMIME(String contentType) {

        return false;
    }

    /**
     * checking File's prefix
     *
     * @param prefix File's prefix
     * @return or not
     */
    private boolean checkFilePreFix(String prefix) {
        prefix = prefix.toLowerCase();

        //Black List
        logger.info("[File's prefix,Black List validation]>>prefix={}", prefix);
        String[] blackList = uploadPrefixBlackList.split(",");
        for (String blackName : blackList) {
            if (prefix.equals(blackName)) {
                return false;
            }
        }
        //White List
        logger.info("[File's prefix,White List validation]>>prefix={}", prefix);
        String[] whiteList = uploadPrefixBlackList.split(",");
        for (String whiteName : whiteList) {
            if (prefix.equals(whiteName)) {
                return true;
            }
        }
        return false;
    }


}
