package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "exam_person")
public class ExamPerson
{
    private int recordId;
    private int examId;
    private int examStudentId;

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
    @Column(name = "exam_id", nullable = false)
    public int getExamId()
    {
        return examId;
    }

    public void setExamId(int examId)
    {
        this.examId = examId;
    }

    @Basic
    @Column(name = "exam_student_id", nullable = false)
    public int getExamStudentId()
    {
        return examStudentId;
    }

    public void setExamStudentId(int examStudentId)
    {
        this.examStudentId = examStudentId;
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

        ExamPerson that = (ExamPerson) o;

        if (recordId != that.recordId)
        {
            return false;
        }
        if (examId != that.examId)
        {
            return false;
        }
        return examStudentId == that.examStudentId;
    }

    @Override
    public int hashCode()
    {
        int result = recordId;
        result = 31 * result + examId;
        result = 31 * result + examStudentId;
        return result;
    }
}
