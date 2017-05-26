package me.songt.smartpaper.vo.exam;

import me.songt.smartpaper.po.Student;
import me.songt.smartpaper.vo.paper.Paper;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by yst on 2017/5/16.
 */
public class Exam
{
    private int examId;
    private String examName;
    private Timestamp examStartTime;
    private Timestamp examEndTime;
    private Paper examPaper;
    private List<Student> examStudentList;

    public Exam()
    {
    }

    public int getExamId()
    {
        return examId;
    }

    public void setExamId(int examId)
    {
        this.examId = examId;
    }

    public String getExamName()
    {
        return examName;
    }

    public void setExamName(String examName)
    {
        this.examName = examName;
    }

    public Timestamp getExamStartTime()
    {
        return examStartTime;
    }

    public void setExamStartTime(Timestamp examStartTime)
    {
        this.examStartTime = examStartTime;
    }

    public Timestamp getExamEndTime()
    {
        return examEndTime;
    }

    public void setExamEndTime(Timestamp examEndTime)
    {
        this.examEndTime = examEndTime;
    }

    public Paper getExamPaper()
    {
        return examPaper;
    }

    public void setExamPaper(Paper examPaper)
    {
        this.examPaper = examPaper;
    }

    public List<Student> getExamStudentList()
    {
        return examStudentList;
    }

    public void setExamStudentList(List<Student> examStudentList)
    {
        this.examStudentList = examStudentList;
    }
}
