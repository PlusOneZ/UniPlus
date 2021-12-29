package cn.edu.tongji.uniplus.good_information.util;

import cn.edu.tongji.uniplus.good_information.configure.OSSConfigure;
import com.aliyun.oss.OSSClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.util.Date;

/**
 * @author zzy
 */
@Component
public class OSSManageUtils {

    @Resource
    OSSConfigure ossConfigure;

    /**
     * 上传OSS服务器文件 @Title: uploadFile
     *
     * @param bs spring 上传的文件
     *           fileName 文件名
     * @return url 请求路径
     * @throws Exception 设定文件
     */
    public String uploadFile(byte[] bs, String fileName) throws Exception {
        //随机名处理
        // 加载配置文件，初始化OSSClient

        OSSClient ossClient = new OSSClient(
                ossConfigure.getEndpoint(),
                ossConfigure.getAccessKeyId(),
                ossConfigure.getAccessKeySecret()
        );
        ossClient.putObject(ossConfigure.getBucketName(), fileName, new ByteArrayInputStream(bs));
        // 设置url过期时间为100年
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 100);
        String url = ossClient.generatePresignedUrl(ossConfigure.getBucketName(), fileName, expiration).toString();
        // 关闭OSSClient
        ossClient.shutdown();
        return url;
    }

}


