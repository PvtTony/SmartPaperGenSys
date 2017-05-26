package me.songt.smartpaper.controller;

import me.songt.smartpaper.po.PaperEntity;
import me.songt.smartpaper.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tony on 2017/5/27.
 */
@RestController
public class PracticeController
{
    @Autowired
    private PracticeService practiceService;

    @GetMapping("/smartpaper/practise/student/{studentId}")
    public List<PaperEntity> getPractiseList(@PathVariable("studentId") int studentId)
    {
        return practiceService.findByStudentId(studentId);
    }
}
