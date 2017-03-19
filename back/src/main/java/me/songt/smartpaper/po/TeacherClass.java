package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "teacher_class")
public class TeacherClass
{
    private int recordId;
    private int teacherId;
    private int classId;

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
    @Column(name = "teacher_id", nullable = false)
    public int getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(int teacherId)
    {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "class_id", nullable = false)
    public int getClassId()
    {
        return classId;
    }

    public void setClassId(int classId)
    {
        this.classId = classId;
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

        TeacherClass that = (TeacherClass) o;

        if (recordId != that.recordId)
        {
            return false;
        }
        if (teacherId != that.teacherId)
        {
            return false;
        }
        return classId == that.classId;
    }

    @Override
    public int hashCode()
    {
        int result = recordId;
        result = 31 * result + teacherId;
        result = 31 * result + classId;
        return result;
    }
}
