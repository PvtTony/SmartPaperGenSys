package me.songt.smartpaper.controller;

import apriori4j.AnalysisResult;
import me.songt.smartpaper.service.DataMiningService;
import me.songt.smartpaper.vo.mining.DataMiningResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tony on 2017/5/25.
 */
@RestController
public class DataMiningController
{
    @Autowired
    private DataMiningService dataMiningService;

    @GetMapping("/smartpaper/exam/{examId}/mining")
    public AnalysisResult getExamResults(@PathVariable("examId") int examId,
                                         @RequestParam(defaultValue = "0.43") double minSupport,
                                         @RequestParam(defaultValue = "0.34") double minConf)
    {
        return dataMiningService.getExamMiningResult(minSupport, minConf, examId);
    }
}
