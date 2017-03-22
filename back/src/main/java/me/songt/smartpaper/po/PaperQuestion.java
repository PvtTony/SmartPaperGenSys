package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "paper_question")
public class PaperQuestion
{
    private int recordId;
    private int paperId;
    private int paperQuestionId;
    private double paperScore;

    @Id
    @Column(name = "record_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getRecordId()
    {
        return recordId;
    }

    public void setRecordId(int recordId)
    {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "paper_id", nullable = false)
    public int getPaperId()
    {
        return paperId;
    }

    public void setPaperId(int paperId)
    {
        this.paperId = paperId;
    }

    @Basic
    @Column(name = "paper_question_id", nullable = false)
    public int getPaperQuestionId()
    {
        return paperQuestionId;
    }

    public void setPaperQuestionId(int paperQuestionId)
    {
        this.paperQuestionId = paperQuestionId;
    }

    @Basic
    @Column(name = "paper_score", nullable = false, precision = 0)
    public double getPaperScore()
    {
        return paperScore;
    }

    public void setPaperScore(double paperScore)
    {
        this.paperScore = paperScore;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        PaperQuestion that = (PaperQuestion) o;

        if (recordId != that.recordId)
        {
            return false;
        }
        if (paperId != that.paperId)
        {
            return false;
        }
        if (paperQuestionId != that.paperQuestionId)
        {
            return false;
        }
        return Double.compare(that.paperScore, paperScore) == 0;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = recordId;
        result = 31 * result + paperId;
        result = 31 * result + paperQuestionId;
        temp = Double.doubleToLongBits(paperScore);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
