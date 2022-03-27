package io.github.mkabumattar.velocityengineconfigtemplate.config;

import io.github.mkabumattar.velocityengineconfigtemplate.config.velocity.view.config.VelocityConfigurer;
import io.github.mkabumattar.velocityengineconfigtemplate.config.velocity.view.resolver.VelocityViewResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;

@Configuration
public class VelocityConfig extends WebMvcConfigurerAdapter {

    @SuppressWarnings("deprecation")
    @Bean
    public VelocityConfigurer velocityConfigurer(ApplicationContext context) {
        VelocityConfigurer config = new VelocityConfigurer();
        Properties properties = new Properties();
        properties.put("input.encoding", "UTF-8");
        properties.put("output.encoding", "UTF-8");
        config.setVelocityProperties(properties);
        return config;
    }
    @SuppressWarnings("deprecation")
    @Bean
    public VelocityViewResolver velocityResolver() {
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setCache(false);
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".vm");
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setExposeSpringMacroHelpers(true);
        resolver.setExposeRequestAttributes(true);
        resolver.setRequestContextAttribute("request");
        return resolver;
    }
}
