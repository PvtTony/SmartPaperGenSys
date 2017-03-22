package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
@Table(name = "question_type")
public class QuestionType
{
    private int typeId;
    private String typeName;
    private int subjectId;

    @Id
    @Column(name = "type_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getTypeId()
    {
        return typeId;
    }

    public void setTypeId(int typeId)
    {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "type_name", nullable = false, length = 200)
    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "subject_id", nullable = false)
    public int getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(int subjectId)
    {
        this.subjectId = subjectId;
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

        QuestionType that = (QuestionType) o;

        if (typeId != that.typeId)
        {
            return false;
        }
        if (subjectId != that.subjectId)
        {
            return false;
        }
        return typeName != null ? typeName.equals(that.typeName) : that.typeName == null;
    }

    @Override
    public int hashCode()
    {
        int result = typeId;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + subjectId;
        return result;
    }
}
