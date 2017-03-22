package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "class")
public class Clazz
{
    private int classId;
    private String className;
    private int gradeId;

    @Id
    @Column(name = "class_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getClassId()
    {
        return classId;
    }

    public void setClassId(int classId)
    {
        this.classId = classId;
    }

    @Basic
    @Column(name = "class_name", nullable = false, length = 200)
    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    @Basic
    @Column(name = "grade_id", nullable = false)
    public int getGradeId()
    {
        return gradeId;
    }

    public void setGradeId(int gradeId)
    {
        this.gradeId = gradeId;
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

        Clazz clazz = (Clazz) o;

        if (classId != clazz.classId)
        {
            return false;
        }
        if (gradeId != clazz.gradeId)
        {
            return false;
        }
        return className != null ? className.equals(clazz.className) : clazz.className == null;
    }

    @Override
    public int hashCode()
    {
        int result = classId;
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + gradeId;
        return result;
    }
}
