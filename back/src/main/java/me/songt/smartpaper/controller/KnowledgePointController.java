package me.songt.smartpaper.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.songt.smartpaper.po.KnowledgePoint;
import me.songt.smartpaper.service.KnowledgePointService;
import me.songt.smartpaper.vo.knowledgePoint.KnowledgePointTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Sarah on 2017/3/27.
 */
@RestController
@RequestMapping(value = "/smartpaper/points")
public class KnowledgePointController {
    @Autowired
    private KnowledgePointService kpService;


    //获取所有知识点
    @ApiOperation(value="获取所有知识点", notes="得到整体知识树")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<KnowledgePointTree> getAll(){
        return kpService.getAllPointTree();
    }

    //添加知识点
    @ApiOperation(value="添加知识点", notes="添加知识点")
//    @ApiImplicitParam(name = "point", value = "知识点实体", required = true, dataType = "KnowledgePoint")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Map<String,Object> addPoint(@RequestBody KnowledgePoint point){
        return kpService.addPoint(point);
    }

    //修改知识点名称
    @ApiOperation(value="修改知识点名称", notes="根据id修改知识点名称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "知识点id", required = true, dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "pointName", value = "知识点名称", required = true, dataType = "string",paramType = "query")
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Map<String,Object> updatePointName(@PathVariable int id,@RequestParam String pointName){
        return kpService.updatePoint(id,pointName);
    }

    //删除知识点
    @ApiOperation(value="删除知识点", notes="根据id集合删除知识点")
    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public Map<String,Object> deletePoint(@ApiParam(value = "知识点id数组")
                                              @RequestParam(value = "pointIds[]") Integer[] pointIds){
        return kpService.deletePoint(pointIds);
    }

}
