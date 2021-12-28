package cn.edu.tongji.uniplus.nearby_place;
/*
    @Created by Jary-Li on 2021/11/25. All rights reserved.
    @Name: UniPlus
    @Description：降级为 2.5.6 以后就能用了
*/

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration    //表明当前类是配置类
@EnableOpenApi    //表示开启生成接口文档功能（只有开启了OpenApi,才可以实现生成接口文档的功能）
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("附近地点模块接口文档")//标题
                .description("截至2021年11月25日")//描述
                //附加信息
                .contact(new Contact("Jary-lrj", "https://www.github.com/jary-lrj", "820359253@qq.com"))
                .version("1.0")//版本
                .build();
    }
}

