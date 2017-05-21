package me.songt.smartpaper.vo.answer;

/**
 * Created by tony on 2017/5/21.
 */
public class Answer
{
    int questionId;
    String questionAnswer;


    public Answer()
    {
    }

    public int getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }

    public String getQuestionAnswer()
    {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer)
    {
        this.questionAnswer = questionAnswer;
    }
}
