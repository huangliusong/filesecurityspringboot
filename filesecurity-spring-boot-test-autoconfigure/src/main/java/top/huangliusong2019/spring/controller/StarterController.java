package top.huangliusong2019.spring.controller;

import annotation.FileSecurityAnnotation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @FileSecurityAnnotation
    @PostMapping("/file")
    public String starter(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return "success";
    }
}
