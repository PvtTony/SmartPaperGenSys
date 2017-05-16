package me.songt.smartpaper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by tony on 2017/3/28.
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter
{
    //Global CORS Configuration
    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurerAdapter()
        {
            @Override
            public void addCorsMappings(CorsRegistry registry)
            {
               registry.addMapping("/**");
            }
        };
    }
}
