package me.songt.smartpaper.vo.mining;

/**
 * Created by tony on 2017/5/25.
 */
public class DataItemSet
{
//    private int studentId;
    private int[] questionId;
//    private boolean isCorrect;
    private double support;

    public DataItemSet()
    {
    }

    public DataItemSet(int[] questionId, double support)
    {
        this.questionId = questionId;
        this.support = support;
    }

    public int[] getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(int[] questionId)
    {
        this.questionId = questionId;
    }

    public double getSupport()
    {
        return support;
    }

    public void setSupport(double support)
    {
        this.support = support;
    }
}
