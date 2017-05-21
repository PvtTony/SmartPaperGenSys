package me.songt.smartpaper.service;

//import me.songt.smartpaper.po.ExamPerson;
import me.songt.smartpaper.po.Student;
import me.songt.smartpaper.vo.exam.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yst on 2017/5/16.
 */

@Service
public interface ExamService
{
    List<Exam> getExamByStudentId(int studentId);

    Exam addExam(String examName, long startTime, long endTime, int paperId);

    Exam modifyExam(int examId, String examName, long startTime, long endTime, int paperId);

    Exam getExamById(int examId);

    void removeExamById(int examId);

    void addExamPerson(int examId, int studentId);

    List<Student> getExamPersonList(int examId);

    void removeExamPerson(int examId, int studentId);


}
