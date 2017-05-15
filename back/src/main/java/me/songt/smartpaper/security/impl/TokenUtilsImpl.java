package me.songt.smartpaper.security.impl;

import me.songt.smartpaper.po.User;
import me.songt.smartpaper.repository.UserRepository;
import me.songt.smartpaper.security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Base64;

/**
 * Created by tony on 2017/4/11.
 */
@Service
@Configurable
public class TokenUtilsImpl implements TokenUtils
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userService;

    @Override
    public String getUserToken(User user, long liftTimeMilliseconds)
    {
        String plainToken = "";

        if (user != null)
        {
            String encodedToken = this.generateTokenByUser(user, liftTimeMilliseconds);
            return encodedToken;
        }
        return null;
    }

    @Override
    public Boolean validate(String token)
    {
        long currentTime = System.currentTimeMillis();
        String[] tokenInfo = parsePlainToken(base64decode(token));
        String userName = tokenInfo[0];
        String password = tokenInfo[1];
        long lifeTime = Long.parseLong(tokenInfo[2]);
        User user = userRepository.findByuserName(userName);
        if (user != null && password.equals(user.getUserPassword()))
        {
            if (currentTime < lifeTime)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserDetails getUser(String token)
    {
        String[] tokenInfo = this.parsePlainToken(this.base64decode(token));

        return userService.loadUserByUsername(tokenInfo[0]);
    }

    private String generateTokenByUser(User user, long lifetimeInMilliseconds)
    {
        String plainToken = user.getUserName() + "|" + user.getUserPassword() + "|" + (System.currentTimeMillis() + lifetimeInMilliseconds);
        byte[] encodedBytes = Base64.getEncoder().encode(plainToken.getBytes());
        String encodedToken = new String(encodedBytes);
        return encodedToken;
    }

    private String[] parsePlainToken(String plainText)
    {
        return plainText.split("\\|");
    }

    private String base64decode(String token)
    {
        return new String(Base64.getDecoder().decode(token.getBytes()));
    }
}
