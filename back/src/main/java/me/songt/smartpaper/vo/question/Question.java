package me.songt.smartpaper.vo.question;

import java.util.List;

/**
 * Created by Sarah on 2017/3/30.
 */
public class Question {
    private int questionId;
    private String questionContent;
    private List<OptionSolution> optionSolutions;  //选项解析集合
    private String questionAttachUrl;
    private String questionAnswer;
    private int questionTypeId;
    private int questionDifficultyId;
    private int questionSubjectId;
    private int questionKnowledgePointId;

    public Question(int questionId, String questionContent, String questionAttachUrl, String questionAnswer, int questionTypeId, int questionDifficultyId, int questionSubjectId, int questionKnowledgePointId) {
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.questionAttachUrl = questionAttachUrl;
        this.questionAnswer = questionAnswer;
        this.questionTypeId = questionTypeId;
        this.questionDifficultyId = questionDifficultyId;
        this.questionSubjectId = questionSubjectId;
        this.questionKnowledgePointId = questionKnowledgePointId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public List<OptionSolution> getOptionSolutions() {
        return optionSolutions;
    }

    public void setOptionSolutions(List<OptionSolution> optionSolutions) {
        this.optionSolutions = optionSolutions;
    }

    public String getQuestionAttachUrl() {
        return questionAttachUrl;
    }

    public void setQuestionAttachUrl(String questionAttachUrl) {
        this.questionAttachUrl = questionAttachUrl;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public int getQuestionDifficultyId() {
        return questionDifficultyId;
    }

    public void setQuestionDifficultyId(int questionDifficultyId) {
        this.questionDifficultyId = questionDifficultyId;
    }

    public int getQuestionSubjectId() {
        return questionSubjectId;
    }

    public void setQuestionSubjectId(int questionSubjectId) {
        this.questionSubjectId = questionSubjectId;
    }

    public int getQuestionKnowledgePointId() {
        return questionKnowledgePointId;
    }

    public void setQuestionKnowledgePointId(int questionKnowledgePointId) {
        this.questionKnowledgePointId = questionKnowledgePointId;
    }
}
