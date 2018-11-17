package pl.dietician;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.dietician.converter.DateConverter;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {


    @Bean
    public DateConverter getDateConverter() {
        return new DateConverter();
    }

    @Override
    public void addFormatters (FormatterRegistry registry) {
        registry.addConverter(getDateConverter());
    }

}
