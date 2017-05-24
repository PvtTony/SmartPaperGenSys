package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "subject")
public class Subject
{
    private int subjectId;
    private String subjectName;

    @Id
    @Column(name = "subject_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(int subjectId)
    {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "subject_name", nullable = false, length = 255)
    public String getSubjectName()
    {
        return subjectName;
    }

    public void setSubjectName(String subjectName)
    {
        this.subjectName = subjectName;
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

        Subject subject = (Subject) o;

        if (subjectId != subject.subjectId)
        {
            return false;
        }
        return subjectName != null ? subjectName.equals(subject.subjectName) : subject.subjectName == null;
    }

    @Override
    public int hashCode()
    {
        int result = subjectId;
        result = 31 * result + (subjectName != null ? subjectName.hashCode() : 0);
        return result;
    }
}
