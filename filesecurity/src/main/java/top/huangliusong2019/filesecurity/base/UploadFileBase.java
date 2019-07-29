package top.huangliusong2019.filesecurity.base;

import top.huangliusong2019.filesecurity.constant.ErrorCode;
import top.huangliusong2019.filesecurity.exception.FileSecurityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import top.huangliusong2019.filesecurity.util.HashValueUtils;

/**
 * @author huangliusong
 * @since 2019/7/24
 * {@link LoggerFactory}
 * {@link Logger}
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

    public UploadFileBase(String uploadPrefixWhiteList,
                          String uploadPrefixBlackList,
                          String uploadMIMEWhiteList,
                          String uploadMimeBlackList,
                          String hashCodeValidate) {
        this.uploadPrefixWhiteList = uploadPrefixWhiteList;
        this.uploadPrefixBlackList = uploadPrefixBlackList;
        this.uploadMIMEWhiteList = uploadMIMEWhiteList;
        this.uploadMimeBlackList = uploadMimeBlackList;
        this.hashCodeValidate = hashCodeValidate;
    }

    /**
     * check file
     *
     * @param contentType contentType
     * @param prefix      prefix
     * @param hashCode    hash value
     * @param fileBytes   file
     */
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
        logger.info("[File value of Hash code ]>>hashCodeValidate={}", hashCodeValidate);
        if (StringUtils.isEmpty(hashCode)) {
            logger.info("[HashCode Validate wasn't opening,passed]");
            return true;
        }
        logger.info("[Start Validate...]");
        //Calculate the file hash value
        String fileHashCode = HashValueUtils.getHashCode(fileBytes, hashCode);
        if (!(StringUtils.isEmpty(fileHashCode)) && fileHashCode.equals(hashCode)) {
            logger.info("[HashCode Validate was opening,passed]");
            return true;
        }
        logger.error("[HashCode Validate was Error]>>>Your HashCode is hashCode={},Calculate the file hash value was fileHashCode={}", hashCode, fileHashCode);
        return false;
    }

    /**
     * checking File's MIME
     *
     * @param contentType File's MIME type
     * @return or not
     */
    private boolean checkFileMIME(String contentType) {
        contentType = contentType.toLowerCase();

        //Black List
        logger.info("[File's MIME,Black List validation]>>contentType={}", contentType);
        String[] blackList = uploadMimeBlackList.split(",");
        for (String blackName : blackList) {
            if (contentType.equals(blackName)) {
                return false;
            }
        }
        //White List
        logger.info("[File's MIME,White List validation]>>contentType={}", contentType);
        String[] whiteList = uploadMIMEWhiteList.split(",");
        for (String whiteName : whiteList) {
            if (contentType.equals(whiteName)) {
                return true;
            }
        }
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
        if (!StringUtils.isEmpty(uploadPrefixBlackList)) {
            logger.info("[Your had config uploadPrefixBlackList]>>uploadPrefixBlackList={}", uploadPrefixBlackList);
            String[] blackList = uploadPrefixBlackList.split(",");
            for (String blackName : blackList) {
                if (prefix.equals(blackName)) {
                    return false;
                }
            }
        }
        //White List
        if (StringUtils.isEmpty(uploadPrefixWhiteList)) {
            logger.info("[Not config uploadPrefixWhiteList,please check your application.yml/application.properties]>>uploadPrefixWhiteList={}", uploadPrefixWhiteList);
            return true;
        }

        logger.info("[File's prefix,White List validation]>>prefix={}", prefix);
        String[] whiteList = uploadPrefixWhiteList.split(",");
        for (String whiteName : whiteList) {
            if (prefix.equals(whiteName)) {
                return true;
            }
        }
        return false;
    }


}
