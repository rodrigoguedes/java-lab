package br.com.guedesdesouza.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableSwagger
//@EnableAutoConfiguration
@SpringBootApplication
public class Application {

//    @Autowired
//    private SpringSwaggerConfig swaggerConfig;
	
    public static void main(String[] args) {
        //new SpringApplicationBuilder(Application.class).web(true).run(args);
    	SpringApplication.run(Application.class, args);
    }
    
//    @Bean
//    public SwaggerSpringMvcPlugin groupOnePlugin() {
//        return new SwaggerSpringMvcPlugin(swaggerConfig)
//                .apiInfo(apiInfo())
//                .includePatterns("/publico.*?", "/home.*?", "/users.*?")
//                .swaggerGroup("publico");
//    }
//
//    private ApiInfo apiInfo() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Servidor de Autenticação Oauth2",
//                "",
//                "Uso livre",
//                "rodrigo@guedesdesouza.com.br",
//                "Licença pública",
//                ""
//        );
//        return apiInfo;
//    }
	
}
