package top.huangliusong2019.test.spring.entity;

/**
 * VO
 *
 * @author huangliusong
 * @since 2019/7/20
 */
public class PropEntity {
    private String uploadPrefixWhiteList;
    private String uploadPrefixBlackList;

    public String getUploadPrefixWhiteList() {
        return uploadPrefixWhiteList;
    }

    public void setUploadPrefixWhiteList(String uploadPrefixWhiteList) {
        this.uploadPrefixWhiteList = uploadPrefixWhiteList;
    }

    public String getUploadPrefixBlackList() {
        return uploadPrefixBlackList;
    }

    public void setUploadPrefixBlackList(String uploadPrefixBlackList) {
        this.uploadPrefixBlackList = uploadPrefixBlackList;
    }

    @Override
    public String toString() {
        return "PropEntity{" +
                "uploadPrefixWhiteList='" + uploadPrefixWhiteList + '\'' +
                ", uploadPrefixBlackList='" + uploadPrefixBlackList + '\'' +
                '}';
    }
}
