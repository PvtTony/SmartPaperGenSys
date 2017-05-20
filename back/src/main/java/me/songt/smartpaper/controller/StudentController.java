package me.songt.smartpaper.controller;

import me.songt.smartpaper.po.Student;
import me.songt.smartpaper.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yst on 2017/5/19.
 */
@RestController
public class StudentController
{


    @Autowired
    private StudentService studentService;

    @GetMapping("/smartpaper/student/user/{userId}")
    public Student findStudentByUserId(@PathVariable("userId") int userId)
    {
        return studentService.findBystudentUserId(userId);
    }
}
