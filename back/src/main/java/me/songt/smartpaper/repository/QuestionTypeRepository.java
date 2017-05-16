package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.QuestionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tony on 2017/3/19.
 */
@Transactional
@Repository
public interface QuestionTypeRepository extends CrudRepository<QuestionType, Integer>
{
    List<QuestionType> findBySubjectId(int subjectId);
}
