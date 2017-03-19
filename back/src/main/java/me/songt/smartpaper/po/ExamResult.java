package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "exam_result")
public class ExamResult
{
    private int recordId;
    private int paperId;
    private int questionId;
    private byte questionIsCorrect;
    private String studentAnswer;
    private int studentId;

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
    @Column(name = "paper_id", nullable = false)
    public int getPaperId()
    {
        return paperId;
    }

    public void setPaperId(int paperId)
    {
        this.paperId = paperId;
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
    @Column(name = "question_is_correct", nullable = false)
    public byte getQuestionIsCorrect()
    {
        return questionIsCorrect;
    }

    public void setQuestionIsCorrect(byte questionIsCorrect)
    {
        this.questionIsCorrect = questionIsCorrect;
    }

    @Basic
    @Column(name = "student_answer", nullable = true, length = 200)
    public String getStudentAnswer()
    {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer)
    {
        this.studentAnswer = studentAnswer;
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

        ExamResult that = (ExamResult) o;

        if (recordId != that.recordId)
        {
            return false;
        }
        if (paperId != that.paperId)
        {
            return false;
        }
        if (questionId != that.questionId)
        {
            return false;
        }
        if (questionIsCorrect != that.questionIsCorrect)
        {
            return false;
        }
        if (studentId != that.studentId)
        {
            return false;
        }
        return studentAnswer != null ? studentAnswer.equals(that.studentAnswer) : that.studentAnswer == null;
    }

    @Override
    public int hashCode()
    {
        int result = recordId;
        result = 31 * result + paperId;
        result = 31 * result + questionId;
        result = 31 * result + (int) questionIsCorrect;
        result = 31 * result + (studentAnswer != null ? studentAnswer.hashCode() : 0);
        result = 31 * result + studentId;
        return result;
    }
}
