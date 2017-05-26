package me.songt.smartpaper.service;

import apriori4j.AnalysisResult;
import me.songt.smartpaper.vo.mining.DataMiningResult;
import me.songt.smartpaper.vo.paper.Paper;

import java.util.List;

/**
 * Created by tony on 2017/5/25.
 */
public interface DataMiningService
{
    AnalysisResult getExamMiningResult(double minSupport, double minConfident, int examId);

    //    public void addWrongAnswer(AnalysisResult result);
    Paper addAnalysisReportToPaper(int studentId, AnalysisResult result, int examId);

    void addPaperToPractice(Paper paper, int studentId);
}