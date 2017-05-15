package me.songt.smartpaper.vo.paper;

/**
 * Created by Sarah on 2017/5/8.
 */
public class PaperQuestionType {
    private int typeId; //题目类型id
    private String typeName; //类型名称
    private int count; //题数
    private double score;  //分数

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
