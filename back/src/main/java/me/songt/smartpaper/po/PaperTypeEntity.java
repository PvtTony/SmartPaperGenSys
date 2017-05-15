package me.songt.smartpaper.po;

import javax.persistence.*;

/**
 * Created by Sarah on 2017/5/11.
 */
@Entity
@Table(name = "paper_type", schema = "smartclass")
public class PaperTypeEntity {
    private int paperTypeId;
    private String paperTypeName;

    @Id
    @Column(name = "paper_type_id", nullable = false)
    public int getPaperTypeId() {
        return paperTypeId;
    }

    public void setPaperTypeId(int paperTypeId) {
        this.paperTypeId = paperTypeId;
    }

    @Basic
    @Column(name = "paper_type_name", nullable = false, length = 50)
    public String getPaperTypeName() {
        return paperTypeName;
    }

    public void setPaperTypeName(String paperTypeName) {
        this.paperTypeName = paperTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaperTypeEntity that = (PaperTypeEntity) o;

        if (paperTypeId != that.paperTypeId) return false;
        if (paperTypeName != null ? !paperTypeName.equals(that.paperTypeName) : that.paperTypeName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paperTypeId;
        result = 31 * result + (paperTypeName != null ? paperTypeName.hashCode() : 0);
        return result;
    }
}
