package me.songt.smartpaper.vo;

import me.songt.smartpaper.po.UserRole;

import java.util.List;

/**
 * Created by tony on 2017/4/11.
 */
public class UserInfo
{
    private int userId;
    private String username;
    private int userType;
    private Object userObject;

    public UserInfo()
    {
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }


}
