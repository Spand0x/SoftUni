package com.spand0x.xmlcardealer.config;

import com.spand0x.xmlcardealer.utils.ValidationUtil;
import com.spand0x.xmlcardealer.utils.ValidationUtilImpl;
import com.spand0x.xmlcardealer.utils.XmlParser;
import com.spand0x.xmlcardealer.utils.XmlParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public XmlParser xmlParser(){
        return new XmlParserImpl();
    }

    @Bean
    public ValidationUtil validationUtil(){
        return new ValidationUtilImpl();
    }
}
