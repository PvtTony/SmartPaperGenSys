package me.songt.smartpaper.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.songt.smartpaper.po.PaperEntity;
import me.songt.smartpaper.po.PaperQuestionEntity;
import me.songt.smartpaper.po.PaperQuestionTypeEntity;
import me.songt.smartpaper.service.PaperService;
import me.songt.smartpaper.service.QuestionService;
import me.songt.smartpaper.util.generationAlgorithm.GeneratePaper;
import me.songt.smartpaper.util.generationAlgorithm.Individual;
import me.songt.smartpaper.util.generationAlgorithm.RuleBean;
import me.songt.smartpaper.vo.paper.Paper;
import me.songt.smartpaper.vo.paper.PaperQuestion;
import me.songt.smartpaper.vo.paper.PaperQuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Sarah on 2017/5/11.
 */
@RestController
@RequestMapping(value = "/smartpaper/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;
    @Autowired
    private QuestionService questionService;

    //根据科目获取试卷列表
    @ApiOperation(value = "根据科目获取试卷列表")
    @ApiImplicitParam(name = "subjectId", value = "科目id", required = true, dataType = "Integer",paramType = "path")
    @RequestMapping(value = "/subjects/{subjectId}",method = RequestMethod.GET)
    public List<PaperEntity> getPaperList(@PathVariable int subjectId){
        return paperService.getAllPaper(subjectId);
    }

    //根据用户id获取试卷列表
    @ApiOperation(value = "根据用户id获取试卷列表")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Integer",paramType = "path")
    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public List<PaperEntity> getPaperByUser(@PathVariable int userId){
        return paperService.getPaperByUser(userId);
    }

    //删除试卷
    @ApiOperation(value = "删除试卷")
    @ApiImplicitParam(name = "paperId", value = "试卷id", required = true, dataType = "Integer",paramType = "path")
    @RequestMapping(value = "/{paperId}",method = RequestMethod.DELETE)
    public Map<String,Object> deletePaper(@PathVariable int paperId){
        return paperService.deletePaper(paperId);
    }

    //查询试卷
    @ApiOperation(value = "查询试卷")
    @ApiImplicitParam(name = "paperId", value = "试卷id", required = true, dataType = "Integer",paramType = "path")
    @RequestMapping(value = "/{paperId}",method = RequestMethod.GET)
    public Paper queryPaper(@PathVariable int paperId){
        return paperService.query(paperId);
    }

    //添加试卷
    @ApiOperation(value = "添加试卷")
    @ApiImplicitParam(name = "paper", value = "试卷实体", required = true, dataType = "Paper")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Paper addPaper(@RequestBody Paper paper){
        PaperEntity paperEntity = new PaperEntity();
        paperEntity.setPaperUserId(paper.getUserId());
        paperEntity.setPaperTitle(paper.getTitle());
        paperEntity.setPaperScore(paper.getTotalScore());
        paperEntity.setPaperSubjectId(paper.getSubjectId());

        List<PaperQuestionTypeEntity> typeEntities = new ArrayList<PaperQuestionTypeEntity>();
        List<PaperQuestionEntity> questionEntities = new ArrayList<PaperQuestionEntity>();
        System.out.println(paper.getPaperTypesAndQuestions().size());
        for (PaperQuestionType questionType:paper.getPaperTypesAndQuestions()){
            PaperQuestionTypeEntity typeEntity = new PaperQuestionTypeEntity();
            typeEntity.setPaperTypeId(questionType.getTypeId());
            typeEntity.setPaperScore(questionType.getScore());
            typeEntities.add(typeEntity);

           for (PaperQuestion question:questionType.getPaperQuestions()){
               PaperQuestionEntity questionEntity = new PaperQuestionEntity();
               questionEntity.setPaperQuestionId(question.getQuestionId());
               questionEntity.setPaperScore(question.getQuestionScore());
               questionEntities.add(questionEntity);
           }
        }
       return paperService.addPaper(paperEntity,typeEntities,questionEntities);
    }

    //自动组卷
    @ApiOperation(value = "自动组卷")
//    @ApiImplicitParam(name = "rule",value = "组卷规则实体",required = true,dataType = "RuleBean",paramType = "body")
    @RequestMapping(value = "/smart/",method = RequestMethod.POST)
    public Map<String,Object>  autoGeneratePaper(@RequestBody RuleBean rule){
        Map<String,Object> map = new HashMap<String,Object>();
        GeneratePaper  generator = new GeneratePaper();
        Individual individual = generator.getPaper(rule,questionService);
        System.out.println(rule.getDifficulty());
        if (!generator.isErrorFlag()){
            System.out.println("适应度"+ individual.getAdaptationDegree());
            Paper paper = new Paper();
            List<PaperQuestionType> types = rule.getEachTypeCount();
            List<PaperQuestion> questions = paperService.changeToPaperQuestion(individual.getQuestionList());
            paper.setPaperTypesAndQuestions(paperService.classifyByType(types,questions));
            map.put("status",true);
            map.put("paper",paper);
            return map;
        }

        map.put("status",false);
        map.put("errorMsg",generator.getErrorMsg());
        return map;
    }

}
