#!/usr/bin/env bash
echo "==================================================================="
echo " start build the project "
echo ">>>> build  filesecurity-spring-boot-starter   <<<<"
echo "Enter Directory filesecurity"
cd filesecurity
ls
pwd
echo ">>>> building filesecurity   <<<<"
mvn clean install
cd ..
pwd
cd filesecurity-spring-boot-autoconfigure
ls
pwd
echo ">>>> building filesecurity-spring-boot-autoconfigure    <<<<"
mvn clean install
echo "end build the project"
echo "==================================================================="