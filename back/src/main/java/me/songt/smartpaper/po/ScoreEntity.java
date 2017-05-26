package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by Sarah on 2017/5/27.
 */
@Entity
@Table(name = "score", schema = "smartclass")
public class ScoreEntity {
    private int recordId;
    private int studentId;
    private double grade;
    private int examId;

    @Id
    @Column(name = "record_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "student_id", nullable = false)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "grade", nullable = false, precision = 0)
    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "exam_id", nullable = false)
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreEntity that = (ScoreEntity) o;

        if (recordId != that.recordId) return false;
        if (studentId != that.studentId) return false;
        if (Double.compare(that.grade, grade) != 0) return false;
        if (examId != that.examId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = recordId;
        result = 31 * result + studentId;
        temp = Double.doubleToLongBits(grade);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + examId;
        return result;
    }
}
