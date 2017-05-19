package me.songt.smartpaper.controller;

import me.songt.smartpaper.po.Student;
import me.songt.smartpaper.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
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


    @GetMapping("/smartpaper/exam/studentId/{studentId}")
    public List<Exam> findExamByStudentId(@PathVariable("studentId") int studentId,
                                          @RequestParam(defaultValue = "1") int pageIndex,
                                          @RequestParam(defaultValue = "10") int pageSize,
                                          @RequestParam(defaultValue = "examName") String sortField,
                                          @RequestParam(defaultValue = "1") int desc)
    {
        return examService.getExamByStudentId(studentId, pageIndex, pageSize, sortField, desc == 1);
    }

    @PostMapping
    public Exam addExam(@RequestParam String examName,
                        @RequestParam long startTime,
                        @RequestParam long endTime,
                        @RequestParam int paperId)
    {
        return examService.addExam(examName, startTime, endTime, paperId);
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




}
