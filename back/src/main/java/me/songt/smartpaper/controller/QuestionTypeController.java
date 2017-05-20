package me.songt.smartpaper.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.songt.smartpaper.po.QuestionType;
import me.songt.smartpaper.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sarah on 2017/5/16.
 */
@RestController
@RequestMapping(value = "/smartpaper/questionType")
public class QuestionTypeController {
    @Qualifier("questionTypeServiceImpl")
    @Autowired
    private QuestionTypeService typeService;

    //获取所有题型
    @ApiOperation(value="根据科目获取所有题型")
    @ApiImplicitParam(name = "subjectId", value = "科目id", required = true, dataType = "long",paramType = "path")
    @RequestMapping(value = "/{subjectId}",method = RequestMethod.GET)
    public List<QuestionType> getAll(@PathVariable int subjectId){
        return typeService.getAll(subjectId);
    }
}
