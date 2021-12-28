# 基于哪个镜像
FROM openjdk:11
# 将本地文件夹挂载到当前容器
VOLUME /jenkins/github/Uniplus/nearby_place/target
# 复制文件到容器
ADD nearby_place.jar /nearby_place.jar
# 声明需要暴露的端口
EXPOSE 8082
# 配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","/nearby_place.jar"]