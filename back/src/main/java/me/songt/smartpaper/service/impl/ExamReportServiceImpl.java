package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.Exam;
import me.songt.smartpaper.po.ExamPerson;
import me.songt.smartpaper.po.ExamResult;
import me.songt.smartpaper.po.PaperQuestionEntity;
import me.songt.smartpaper.repository.ExamPersonRepository;
import me.songt.smartpaper.repository.ExamRepository;
import me.songt.smartpaper.repository.ExamResultRepository;
import me.songt.smartpaper.repository.PaperQuestionRepository;
import me.songt.smartpaper.service.*;
import me.songt.smartpaper.vo.report.LevelReport;
import me.songt.smartpaper.vo.report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
//    @Autowired
//    private QuestionService questionService;

    @Autowired
    private PaperQuestionRepository paperQuestionRepository;


    @Override
    public Report getExamReport(int studentId, int examId)
    {
        Report report = new Report();
        int examPaperId = examRepository.findOne(examId).getExamPaperId();
        report.setReportPaper(paperService.query(examPaperId));
        report.setAvgScore(getExamAverage(examId));
        report.setMinScore(getExamScoreMin(examId));
        report.setExamScoreReport(getStudentExamScoreList(studentId));
        report.setScore(getExamScore(studentId, examId));
        return report;
    }

    private double getExamScore(int studentId, int examId)
    {
        Exam exam = examRepository.findOne(examId);
        double score = getStudentExamTotalScore(exam.getExamPaperId(), studentId);
        return score;
    }

    private List<LevelReport> getStudentExamScoreList(int studentId)
    {
        List<me.songt.smartpaper.vo.exam.Exam> examList = examService.getExamByStudentId(studentId);
        List<LevelReport> reports = new ArrayList<>();
        for (me.songt.smartpaper.vo.exam.Exam exam : examList)
        {
            LevelReport report = new LevelReport();
            report.setExamName(exam.getExamName());
//            int examId = exam.getExamId();
            double score = getStudentExamTotalScore(exam.getExamPaper().getPaperId(), studentId);
            report.setReportData(score);
            reports.add(report);
        }
        return reports;
    }

    private double getStudentExamTotalScore(int paperId, int studentId)
    {
        List<ExamResult> examResults = examResultRepository.findByPaperIdEqualsAndStudentIdEquals(paperId, studentId);
        double scoreSum = 0;
        for (ExamResult result :
                examResults)
        {
            if (result.getQuestionIsCorrect() == new Integer(1).byteValue())
            {
                int questionId = result.getQuestionId();
                PaperQuestionEntity entity = paperQuestionRepository.findByPaperIdEqualsAndPaperQuestionIdEquals(paperId, questionId);
                scoreSum += entity.getPaperScore();
            }
        }
        return scoreSum;
    }

    private Double[] getExamScoreList(int examId)
    {
        Exam exam = examRepository.findOne(examId);
        int paperId = exam.getExamPaperId();

        List<ExamPerson> personList = examPersonRepository.findByexamId(examId);
        Double[] scoreList = new Double[personList.size()];
        for (int i = 0; i < personList.size(); i++)
        {
            scoreList[i] = getStudentExamTotalScore(paperId, personList.get(i).getExamStudentId());
        }

        return scoreList;
    }


    private double getExamAverage(int examId)
    {
        Exam exam = examRepository.findOne(examId);
        int paperId = exam.getExamPaperId();
        double totalSum = 0;
        List<ExamPerson> personList = examPersonRepository.findByexamId(examId);
        int size = personList.size();
        for (ExamPerson person : personList)
        {
            int studentId = person.getExamStudentId();
            totalSum += getStudentExamTotalScore(paperId, studentId);
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
