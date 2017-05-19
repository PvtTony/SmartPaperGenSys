package me.songt.smartpaper.controller;

import me.songt.smartpaper.po.Subject;
import me.songt.smartpaper.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yst on 2017/5/19.
 */
@RestController
public class SubjectController
{

//    @Qualifier("subjectService")
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/smartpaper/subject/{subjectId}")
    public Subject findBySubjectId(@PathVariable("subjectId") int subjectId)
    {
        return subjectService.findBySubjectId(subjectId);
    }
}
