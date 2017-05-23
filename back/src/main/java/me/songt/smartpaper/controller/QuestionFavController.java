package me.songt.smartpaper.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.songt.smartpaper.po.QuestionFav;
import me.songt.smartpaper.service.impl.QuestionFavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Sarah on 2017/5/23.
 */
@RestController
@RequestMapping(value = "/smartpaper/fav")
public class QuestionFavController {
    @Autowired
    private QuestionFavService favService;

    //获得所有收藏试题
    @ApiOperation(value="获取所有收藏试题")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId",value = "用户id",dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "Integer",paramType = "query",defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "每一页的大小", required = false, dataType = "Integer",paramType = "query",defaultValue = "15")
    })
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public Map<String,Object> getAll(@PathVariable int userId,
                                     @RequestParam(value = "page", defaultValue = "0")int page,
                                     @RequestParam(value = "size", defaultValue = "15")int size){
        Sort sort = new Sort(Sort.Direction.DESC,"questionId"); //通过id逆序排列
        Pageable pageable = new PageRequest(page,size,sort);
        return favService.getAll(userId,pageable);
    }

    //加入收藏夹
    @ApiOperation(value="加入收藏夹")
    @ApiImplicitParam(name="questionFav",value = "用户id和题目id",dataType = "QuestionFav")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Map<String,Object> addFav(@RequestBody QuestionFav questionFav){
        return favService.addFav(questionFav);
    }

    //移除收藏夹
    @ApiOperation(value="移除收藏夹")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "questionId", value = "题目id", dataType = "Integer",paramType = "query")
    })
    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam int userId,@RequestParam int questionId) {
        return favService.removeFav(userId, questionId);
    }
}
