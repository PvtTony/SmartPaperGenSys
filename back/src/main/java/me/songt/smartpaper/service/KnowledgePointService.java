package me.songt.smartpaper.service;

import me.songt.smartpaper.vo.KnowledgePointTree;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2017/3/19.
 */
@Service
public interface KnowledgePointService
{
    List<KnowledgePointTree> getAllPointTree();

    List<Integer> getAllPointId();

    List<KnowledgePointTree> getAllChildPointTree(int parentPointId);

    List<Integer> getAllChildPointId(int parentPointId);
}
