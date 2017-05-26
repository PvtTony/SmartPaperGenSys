package me.songt.smartpaper.service;

import me.songt.smartpaper.vo.UserInfo;
import org.springframework.stereotype.Service;

/**
 * Created by yst on 2017/5/16.
 */
@Service
public interface UserAuthService
{
    UserInfo auth(String username, String password);

//    UserInfo register(String )
}
