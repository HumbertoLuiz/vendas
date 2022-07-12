package io.github.humbertoluiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.RequestHandlerSelectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    private static final String BASE_PACKAGE = "io.github.humbertoluiz.rest.controller";
    private static final String API_TITLE = "Vendas API";
    private static final String API_DESCRIPTION = "REST API for vendas management";
    private static final String CONTACT_NAME = "Humberto Luiz";
    private static final String CONTACT_GITHUB = "https://gtihub.com/humbertoluiz";
    private static final String CONTACT_EMAIL = "kaos_132@hotmail.com";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.useDefaultResponseMessages(false)
                .select()
                .apis(basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/.*"))
                .build()
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .contact(new Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
                .build();
    }
    
	public ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext
				.builder()
				.securityReferences(defaultAuth())
				.operationSelector(operationContext -> true)
				.build();
	}
	
	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope(
				"global", "accessEverything");
		AuthorizationScope[] scopes = new AuthorizationScope[1];
		scopes[0] = authorizationScope;
		SecurityReference reference = new SecurityReference("JWT", scopes);
				List<SecurityReference> auths = new ArrayList<>();
				auths.add(reference);
		return auths;
	}
}