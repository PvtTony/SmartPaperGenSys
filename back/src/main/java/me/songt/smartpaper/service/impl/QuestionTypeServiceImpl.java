package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.QuestionType;
import me.songt.smartpaper.repository.QuestionTypeRepository;
import me.songt.smartpaper.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sarah on 2017/5/16.
 */
@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {
    @Autowired
    private QuestionTypeRepository typeRepository;

    @Override
    public List<QuestionType> getAll(int subjectId) {
        return (List<QuestionType>) typeRepository.findBySubjectId(subjectId);
    }
}
