package kr.jellyms.custommapper.component;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperComponent {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
