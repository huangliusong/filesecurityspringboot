# EN Document

# filesecurityspringboot
[![Maven central](https://img.shields.io/badge/Maven%20central-v1.1-red.svg)](https://search.maven.org/)
[![top](https://img.shields.io/badge/build-top.huangliusong2019-green.svg)]()
[![Sonatype Nexus (Snapshots)](https://img.shields.io/badge/Sonatype%20Nexus-v1.1-blue.svg)](https://oss.sonatype.org/content/repositories/snapshots/top/huangliusong2019/)
[![build](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com/huangliusong1994/filesecurityspringboot)

![](./secutity1.png)

# Document
[中文](./cn_doc_index.md)  |  [EN](./en_doc_index.md)


# Quick Start

## Add Dependency
~~~
<dependency>
  <groupId>top.huangliusong2019</groupId>
  <artifactId>filesecurity-spring-boot-starter</artifactId>
  <version>1.1.3-SNAPSHOT</version>
</dependency>
~~~
filesecurity-spring-boot-starter has been uploaded to maven repository. Add the dependencies above, and you can successfully block file upload requests by annotating @filesecurityannotation on the methods that need to be intercepted.

## Add Annotation
~~~
    @FileSecurityAnnotation
    @PostMapping("/file")
    public String starter(@RequestParam("file") MultipartFile file) {
        return "success";
    } 
~~~

## config
~~~
file:
  #prefix black list
  upload-prefix-black-list: ".exe"
  #prefix white list
  upload-prefix-white-list: ""
  #MIME  white list
  uploadMIMEWhiteList: "image/jpeg"
  #MIME black list
  uploadMimeBlackList: ""
  #validate hash value of file
  hashCodeValidate: "MD5"
~~~