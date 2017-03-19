package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "question_fav")
public class QuestionFav
{
    private int recordId;
    private int questionId;
    private int userId;

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
    @Column(name = "user_id", nullable = false)
    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
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

        QuestionFav that = (QuestionFav) o;

        if (recordId != that.recordId)
        {
            return false;
        }
        if (questionId != that.questionId)
        {
            return false;
        }
        return userId == that.userId;
    }

    @Override
    public int hashCode()
    {
        int result = recordId;
        result = 31 * result + questionId;
        result = 31 * result + userId;
        return result;
    }
}
