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
@RestController("/smartpaper/class")
public class ClassController
{


    @Autowired
    private ClazzService clazzService;

    @GetMapping("/teacher/{teacherId}")
    public List<ClassInfo> findClassListByTeacherId(@PathVariable("teacherId") int teacherId)
    {
        return clazzService.findClassListByTeacherId(teacherId);
    }

    @GetMapping
    public ClassInfo findClassByClassId(@RequestParam int classId)
    {
        return clazzService.findClassByClassId(classId);
    }

    @GetMapping("/grade/{gradeId}")
    public List<ClassInfo> findClassByGradeId(@PathVariable("gradeId") int gradeId)
    {
        return clazzService.findClassByGradeId(gradeId);
    }
}
