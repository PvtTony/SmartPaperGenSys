package me.songt.smartpaper.service;

import me.songt.smartpaper.po.QuestionType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sarah on 2017/5/16.
 */
@Service
public interface QuestionTypeService {
    //获取所有题型
    List<QuestionType> getAll(int subjectId);
}
