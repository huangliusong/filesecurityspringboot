package filesecurity;

/**
 * @author huangliusong
 * @since 2019/7/26
 */
public enum ErrorCode {
    /**
     * ERROR
     */
    ERROR("1", "error"),
    /**
     * MIME of file type is not support
     */
    MIME_FILE_TYPE_ERROR("1001","MIME of file type is not support");
    ;
    /**
     * code
     */
    private String code;
    /**
     * message
     */
    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
