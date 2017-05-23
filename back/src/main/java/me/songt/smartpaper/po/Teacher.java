package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "teacher")
public class Teacher
{
    private int teacherId;
    private String teacherName;
    private byte teacherGender;
    private int teacherAge;
    private int teacherSubjectId;
    private int teacherUserId;

    @Id
    @Column(name = "teacher_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(int teacherId)
    {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "teacher_name", nullable = false, length = 100)
    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "teacher_gender", nullable = false)
    public byte getTeacherGender()
    {
        return teacherGender;
    }

    public void setTeacherGender(byte teacherGender)
    {
        this.teacherGender = teacherGender;
    }

    @Basic
    @Column(name = "teacher_age", nullable = false)
    public int getTeacherAge()
    {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge)
    {
        this.teacherAge = teacherAge;
    }

    @Basic
    @Column(name = "teacher_subject_id", nullable = false)
    public int getTeacherSubjectId()
    {
        return teacherSubjectId;
    }

    public void setTeacherSubjectId(int teacherSubjectId)
    {
        this.teacherSubjectId = teacherSubjectId;
    }

    @Basic
    @Column(name = "teacher_user_id", nullable = false)
    public int getTeacherUserId()
    {
        return teacherUserId;
    }

    public void setTeacherUserId(int teacherUserId)
    {
        this.teacherUserId = teacherUserId;
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

        Teacher teacher = (Teacher) o;

        if (teacherId != teacher.teacherId)
        {
            return false;
        }
        if (teacherGender != teacher.teacherGender)
        {
            return false;
        }
        if (teacherAge != teacher.teacherAge)
        {
            return false;
        }
        if (teacherSubjectId != teacher.teacherSubjectId)
        {
            return false;
        }
        if (teacherUserId != teacher.teacherUserId)
        {
            return false;
        }
        return teacherName != null ? teacherName.equals(teacher.teacherName) : teacher.teacherName == null;
    }

    @Override
    public int hashCode()
    {
        int result = teacherId;
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (int) teacherGender;
        result = 31 * result + teacherAge;
        result = 31 * result + teacherSubjectId;
        result = 31 * result + teacherUserId;
        return result;
    }
}
