package com.example.automatic.irrigation.system.Config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;


public class AppConfig {
    private static final String timeFormat =  "HH:mm:ss";
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer(){
        return builder->{
            builder.simpleDateFormat(timeFormat);
        };

    }
}
