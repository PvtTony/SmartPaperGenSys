package me.songt.smartpaper.service;

import me.songt.smartpaper.po.Teacher;
import me.songt.smartpaper.vo.TeacherInfo;
import org.springframework.stereotype.Service;

/**
 * Created by yst on 2017/5/19.
 */
@Service
public interface TeacherService
{
    /*Teacher findTeacherByuserId(int userId);*/
    TeacherInfo findTeacherByuserId(int userId);
}
