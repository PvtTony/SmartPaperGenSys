package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.Student;
import me.songt.smartpaper.repository.StudentRepository;
import me.songt.smartpaper.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by yst on 2017/5/19.
 */
@Service
public class StudentServiceImpl implements StudentService
{


    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student findBystudentUserId(int userId)
    {
        return studentRepository.findBystudentUserId(userId);
    }
}
