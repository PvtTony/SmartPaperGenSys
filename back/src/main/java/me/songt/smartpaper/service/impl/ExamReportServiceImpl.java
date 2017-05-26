package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.*;
import me.songt.smartpaper.repository.*;
import me.songt.smartpaper.service.*;
import me.songt.smartpaper.vo.paper.Paper;
import me.songt.smartpaper.vo.report.StudentExamReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by tony on 2017/5/24.
 */
@Service
public class ExamReportServiceImpl implements ExamReportService
{


//    @Qualifier("paperServiceImpl")
    @Autowired
    private PaperService paperService;

//    private ExamService examService;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamPersonRepository examPersonRepository;

    @Autowired
    private ExamResultRepository examResultRepository;

    @Autowired
    private ExamAnswerService examAnswerService;

    @Autowired
    private ExamService examService;

    @Autowired
    private PaperQuestionRepository paperQuestionRepository;

    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentExamReport getExamReport(int studentId, int examId)
    {
        StudentExamReport report = new StudentExamReport();
        int examPaperId = examRepository.findOne(examId).getExamPaperId();
        Paper examPaper = paperService.query(examPaperId);
        PaperEntity paper = paperRepository.findOne(examPaperId);
        report.setPaperId(examPaperId);
        report.setTotalScore(paper.getPaperScore());
        report.setAvgScore(getExamAverage(examId));
        report.setMinScore(getExamScoreMin(examId));
        report.setStudentScore(getExamScore(studentId, examId));
        report.setStudentId(studentId);
        report.setExamPaper(examPaper);
        report.setStudent(studentRepository.findOne(studentId));
        return report;
    }

    @Override
    public List<StudentExamReport> getTotalReport(int studentId)
    {
//        List<ExamResult> results = examResultRepository.findBystudentId(studentId);
        List<StudentExamReport> examReportList = new ArrayList<>();
        List<ExamPerson> personList = examPersonRepository.findByexamStudentId(studentId);
        personList.forEach(person ->
        {
            int examId = person.getExamId();
            examReportList.add(getExamReport(studentId, examId));
        });
        return examReportList;
    }

    @Override
    public List<StudentExamReport> getExamReport(int examId)
    {
        List<ExamPerson> examPeople = examPersonRepository.findByexamId(examId);
        List<StudentExamReport> examReportList = new ArrayList<>();
        examPeople.forEach(examPerson -> {
            int studentId = examPerson.getExamStudentId();
            examReportList.add(getExamReport(studentId, examId));
        });
        return examReportList;
    }

    private double getExamScore(int studentId, int examId)
    {
        double score = getStudentExamTotalScore(examId, studentId);
        return score;
    }


    private double getStudentExamTotalScore(int examId, int studentId)
    {
        ScoreEntity entity = scoreRepository.findByStudentIdEqualsAndExamIdEquals(studentId, examId);
        return entity.getGrade();
    }

    private Double[] getExamScoreList(int examId)
    {
//        Exam exam = examRepository.findOne(examId);
//        int paperId = exam.getExamPaperId();
        List<ExamPerson> personList = examPersonRepository.findByexamId(examId);
        Double[] scoreList = new Double[personList.size()];
        for (int i = 0; i < personList.size(); i++)
        {
            scoreList[i] = getStudentExamTotalScore(examId, personList.get(i).getExamStudentId());
        }
        return scoreList;
    }


    private double getExamAverage(int examId)
    {
//        Exam exam = examRepository.findOne(examId);
//        int paperId = exam.getExamPaperId();
        double totalSum = 0;
        List<ExamPerson> personList = examPersonRepository.findByexamId(examId);
        int size = personList.size();
        for (ExamPerson person : personList)
        {
            int studentId = person.getExamStudentId();
            totalSum += getStudentExamTotalScore(examId, studentId);
        }

        return totalSum / size;
    }

    private double getExamScoreMin(int examId)
    {
        Double[] scoreList = getExamScoreList(examId);
        Arrays.sort(scoreList);
        return scoreList[0];
    }
}
