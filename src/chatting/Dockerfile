# 基于哪个镜像
FROM openjdk:11
# 将本地文件夹挂载到当前容器
VOLUME /var/lib/jenkins/workspace/uniplus_all/src/chatting/target
# 复制文件到容器
ADD chatting.jar /chatting.jar
# 声明需要暴露的端口
EXPOSE 8086
# 配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","/chatting.jar"]