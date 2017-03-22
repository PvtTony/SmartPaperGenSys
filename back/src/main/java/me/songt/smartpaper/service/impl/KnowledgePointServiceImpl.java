package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.KnowledgePoint;
import me.songt.smartpaper.repository.KnowledgePointRepository;
import me.songt.smartpaper.service.KnowledgePointService;
import me.songt.smartpaper.vo.KnowledgePointTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tony on 2017/3/19.
 */
@Service
public class KnowledgePointServiceImpl implements KnowledgePointService
{
    @Autowired
    private KnowledgePointRepository pointRepository;

    @Override
    public List<KnowledgePointTree> getAllPointTree()
    {
        return findChildPointTree((Collection<KnowledgePoint>) pointRepository.findAll());
    }

    @Override
    public List<Integer> getAllPointId()
    {
        return findChildPointIds((Collection<KnowledgePoint>) pointRepository.findAll());
    }

    @Override
    public List<KnowledgePointTree> getAllChildPointTree(int parentPointId)
    {
        return findChildPointTree(pointRepository.findByparentPointId(parentPointId));
    }

    @Override
    public List<Integer> getAllChildPointId(int parentPointId)
    {
        return findChildPointIds(pointRepository.findByparentPointId(parentPointId));
    }

    public List<KnowledgePointTree> findChildPointTree(Collection<KnowledgePoint> source)
    {
        LinkedList<KnowledgePointTree> pointTree = new LinkedList<>();
        for (KnowledgePoint point : source)
        {
            //转换数据到展示用到类
            KnowledgePointTree treeNode = new KnowledgePointTree(point.getPointId(), point.getPointName(),
                    point.getPointSubjectId(), point.getParentPointId(), point.getPointDepth());
            //检查子集
            Collection<KnowledgePoint> childs = pointRepository.findByparentPointId(point.getPointId());
            if (childs.size() != 0)
            {
                //递归查询，把结果加入到容器
                treeNode.setChildTree(findChildPointTree(childs));
            }
            pointTree.add(treeNode);
        }
        return pointTree;
    }

    public List<Integer> findChildPointIds(Collection<KnowledgePoint> source)
    {
        ArrayList<Integer> childPointId = new ArrayList<>();
        for (KnowledgePoint point : source)
        {
            //将Id加入到容器类中
            childPointId.add(point.getPointId());
            //检查子集
            Collection<KnowledgePoint> childs = pointRepository.findByparentPointId(point.getPointId());
            if (childs.size() != 0)
            {
                //递归查询，把结果加入到容器
                childPointId.addAll(findChildPointIds(childs));
            }
        }
        return childPointId;
    }
}