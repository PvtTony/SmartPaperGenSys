package me.songt.smartpaper.service;

import me.songt.smartpaper.vo.ClassInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yst on 2017/5/19.
 */
@Service
public interface ClazzService
{
    List<ClassInfo> findClassListByTeacherId(int teacherId);

    ClassInfo findClassByClassId(int classId);

    List<ClassInfo> findClassByGradeId(int gradeId);
}
