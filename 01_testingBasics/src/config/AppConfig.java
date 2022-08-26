package config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "bean")
@PropertySource("classpath:application.properties")
public class AppConfig {

}
