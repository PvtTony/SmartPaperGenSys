package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "user_role")
public class UserRole
{
    private int roleId;
    private String roleName;

    @Id
    @Column(name = "role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getRoleId()
    {
        return roleId;
    }

    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 200)
    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
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

        UserRole userRole = (UserRole) o;

        if (roleId != userRole.roleId)
        {
            return false;
        }
        return roleName != null ? roleName.equals(userRole.roleName) : userRole.roleName == null;
    }

    @Override
    public int hashCode()
    {
        int result = roleId;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
