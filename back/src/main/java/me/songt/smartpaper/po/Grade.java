package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "grade")
public class Grade
{
    private int gradeId;
    private String gradeName;

    @Id
    @Column(name = "grade_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getGradeId()
    {
        return gradeId;
    }

    public void setGradeId(int gradeId)
    {
        this.gradeId = gradeId;
    }

    @Basic
    @Column(name = "grade_name", nullable = false, length = 200)
    public String getGradeName()
    {
        return gradeName;
    }

    public void setGradeName(String gradeName)
    {
        this.gradeName = gradeName;
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

        Grade grade = (Grade) o;

        if (gradeId != grade.gradeId)
        {
            return false;
        }
        return gradeName != null ? gradeName.equals(grade.gradeName) : grade.gradeName == null;
    }

    @Override
    public int hashCode()
    {
        int result = gradeId;
        result = 31 * result + (gradeName != null ? gradeName.hashCode() : 0);
        return result;
    }
}
