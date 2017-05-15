package me.songt.smartpaper.security;

import me.songt.smartpaper.po.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by tony on 2017/4/11.
 */
public interface TokenUtils
{
    String getUserToken(User user, long liftTimeMilliseconds);

    Boolean validate(String token);

    UserDetails getUser(String token);

}
