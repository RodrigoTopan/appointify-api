package puc.appointify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class AppointifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointifyApplication.class, args);
    }

    @Bean
    public Docket documentation() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("puc.appointify.application.rest"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .pathMapping(getPathMapping());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Inka Shipping").version("1.0").build();
    }

    private String getPathMapping() {
        return "/";
    }

}
