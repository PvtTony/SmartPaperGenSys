package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.Difficulty;
import me.songt.smartpaper.repository.DifficultyRepository;
import me.songt.smartpaper.service.DifficultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sarah on 2017/5/16.
 */
@Service
public class DifficultyServiceImpl implements DifficultyService{
    @Autowired
    private DifficultyRepository difficultyRepository;

    @Override
    public List<Difficulty> getAll() {
        return (List<Difficulty>) difficultyRepository.findAll();
    }
}
