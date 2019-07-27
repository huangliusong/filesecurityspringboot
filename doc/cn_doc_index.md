# filesecurityspringboot
[![Maven central](https://img.shields.io/badge/Maven%20central-v1.1-red.svg)](https://search.maven.org/)
[![top](https://img.shields.io/badge/build-top.huangliusong2019-green.svg)]()
[![Sonatype Nexus (Snapshots)](https://img.shields.io/badge/Sonatype%20Nexus-v1.1-blue.svg)](https://oss.sonatype.org/content/repositories/snapshots/top/huangliusong2019/)
[![build](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/huangliusong1994/filesecurityspringboot)

![](./secutity1.png)

# 文档(Document)
[中文](./doc/cn_doc_index.md)  |  [EN](./doc/en_doc_index.md)

# 中文文档
## 介绍
文件上传拦截，对文件上传进行安全性校验，拦截文件上传后缀，根据文件头前几位二进制判断文件类型，根据文件MIME类型拦截，开启文件上传校验，校验文件哈希值，只需一个注解即可完成！开箱即用！

# 快速开始

## 添加依赖
~~~
<dependency>
  <groupId>top.huangliusong2019</groupId>
  <artifactId>filesecurity-spring-boot-starter</artifactId>
  <version>1.1.3-SNAPSHOT</version>
</dependency>
~~~
filesecurity-spring-boot-starter已上传到maven仓库，加入以上依赖即可，加入依赖后，在需要拦截的方法上加注解@FileSecurityAnnotation即可成功拦截文件上传请求。


## 添加注解
~~~
    @FileSecurityAnnotation
    @PostMapping("/file")
    public String starter(@RequestParam("file") MultipartFile file) {
        return "success";
    }
~~~

## 自定义配置
~~~
file:
  #拦截后缀黑名单
  upload-prefix-black-list: ".exe"
  #拦截后缀白名单
  upload-prefix-white-list: ""
  #拦截MIME文件类型白名单
  uploadMIMEWhiteList: "image/jpeg"
  #拦截MIME文件类型黑名单
  uploadMimeBlackList: ""
  #开启上传校验
  hashCodeValidate: "MD5"
~~~