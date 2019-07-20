package filesecurity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * The file type is intercepted by the 10-byte judgment and
 * the file type is determined by the file header
 *
 * @author huangliusong
 * @since 2019/7/20
 * {@link }
 */
public class FileFilterByte10 {
    private static final HashMap<String, String> mFileTypes;

    static {
        mFileTypes = new HashMap<String, String>();
    }

    // judge file type by file header content by 10个字节判断
    static {
        //JPEG (jpg)
        mFileTypes.put("ffd8ffe000104a464946", "jpg");
        //PNG (png)
        mFileTypes.put("89504e470d0a1a0a0000", "png");
        //GIF (gif)
        mFileTypes.put("47494638396126026f01", "gif");
        //TIFF (tif)
        mFileTypes.put("49492a00227105008037", "tif");
        //16色位图(bmp)
        mFileTypes.put("424d228c010000000000", "bmp");
        //24位位图(bmp)
        mFileTypes.put("424d8240090000000000", "bmp");
        //256色位图(bmp)
        mFileTypes.put("424d8e1b030000000000", "bmp");
        //CAD (dwg)
        mFileTypes.put("41433130313500000000", "dwg");
        //HTML (html)
        mFileTypes.put("3c21444f435459504520", "html");
        //HTM (htm)
        mFileTypes.put("3c21646f637479706520", "htm");
        //css
        mFileTypes.put("48544d4c207b0d0a0942", "css");
        //js
        mFileTypes.put("696b2e71623d696b2e71", "js");
        //Rich Text Format (rtf)
        mFileTypes.put("7b5c727466315c616e73", "rtf");
        //Photoshop (psd)
        mFileTypes.put("38425053000100000000", "psd");
        //Email [Outlook Express 6] (eml)
        mFileTypes.put("46726f6d3a203d3f6762", "eml");
        //MS Excel 注意：word、msi 和 excel的文件头一样
        mFileTypes.put("d0cf11e0a1b11ae10000", "doc");
        //MS Access (mdb)
        mFileTypes.put("5374616E64617264204A", "mdb");
        mFileTypes.put("252150532D41646F6265", "ps");
        //Adobe Acrobat (pdf)
        mFileTypes.put("255044462d312e350d0a", "pdf");
        //rmvb/rm相同
        mFileTypes.put("2e524d46000000120001", "rmvb");
        //flv与f4v相同
        mFileTypes.put("464c5601050000000900", "flv");
        mFileTypes.put("00000020667479706d70", "mp4");
        mFileTypes.put("49443303000000002176", "mp3");
        mFileTypes.put("000001ba210001000180", "mpg");
        //wmv与asf相同
        mFileTypes.put("3026b2758e66cf11a6d9", "wmv");
        //Wave (wav)
        mFileTypes.put("52494646e27807005741", "wav");
        mFileTypes.put("52494646d07d60074156", "avi");
        //MIDI (mid)
        mFileTypes.put("4d546864000000060001", "mid");
        mFileTypes.put("504b0304140000000800", "zip");
        mFileTypes.put("526172211a0700cf9073", "rar");
        mFileTypes.put("235468697320636f6e66", "ini");
        mFileTypes.put("504b03040a0000000000", "jar");
        //可执行文件
        mFileTypes.put("4d5a9000030000000400", "exe");
        //jsp文件
        mFileTypes.put("3c25402070616765206c", "jsp");
        //MF文件
        mFileTypes.put("4d616e69666573742d56", "mf");
        //xml文件
        mFileTypes.put("3c3f786d6c2076657273", "xml");
        //xml文件
        mFileTypes.put("494e5345525420494e54", "sql");
        //java文件
        mFileTypes.put("7061636b616765207765", "java");
        //bat文件
        mFileTypes.put("406563686f206f66660d", "bat");
        //gz文件
        mFileTypes.put("1f8b0800000000000000", "gz");
        //bat文件
        mFileTypes.put("6c6f67346a2e726f6f74", "properties");
        //bat文件
        mFileTypes.put("cafebabe0000002e0041", "class");
        //bat文件
        mFileTypes.put("49545346030000006000", "chm");
        //bat文件
        mFileTypes.put("04000000010000001300", "mxp");
        //docx文件
        mFileTypes.put("504b0304140006000800", "docx");
        //WPS文字wps、表格et、演示dps都是一样的
        mFileTypes.put("d0cf11e0a1b11ae10000", "wps");
        mFileTypes.put("6431303a637265617465", "torrent");

        //QuickTime (mov)
        mFileTypes.put("6D6F6F76", "mov");
        //WordPerfect (wpd)
        mFileTypes.put("FF575043", "wpd");
        //Outlook Express (dbx)
        mFileTypes.put("CFAD12FEC5FD746F", "dbx");
        //Outlook (pst)
        mFileTypes.put("2142444E", "pst");
        //Quicken (qdf)
        mFileTypes.put("AC9EBD8F", "qdf");
        //Windows Password (pwl)
        mFileTypes.put("E3828596", "pwl");
        //Real Audio (ram)
        mFileTypes.put("2E7261FD", "ram");
        //null
        mFileTypes.put("null", null);
    }

    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    private static String getFileHeader(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || file.length() < 11) {
            return "null";
        }
        FileInputStream is = null;
        String value = null;
        try {
            is = new FileInputStream(file);
            byte[] b = new byte[10];
            is.read(b, 0, b.length);
            value = bytesToHexString(b);
        } catch (Exception e) {
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
        return value;
    }

    public static String getFileType(String filePath) {
        return mFileTypes.get(getFileHeader(filePath));
    }

}
