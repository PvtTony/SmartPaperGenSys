package me.songt.smartpaper.service;

import me.songt.smartpaper.vo.report.Report;
import org.springframework.stereotype.Service;

/**
 * Created by tony on 2017/5/23.
 */
@Service
public interface ExamReportService
{
    Report getExamReport(int studentId, int examId);


}
