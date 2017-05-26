package me.songt.smartpaper.controller;

import apriori4j.AnalysisResult;
import me.songt.smartpaper.service.DataMiningService;
import me.songt.smartpaper.vo.paper.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tony on 2017/5/25.
 */
@RestController
public class DataMiningController
{
    @Autowired
    private DataMiningService dataMiningService;

    @GetMapping("/smartpaper/exam/{examId}/student/{studentId}/mining")
    public AnalysisResult getExamResults(@PathVariable("examId") int examId,
                                         @PathVariable("studentId") int studentId,
                                         @RequestParam(defaultValue = "0.1") double minSupport,
                                         @RequestParam(defaultValue = "0.3") double minConf)
    {
        AnalysisResult result = dataMiningService.getExamMiningResult(minSupport, minConf, examId);
        Paper paper = dataMiningService.addAnalysisReportToPaper(studentId, result, examId);
        dataMiningService.addPaperToPractice(paper, studentId);
        return result;
    }
}
