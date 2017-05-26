package me.songt.smartpaper.controller;

import me.songt.smartpaper.service.WrongAnswerService;
import me.songt.smartpaper.vo.wa.WrongAnswerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tony on 2017/5/26.
 */
@RestController
public class WrongAnswerController
{

    @Autowired
    private WrongAnswerService wrongAnswerService;

    @GetMapping("/smartpaper/wa/student/{studentId}")
    public List<WrongAnswerInfo> getWrongAnswerInfoByStudentId(@PathVariable("studentId") int studentId)
    {
        return wrongAnswerService.getWrongAnswers(studentId);
    }

    @DeleteMapping("/smartpaper/wa/question/{questionId}/{studentId}")
    public void removeWrongAnswer(@PathVariable("questionId") int questionId,
                                  @PathVariable("studentId") int studentId)
    {
        wrongAnswerService.removeWrongAnswer(questionId, studentId);
    }

    @DeleteMapping("/smartpaper/wa/{recordId}")
    public void removeWrongAnswer(@PathVariable("recordId") int recordId)
    {
        wrongAnswerService.removeWrongAnswer(recordId);
    }

}
