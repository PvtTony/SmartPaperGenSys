package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.Teacher;
import me.songt.smartpaper.repository.SubjectRepository;
import me.songt.smartpaper.repository.TeacherRepository;
import me.songt.smartpaper.service.ClazzService;
import me.songt.smartpaper.service.TeacherService;
import me.songt.smartpaper.vo.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by yst on 2017/5/19.
 */
@Service
public class TeacherServiceImpl implements TeacherService
{


    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ClazzService clazzService;


    @Override
    public TeacherInfo findTeacherByuserId(int userId)
    {
        TeacherInfo info = null;
        Teacher teacher = teacherRepository.findByteacherUserId(userId);
        if (teacher != null)
        {
            info = new TeacherInfo();
            info.setTeacherName(teacher.getTeacherName());
            info.setTeacherId(teacher.getTeacherId());
            info.setTeacherAge(teacher.getTeacherAge());
            info.setTeacherGender(teacher.getTeacherGender());
            info.setTeacherUserId(teacher.getTeacherUserId());
            info.setTeacherSubject(subjectRepository.findOne(teacher.getTeacherSubjectId()));
            info.setTeacherClass(clazzService.findClassListByTeacherId(teacher.getTeacherId()));
        }
        return info;
    }

    /*@Override
    public Teacher findTeacherByuserId(int userId)
    {
        return teacherRepository.findByteacherUserId(userId);
    }*/
}
