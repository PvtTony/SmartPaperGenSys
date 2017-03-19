package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by tony on 2017/3/19.
 */
@Repository
@Transactional
public interface SubjectRepository extends CrudRepository<Subject, Integer>
{
}
