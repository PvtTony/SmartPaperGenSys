package me.songt.smartpaper.po;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sarah on 2017/5/11.
 */
@Entity
@Table(name = "paper", schema = "smartclass")
public class PaperEntity {
    private int paperId;
    private byte paperIsShare;
    private double paperScore;
    private int paperSubjectId;
    private String paperTitle;
    private int paperUserId;
    private Timestamp paperGenerateTime;

    @Id
    @Column(name = "paper_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    @Basic
    @Column(name = "paper_is_share", nullable = false)
    public byte getPaperIsShare() {
        return paperIsShare;
    }

    public void setPaperIsShare(byte paperIsShare) {
        this.paperIsShare = paperIsShare;
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
    @Column(name = "paper_subject_id", nullable = false)
    public int getPaperSubjectId() {
        return paperSubjectId;
    }

    public void setPaperSubjectId(int paperSubjectId) {
        this.paperSubjectId = paperSubjectId;
    }

    @Basic
    @Column(name = "paper_title", nullable = false, length = 50)
    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    @Basic
    @Column(name = "paper_user_id", nullable = false)
    public int getPaperUserId() {
        return paperUserId;
    }

    public void setPaperUserId(int paperUserId) {
        this.paperUserId = paperUserId;
    }

    @Basic
    @Column(name = "paper_generate_time", nullable = false)
    public Timestamp getPaperGenerateTime() {
        return paperGenerateTime;
    }

    public void setPaperGenerateTime(Timestamp paperGenerateTime) {
        this.paperGenerateTime = paperGenerateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaperEntity that = (PaperEntity) o;

        if (paperId != that.paperId) return false;
        if (paperIsShare != that.paperIsShare) return false;
        if (Double.compare(that.paperScore, paperScore) != 0) return false;
        if (paperSubjectId != that.paperSubjectId) return false;
        if (paperUserId != that.paperUserId) return false;
        if (paperTitle != null ? !paperTitle.equals(that.paperTitle) : that.paperTitle != null) return false;
        if (paperGenerateTime != null ? !paperGenerateTime.equals(that.paperGenerateTime) : that.paperGenerateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = paperId;
        result = 31 * result + (int) paperIsShare;
        temp = Double.doubleToLongBits(paperScore);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + paperSubjectId;
        result = 31 * result + (paperTitle != null ? paperTitle.hashCode() : 0);
        result = 31 * result + paperUserId;
        result = 31 * result + (paperGenerateTime != null ? paperGenerateTime.hashCode() : 0);
        return result;
    }
}
