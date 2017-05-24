package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by Sarah on 2017/5/16.
 */
@Entity
@Table(name = "difficulty")
public class Difficulty {
    private int difficultyId;
    private String difficultyCoef;
    private String difficultyName;

    @Id
    @Column(name = "difficulty_id", nullable = false)
    public int getDifficultyId() {
        return difficultyId;
    }

    public void setDifficultyId(int difficultyId) {
        this.difficultyId = difficultyId;
    }

    @Basic
    @Column(name = "difficulty_coef", nullable = false, length = 20)
    public String getDifficultyCoef() {
        return difficultyCoef;
    }

    public void setDifficultyCoef(String difficultyCoef) {
        this.difficultyCoef = difficultyCoef;
    }

    @Basic
    @Column(name = "difficulty_name", nullable = false, length = 200)
    public String getDifficultyName() {
        return difficultyName;
    }

    public void setDifficultyName(String difficultyName) {
        this.difficultyName = difficultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Difficulty that = (Difficulty) o;

        if (difficultyId != that.difficultyId) return false;
        if (difficultyCoef != null ? !difficultyCoef.equals(that.difficultyCoef) : that.difficultyCoef != null)
            return false;
        if (difficultyName != null ? !difficultyName.equals(that.difficultyName) : that.difficultyName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = difficultyId;
        result = 31 * result + (difficultyCoef != null ? difficultyCoef.hashCode() : 0);
        result = 31 * result + (difficultyName != null ? difficultyName.hashCode() : 0);
        return result;
    }
}
