package me.songt.smartpaper.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by tony on 2017/3/29.
 *
 */
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
//        super.configure(http);
        http.csrf().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);



    }


}
