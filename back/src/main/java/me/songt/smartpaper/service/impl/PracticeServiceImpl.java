package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.PaperEntity;
import me.songt.smartpaper.po.PracticeEntity;
import me.songt.smartpaper.repository.PaperRepository;
import me.songt.smartpaper.repository.PracticeRepository;
import me.songt.smartpaper.service.PaperService;
import me.songt.smartpaper.service.PracticeService;
import me.songt.smartpaper.vo.paper.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarah on 2017/5/27.
 */
@Service
public class PracticeServiceImpl implements PracticeService
{
    @Autowired
    private PracticeRepository practiceRepository;
    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperRepository paperRepository;

    @Override
    public List<PaperEntity> findByStudentId(int studentId)
    {
        List<PaperEntity> papers = new ArrayList<>();
        List<PracticeEntity> practiceEntities = practiceRepository.findByStudentId(studentId);
        for (PracticeEntity practice : practiceEntities)
        {
            PaperEntity entity = paperRepository.findOne(practice.getPaperId());
            papers.add(entity);
        }
        return papers;
    }




}
