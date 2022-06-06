package gulewskr.rentcarapp;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RentCarAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentCarAppApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("1") String appVersion) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("CarRent API").version(appVersion));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*")
                        .allowedOrigins("http://localhost:3000","http://localhost:8080");
            }
        };
    }
}
