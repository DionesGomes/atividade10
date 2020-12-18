package br.com.ifpb.atividade.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfoBuilder apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Produto REST API");
        apiInfoBuilder.description("Uma API REST simples para gerenciamento de produtos.");
        apiInfoBuilder.version("0.1");
        apiInfoBuilder.contact(new Contact(
                "Diones Gomes",
                "http://github.com/DionesGomes",
                "diones.rocha@academico.ifpb.edu.br"
        ));

        return apiInfoBuilder;
    }

    @Bean
    public Docket apiDetails() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.select()
                .apis(RequestHandlerSelectors.basePackage("br.com.ifpb.Atividade10"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo().build());

        return docket;
    }
}
