package me.songt.smartpaper.config;

import me.songt.smartpaper.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by tony on 2017/3/27.
 */
public class GlobalAuthenticationConfig extends GlobalAuthenticationConfigurerAdapter
{

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception
    {
//        super.init(auth);
        auth.userDetailsService(new UserDetailsServiceImpl());
    }
}
