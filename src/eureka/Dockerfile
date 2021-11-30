# 基于哪个镜像
FROM java:8
# 将本地文件夹挂载到当前容器
VOLUME /root/app/demo/eureka
# 复制文件到容器
ADD eureka.jar /eureka.jar
# 声明需要暴露的端口
EXPOSE 8100
# 配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","/eureka.jar"]