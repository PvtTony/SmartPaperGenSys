package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.QuestionEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

/**
 * Created by tony on 2017/3/19.
 */
@Transactional
@Repository
public interface QuestionRepository extends PagingAndSortingRepository<QuestionEntity, Integer>
{

    //根据科目id查找试题
    List<QuestionEntity> findByQuestionSubjectId(int questionSubjectId);

    //根据科目id、知识点查找试题
    List<QuestionEntity> findByQuestionSubjectIdAndQuestionKnowledgePointId(int questionSubjectId,int questionKnowledgePointId);
    //根据科目id、难度系数查找试题
    List<QuestionEntity> findByQuestionSubjectIdAndQuestionDifficultyId(int questionSubjectId,int questionDifficultyId);
    //根据科目id、题目类型查找试题
    List<QuestionEntity> findByQuestionSubjectIdAndQuestionTypeId(int questionSubjectId,int questionTypeId);

    //根据科目id、知识点、难度系数查找试题
    List<QuestionEntity> findByQuestionSubjectIdAndQuestionKnowledgePointIdAndQuestionDifficultyId(int questionSubjectId,int questionKnowledgePointId,int questionDifficultyId);
    //根据科目id、知识点、题目类型查找试题
    List<QuestionEntity> findByQuestionSubjectIdAndQuestionKnowledgePointIdAndQuestionTypeId(int questionSubjectId, int questionKnowledgePointId, int questionTypeId);
    //根据科目id、难度系数、题目类型查找试题
    List<QuestionEntity> findByQuestionSubjectIdAndQuestionDifficultyIdAndQuestionTypeId(int questionSubjectId,int questionDifficultyId,int questionTypeId);

    //根据科目id、知识点、难度系数、题目类型查找试题
    List<QuestionEntity> findByQuestionSubjectIdAndQuestionKnowledgePointIdAndQuestionDifficultyIdAndQuestionTypeId(int questionSubjectId,int questionKnowledgePointId,int questionDifficultyId,int questionTypeId);

    //修改题目信息
    @Modifying
    @Query("update QuestionEntity a set a.questionContent =:questionContent,a.questionOption =:questionOption, a.questionAnswer =:questionAnswer," +
            "a.questionOptionCount = :questionOptionCount,a.questionSolution=:questionSolution where a.questionId=:questionId")
    void updateQuestion(@Param("questionId") int questionId, @Param("questionContent") String questionContent,@Param("questionOption") String questionOption,@Param("questionAnswer") String questionAnswer,
                        @Param("questionOptionCount") int questionOptionCount,@Param("questionSolution") String questionSolution);

    //根据题型和知识点集合查找题目
    List<QuestionEntity> findByQuestionSubjectIdAndQuestionTypeIdAndQuestionKnowledgePointIdIn(int questionSubjectId,int questionTypeId, Collection<Integer> questionKnowledgePointIds);

}
