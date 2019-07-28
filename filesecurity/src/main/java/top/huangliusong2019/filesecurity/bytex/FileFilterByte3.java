package top.huangliusong2019.filesecurity.bytex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * The file type is intercepted by six bytes
 * and the file type is determined by the file header
 *
 * @author huangliusong
 * @since 2019/7/20
 * {@link HashMap}
 */
public class FileFilterByte3 {
    private static final HashMap<String, String> HEADER_FILE_TYPES = new HashMap<String, String>();
    private static final Integer FILE_LENGTH = 4;

    /**
     * judge file type by Three bytes to judge
     */
    static {
        //images
        HEADER_FILE_TYPES.put("FFD8FF", "jpg");
        HEADER_FILE_TYPES.put("89504E47", "png");
        HEADER_FILE_TYPES.put("47494638", "gif");
        HEADER_FILE_TYPES.put("49492A00", "tif");
        HEADER_FILE_TYPES.put("424D", "bmp");
        //CAD
        HEADER_FILE_TYPES.put("41433130", "dwg");
        HEADER_FILE_TYPES.put("38425053", "psd");
        //日记本
        HEADER_FILE_TYPES.put("7B5C727466", "rtf");
        HEADER_FILE_TYPES.put("3C3F786D6C", "xml");
        HEADER_FILE_TYPES.put("68746D6C3E", "html");
        //email
        HEADER_FILE_TYPES.put("44656C69766572792D646174653A", "eml");
        HEADER_FILE_TYPES.put("D0CF11E0", "doc");
        HEADER_FILE_TYPES.put("5374616E64617264204A", "mdb");
        HEADER_FILE_TYPES.put("252150532D41646F6265", "ps");
        HEADER_FILE_TYPES.put("255044462D312E", "pdf");
        HEADER_FILE_TYPES.put("504B0304", "zip");
        HEADER_FILE_TYPES.put("52617221", "rar");
        HEADER_FILE_TYPES.put("57415645", "wav");
        HEADER_FILE_TYPES.put("41564920", "avi");
        HEADER_FILE_TYPES.put("2E524D46", "rm");
        HEADER_FILE_TYPES.put("000001BA", "mpg");
        HEADER_FILE_TYPES.put("000001B3", "mpg");
        HEADER_FILE_TYPES.put("6D6F6F76", "mov");
        HEADER_FILE_TYPES.put("3026B2758E66CF11", "asf");
        HEADER_FILE_TYPES.put("4D546864", "mid");
        HEADER_FILE_TYPES.put("1F8B08", "gz");
        HEADER_FILE_TYPES.put("", "");
    }


    /**
     * @param filePath filePath
     * @return String
     */
    public static String getFileType(String filePath) {
        return HEADER_FILE_TYPES.get(getFileHeader(filePath));
    }

    /**
     * 获取文件头信息
     *
     * @param filePath filePath
     * @return String
     */
    private static String getFileHeader(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || file.length() < FILE_LENGTH) {
            return "null";
        }
        FileInputStream is = null;
        String value = null;
        try {
            is = new FileInputStream(file);
            byte[] b = new byte[3];
            int result = is.read(b, 0, b.length);
            if (result == 1) {
                System.out.println(result);
            }
            value = bytesToHexString(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    private static String bytesToHexString(byte[] src) {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < src.length; i++) {
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }
}
