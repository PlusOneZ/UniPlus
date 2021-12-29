# 基于哪个镜像
FROM openjdk:11
# 将本地文件夹挂载到当前容器
VOLUME /var/lib/jenkins/workspace/uniplus_all/src/user-service/target
# 复制文件到容器
ADD user-service.jar /user-service.jar
# 声明需要暴露的端口
EXPOSE 9000
# 配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","/user-service.jar"]