package top.huangliusong2019.spring.controller;

import annotation.FileSecurityAnnotation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangliusong
 * @since 2019/7/20
 * {@link }
 */
@CrossOrigin
@RestController
@RequestMapping("/v1")
public class StarterController {

    @FileSecurityAnnotation
    @GetMapping("/starter")
    public String starter() {
        return "success";
    }
}
