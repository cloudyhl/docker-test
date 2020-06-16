
FROM anapsix/alpine-java:8_server-jre_unlimited

# 维护者
MAINTAINER yhl

# 添加springboot项目到镜像中的home目录，并重命名为test.jar
ADD docker-test-0.0.1-SNAPSHOT.jar ~/test.jar

#对外端口
EXPOSE 8080

ENTRYPOINT ["java", "-jar" ,"~/test.jar"]