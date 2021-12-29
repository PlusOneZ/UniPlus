package cn.edu.tongji.uniplus.good_information.configure;



import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

/**
 * OSSConfigure
 * @author 梁乔
 * @since 2021/11/25 22:59 
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "oss", ignoreUnknownFields = false )
@PropertySource("classpath:config/secret.properties")
public class OSSConfigure {
    //地域节点
    private String endpoint;
    //access keyId
    private String accessKeyId;
    //accesskeyId
    private String accessKeySecret;
    //存储空间
    private String bucketName;
    //访问路径
    private String accessUrl;
}