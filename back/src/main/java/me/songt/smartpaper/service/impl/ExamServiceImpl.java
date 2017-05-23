package me.songt.smartpaper.service.impl;

import com.sun.istack.internal.NotNull;
import me.songt.smartpaper.po.ExamPerson;
import me.songt.smartpaper.po.Student;
import me.songt.smartpaper.repository.ExamPersonRepository;
import me.songt.smartpaper.repository.ExamRepository;
import me.songt.smartpaper.repository.ExamResultRepository;
import me.songt.smartpaper.repository.StudentRepository;
import me.songt.smartpaper.service.ExamService;
import me.songt.smartpaper.service.PaperService;
import me.songt.smartpaper.vo.exam.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yst on 2017/5/17.
 */
@Service
public class ExamServiceImpl implements ExamService
{


    @Autowired
    private ExamResultRepository examResultRepository;
    

    @Autowired
    private ExamPersonRepository examPersonRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private PaperService paperService;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Exam> getExamByStudentId(int studentId)
    {
        List<Exam> exams = new ArrayList<>();
        List<ExamPerson> examPeople = examPersonRepository.findByexamStudentId(studentId);

//        long currentTime = System.currentTimeMillis();
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        for (ExamPerson person : examPeople)
        {
            Exam exam = new Exam();
            int examId = person.getExamId();
            me.songt.smartpaper.po.Exam poExam = examRepository.findOne(examId);
            exam.setExamId(poExam.getExamId());
            if (poExam.getExamStartTime().after(currentTime))
            {
                continue;
            }
            exam.setExamStartTime(poExam.getExamStartTime());
            exam.setExamEndTime(poExam.getExamEndtime());
            exam.setExamPaper(paperService.query(poExam.getExamPaperId()));
            exam.setExamStudentList(getExamPersonList(examId));
            exams.add(exam);
        }
        return exams;
    }

    @Override
    public List<Exam> getAllExams()
    {
        List<Exam> exams = new ArrayList<>();
        @NotNull
        List<me.songt.smartpaper.po.Exam> examList = (List< me.songt.smartpaper.po.Exam>) examRepository.findAll();
        for (me.songt.smartpaper.po.Exam exam : examList)
        {
            Exam examItem = new Exam();
            examItem.setExamId(exam.getExamId());
            examItem.setExamPaper(paperService.query(exam.getExamPaperId()));
            examItem.setExamStartTime(exam.getExamStartTime());
            examItem.setExamEndTime(exam.getExamEndtime());
            examItem.setExamStudentList(getExamPersonList(exam.getExamId()));
            exams.add(examItem);
        }
        return exams;

    }

    @Override
    public Exam addExam(String examName, long startTime, long endTime, int paperId)
    {
        me.songt.smartpaper.po.Exam poExam = new me.songt.smartpaper.po.Exam();
        poExam.setExamName(examName);
        poExam.setExamStartTime(new Timestamp(startTime));
        poExam.setExamEndtime(new Timestamp(endTime));
        poExam.setExamPaperId(paperId);

        poExam = examRepository.save(poExam);
        Exam voExam = new Exam();
        voExam.setExamId(poExam.getExamId());
        voExam.setExamStartTime(poExam.getExamStartTime());
        voExam.setExamEndTime(poExam.getExamEndtime());
        voExam.setExamPaper(paperService.query(paperId));
        voExam.setExamStudentList(null);
        return voExam;
    }

    @Override
    public Exam modifyExam(int examId, String examName, long startTime, long endTime, int paperId)
    {
        me.songt.smartpaper.po.Exam poExam = examRepository.findOne(examId);
        poExam.setExamName(examName);
        poExam.setExamStartTime(new Timestamp(startTime));
        poExam.setExamEndtime(new Timestamp(endTime));
        poExam.setExamPaperId(paperId);
        poExam = examRepository.save(poExam);
        Exam voExam = new Exam();
        voExam.setExamId(poExam.getExamId());
        voExam.setExamStartTime(poExam.getExamStartTime());
        voExam.setExamEndTime(poExam.getExamEndtime());
        voExam.setExamPaper(paperService.query(paperId));
        voExam.setExamStudentList(getExamPersonList(poExam.getExamId()));
        return voExam;
    }

    @Override
    public Exam getExamById(int examId)
    {
        me.songt.smartpaper.po.Exam poExam = examRepository.findOne(examId);
        Exam voExam = new Exam();
        voExam.setExamId(poExam.getExamId());
        voExam.setExamStartTime(poExam.getExamStartTime());
        voExam.setExamEndTime(poExam.getExamEndtime());
        voExam.setExamPaper(paperService.query(poExam.getExamPaperId()));
        voExam.setExamStudentList(getExamPersonList(poExam.getExamId()));
        return null;
    }

    @Override
    public void removeExamById(int examId)
    {
        examRepository.delete(examId);
//        return null;
    }

    @Override
    public void addExamPerson(int examId, int studentId)
    {
        ExamPerson examPerson = new ExamPerson();
        examPerson.setExamId(examId);
        examPerson.setExamStudentId(studentId);
        examPersonRepository.save(examPerson);
    }

    @Override
    public List<Student> getExamPersonList(int examId)
    {
        List<Student> studentList = new ArrayList<>();
        List<ExamPerson> personList = examPersonRepository.findByexamId(examId);
        if (personList.size() == 0)
        {
            return null;
        }
        for (ExamPerson examPerson :
                personList)
        {
            studentList.add(studentRepository.findOne(examPerson.getExamStudentId()));
        }
        return studentList;
    }


    @Override
    public void removeExamPerson(int examId, int studentId)
    {
        ExamPerson person = examPersonRepository.findByExamIdEqualsAndExamStudentIdEquals(examId, studentId);
        examPersonRepository.delete(person);
    }


}
