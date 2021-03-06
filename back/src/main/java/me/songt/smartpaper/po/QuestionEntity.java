package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by Sarah on 2017/5/20.
 */
@Entity
@Table(name = "question", schema = "smartclass")
public class QuestionEntity {
    private int questionId;
    private String questionContent;
    private String questionAttachUrl;
    private String questionOption;
    private String questionAnswer;
    private int questionTypeId;
    private int questionDifficultyId;
    private int questionOptionCount;
    private String questionSolution;
    private int questionSubjectId;
    private int questionKnowledgePointId;

    @Id
    @Column(name = "question_id", nullable = false)
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "question_content", nullable = true, length = -1)
    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @Basic
    @Column(name = "question_attach_url", nullable = true, length = 255)
    public String getQuestionAttachUrl() {
        return questionAttachUrl;
    }

    public void setQuestionAttachUrl(String questionAttachUrl) {
        this.questionAttachUrl = questionAttachUrl;
    }

    @Basic
    @Column(name = "question_option", nullable = false, length = -1)
    public String getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }

    @Basic
    @Column(name = "question_answer", nullable = false, length = -1)
    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    @Basic
    @Column(name = "question_type_id", nullable = false)
    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    @Basic
    @Column(name = "question_difficulty_id", nullable = false)
    public int getQuestionDifficultyId() {
        return questionDifficultyId;
    }

    public void setQuestionDifficultyId(int questionDifficultyId) {
        this.questionDifficultyId = questionDifficultyId;
    }

    @Basic
    @Column(name = "question_option_count", nullable = false)
    public int getQuestionOptionCount() {
        return questionOptionCount;
    }

    public void setQuestionOptionCount(int questionOptionCount) {
        this.questionOptionCount = questionOptionCount;
    }

    @Basic
    @Column(name = "question_solution", nullable = false, length = -1)
    public String getQuestionSolution() {
        return questionSolution;
    }

    public void setQuestionSolution(String questionSolution) {
        this.questionSolution = questionSolution;
    }

    @Basic
    @Column(name = "question_subject_id", nullable = false)
    public int getQuestionSubjectId() {
        return questionSubjectId;
    }

    public void setQuestionSubjectId(int questionSubjectId) {
        this.questionSubjectId = questionSubjectId;
    }

    @Basic
    @Column(name = "question_knowledge_point_id", nullable = false)
    public int getQuestionKnowledgePointId() {
        return questionKnowledgePointId;
    }

    public void setQuestionKnowledgePointId(int questionKnowledgePointId) {
        this.questionKnowledgePointId = questionKnowledgePointId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity that = (QuestionEntity) o;

        if (questionId != that.questionId) return false;
        if (questionTypeId != that.questionTypeId) return false;
        if (questionDifficultyId != that.questionDifficultyId) return false;
        if (questionOptionCount != that.questionOptionCount) return false;
        if (questionSubjectId != that.questionSubjectId) return false;
        if (questionKnowledgePointId != that.questionKnowledgePointId) return false;
        if (questionContent != null ? !questionContent.equals(that.questionContent) : that.questionContent != null)
            return false;
        if (questionAttachUrl != null ? !questionAttachUrl.equals(that.questionAttachUrl) : that.questionAttachUrl != null)
            return false;
        if (questionOption != null ? !questionOption.equals(that.questionOption) : that.questionOption != null)
            return false;
        if (questionAnswer != null ? !questionAnswer.equals(that.questionAnswer) : that.questionAnswer != null)
            return false;
        if (questionSolution != null ? !questionSolution.equals(that.questionSolution) : that.questionSolution != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + (questionContent != null ? questionContent.hashCode() : 0);
        result = 31 * result + (questionAttachUrl != null ? questionAttachUrl.hashCode() : 0);
        result = 31 * result + (questionOption != null ? questionOption.hashCode() : 0);
        result = 31 * result + (questionAnswer != null ? questionAnswer.hashCode() : 0);
        result = 31 * result + questionTypeId;
        result = 31 * result + questionDifficultyId;
        result = 31 * result + questionOptionCount;
        result = 31 * result + (questionSolution != null ? questionSolution.hashCode() : 0);
        result = 31 * result + questionSubjectId;
        result = 31 * result + questionKnowledgePointId;
        return result;
    }
}
