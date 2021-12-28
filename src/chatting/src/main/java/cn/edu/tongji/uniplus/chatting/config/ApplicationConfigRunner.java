package cn.edu.tongji.uniplus.chatting.config;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

/**
 * @author tangshuo
 * @version 1.0.0
 */
@EnableDiscoveryClient
@Component
public class ApplicationConfigRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception{
        IdGeneratorOptions options = new IdGeneratorOptions((short) 1);
        YitIdHelper.setIdGenerator(options);
        System.out.println("Id生成器初始化配置完成");
    }
}
