package application.residentEvil.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean(name="modelMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
 }
