package me.songt.smartpaper.vo.knowledgePoint;

import java.util.List;

/**
 * Created by Sarah on 2017/5/8.
 */
public class KnowledgePointTree
{
    private int pointId;
    private String pointName;
    private int pointSubjectId;
    private int parentPointId;
    private List<KnowledgePointTree> childTree;

    public KnowledgePointTree()
    {
    }

    public KnowledgePointTree(int pointId, String pointName, int pointSubjectId, int parentPointId)
    {
        this.pointId = pointId;
        this.pointName = pointName;
        this.pointSubjectId = pointSubjectId;
        this.parentPointId = parentPointId;
    }

    public int getPointId()
    {
        return pointId;
    }

    public void setPointId(int pointId)
    {
        this.pointId = pointId;
    }

    public String getPointName()
    {
        return pointName;
    }

    public void setPointName(String pointName)
    {
        this.pointName = pointName;
    }

    public int getPointSubjectId()
    {
        return pointSubjectId;
    }

    public void setPointSubjectId(int pointSubjectId)
    {
        this.pointSubjectId = pointSubjectId;
    }

    public int getParentPointId()
    {
        return parentPointId;
    }

    public void setParentPointId(int parentPointId)
    {
        this.parentPointId = parentPointId;
    }

    public List<KnowledgePointTree> getChildTree()
    {
        return childTree;
    }

    public void setChildTree(List<KnowledgePointTree> childTree)
    {
        this.childTree = childTree;
    }
}