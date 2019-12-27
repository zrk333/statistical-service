package com.gm.statistical.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/09
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.host:}")
    private String host;

    @Bean
    public Docket buildAppDocket() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Content-Type").description("").modelRef(new ModelRef("string")).defaultValue("application/json").parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        tokenPar.name("X-GM-userId").description("用户id").modelRef(new ModelRef("long")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        tokenPar.name("X-GM-platform").description("平台").modelRef(new ModelRef("int")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        tokenPar.name("X-GM-lng").description("经度").modelRef(new ModelRef("long")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        tokenPar.name("X-GM-lat").description("纬度").modelRef(new ModelRef("long")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .host(host)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gm.statistical"))
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("统计服务")
                .description("统计服务相关API文档")
                .build();
    }
}
