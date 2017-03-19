package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by tony on 2017/3/19.
 */
@Entity
public class Difficulty
{
    private int difficultyId;
    private double difficultyCoef;
    private String difficultyName;

    @Id
    @Column(name = "difficulty_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getDifficultyId()
    {
        return difficultyId;
    }

    public void setDifficultyId(int difficultyId)
    {
        this.difficultyId = difficultyId;
    }

    @Basic
    @Column(name = "difficulty_coef", nullable = false, precision = 0)
    public double getDifficultyCoef()
    {
        return difficultyCoef;
    }

    public void setDifficultyCoef(double difficultyCoef)
    {
        this.difficultyCoef = difficultyCoef;
    }

    @Basic
    @Column(name = "difficulty_name", nullable = false, length = 200)
    public String getDifficultyName()
    {
        return difficultyName;
    }

    public void setDifficultyName(String difficultyName)
    {
        this.difficultyName = difficultyName;
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

        Difficulty that = (Difficulty) o;

        if (difficultyId != that.difficultyId)
        {
            return false;
        }
        if (Double.compare(that.difficultyCoef, difficultyCoef) != 0)
        {
            return false;
        }
        return difficultyName != null ? difficultyName.equals(that.difficultyName) : that.difficultyName == null;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = difficultyId;
        temp = Double.doubleToLongBits(difficultyCoef);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (difficultyName != null ? difficultyName.hashCode() : 0);
        return result;
    }
}
