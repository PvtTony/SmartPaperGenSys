package me.songt.smartpaper.vo;

import me.songt.smartpaper.po.Grade;

/**
 * Created by yst on 2017/5/19.
 */
public class ClassInfo
{
    private int classId;
    private String className;
    private Grade grade;

    public ClassInfo()
    {
    }

    public int getClassId()
    {
        return classId;
    }

    public void setClassId(int classId)
    {
        this.classId = classId;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public Grade getGrade()
    {
        return grade;
    }

    public void setGrade(Grade grade)
    {
        this.grade = grade;
    }
}
