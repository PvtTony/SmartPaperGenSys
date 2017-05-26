package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.ScoreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Sarah on 2017/5/27.
 */
@Transactional
@Repository
public interface ScoreRepository extends CrudRepository<ScoreEntity, Integer>
{
    ScoreEntity findByStudentIdEqualsAndExamIdEquals(int studentId, int examId);
}
