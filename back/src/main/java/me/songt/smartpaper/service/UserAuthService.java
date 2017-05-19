package me.songt.smartpaper.service;

import me.songt.smartpaper.vo.UserInfo;

/**
 * Created by yst on 2017/5/16.
 */
public interface UserAuthService
{
    UserInfo auth(String authId, String password);

//    UserInfo register(String )
}
