package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by Sarah on 2017/5/27.
 */
@Entity
@Table(name = "practice", schema = "smartclass")
public class PracticeEntity {
    private int pracaticeId;
    private int paperId;
    private int studentId;

    @Id
    @Column(name = "pracatice_id", nullable = false)
    public int getPracaticeId() {
        return pracaticeId;
    }

    public void setPracaticeId(int pracaticeId) {
        this.pracaticeId = pracaticeId;
    }

    @Basic
    @Column(name = "paper_id", nullable = false)
    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    @Basic
    @Column(name = "student_id", nullable = false)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracticeEntity that = (PracticeEntity) o;

        if (pracaticeId != that.pracaticeId) return false;
        if (paperId != that.paperId) return false;
        if (studentId != that.studentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pracaticeId;
        result = 31 * result + paperId;
        result = 31 * result + studentId;
        return result;
    }
}
