package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.QuestionEntity;
import me.songt.smartpaper.repository.QuestionRepository;
import me.songt.smartpaper.service.QuestionService;
import me.songt.smartpaper.util.QuestionUtil;
import me.songt.smartpaper.vo.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Sarah on 2017/3/30.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Page<Question> getAll(Pageable pageable) {
        List<QuestionEntity> questionEntities = (List<QuestionEntity>) questionRepository.findAll();
        if (questionEntities!=null)
           return QuestionUtil.dealQuestionPage(questionEntities,pageable);
        return null;
    }

    @Override
    public Page<Question> findBySubjectId(int subjectId,Pageable pageable) {
        List<QuestionEntity> questionEntities = questionRepository.findByQuestionSubjectId(subjectId);
        if (questionEntities!=null)
            return QuestionUtil.dealQuestionPage(questionEntities,pageable);
        return null;
    }

    @Override
    public Page<Question> findBySubjectIdAndPointId(int subjectId, int pointId,Pageable pageable) {
        List<QuestionEntity> questionEntities = questionRepository.findByQuestionSubjectIdAndQuestionKnowledgePointId(subjectId,pointId);
        if (questionEntities!=null)
            return QuestionUtil.dealQuestionPage(questionEntities,pageable);
        return null;
    }

    @Override
    public Page<Question> findBySubjectIdAndDifficultyId(int subjectId, int difficultyId,Pageable pageable) {
        List<QuestionEntity> questionEntities = questionRepository.findByQuestionSubjectIdAndQuestionDifficultyId(subjectId,difficultyId);
        if (questionEntities!=null)
            return QuestionUtil.dealQuestionPage(questionEntities,pageable);
        return null;
    }

    @Override
    public Page<Question> findBySubjectIdAndTypeId(int subjectId, int typeId,Pageable pageable) {
        List<QuestionEntity> questionEntities = questionRepository.findByQuestionSubjectIdAndQuestionTypeId(subjectId,typeId);
        if (questionEntities!=null)
            return QuestionUtil.dealQuestionPage(questionEntities,pageable);
        return null;
    }

    @Override
    public Page<Question> findBySubjectIdAndPointIdAndDifficultyId(int subjectId, int pointId, int difficultyId,Pageable pageable) {
        List<QuestionEntity> questionEntities = questionRepository.findByQuestionSubjectIdAndQuestionKnowledgePointIdAndQuestionDifficultyId(subjectId,pointId,difficultyId);
        if (questionEntities!=null)
            return QuestionUtil.dealQuestionPage(questionEntities,pageable);
        return null;
    }

    @Override
    public Page<Question> findBySubjectIdAndPointIdAndTypeId(int subjectId, int pointId, int typeId,Pageable pageable) {
        List<QuestionEntity> questionEntities = questionRepository.findByQuestionSubjectIdAndQuestionKnowledgePointIdAndQuestionTypeId(subjectId,pointId,typeId);
        if (questionEntities!=null)
            return QuestionUtil.dealQuestionPage(questionEntities,pageable);
        return null;
    }

    @Override
    public Page<Question> findBySubjectIdAndDifficultyIdAndTypeId(int subjectId, int difficultyId, int typeId,Pageable pageable) {
        List<QuestionEntity> questionEntities = questionRepository.findByQuestionSubjectIdAndQuestionDifficultyIdAndQuestionTypeId(subjectId,difficultyId,typeId);
        if (questionEntities!=null)
            return QuestionUtil.dealQuestionPage(questionEntities,pageable);
        return null;
    }

    @Override
    public Page<Question> findBySubjectIdAndPointIdAndDifficultyIdAndTypeId(int subjectId, int pointId, int difficultyId,
                                                                            int typeId,Pageable pageable) {
       List<QuestionEntity> questionEntities =
               questionRepository.findByQuestionSubjectIdAndQuestionKnowledgePointIdAndQuestionDifficultyIdAndQuestionTypeId(subjectId,
                       pointId,difficultyId,typeId);
        if (questionEntities!=null)
            return QuestionUtil.dealQuestionPage(questionEntities,pageable);
        return null;
    }

    @Override
    public Map<String, Object> addQuestion(QuestionEntity questionEntity) {
        Map<String, Object> map = new HashMap<String, Object>();
        questionRepository.save(questionEntity);
        map.put("status",true);
        map.put("message","添加题目成功");
        return map;
    }

    @Override
    public Map<String, Object> updateQuestion(int questionId,QuestionEntity questionEntity) {
        Map<String, Object> map = new HashMap<String, Object>();
        questionRepository.updateQuestion(questionId,questionEntity.getQuestionContent(),questionEntity.getQuestionOption(),
                questionEntity.getQuestionAnswer(),questionEntity.getQuestionOptionCount(),questionEntity.getQuestionSolution());
        map.put("status",true);
        map.put("message","修改题目成功");
        return map;
    }

    @Override
    public Map<String, Object> deleteQuestion(int questionId) {
        Map<String, Object> map = new HashMap<String, Object>();
        questionRepository.delete(questionId);
        map.put("status",true);
        map.put("message","删除题目成功");
        return map;
    }

    @Override
    public QuestionEntity[] getQuestionArray(int typeId,List<Integer>pointIds,int subjectId) {
            List<QuestionEntity> questions = questionRepository.findByQuestionSubjectIdAndQuestionTypeIdAndQuestionKnowledgePointIdIn(subjectId,typeId,pointIds);
        QuestionEntity[] questionEntities = new QuestionEntity[questions.size()];
        return questions.toArray(questionEntities);
    }

    @Override
    public Question query(int questionId) {
        return QuestionUtil.dealQuestion(questionRepository.findOne(questionId));
    }


}
