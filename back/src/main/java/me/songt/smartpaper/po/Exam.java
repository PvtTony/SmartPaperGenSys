package me.songt.smartpaper.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
public class Exam
{
    private int examId;
    private Timestamp examEndtime;
    private String examName;
    private int examPaperId;
    private Timestamp examStartTime;

    @Id
    @Column(name = "exam_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getExamId()
    {
        return examId;
    }

    public void setExamId(int examId)
    {
        this.examId = examId;
    }

    @Basic
    @Column(name = "exam_endtime", nullable = false)
    public Timestamp getExamEndtime()
    {
        return examEndtime;
    }

    public void setExamEndtime(Timestamp examEndtime)
    {
        this.examEndtime = examEndtime;
    }

    @Basic
    @Column(name = "exam_name", nullable = false, length = 200)
    public String getExamName()
    {
        return examName;
    }

    public void setExamName(String examName)
    {
        this.examName = examName;
    }

    @Basic
    @Column(name = "exam_paper_id", nullable = false)
    public int getExamPaperId()
    {
        return examPaperId;
    }

    public void setExamPaperId(int examPaperId)
    {
        this.examPaperId = examPaperId;
    }

    @Basic
    @Column(name = "exam_start_time", nullable = false)
    public Timestamp getExamStartTime()
    {
        return examStartTime;
    }

    public void setExamStartTime(Timestamp examStartTime)
    {
        this.examStartTime = examStartTime;
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

        Exam exam = (Exam) o;

        if (examId != exam.examId)
        {
            return false;
        }
        if (examPaperId != exam.examPaperId)
        {
            return false;
        }
        if (examEndtime != null ? !examEndtime.equals(exam.examEndtime) : exam.examEndtime != null)
        {
            return false;
        }
        if (examName != null ? !examName.equals(exam.examName) : exam.examName != null)
        {
            return false;
        }
        return examStartTime != null ? examStartTime.equals(exam.examStartTime) : exam.examStartTime == null;
    }

    @Override
    public int hashCode()
    {
        int result = examId;
        result = 31 * result + (examEndtime != null ? examEndtime.hashCode() : 0);
        result = 31 * result + (examName != null ? examName.hashCode() : 0);
        result = 31 * result + examPaperId;
        result = 31 * result + (examStartTime != null ? examStartTime.hashCode() : 0);
        return result;
    }
}
