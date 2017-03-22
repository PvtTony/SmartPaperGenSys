package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
public class User
{
    private int userId;
    private String userName;
    private String userPassword;
    private int userRoleId;

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 200)
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 255)
    public String getUserPassword()
    {
        return userPassword;
    }

    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_role_id", nullable = false)
    public int getUserRoleId()
    {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId)
    {
        this.userRoleId = userRoleId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        User user = (User) o;

        if (userId != user.userId)
        {
            return false;
        }
        if (userRoleId != user.userRoleId)
        {
            return false;
        }
        if (userName != null ? !userName.equals(user.userName) : user.userName != null)
        {
            return false;
        }
        return userPassword != null ? userPassword.equals(user.userPassword) : user.userPassword == null;
    }

    @Override
    public int hashCode()
    {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + userRoleId;
        return result;
    }
}
