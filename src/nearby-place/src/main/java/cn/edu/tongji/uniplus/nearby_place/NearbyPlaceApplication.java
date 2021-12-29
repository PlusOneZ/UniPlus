package cn.edu.tongji.uniplus.nearby_place;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;
@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
public class NearbyPlaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NearbyPlaceApplication.class, args);
    }
}
