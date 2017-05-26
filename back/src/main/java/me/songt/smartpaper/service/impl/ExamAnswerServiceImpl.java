package me.songt.smartpaper.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.songt.smartpaper.po.Exam;
import me.songt.smartpaper.po.ExamResult;
import me.songt.smartpaper.po.PaperQuestionEntity;
import me.songt.smartpaper.po.ScoreEntity;
import me.songt.smartpaper.repository.ExamRepository;
import me.songt.smartpaper.repository.ExamResultRepository;
import me.songt.smartpaper.repository.PaperQuestionRepository;
import me.songt.smartpaper.repository.ScoreRepository;
import me.songt.smartpaper.service.ExamAnswerService;
import me.songt.smartpaper.service.PaperService;
import me.songt.smartpaper.service.QuestionService;
import me.songt.smartpaper.service.WrongAnswerService;
import me.songt.smartpaper.vo.answer.Answer;
import me.songt.smartpaper.vo.paper.Paper;
import me.songt.smartpaper.vo.question.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2017/5/21.
 */
@Service
public class ExamAnswerServiceImpl implements ExamAnswerService
{
    private Logger logger = LoggerFactory.getLogger(ExamAnswerServiceImpl.class);

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamResultRepository examResultRepository;

    @Autowired
    private WrongAnswerService wrongAnswerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private PaperQuestionRepository paperQuestionRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public List<ExamResult> addStudentAnswer(int paperId, int studentId, String answerData)
    {
//        Gson gson = new Gson();
//        List<Answer> answers = gson.fromJson(answerJson, new TypeToken<List<Answer>>(){}.getType());
        List<Answer> answers = new ArrayList<>();
        String[] answerArray = answerData.split(",");


        for (String answer :
                answerArray)
        {
            String[] data = answer.split("\\|");
            Answer ans = new Answer();
            ans.setQuestionId(Integer.parseInt(data[0]));
            ans.setQuestionAnswer(data[1]);
            answers.add(ans);
        }

        for (Answer answer : answers)
        {
            ExamResult examResult = new ExamResult();
            examResult.setPaperId(paperId);
            examResult.setQuestionId(answer.getQuestionId());
            int questionId = answer.getQuestionId();
            Question question = questionService.query(questionId);
            double score = paperQuestionRepository.findByPaperIdEqualsAndPaperQuestionIdEquals(paperId, questionId).getPaperScore();
            if (question != null && question.getQuestionTypeId() == 2)
            {
                String correctAnswer = question.getQuestionAnswer()
                        .trim()
                        .toLowerCase()
                        .replace(" ", "")
                        .replaceAll("\\d+-\\d+", "");
                logger.debug(correctAnswer);
                boolean isAnswerCorrect = answer.getQuestionAnswer()
                        .trim().toLowerCase().equals(correctAnswer);

                if (!isAnswerCorrect)
                {
                    wrongAnswerService.addWrongAnswer(question.getQuestionId(), studentId, answer.getQuestionAnswer());
                }
                examResult.setQuestionIsCorrect(isAnswerCorrect ? new Integer(1).byteValue() : new Integer(0).byteValue());
            }
            else if (question != null && question.getQuestionTypeId() == 1)
            {
                String correctAnswer = question.getQuestionAnswer().trim().toLowerCase();
                boolean isAnswerCorrect = answer.getQuestionAnswer()
                        .trim().toLowerCase().equals(correctAnswer);
                logger.debug(correctAnswer);
                if (!isAnswerCorrect)
                {
                    wrongAnswerService.addWrongAnswer(question.getQuestionId(), studentId, answer.getQuestionAnswer());
                }
                examResult.setQuestionIsCorrect(isAnswerCorrect ? new Integer(1).byteValue() : new Integer(0).byteValue());
            }
            examResult.setStudentAnswer(answer.getQuestionAnswer());
            examResult.setStudentId(studentId);
            examResult.setStudentAnswer(answer.getQuestionAnswer().toLowerCase());
            examResultRepository.save(examResult);
        }
        ScoreEntity entity = new ScoreEntity();
        Exam exam = examRepository.findByExamPaperId(paperId);
        entity.setStudentId(studentId);
        entity.setExamId(exam.getExamId());
        entity.setGrade(getStudentExamTotalScore(paperId, studentId));
        scoreRepository.save(entity);
        return examResultRepository.findByPaperIdEqualsAndStudentIdEquals(paperId, studentId);
    }

    private double getStudentExamTotalScore(int paperId, int studentId)
    {
        List<ExamResult> examResults = examResultRepository.findByPaperIdEqualsAndStudentIdEquals(paperId, studentId);
        double scoreSum = 0;
        for (ExamResult result : examResults)
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
}
