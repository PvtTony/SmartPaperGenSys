package me.songt.smartpaper.vo.report;

import me.songt.smartpaper.vo.paper.Paper;

import java.util.List;

/**
 * Created by tony on 2017/5/23.
 */
public class Report
{
    List<LevelReport> examScoreReport;
//    List<LevelReport> examRankReport;
    Paper reportPaper;

    private double minScore;
    private double avgScore;

    public Report()
    {
    }

    public List<LevelReport> getExamScoreReport()
    {
        return examScoreReport;
    }

    public void setExamScoreReport(List<LevelReport> examScoreReport)
    {
        this.examScoreReport = examScoreReport;
    }

   /* public List<LevelReport> getExamRankReport()
    {
        return examRankReport;
    }

    public void setExamRankReport(List<LevelReport> examRankReport)
    {
        this.examRankReport = examRankReport;
    }*/

    public Paper getReportPaper()
    {
        return reportPaper;
    }

    public void setReportPaper(Paper reportPaper)
    {
        this.reportPaper = reportPaper;
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
}
