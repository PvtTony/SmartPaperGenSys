package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.ScoreEntity;
import me.songt.smartpaper.repository.ScoreRepository;
import me.songt.smartpaper.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tony on 2017/5/27.
 */
@Service
public class ScoreServiceImpl implements ScoreService
{
    @Autowired
    private ScoreRepository scoreRepository;


    @Override
    public void addScoreInfo(int studentId, int examId, double grade)
    {
        return;
    }
}
