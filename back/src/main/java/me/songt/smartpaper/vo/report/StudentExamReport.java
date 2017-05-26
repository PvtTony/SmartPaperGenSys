package me.songt.smartpaper.vo.report;

import me.songt.smartpaper.vo.paper.Paper;

import java.util.List;

/**
 * Created by tony on 2017/5/23.
 */
public class StudentExamReport
{
    private int studentId;
    private double minScore;
    private double avgScore;
    private double studentScore;
    private double totalScore;
    private int paperId;

    public StudentExamReport()
    {
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public double getMinScore()
    {
        return minScore;
    }

    public void setMinScore(double minScore)
    {
        this.minScore = minScore;
    }

    public double getAvgScore()
    {
        return avgScore;
    }

    public void setAvgScore(double avgScore)
    {
        this.avgScore = avgScore;
    }

    public double getStudentScore()
    {
        return studentScore;
    }

    public void setStudentScore(double studentScore)
    {
        this.studentScore = studentScore;
    }

    public double getTotalScore()
    {
        return totalScore;
    }

    public void setTotalScore(double totalScore)
    {
        this.totalScore = totalScore;
    }

    public int getPaperId()
    {
        return paperId;
    }

    public void setPaperId(int paperId)
    {
        this.paperId = paperId;
    }
}
