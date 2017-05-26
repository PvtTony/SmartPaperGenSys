package me.songt.smartpaper.service;

import org.springframework.stereotype.Service;

/**
 * Created by tony on 2017/5/27.
 */
@Service
public interface ScoreService
{
    void addScoreInfo(int studentId, int examId, double grade);
}
