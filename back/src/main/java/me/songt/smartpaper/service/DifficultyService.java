package me.songt.smartpaper.service;

import me.songt.smartpaper.po.Difficulty;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sarah on 2017/5/16.
 */
@Service
public interface DifficultyService {
    //获取所有难度系数
    List<Difficulty> getAll();
}
