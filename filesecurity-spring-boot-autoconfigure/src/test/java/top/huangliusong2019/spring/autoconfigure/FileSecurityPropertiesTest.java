package top.huangliusong2019.spring.autoconfigure;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huangliusong
 * @since 2019/7/20
 * {@link FileSecurityProperties}
 */

public class FileSecurityPropertiesTest {
    private static final Logger logger = LoggerFactory.getLogger(FileSecurityPropertiesTest.class);


    @org.junit.Before
    public void setUp() throws Exception {
        logger.info("init");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        logger.info("destroy");
    }

    @Test
    public void TestAutoConfig() {
        logger.info("Testing");
        FileSecurityProperties properties = new FileSecurityProperties();
        properties
                .setUploadPrefixWhiteList(".exe,.html,.php");
        properties.setUploadPrefixBlackList(".exe,.html,.php");
        Assert.assertNotNull(properties);
        Assert.assertNotNull(properties.getUploadPrefixWhiteList());
        Assert.assertNotNull(properties.getUploadPrefixBlackList());
    }
}
