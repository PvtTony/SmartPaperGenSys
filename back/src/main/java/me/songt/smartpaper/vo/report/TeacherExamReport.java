package me.songt.smartpaper.vo.report;

import me.songt.smartpaper.vo.paper.Paper;
import me.songt.smartpaper.vo.question.Question;

import java.util.List;

/**
 * Created by tony on 2017/5/24.
 */
public class TeacherExamReport
{
    private int paperId;

    private List<StudentExamReport> studentExamReportList;

    private double minScore;
    private double maxScore;
    private double totalScore;

    public TeacherExamReport()
    {
    }

    public int getPaperId()
    {
        return paperId;
    }

    public void setPaperId(int paperId)
    {
        this.paperId = paperId;
    }

    public List<StudentExamReport> getStudentExamReportList()
    {
        return studentExamReportList;
    }

    public void setStudentExamReportList(List<StudentExamReport> studentExamReportList)
    {
        this.studentExamReportList = studentExamReportList;
    }

    public double getMinScore()
    {
        return minScore;
    }

    public void setMinScore(double minScore)
    {
        this.minScore = minScore;
    }

    public double getMaxScore()
    {
        return maxScore;
    }

    public void setMaxScore(double maxScore)
    {
        this.maxScore = maxScore;
    }

    public double getTotalScore()
    {
        return totalScore;
    }

    public void setTotalScore(double totalScore)
    {
        this.totalScore = totalScore;
    }
}
