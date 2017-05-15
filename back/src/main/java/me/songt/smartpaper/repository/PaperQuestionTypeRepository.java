package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.PaperQuestionTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tony on 2017/3/19.
 */
@Transactional
@Repository
public interface PaperQuestionTypeRepository extends CrudRepository<PaperQuestionTypeEntity, Integer>
{
    //根据试卷id删除记录
    Long deleteByPaperId(long paperId);
    //根据试卷id查找题型
    List<PaperQuestionTypeEntity> findByPaperId(long paperId);
}
