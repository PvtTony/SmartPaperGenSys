package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.Subject;
import me.songt.smartpaper.repository.SubjectRepository;
import me.songt.smartpaper.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by yst on 2017/5/19.
 */
@Service
public class SubjectServiceImpl implements SubjectService
{


    @Qualifier("subjectRepository")
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject findBySubjectId(int subjectId)
    {

        return subjectRepository.findOne(subjectId);
    }
}
