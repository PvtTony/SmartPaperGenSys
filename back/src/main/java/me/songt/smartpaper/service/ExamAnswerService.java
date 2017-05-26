package me.songt.smartpaper.service;

import me.songt.smartpaper.po.ExamResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2017/5/21.
 */
@Service
public interface ExamAnswerService
{
    List<ExamResult> addStudentAnswer(int paperId, int studentId, String answerData);

    

}
