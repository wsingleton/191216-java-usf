package com.revature;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.revature.entities.Picture;
import com.revature.service.ImageService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.ByteBuffer;

@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
@OpenAPIDefinition(info =
@Info(title = "Compare API", version = "1.0", description = "Documentation Compare API v1.0")
)
public class AppConfig implements CommandLineRunner {

    @Autowired
    private ImageService imageService;

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);

    }

    @Bean
    public Docket swaggerPersonApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.revature.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Compare API").description("Documentation Compare API v1.0").build());
    }

    @Override
    public void run(String... args) throws Exception{
        Picture picA = new Picture("1", "imgA.jpg");
        Picture picB = new Picture("2", "imgB.jpg");
        Picture picC = new Picture("3", "imgC.jpg");



    }



}
