package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.WrongAnswer;
import me.songt.smartpaper.repository.WrongAnswerRepository;
import me.songt.smartpaper.service.WrongAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2017/5/21.
 */
@Service
public class WrongAnswerServiceImpl implements WrongAnswerService
{

    @Autowired
    private WrongAnswerRepository wrongAnswerRepository;

    @Override
    public WrongAnswer addWrongAnswer(int questionId, int studentId, String wrongAnswer)
    {
        WrongAnswer newWA = new WrongAnswer();
        newWA.setQuestionId(questionId);
        newWA.setStudentId(studentId);
        newWA.setQuestionWrongAnswer(wrongAnswer);
        return wrongAnswerRepository.save(newWA);
    }

    @Override
    public List<WrongAnswer> getWrongAnswers(int studentId)
    {
        return wrongAnswerRepository.findByStudentId(studentId);
    }

    @Override
    public void removeWrongAnswer(int questionId, int studentId)
    {
        WrongAnswer wa = wrongAnswerRepository.findByStudentIdEqualsAndQuestionIdEquals(questionId, studentId);
        wrongAnswerRepository.delete(wa);
    }

    @Override
    public void removeWrongAnswer(int recordId)
    {
        wrongAnswerRepository.delete(recordId);
    }
}
