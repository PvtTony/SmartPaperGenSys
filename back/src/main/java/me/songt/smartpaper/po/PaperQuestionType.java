package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "paper_question_type")
public class PaperQuestionType
{
    private int recordId;
    private int paperId;
    private double paperScore;
    private int paperTypeId;

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
    @Column(name = "paper_score", nullable = false, precision = 0)
    public double getPaperScore()
    {
        return paperScore;
    }

    public void setPaperScore(double paperScore)
    {
        this.paperScore = paperScore;
    }

    @Basic
    @Column(name = "paper_type_id", nullable = false)
    public int getPaperTypeId()
    {
        return paperTypeId;
    }

    public void setPaperTypeId(int paperTypeId)
    {
        this.paperTypeId = paperTypeId;
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

        PaperQuestionType that = (PaperQuestionType) o;

        if (recordId != that.recordId)
        {
            return false;
        }
        if (paperId != that.paperId)
        {
            return false;
        }
        if (Double.compare(that.paperScore, paperScore) != 0)
        {
            return false;
        }
        return paperTypeId == that.paperTypeId;
    }

    @Override
    public int hashCode()
    {
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
