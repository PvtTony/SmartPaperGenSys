package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.Clazz;
import me.songt.smartpaper.po.TeacherClass;
import me.songt.smartpaper.repository.ClazzRepository;
import me.songt.smartpaper.repository.GradeRepository;
import me.songt.smartpaper.repository.TeacherClassRepository;
import me.songt.smartpaper.service.ClazzService;
import me.songt.smartpaper.vo.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yst on 2017/5/19.
 */
@Service("ClassService")
public class ClazzServiceImpl implements ClazzService
{

    @Autowired
    private TeacherClassRepository teacherClassRepository;
    @Autowired
    private ClazzRepository clazzRepository;
    @Autowired
    private GradeRepository gradeRepository;


    @Override
    public List<ClassInfo> findClassListByTeacherId(int teacherId)
    {
        List<ClassInfo> infoList = null;
        List<TeacherClass> classList = teacherClassRepository.findByteacherId(teacherId);
        if (classList.size() != 0)
        {
            infoList = new ArrayList<>();
            ClassInfo info;
            for (TeacherClass teacherClass : classList)
            {
                /*info = new ClassInfo();
                info.setClassId(teacherClass.getClassId());
                Clazz clazz = clazzRepository.findOne(teacherClass.getClassId());
                info.setClassName(clazz.getClassName());
                info.setGrade(gradeRepository.findOne(clazz.getGradeId()));*/
                info = findClassByClassId(teacherClass.getClassId());
//                info.setClassId(teacherClass.getClassId());
                infoList.add(info);
            }
        }
        return infoList;
    }

    @Override
    public ClassInfo findClassByClassId(int classId)
    {
        ClassInfo info = null;
        Clazz clazz = clazzRepository.findOne(classId);
        if (clazz != null)
        {
            info = new ClassInfo();
            info.setClassId(classId);
            info.setClassName(clazz.getClassName());
            info.setGrade(gradeRepository.findOne(clazz.getGradeId()));

        }
        return info;
    }

    @Override
    public List<ClassInfo> findClassByGradeId(int gradeId)
    {
        List<ClassInfo> infoList = null;
        List<Clazz> clazzList = clazzRepository.findBygradeId(gradeId);
        if (clazzList.size() != 0)
        {
            infoList = new ArrayList<>();
            ClassInfo info = null;
            for (Clazz clazz : clazzList)
            {
                info = new ClassInfo();
                info.setClassName(clazz.getClassName());
                info.setClassId(clazz.getClassId());
                info.setGrade(gradeRepository.findOne(clazz.getGradeId()));
                infoList.add(info);
            }
        }
        return infoList;
    }
}
