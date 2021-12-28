# 基于哪个镜像
FROM openjdk:11
# 将本地文件夹挂载到当前容器
VOLUME /jenkins/github/Uniplus/user/target
# 复制文件到容器
ADD user.jar /user.jar
# 声明需要暴露的端口
EXPOSE 8080
# 配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","/user.jar"]