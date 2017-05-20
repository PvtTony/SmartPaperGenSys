package me.songt.smartpaper.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.songt.smartpaper.po.QuestionEntity;
import me.songt.smartpaper.service.QuestionService;
import me.songt.smartpaper.vo.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Sarah on 2017/3/30.
 */
@RestController
@RequestMapping(value = "/smartpaper/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    //获取所有试题
    @ApiOperation(value="获取所有试题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "Integer",paramType = "query",defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "每一页的大小", required = false, dataType = "Integer",paramType = "query",defaultValue = "15")
    })
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Page<Question> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "15") Integer size){
        Sort sort = new Sort(Sort.Direction.DESC,"questionId"); //通过id逆序排列
        Pageable pageable = new PageRequest(page,size,sort);
        return questionService.getAll(pageable);
    }

//    //根据科目id查找试题
//    @ApiOperation(value="根据科目筛选试题")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "subjectId",value ="科目id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "Integer",paramType = "query",defaultValue = "0"),
//            @ApiImplicitParam(name = "size", value = "每一页的大小", required = false, dataType = "Integer",paramType = "query",defaultValue = "15")
//    })
//    @RequestMapping(value = "/subjects/{subjectId}",method = RequestMethod.GET)
//    public Page<Question> findBySubjectId(@PathVariable Integer subjectId,
//                                          @RequestParam(value = "page", defaultValue = "0") Integer page,
//                                          @RequestParam(value = "size", defaultValue = "15") Integer size){
//        Sort sort = new Sort(Sort.Direction.DESC,"questionId"); //通过id逆序排列
//        Pageable pageable = new PageRequest(page,size,sort);
//        return questionService.findBySubjectId(subjectId,pageable);
//    }
//
//    //根据科目id、知识点查找试题
//    @ApiOperation(value="根据科目、知识点筛选试题")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "subjectId",value ="科目id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "pointId",value ="知识点id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "Integer",paramType = "query",defaultValue = "0"),
//            @ApiImplicitParam(name = "size", value = "每一页的大小", required = false, dataType = "Integer",paramType = "query",defaultValue = "15")
//    })
//    @RequestMapping(value = "/subjects/{subjectId}/points/{pointId}",method = RequestMethod.GET)
//    public Page<Question> findBySubjectIdAndPointId(@PathVariable(value = "subjectId") Integer subjectId,
//                                                    @PathVariable(value = "pointId")Integer pointId,
//                                                    @RequestParam(value = "page", defaultValue = "0") Integer page,
//                                                    @RequestParam(value = "size", defaultValue = "15") Integer size){
//        Sort sort = new Sort(Sort.Direction.DESC,"questionId"); //通过id逆序排列
//        Pageable pageable = new PageRequest(page,size,sort);
//        return questionService.findBySubjectIdAndPointId(subjectId,pointId,pageable);
//    }
//
//    //根据科目id、难度系数查找试题
//    @ApiOperation(value="根据科目、难度系数筛选试题")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "subjectId",value ="科目id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "difficultyId",value ="难度系数id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "Integer",paramType = "query",defaultValue = "0"),
//            @ApiImplicitParam(name = "size", value = "每一页的大小", required = false, dataType = "Integer",paramType = "query",defaultValue = "15")
//    })
//    @RequestMapping(value = "/subjects/{subjectId}/difficulties/{difficultyId}",method = RequestMethod.GET)
//    public Page<Question> findBySubjectIdAndDifficultyId(@PathVariable(value = "subjectId") Integer subjectId,
//                                                         @PathVariable(value = "difficultyId")Integer difficultyId,
//                                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
//                                                         @RequestParam(value = "size", defaultValue = "15")Integer size){
//        Sort sort = new Sort(Sort.Direction.DESC,"questionId"); //通过id逆序排列
//        Pageable pageable = new PageRequest(page,size,sort);
//        return questionService.findBySubjectIdAndDifficultyId(subjectId,difficultyId,pageable);
//    }
//
//    //根据科目id、题目类型查找试题
//    @ApiOperation(value="根据科目、题目类型筛选试题")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "subjectId",value ="科目id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "typeId",value ="题目类型id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "Integer",paramType = "query",defaultValue = "0"),
//            @ApiImplicitParam(name = "size", value = "每一页的大小", required = false, dataType = "Integer",paramType = "query",defaultValue = "15")
//    })
//    @RequestMapping(value = "/subjects/{subjectId}/types/{typeId}",method = RequestMethod.GET)
//    public Page<Question> findBySubjectIdAndTypeId(@PathVariable(value = "subjectId") Integer subjectId,
//                                                            @PathVariable(value = "typeId")Integer typeId,
//                                                            @RequestParam(value = "page", defaultValue = "0") Integer page,
//                                                            @RequestParam(value = "size", defaultValue = "15")Integer size){
//        Sort sort = new Sort(Sort.Direction.DESC,"questionId"); //通过id逆序排列
//        Pageable pageable = new PageRequest(page,size,sort);
//        return questionService.findBySubjectIdAndTypeId(subjectId,typeId,pageable);
//    }
//
//    //根据科目id、知识点、难度系数查找试题
//    @ApiOperation(value="根据科目、知识点、难度系数筛选试题")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "subjectId",value ="科目id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "pointId",value ="知识点id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "difficultyId",value ="难度系数id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "Integer",paramType = "query",defaultValue = "0"),
//            @ApiImplicitParam(name = "size", value = "每一页的大小", required = false, dataType = "Integer",paramType = "query",defaultValue = "15")
//    })
//    @RequestMapping(value = "/subjects/{subjectId}/points/{pointId}/difficulties/{difficultyId}",method = RequestMethod.GET)
//    public Page<Question> findBySubjectIdAndPointIdAndDifficultyId(@PathVariable(value = "subjectId") Integer subjectId,
//                                                                   @PathVariable(value = "pointId") Integer pointId,
//                                                                   @PathVariable(value = "difficultyId")Integer difficultyId,
//                                                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
//                                                                   @RequestParam(value = "size", defaultValue = "15")Integer size){
//        Sort sort = new Sort(Sort.Direction.DESC,"questionId"); //通过id逆序排列
//        Pageable pageable = new PageRequest(page,size,sort);
//        return questionService.findBySubjectIdAndPointIdAndDifficultyId(subjectId,pointId,difficultyId,pageable);
//    }
//    //根据科目id、知识点、题目类型查找试题
//    @ApiOperation(value="根据科目、知识点、题目类型筛选试题")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "subjectId",value ="科目id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "pointId",value ="知识点id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "typeId",value ="题目类型id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "Integer",paramType = "query",defaultValue = "0"),
//            @ApiImplicitParam(name = "size", value = "每一页的大小", required = false, dataType = "Integer",paramType = "query",defaultValue = "15")
//    })
//    @RequestMapping(value = "/subjects/{subjectId}/points/{pointId}/types/{typeId}",method = RequestMethod.GET)
//    public Page<Question> findBySubjectIdAndPointIdAndTypeId(@PathVariable(value = "subjectId") Integer subjectId,
//                                                             @PathVariable(value = "pointId") Integer pointId,
//                                                             @PathVariable(value = "typeId")Integer typeId,
//                                                             @RequestParam(value = "page", defaultValue = "0") Integer page,
//                                                             @RequestParam(value = "size", defaultValue = "15")Integer size){
//        Sort sort = new Sort(Sort.Direction.DESC,"questionId"); //通过id逆序排列
//        Pageable pageable = new PageRequest(page,size,sort);
//        return questionService.findBySubjectIdAndPointIdAndTypeId(subjectId,pointId,typeId,pageable);
//    }
//    //根据科目id、难度系数、题目类型查找试题
//    @ApiOperation(value="根据科目、难度系数、题目类型筛选试题")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "subjectId",value ="科目id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "difficultyId",value ="难度系数id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "typeId",value ="题目类型id",required = true,dataType = "Integer",paramType = "path"),
//            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "Integer",paramType = "query",defaultValue = "0"),
//            @ApiImplicitParam(name = "size", value = "每一页的大小", required = false, dataType = "Integer",paramType = "query",defaultValue = "15")
//    })
//    @RequestMapping(value = "/subjects/{subjectId}/difficulties/{difficultyId}/types/{typeId}",method = RequestMethod.GET)
//    public Page<Question> findBySubjectIdAndDifficultyIdAndTypeId(@PathVariable(value = "subjectId") Integer subjectId,
//                                                                  @PathVariable(value = "difficultyId") Integer difficultyId,
//                                                                  @PathVariable(value = "typeId")Integer typeId,
//                                                                  @RequestParam(value = "page", defaultValue = "0") Integer page,
//                                                                  @RequestParam(value = "size", defaultValue = "15")Integer size){
//        Sort sort = new Sort(Sort.Direction.DESC,"questionId"); //通过id逆序排列
//        Pageable pageable = new PageRequest(page,size,sort);
//        return questionService.findBySubjectIdAndDifficultyIdAndTypeId(subjectId,difficultyId,typeId,pageable);
//    }

    //根据科目id、知识点、难度系数、题目类型查找试题
    @ApiOperation(value="根据科目、知识点、难度系数、题目类型筛选试题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "subjectId",value ="科目id",required = true,dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "pointId",value ="知识点id",required = true,dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "difficultyId",value ="难度系数id",required = true,dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "typeId",value ="题目类型id",required = true,dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "Integer",paramType = "query",defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "每一页的大小", required = false, dataType = "Integer",paramType = "query",defaultValue = "15")
    })
    @RequestMapping(value = "/subjects/{subjectId}/points/{pointId}/difficulties/{difficultyId}/types/{typeId}",method = RequestMethod.GET)
    public Page<Question> findBySubjectIdAndPointIdAndDifficultyIdAndTypeId(@PathVariable(value = "subjectId") Integer subjectId,
                                                                            @PathVariable(value = "pointId") Integer pointId,
                                                                            @PathVariable(value = "difficultyId") Integer difficultyId,
                                                                            @PathVariable(value = "typeId")Integer typeId,
                                                                            @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                            @RequestParam(value = "size", defaultValue = "15")Integer size){
        Sort sort = new Sort(Sort.Direction.DESC,"questionId"); //通过id逆序排列
        Pageable pageable = new PageRequest(page,size,sort);
        if(pointId==0&&difficultyId==0&&typeId==0)
            return questionService.findBySubjectId(subjectId,pageable);
        else if(pointId!=0&&difficultyId==0&&typeId==0)
            return questionService.findBySubjectIdAndPointId(subjectId,pointId,pageable);
        else if(pointId==0&&difficultyId!=0&&typeId==0)
            return questionService.findBySubjectIdAndDifficultyId(subjectId,difficultyId,pageable);
        else if(pointId==0&&difficultyId==0&&typeId!=0)
            return questionService.findBySubjectIdAndTypeId(subjectId,typeId,pageable);
        else if(pointId!=0&&difficultyId!=0&&typeId==0)
            return questionService.findBySubjectIdAndPointIdAndDifficultyId(subjectId,pointId,difficultyId,pageable);
        else if(pointId!=0&&difficultyId==0&&typeId!=0)
            return questionService.findBySubjectIdAndPointIdAndTypeId(subjectId,pointId,typeId,pageable);
        else if (pointId==0&&difficultyId!=0&&typeId!=0)
            return questionService.findBySubjectIdAndDifficultyIdAndTypeId(subjectId,difficultyId,typeId,pageable);
        return questionService.findBySubjectIdAndPointIdAndDifficultyIdAndTypeId(subjectId,pointId,difficultyId,typeId,pageable);
    }


    //添加题目
    @ApiOperation(value = "添加题目")
