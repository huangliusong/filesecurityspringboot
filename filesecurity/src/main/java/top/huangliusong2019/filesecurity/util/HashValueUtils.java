package top.huangliusong2019.filesecurity.util;

import org.apache.commons.codec.digest.DigestUtils;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

/**
 * Hash Value Utils
 *
 * @author huangliusong
 * @since 2019/7/29
 * {@link MessageDigest}
 * {@link DatatypeConverter}
 */
public class HashValueUtils {

    /**
     * Create MessageDigest by digestType
     *
     * @param digestType Hash Type
     * @return MessageDigest
     */
    public static MessageDigest getDigestType(String digestType) {
        MessageDigest messageDigest = null;
        switch (digestType) {
            case "MD5":
                messageDigest = DigestUtils.getMd5Digest();
                return messageDigest;
            case "SHA-1":
                messageDigest = DigestUtils.getMd5Digest();
                return messageDigest;
            case "SHA-256":
                messageDigest = DigestUtils.getSha256Digest();
                return messageDigest;
            case "SHA-384":
                messageDigest = DigestUtils.getSha384Digest();
                return messageDigest;
            case "SHA-512":
                messageDigest = DigestUtils.getSha512Digest();
                return messageDigest;
            default:
                messageDigest = DigestUtils.getMd5Digest();
                return messageDigest;
        }
    }

    /**
     * Get Hash Code by file
     *
     * @param fileBytes  byte of file
     * @param digestType digest type
     * @return HashCode of file
     */
    public static String getHashCode(byte[] fileBytes, String digestType) {
        MessageDigest messageDigest = getDigestType(digestType);
        messageDigest.update(fileBytes);
        byte[] digest = messageDigest.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
