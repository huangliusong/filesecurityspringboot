package filesecurity;

/**
 * @author huangliusong
 * @since 2019/7/26
 * {@link RuntimeException}
 */
public class FileSecurityException extends RuntimeException {
    /**
     * code
     */
    private String code;
    /**
     * message
     */
    private String msg;

    FileSecurityException(ErrorCode errorCode) {
        super();
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
