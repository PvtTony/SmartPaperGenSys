package me.songt.smartpaper.vo.paper;

import me.songt.smartpaper.vo.question.OptionSolution;

import java.util.List;

/**
 * Created by Sarah on 2017/5/8.
 */
public class PaperQuestion {
    private int questionId;
    private String questionContent; //题目内容
    private List<OptionSolution> items;  //选项
    private double questionScore;
    private String answer;
    private int typeId;

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

    public List<OptionSolution> getItems() {
        return items;
    }

    public void setItems(List<OptionSolution> items) {
        this.items = items;
    }

    public double getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(double questionScore) {
        this.questionScore = questionScore;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
