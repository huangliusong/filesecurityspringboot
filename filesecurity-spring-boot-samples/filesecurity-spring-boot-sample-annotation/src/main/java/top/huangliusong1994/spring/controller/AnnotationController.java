package top.huangliusong1994.spring.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.huangliusong2019.filesecurity.annotation.FileSecurityAnnotation;
import top.huangliusong2019.spring.autoconfigure.FileSecurityProperties;

/**
 * Test FileSecurityProperties
 *
 * @author huangliusong
 * @since 2019/7/20
 * {@link FileSecurityProperties}
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/v1")
public class AnnotationController {
    private Logger logger = LoggerFactory.getLogger(AnnotationController.class);
    @Autowired
    private FileSecurityProperties properties;


    @GetMapping(value = "/annotation")
    @ResponseBody
    @FileSecurityAnnotation
    public String prop() {
        logger.info("Test Interceptor...");
        return "success";
    }
}
