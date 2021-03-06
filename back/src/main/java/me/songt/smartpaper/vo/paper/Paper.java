package me.songt.smartpaper.vo.paper;



import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by Sarah on 2017/5/8.
 */
public class Paper {
    private int paperId;
    private String title; //试卷标题
    private double totalScore; //总分
    private List<PaperQuestionType> paperTypesAndQuestions;
    private int subjectId;
    private int userId;

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<PaperQuestionType> getPaperTypesAndQuestions() {
        return paperTypesAndQuestions;
    }

    public void setPaperTypesAndQuestions(List<PaperQuestionType> paperTypesAndQuestions) {
        this.paperTypesAndQuestions = paperTypesAndQuestions;
    }
}