//    @ApiImplicitParam(name = "questionEntity",value = "题目实体",required = true,dataType = "QuestionEntity")
    @RequestMapping(value = "/",method = RequestMethod.POST, produces="application/json")
    public Map<String,Object> addQuestion(@RequestBody QuestionEntity questionEntity){
        return questionService.addQuestion(questionEntity);
    }
    //修改题目信息
    @ApiOperation(value="修改题目信息", notes="根据题目id修改题目信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "questionId", value = "试题id", required = true, dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "questionEntity",value = "题目实体",required = true,dataType = "QuestionEntity")
    })
    @RequestMapping(value = "/{questionId}",method = RequestMethod.PUT)
    public Map<String,Object> updateQuestion(@PathVariable Integer questionId,
                                             @ModelAttribute QuestionEntity questionEntity){
        return questionService.updateQuestion(questionId,questionEntity);
    }
    //删除题目
    @ApiOperation(value = "删除题目")
    @ApiImplicitParam(name = "questionId", value = "试题id", required = true, dataType = "Integer",paramType = "path")
    @RequestMapping(value = "/{questionId}",method = RequestMethod.DELETE)
    public Map<String,Object> deleteQuestion(@PathVariable int questionId){
        return questionService.deleteQuestion(questionId);
    }

    //查看题目
    @ApiOperation(value = "查看题目")
    @ApiImplicitParam(name = "questionId", value = "试题id", required = true, dataType = "Integer",paramType = "path")
    @RequestMapping(value = "/{questionId}",method = RequestMethod.GET)
    public Question queryQuestion(@PathVariable int questionId){
        return questionService.query(questionId);
    }

}
