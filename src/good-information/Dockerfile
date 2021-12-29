# 基于哪个镜像
FROM openjdk:11
# 将本地文件夹挂载到当前容器
VOLUME /var/lib/jenkins/workspace/uniplus_all/src/good-information/target
# 复制文件到容器
ADD good-information.jar /good-information.jar
# 声明需要暴露的端口
EXPOSE 8085
# 配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","/good-information.jar"]