package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by tony on 2017/3/19.
 */
@Transactional
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer>
{
    UserRole findByroleId(int roleId);
}
