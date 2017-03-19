package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
public class Paper
{
    private int paperId;
    private byte paperIsShare;
    private double paperScore;
    private int paperSubjectId;
    private int paperTitle;
    private int paperUserId;

    @Id
    @Column(name = "paper_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getPaperId()
    {
        return paperId;
    }

    public void setPaperId(int paperId)
    {
        this.paperId = paperId;
    }

    @Basic
    @Column(name = "paper_is_share", nullable = false)
    public byte getPaperIsShare()
    {
        return paperIsShare;
    }

    public void setPaperIsShare(byte paperIsShare)
    {
        this.paperIsShare = paperIsShare;
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
    @Column(name = "paper_subject_id", nullable = false)
    public int getPaperSubjectId()
    {
        return paperSubjectId;
    }

    public void setPaperSubjectId(int paperSubjectId)
    {
        this.paperSubjectId = paperSubjectId;
    }

    @Basic
    @Column(name = "paper_title", nullable = false)
    public int getPaperTitle()
    {
        return paperTitle;
    }

    public void setPaperTitle(int paperTitle)
    {
        this.paperTitle = paperTitle;
    }

    @Basic
    @Column(name = "paper_user_id", nullable = false)
    public int getPaperUserId()
    {
        return paperUserId;
    }

    public void setPaperUserId(int paperUserId)
    {
        this.paperUserId = paperUserId;
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

        Paper paper = (Paper) o;

        if (paperId != paper.paperId)
        {
            return false;
        }
        if (paperIsShare != paper.paperIsShare)
        {
            return false;
        }
        if (Double.compare(paper.paperScore, paperScore) != 0)
        {
            return false;
        }
        if (paperSubjectId != paper.paperSubjectId)
        {
            return false;
        }
        if (paperTitle != paper.paperTitle)
        {
            return false;
        }
        return paperUserId == paper.paperUserId;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = paperId;
        result = 31 * result + (int) paperIsShare;
        temp = Double.doubleToLongBits(paperScore);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + paperSubjectId;
        result = 31 * result + paperTitle;
        result = 31 * result + paperUserId;
        return result;
    }
}
