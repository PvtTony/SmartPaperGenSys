package me.songt.smartpaper.vo.report;

import me.songt.smartpaper.po.Student;

import java.util.List;

/**
 * Created by tony on 2017/5/27.
 */
public class TeacherExamReport
{
    int examId;
    List<StudentExamReport> examReports;

    public TeacherExamReport(int examId, List<StudentExamReport> examReports)
    {
        this.examId = examId;
        this.examReports = examReports;
    }

    public TeacherExamReport()
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

    public List<StudentExamReport> getExamReports()
    {
        return examReports;
    }

    public void setExamReports(List<StudentExamReport> examReports)
    {
        this.examReports = examReports;
    }
}
