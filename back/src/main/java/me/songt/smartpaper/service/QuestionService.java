package me.songt.smartpaper.service;

import me.songt.smartpaper.po.QuestionEntity;
import me.songt.smartpaper.vo.question.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by Sarah on 2017/3/29.
 */
@Service
public interface QuestionService {
    //获得所有试题
    Page<Question> getAll(Pageable pageable);
    //根据科目id查找试题
    Page<Question> findBySubjectId(int subjectId,Pageable pageable);
    //根据科目id、知识点查找试题
    Page<Question> findBySubjectIdAndPointId(int subjectId, int pointId,Pageable pageable);
    //根据科目id、难度系数查找试题
    Page<Question> findBySubjectIdAndDifficultyId(int subjectId,int difficultyId,Pageable pageable);
    //根据科目id、题目类型查找试题
    Page<Question> findBySubjectIdAndTypeId(int subjectId,int typeId,Pageable pageable);

    //根据科目id、知识点、难度系数查找试题
    Page<Question> findBySubjectIdAndPointIdAndDifficultyId(int subjectId,int pointId,int difficultyId,Pageable pageable);
    //根据科目id、知识点、题目类型查找试题
    Page<Question> findBySubjectIdAndPointIdAndTypeId(int subjectId,int pointId,int typeId,Pageable pageable);
    //根据科目id、难度系数、题目类型查找试题
    Page<Question> findBySubjectIdAndDifficultyIdAndTypeId(int subjectId,int difficultyId,int typeId,Pageable pageable);

    //根据科目id、知识点、难度系数、题目类型查找试题
    Page<Question> findBySubjectIdAndPointIdAndDifficultyIdAndTypeId(int subjectId,int pointId,int difficultyId,int typeId,Pageable pageable);

    //添加题目
    Map<String,Object> addQuestion(QuestionEntity questionEntity);
    //修改题目信息
    Map<String,Object> updateQuestion(int questionId,QuestionEntity questionEntity);
    //删除题目
    Map<String,Object> deleteQuestion(int questionId);

    //根据科目、题型集合查找试题
    QuestionEntity[] getQuestionArray(int typeId, List<Integer>pointIds,int subjectId);

    //查看试题
    Question query(int questionId);

}
