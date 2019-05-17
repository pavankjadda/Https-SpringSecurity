package com.pj.springsecurity.https.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig
{

/*    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer()
        {
            @Override
            public void addCorsMappings(CorsRegistry registry)
            {
                registry.addMapping("/**");
            }
        };
    }*/

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
