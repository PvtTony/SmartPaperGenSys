package me.songt.smartpaper.vo.practice;

import me.songt.smartpaper.po.Student;
import me.songt.smartpaper.vo.paper.Paper;

/**
 * Created by tony on 2017/5/27.
 */
public class PractiseInfo

{
    private int practiseId;
    private Student student;
    private Paper paper;

    public PractiseInfo()
    {
    }

    public int getPractiseId()
    {
        return practiseId;
    }

    public void setPractiseId(int practiseId)
    {
        this.practiseId = practiseId;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public Paper getPaper()
    {
        return paper;
    }

    public void setPaper(Paper paper)
    {
        this.paper = paper;
    }
}
