package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "wrong_answer")
public class WrongAnswer
{
    private int recordId;
    private int questionId;
    private int studentId;
    private String questionWrongAnswer;

    @Id
    @Column(name = "record_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getRecordId()
    {
        return recordId;
    }

    public void setRecordId(int recordId)
    {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "question_id", nullable = false)
    public int getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "student_id", nullable = false)
    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "question_wrong_answer", nullable = false, length = 200)
    public String getQuestionWrongAnswer()
    {
        return questionWrongAnswer;
    }

    public void setQuestionWrongAnswer(String questionWrongAnswer)
    {
        this.questionWrongAnswer = questionWrongAnswer;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        WrongAnswer that = (WrongAnswer) o;

        if (recordId != that.recordId)
        {
            return false;
        }
        if (questionId != that.questionId)
        {
            return false;
        }
        if (studentId != that.studentId)
        {
            return false;
        }
        return questionWrongAnswer != null ? questionWrongAnswer.equals(that.questionWrongAnswer) : that.questionWrongAnswer == null;
    }

    @Override
    public int hashCode()
    {
        int result = recordId;
        result = 31 * result + questionId;
        result = 31 * result + studentId;
        result = 31 * result + (questionWrongAnswer != null ? questionWrongAnswer.hashCode() : 0);
        return result;
    }
}
