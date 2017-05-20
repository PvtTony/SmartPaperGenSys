package me.songt.smartpaper.po;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

/**
 * Created by Sarah on 2017/5/8.
 */

@Entity
@Table(name = "paper_question_type", schema = "smartclass")
public class PaperQuestionTypeEntity {
    private int recordId;
    private int paperId;
    private double paperScore;
    private int paperTypeId;

    @Id
    @Column(name = "record_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "paper_id", nullable = false)
    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    @Basic
    @Column(name = "paper_score", nullable = false, precision = 0)
    public double getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(double paperScore) {
        this.paperScore = paperScore;
    }

    @Basic
    @Column(name = "paper_type_id", nullable = false)
    public int getPaperTypeId() {
        return paperTypeId;
    }

    public void setPaperTypeId(int paperTypeId) {
        this.paperTypeId = paperTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaperQuestionTypeEntity that = (PaperQuestionTypeEntity) o;

        if (recordId != that.recordId) return false;
        if (paperId != that.paperId) return false;
        if (Double.compare(that.paperScore, paperScore) != 0) return false;
        if (paperTypeId != that.paperTypeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = recordId;
        result = 31 * result + paperId;
        temp = Double.doubleToLongBits(paperScore);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + paperTypeId;
        return result;
    }
}
