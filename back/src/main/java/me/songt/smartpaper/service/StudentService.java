package me.songt.smartpaper.service;

import me.songt.smartpaper.po.Student;
import org.springframework.stereotype.Service;

/**
 * Created by yst on 2017/5/19.
 */
@Service
public interface StudentService
{
    Student findBystudentUserId(int userId);




}
