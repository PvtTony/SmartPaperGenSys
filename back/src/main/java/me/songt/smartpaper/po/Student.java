package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
public class Student
{
    private int studentId;
    private String studentName;
    private byte studentGender;
    private int studentAge;
    private int studentClassId;
    private int studentUserId;

    @Id
    @Column(name = "student_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "student_name", nullable = false, length = 100)
    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "student_gender", nullable = false)
    public byte getStudentGender()
    {
        return studentGender;
    }

    public void setStudentGender(byte studentGender)
    {
        this.studentGender = studentGender;
    }

    @Basic
    @Column(name = "student_age", nullable = false)
    public int getStudentAge()
    {
        return studentAge;
    }

    public void setStudentAge(int studentAge)
    {
        this.studentAge = studentAge;
    }

    @Basic
    @Column(name = "student_class_id", nullable = false)
    public int getStudentClassId()
    {
        return studentClassId;
    }

    public void setStudentClassId(int studentClassId)
    {
        this.studentClassId = studentClassId;
    }

    @Basic
    @Column(name = "student_user_id", nullable = false)
    public int getStudentUserId()
    {
        return studentUserId;
    }

    public void setStudentUserId(int studentUserId)
    {
        this.studentUserId = studentUserId;
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

        Student student = (Student) o;

        if (studentId != student.studentId)
        {
            return false;
        }
        if (studentGender != student.studentGender)
        {
            return false;
        }
        if (studentAge != student.studentAge)
        {
            return false;
        }
        if (studentClassId != student.studentClassId)
        {
            return false;
        }
        if (studentUserId != student.studentUserId)
        {
            return false;
        }
        return studentName != null ? studentName.equals(student.studentName) : student.studentName == null;
    }

    @Override
    public int hashCode()
    {
        int result = studentId;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (int) studentGender;
        result = 31 * result + studentAge;
        result = 31 * result + studentClassId;
        result = 31 * result + studentUserId;
        return result;
    }
}
