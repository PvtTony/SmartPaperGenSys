package me.songt.smartpaper.service;

import me.songt.smartpaper.vo.report.StudentExamReport;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2017/5/23.
 */
@Service
public interface ExamReportService
{
    StudentExamReport getExamReport(int studentId, int examId);

    List<StudentExamReport> getTotalReport(int studentId);

//    List<StudentExamReport>

    List<StudentExamReport> getExamReport(int examId);

    List<StudentExamReport> getAllReport();
}
