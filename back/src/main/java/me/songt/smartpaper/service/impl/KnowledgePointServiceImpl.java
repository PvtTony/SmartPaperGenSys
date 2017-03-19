package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.service.KnowledgePointService;
import me.songt.smartpaper.vo.KnowledgePointTree;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2017/3/19.
 */
@Service
public class KnowledgePointServiceImpl implements KnowledgePointService
{
    @Override
    public List<KnowledgePointTree> getAllPointTree()
    {
        return null;
    }

    @Override
    public List<Integer> getAllPointId()
    {
        return null;
    }

    @Override
    public List<KnowledgePointTree> getAllChildPointTree(int parentPointId)
    {
        return null;
    }

    @Override
    public List<Integer> getAllChildPointId(int parentPointId)
    {
        return null;
    }
}
