package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.PaperEntity;
import me.songt.smartpaper.po.PaperQuestionEntity;
import me.songt.smartpaper.po.PaperQuestionTypeEntity;
import me.songt.smartpaper.po.QuestionEntity;
import me.songt.smartpaper.repository.*;
import me.songt.smartpaper.service.PaperService;
import me.songt.smartpaper.util.QuestionUtil;
import me.songt.smartpaper.vo.paper.Paper;
import me.songt.smartpaper.vo.paper.PaperQuestion;
import me.songt.smartpaper.vo.paper.PaperQuestionType;
import me.songt.smartpaper.vo.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sarah on 2017/5/8.
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperRepository paperRepository;
    @Autowired
    private PaperQuestionTypeRepository questionTypeRepository;
    @Autowired
    private PaperQuestionRepository paperQuestionRepository;
    @Autowired
    private QuestionTypeRepository typeRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Map<String, Object> addPaper(PaperEntity paper, List<PaperQuestionTypeEntity> types, List<PaperQuestionEntity> questions) {
        Map<String, Object> map = new HashMap<String, Object>();
        paper.setPaperGenerateTime(new Timestamp(System.currentTimeMillis()));
        paperRepository.save(paper);
        int paperId =paper.getPaperId();

        for (PaperQuestionTypeEntity type:types){
            type.setPaperId(paperId);
            questionTypeRepository.save(type);
        }

        for (PaperQuestionEntity question:questions){
            question.setPaperId(paperId);
            paperQuestionRepository.save(question);

        }

        map.put("status",true);
        map.put("message","添加试卷成功");
        return map;
    }

    @Override
    public Map<String, Object> deletePaper(int paperId) {
        Map<String, Object> map = new HashMap<String, Object>();

        paperRepository.delete(paperId);
        questionTypeRepository.deleteByPaperId(paperId);
        paperQuestionRepository.deleteByPaperId(paperId);

        map.put("status",true);
        map.put("message","删除试卷成功");
        return map;
    }

    @Override
    public Paper query(int paperId) {
        Paper paper = new Paper();

        //根据试卷id查找到试卷
        PaperEntity p = paperRepository.findOne(paperId);
        paper.setPaperId(p.getPaperId());
        paper.setTitle(p.getPaperTitle());
        paper.setTotalScore(p.getPaperScore());
        paper.setSubjectId(p.getPaperSubjectId());
        paper.setUserId(p.getPaperUserId());

        //根据试卷id查找到所含题型
        List<PaperQuestionTypeEntity> typeEntities = questionTypeRepository.findByPaperId(paperId);
        List<PaperQuestionType> types = changeToPaperQuestionType(typeEntities);

        //根据试卷id查找到所含试题
        List<PaperQuestionEntity> questionEntities = paperQuestionRepository.findByPaperId(paperId);
        List<QuestionEntity> questionList = new ArrayList<QuestionEntity>();
        for(PaperQuestionEntity questionEntity:questionEntities) {
            QuestionEntity entity = questionRepository.findOne(questionEntity.getPaperQuestionId());
            questionList.add(entity);
        }
        List<PaperQuestion> questions = changeToPaperQuestion(questionList);
        for (int i=0;i<questions.size();i++)
                questions.get(i).setQuestionScore(questionEntities.get(i).getPaperScore());


        //将试题按题型分类
        types = classifyByType(types,questions);

        paper.setPaperTypesAndQuestions(types);

        return paper;
    }


    //将试题按题型分类
    @Override
    public   List<PaperQuestionType> classifyByType(List<PaperQuestionType> types,List<PaperQuestion> questions){
        for (PaperQuestionType type:types){
            List<PaperQuestion> paperQuestions = new ArrayList<PaperQuestion>();
            for (PaperQuestion question:questions){
                if (question.getTypeId()==type.getTypeId()){
                    paperQuestions.add(question);
                }
            }
            type.setCount(paperQuestions.size());
            type.setPaperQuestions(paperQuestions);
        }
        return types;
    }

    @Override
    public List<PaperQuestion> changeToPaperQuestion(List<QuestionEntity> questionList){
        List<PaperQuestion> questions = new ArrayList<PaperQuestion>();
        for(QuestionEntity questionEntity:questionList){
            Question q = QuestionUtil.dealQuestion(questionEntity);
            PaperQuestion question = new PaperQuestion();
            question.setQuestionId(q.getQuestionId());
            question.setQuestionContent(q.getQuestionContent());
            question.setItems(q.getOptionSolutions());
            question.setAnswer(q.getQuestionAnswer());
            question.setTypeId(q.getQuestionTypeId());

            questions.add(question);
        }
        return questions;
    }

    @Override
    public List<PaperQuestionType> changeToPaperQuestionType( List<PaperQuestionTypeEntity> typeEntities){
        List<PaperQuestionType> types = new ArrayList<PaperQuestionType>();
        for(PaperQuestionTypeEntity type:typeEntities){
            PaperQuestionType questionType = new PaperQuestionType();
            questionType.setTypeId(type.getPaperTypeId());
            String typeName = typeRepository.findOne(type.getPaperTypeId()).getTypeName();
            questionType.setTypeName(typeName);
            questionType.setScore(type.getPaperScore());

            types.add(questionType);
        }
        return types;
    }


    @Override
    public List<PaperEntity> getAllPaper(int subjectId) {
        return paperRepository.findByPaperSubjectId(subjectId);
    }

    @Override
    public List<PaperEntity> getPaperByUser(int userId) {
        return paperRepository.findByPaperUserId(userId);
    }

}
