package realestate.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import realestate.util.HtmlReader;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean(name="validator")
    public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }


    @Bean(name="modelMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean(name="htmlReader")
    public HtmlReader htmlReader(){
        return new HtmlReader();
    }
}

