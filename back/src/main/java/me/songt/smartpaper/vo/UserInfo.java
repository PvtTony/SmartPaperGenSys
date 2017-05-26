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

    public static final int TYPE_TEACHER = 2;
    public static final int TYPE_STUDENT = 1;

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


    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getUserType()
    {
        return userType;
    }

    public void setUserType(int userType)
    {
        this.userType = userType;
    }

    public Object getUserObject()
    {
        return userObject;
    }

    public void setUserObject(Object userObject)
    {
        this.userObject = userObject;
    }

}
