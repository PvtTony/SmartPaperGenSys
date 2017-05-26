package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.PaperQuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tony on 2017/3/19.
 */
@Transactional
@Repository
public interface PaperQuestionRepository extends CrudRepository<PaperQuestionEntity, Integer>
{
    //根据试卷id删除记录
    int deleteByPaperId(int paperId);
    //根据试卷id查找题目
    List<PaperQuestionEntity> findByPaperId(int paperId);

    PaperQuestionEntity findByPaperIdEqualsAndPaperQuestionIdEquals(int paperId, int questionId);
}
