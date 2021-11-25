package cn.edu.tongji.uniplus.nearby_place;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class NearbyPlaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NearbyPlaceApplication.class, args);
    }

}
