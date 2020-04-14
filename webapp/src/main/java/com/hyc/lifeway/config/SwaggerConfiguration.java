package com.hyc.lifeway.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author ：胡友成
 * @Date ：2020/4/13
 * @Description：
 */
@Configuration
@EnableSwagger2
@Profile({"dev", "prod"})
public class SwaggerConfiguration {

    @Bean
    public Docket api(ApiInfo apiInfo, Predicate<RequestHandler>[] predicates) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(Predicates.or(predicates))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Predicate<RequestHandler> csPredicate() {
        List<Predicate<RequestHandler>> list = new ArrayList<>();
        list.add(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class));
        return Predicates.or(list);
    }

    @Bean
    public ApiInfo swaggerApiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("xx")
                .version("1.0")
                .build();
    }
}
