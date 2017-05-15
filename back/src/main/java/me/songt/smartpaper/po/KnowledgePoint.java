package me.songt.smartpaper.po;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

/**
 * Created by Sarah on 2017/3/28.
 */
@Entity
@Table(name = "knowledge_point", schema = "smartclass")
public class KnowledgePoint {
    private int pointId;
    private int parentPointId;
    private String pointName;
    private int pointSubjectId;

    @Id
    @Column(name = "point_id", nullable = false)
    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    @Basic
    @Column(name = "parent_point_id", nullable = false)
    public int getParentPointId() {
        return parentPointId;
    }

    public void setParentPointId(int parentPointId) {
        this.parentPointId = parentPointId;
    }

    @Basic
    @Column(name = "point_name", nullable = false, length = 200)
    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    @Basic
    @Column(name = "point_subject_id", nullable = false)
    public int getPointSubjectId() {
        return pointSubjectId;
    }

    public void setPointSubjectId(int pointSubjectId) {
        this.pointSubjectId = pointSubjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KnowledgePoint that = (KnowledgePoint) o;

        if (pointId != that.pointId) return false;
        if (parentPointId != that.parentPointId) return false;
        if (pointSubjectId != that.pointSubjectId) return false;
        if (pointName != null ? !pointName.equals(that.pointName) : that.pointName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pointId;
        result = 31 * result + parentPointId;
        result = 31 * result + (pointName != null ? pointName.hashCode() : 0);
        result = 31 * result + pointSubjectId;
        return result;
    }
}
