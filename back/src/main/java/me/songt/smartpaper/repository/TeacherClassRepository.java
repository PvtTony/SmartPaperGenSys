package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.TeacherClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by tony on 2017/3/19.
 */
@Repository
@Transactional
public interface TeacherClassRepository extends CrudRepository<TeacherClass, Integer>
{
}
