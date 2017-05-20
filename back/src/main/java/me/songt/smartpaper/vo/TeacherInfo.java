package me.songt.smartpaper.vo;

import me.songt.smartpaper.po.Subject;

import java.util.List;

/**
 * Created by yst on 2017/5/19.
 */
public class TeacherInfo
{
    private int teacherId;
    private String teacherName;
    private byte teacherGender;
    private int teacherAge;
    private Subject teacherSubject;
    private int teacherUserId;
    private List<ClassInfo> teacherClass;

    public TeacherInfo()
    {
    }

    public int getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(int teacherId)
    {
        this.teacherId = teacherId;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public byte getTeacherGender()
    {
        return teacherGender;
    }

    public void setTeacherGender(byte teacherGender)
    {
        this.teacherGender = teacherGender;
    }

    public int getTeacherAge()
    {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge)
    {
        this.teacherAge = teacherAge;
    }

    public Subject getTeacherSubject()
    {
        return teacherSubject;
    }

    public void setTeacherSubject(Subject teacherSubject)
    {
        this.teacherSubject = teacherSubject;
    }

    public int getTeacherUserId()
    {
        return teacherUserId;
    }

    public void setTeacherUserId(int teacherUserId)
    {
        this.teacherUserId = teacherUserId;
    }

    public List<ClassInfo> getTeacherClass()
    {
        return teacherClass;
    }

    public void setTeacherClass(List<ClassInfo> teacherClass)
    {
        this.teacherClass = teacherClass;
    }
}
