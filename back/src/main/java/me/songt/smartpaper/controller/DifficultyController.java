package me.songt.smartpaper.controller;

import io.swagger.annotations.ApiOperation;
import me.songt.smartpaper.po.Difficulty;
import me.songt.smartpaper.service.DifficultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sarah on 2017/5/16.
 */
@RestController
@RequestMapping(value = "/smartpaper/difficulty")
public class DifficultyController {
    @Autowired
    private DifficultyService difficultyService;

    //获取所有难度系数
    @ApiOperation(value="获取所有难度系数")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Difficulty> getAll(){
        return difficultyService.getAll();
    }
}
