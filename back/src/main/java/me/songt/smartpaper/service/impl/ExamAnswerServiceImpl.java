package me.songt.smartpaper.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.songt.smartpaper.po.ExamResult;
import me.songt.smartpaper.repository.ExamResultRepository;
import me.songt.smartpaper.service.ExamAnswerService;
import me.songt.smartpaper.service.QuestionService;
import me.songt.smartpaper.service.WrongAnswerService;
import me.songt.smartpaper.vo.answer.Answer;
import me.songt.smartpaper.vo.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2017/5/21.
 */
@Service
public class ExamAnswerServiceImpl implements ExamAnswerService
{
    @Autowired
    private ExamResultRepository examResultRepository;

    @Autowired
    private WrongAnswerService wrongAnswerService;

    @Autowired
    private QuestionService questionService;

    @Override
    public List<ExamResult> addStudentAnswer(int paperId, int studentId, String answerJson)
    {
        Gson gson = new Gson();
        List<Answer> answers = gson.fromJson(answerJson, new TypeToken<List<Answer>>(){}.getType());
        for (Answer answer : answers)
        {
            ExamResult examResult = new ExamResult();
            examResult.setPaperId(paperId);
            examResult.setQuestionId(answer.getQuestionId());
            Question question = questionService.query(answer.getQuestionId());
            if (question != null && question.getQuestionTypeId() == 2)
            {
                String correctAnswer = question.getQuestionAnswer()
                        .trim()
                        .toLowerCase()
                        .replace(" ", "")
                        .replaceAll("\\d+-\\d+", "");
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
        return examResultRepository.findByPaperIdEqualsAndStudentIdEquals(paperId, studentId);
    }
}
