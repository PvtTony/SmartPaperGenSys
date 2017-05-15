package me.songt.smartpaper.util.generationAlgorithm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import me.songt.smartpaper.po.QuestionType;
import me.songt.smartpaper.vo.paper.PaperQuestionType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sarah on 2017/5/9.
 */
//组卷约束条件
    @ApiModel
    @Component
public class RuleBean {
    @ApiModelProperty(name = "difficulty",value = "试卷期望难度系数对应id",dataType = "long")
    private int difficulty; //试卷期望难度系数
    @ApiModelProperty(name = "eachTypeCount",value = "题型题数list",dataType = "PaperQuestionType")
    private List<PaperQuestionType> eachTypeCount; // 各种题型题数
    @ApiModelProperty(name = "pointIds",value = "试卷包含的知识点id集合",dataType = "Integer")
    private List<Integer> pointIds; //试卷包含的知识点id
    @ApiModelProperty(name = "subjectId",value = "科目id",dataType = "long")
    private int subjectId;  //科目id

    public RuleBean(){

    }

    public RuleBean(int difficulty, List<PaperQuestionType> eachTypeCount, List<Integer> pointIds, int subjectId) {
        this.difficulty = difficulty;
        this.eachTypeCount = eachTypeCount;
        this.pointIds = pointIds;
        this.subjectId = subjectId;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public List<PaperQuestionType> getEachTypeCount() {
        return eachTypeCount;
    }

    public void setEachTypeCount(List<PaperQuestionType> eachTypeCount) {
        this.eachTypeCount = eachTypeCount;
    }

    public List<Integer> getPointIds() {
        return pointIds;
    }

    public void setPointIds(List<Integer> pointIds) {
        this.pointIds = pointIds;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
