package me.songt.smartpaper.controller;

import me.songt.smartpaper.service.TeacherService;
import me.songt.smartpaper.vo.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yst on 2017/5/19.
 */
@RestController
public class TeacherController
{

//    @Qualifier("teacherService")
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/smartpaper/teacher/user/{userId}")
    public TeacherInfo findTeacherByUserId(@PathVariable("userId") int userId)
    {
        return teacherService.findTeacherByuserId(userId);
    }
}
