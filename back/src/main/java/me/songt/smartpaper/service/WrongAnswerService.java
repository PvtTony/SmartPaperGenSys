package me.songt.smartpaper.service;

import me.songt.smartpaper.po.WrongAnswer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2017/5/21.
 */
@Service
public interface WrongAnswerService
{
    WrongAnswer addWrongAnswer(int questionId, int studentId, String wrongAnswer);

//    WrongAnswer addWrongAnswer(WrongAnswer wrongAnswer);

    List<WrongAnswer> getWrongAnswers(int studentId);

    void removeWrongAnswer(int questionId, int studentId);

    void removeWrongAnswer(int recordId);

}
