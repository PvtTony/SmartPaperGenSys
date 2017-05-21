package me.songt.smartpaper.service;


import me.songt.smartpaper.po.PaperEntity;
import me.songt.smartpaper.po.PaperQuestionEntity;
import me.songt.smartpaper.po.PaperQuestionTypeEntity;
import me.songt.smartpaper.po.QuestionEntity;
import me.songt.smartpaper.vo.paper.Paper;
import me.songt.smartpaper.vo.paper.PaperQuestion;
import me.songt.smartpaper.vo.paper.PaperQuestionType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Sarah on 2017/5/8.
 */
@Service
public interface PaperService {

    //添加试卷
    Paper addPaper(PaperEntity paper, List<PaperQuestionTypeEntity> types, List<PaperQuestionEntity> questions);
    //删除试卷
    Map<String, Object> deletePaper(int paperId);
    //查看试卷
    Paper query(int paperId);

    //根据科目获得所有试卷
    List<PaperEntity> getAllPaper(int subjectId);
    //根据用户id查找试卷
    List<PaperEntity> getPaperByUser(int userId);

    List<PaperQuestion> changeToPaperQuestion(List<QuestionEntity> questionList);
    List<PaperQuestionType> changeToPaperQuestionType(List<PaperQuestionTypeEntity> typeEntities);
    //将试题按题型分类
    List<PaperQuestionType> classifyByType(List<PaperQuestionType> types,List<PaperQuestion> questions);
}
