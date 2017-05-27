package me.songt.smartpaper.controller;

import me.songt.smartpaper.po.ExamResult;
//import me.songt.smartpaper.po.ExamResult;
import me.songt.smartpaper.po.Student;
import me.songt.smartpaper.service.ExamAnswerService;
import me.songt.smartpaper.service.ExamReportService;
import me.songt.smartpaper.service.ExamService;
import me.songt.smartpaper.vo.report.StudentExamReport;
import me.songt.smartpaper.vo.report.TeacherExamReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import me.songt.smartpaper.vo.exam.Exam;

import java.util.List;

/**
 * Created by yst on 2017/5/17.
 */
@RestController
public class ExamController
{

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamAnswerService examAnswerService;

    @Autowired
    private ExamReportService examReportService;

    @GetMapping("/smartpaper/exam/studentId/{studentId}")
    public List<Exam> findExamByStudentId(@PathVariable("studentId") int studentId)
    {
        return examService.getExamByStudentId(studentId);
    }

    @GetMapping("/smartpaper/exam")
    public List<Exam> getAllExam()
    {
        return examService.getAllExams();
    }

    @PostMapping("/smartpaper/exam")
    public Exam addExam(@RequestParam String examName,
                        @RequestParam long startTime,
                        @RequestParam long endTime,
                        @RequestParam int paperId)
    {
        Exam exam = examService.addExam(examName, startTime, endTime, paperId);
        int examid = exam.getExamId();
        examService.addExamPerson(examid, 1);
        return exam;
    }

    @PostMapping("/smartpaper/exam/studentId/{studentId}/{paperId}")
    public List<ExamResult> submitAnswer(@PathVariable("paperId") int paperId,
                                         @PathVariable("studentId") int studentId,
                                         @RequestParam String answerJson)
    {
        return examAnswerService.addStudentAnswer(paperId, studentId, answerJson);
    }

    @PutMapping("/smartpaper/exam/{examId}")
    public Exam modifyExam(@PathVariable("examId") int examId,
                           @RequestParam String examName,
                           @RequestParam long startTime,
                           @RequestParam long endTime,
                           @RequestParam int paperId)
    {
        return examService.modifyExam(examId, examName, startTime, endTime, paperId);
    }

    @GetMapping("/smartpaper/exam/{examId}")
    public Exam getExamById(@PathVariable("examId") int examId)
    {
        return examService.getExamById(examId);
    }

    @DeleteMapping("/smartpaper/exam/{examId}")
    public void removeExamById(@PathVariable int examId)
    {
        examService.removeExamById(examId);
//        return "ok";
    }

    @PostMapping("/smartpaper/exam/{examId}/student")
    public void addExamPerson(@PathVariable("examId") int examId,@RequestParam int studentId)
    {
        examService.addExamPerson(examId, studentId);
    }

    @GetMapping("/smartpaper/exam/{examId}/student")
    public List<Student> getExamPersonList(@PathVariable("examId") int examId)
    {
        return examService.getExamPersonList(examId);
    }

    @DeleteMapping("/smartpaper/exam/{examId}/student/{studentId}")
    public void removeExamPerson(@PathVariable("examId") int examId,
                                 @PathVariable("studentId") int studentId)
    {
        examService.removeExamPerson(examId, studentId);
    }

    @GetMapping("/smartpaper/exam/{examId}/student/{studentId}/report")
    public StudentExamReport getExamReport(@PathVariable("studentId") int studentId, @PathVariable("examId") int examId)
    {
        return examReportService.getExamReport(studentId, examId);
    }

    @GetMapping("/smartpaper/exam/student/{studentId}/report")
    public List<StudentExamReport> getExamReportByStudentId(@PathVariable("studentId") int studentId)
    {
        return examReportService.getTotalReport(studentId);
    }

    @GetMapping("/smartpaper/exam/{examId}/report")
    public List<StudentExamReport> getExamReport(@PathVariable("examId") int examid)
    {
        return examReportService.getExamReport(examid);
    }

    @GetMapping("/smartpaper/exam/report")
    public List<TeacherExamReport> getAllExamReport()
    {
        return examReportService.getAllReport();
    }




}
