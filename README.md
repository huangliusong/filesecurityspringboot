# filesecurityspringboot
[![Maven central](https://img.shields.io/badge/Maven%20central-v1.1-red.svg)](https://oss.sonatype.org/#nexus-search;quick~filesecurity-spring-boot-starter)
[![top](https://img.shields.io/badge/build-top.huangliusong2019-green.svg)](https://github.com/huangliusong/filesecurityspringboot)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/badge/Sonatype%20Nexus-v1.1-blue.svg)](https://oss.sonatype.org/content/repositories/snapshots/top/huangliusong2019/)
[![build](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://travis-ci.org/huangliusong/filesecurityspringboot)

![](./doc/secutity1.png)

# 文档(Document)
[中文](./doc/cn_doc_index.md)  |  [EN](./doc/en_doc_index.md)

## top.huangliusong2019
file-security-spring-boot  will help you use file-security with Spring Boot


## Requirements

* Java 8+ and 
* Spring Boot 1.5.7+
* Maven 3.3.9+

## Quick Start(out-of-the-box)

~~~
<dependency>
  <groupId>top.huangliusong2019</groupId>
  <artifactId>filesecurity-spring-boot-starter</artifactId>
  <version>1.1.3-SNAPSHOT</version>
</dependency>
~~~

## Dependency

### [filesecurity-spring-boot-starter](https://github.com/huangliusong/filesecurity-spring-boot-starter)

### [filesecurity-parent](https://github.com/huangliusong/filesecurity-parent)

### [filesecurity-spring-boot](https://github.com/huangliusong1994/filesecurity-parent)



## metadata
[metadata document of spring](https://docs.spring.io/spring-boot/docs/2.1.x/reference/htmlsingle/#configuration-metadata
)

## deploy
> mvn clean package deploy

> mvn deploy

## package

~~~
[INFO] Reactor Summary:
[INFO] 
[INFO] filesecurity-spring-boot ........................... SUCCESS [  0.615 s]
[INFO] filesecurity ....................................... SUCCESS [  1.116 s]
[INFO] filesecurity-spring-boot-samples ................... SUCCESS [  0.004 s]
[INFO] filesecurity-spring-boot-sample-annotation ......... SUCCESS [  1.348 s]
[INFO] filesecurity-spring-boot-sample-properties ......... SUCCESS [  0.071 s]
[INFO] filesecurity-spring-boot-autoconfigure ............. SUCCESS [  2.161 s]
[INFO] filesecurity-spring-boot-starter ................... SUCCESS [  0.056 s]
[INFO] filesecurity-spring-boot-test-autoconfigure ........ SUCCESS [  0.057 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 6.492 s
[INFO] Finished at: 2019-07-29T06:11:50Z
[INFO] Final Memory: 36M/459M
[INFO] ------------------------------------------------------------------------
~~~