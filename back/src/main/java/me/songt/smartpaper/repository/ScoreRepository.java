package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.ScoreEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sarah on 2017/5/27.
 */
public interface ScoreRepository extends CrudRepository<ScoreEntity, Integer>
{
    ScoreEntity findByStudentIdEqualsAndExamIdEquals(int studentId, int examId);
}
