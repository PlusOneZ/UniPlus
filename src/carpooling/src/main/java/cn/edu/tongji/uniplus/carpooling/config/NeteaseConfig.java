package cn.edu.tongji.uniplus.carpooling.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName NeteaseConfig.java
 * @Description TODO
 * @createTime 2021年12月29日 20:57:00
 */


@Configuration
@ConfigurationProperties(prefix = "netease", ignoreUnknownFields = false)
@PropertySource("classpath:config/secret.properties")
@Data
@Component
public class NeteaseConfig {
    private String appKey;
    private String appSecret;
    private String nonce;
}
