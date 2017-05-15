package me.songt.smartpaper.vo;

import me.songt.smartpaper.po.UserRole;

import java.util.List;

/**
 * Created by tony on 2017/4/11.
 */
public class UserInfo
{
    private String username, token;
    private List<UserRole> roles;

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

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public List<UserRole> getRoles()
    {
        return roles;
    }

    public void setRoles(List<UserRole> roles)
    {
        this.roles = roles;
    }
}
