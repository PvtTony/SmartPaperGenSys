package me.songt.smartpaper.controller;

import me.songt.smartpaper.service.ClazzService;
import me.songt.smartpaper.vo.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yst on 2017/5/19.
 */
@RestController
public class ClassController
{


    @Autowired
    private ClazzService clazzService;

    @GetMapping("/smartpaper/class/teacher/{teacherId}")
    public List<ClassInfo> findClassListByTeacherId(@PathVariable("teacherId") int teacherId)
    {
        return clazzService.findClassListByTeacherId(teacherId);
    }

    @GetMapping("/smartpaper/class/{classId}")
    public ClassInfo findClassByClassId(@PathVariable("classId") int classId)
    {
        return clazzService.findClassByClassId(classId);
    }

    @GetMapping("/smartpaper/class/grade/{gradeId}")
    public List<ClassInfo> findClassByGradeId(@PathVariable("gradeId") int gradeId)
    {
        return clazzService.findClassByGradeId(gradeId);
    }
}
