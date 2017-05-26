package me.songt.smartpaper.vo.wa;

import me.songt.smartpaper.po.WrongAnswer;
import me.songt.smartpaper.service.QuestionService;
import me.songt.smartpaper.vo.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by tony on 2017/5/26.
 */
public class WrongAnswerInfo
{
    private int recordId;
//    private int questionId;
    private Question question;
    private int studentId;
    private String questionWrongAnswer;

    @Autowired
    private QuestionService questionService;


    public WrongAnswerInfo()
    {

    }

    public WrongAnswerInfo(int recordId, int questionid, int studentId, String questionWrongAnswer)
    {
        this.recordId = recordId;
        this.studentId = studentId;
        this.questionWrongAnswer = questionWrongAnswer;
        this.question = questionService.query(questionid);
    }

    public int getRecordId()
    {
        return recordId;
    }

    public void setRecordId(int recordId)
    {
        this.recordId = recordId;
    }

    public Question getQuestion()
    {
        return question;
    }

    public void setQuestion(Question question)
    {
        this.question = question;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public String getQuestionWrongAnswer()
    {
        return questionWrongAnswer;
    }

    public void setQuestionWrongAnswer(String questionWrongAnswer)
    {
        this.questionWrongAnswer = questionWrongAnswer;
    }
}
