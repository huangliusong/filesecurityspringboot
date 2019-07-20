package top.huangliusong2019.spring.autoconfigure;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huangliusong
 * @since 2019/7/20
 * {@link }
 */

public class FileSecurityAutoConfigurationTest {
    private static final Logger logger = LoggerFactory.getLogger(FileSecurityAutoConfigurationTest.class);
    private AnnotationConfigApplicationContext context;

    @Before
    public void init() {
        this.context = new AnnotationConfigApplicationContext();
    }

    @After
    public void closeContext() {
        if (this.context != null) {
            this.context.close();
        }
    }

    @Test
    public void TestAutoConfig() {
        context.register(FileSecurityAutoConfiguration.class);
        this.context.refresh();
        FileSecurityProperties properties = context.getBean(FileSecurityProperties.class);
        logger.info("properties={}", properties);
        Assert.assertNotNull(properties);

    }
}
