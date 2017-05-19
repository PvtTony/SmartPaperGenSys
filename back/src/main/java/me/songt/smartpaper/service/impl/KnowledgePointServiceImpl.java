package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.KnowledgePoint;
import me.songt.smartpaper.repository.KnowledgePointRepository;
import me.songt.smartpaper.service.KnowledgePointService;
import me.songt.smartpaper.vo.knowledgePoint.KnowledgePointTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Sarah on 2017/3/27.
 */
@Service
public class KnowledgePointServiceImpl implements KnowledgePointService {
    @Autowired
    private KnowledgePointRepository kpRepository;

    @Override
    public Map<String,Object> addPoint(KnowledgePoint point) {
        Map<String, Object> map = new HashMap<String, Object>();
        kpRepository.save(point);
        map.put("status",true);
        map.put("message","添加知识点名称成功");
        return map;
    }

    @Override
    public Map<String, Object> updatePoint(int id,String pointName) {
        Map<String, Object> map = new HashMap<String, Object>();
        kpRepository.updatePointName(id,pointName);
        map.put("status",true);
        map.put("message","修改知识点名称成功");
        return map;
    }

    @Override
    public Map<String, Object> deletePoint(Integer[] pointIds) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Integer pointId :pointIds) {
            kpRepository.delete(pointId);
        }
        map.put("status",true);
        map.put("message","删除知识点成功");
        return map;
    }

    @Override
    public List<KnowledgePointTree> getAllPointTree()
    {
        return findChildPointTree((Collection<KnowledgePoint>) kpRepository.findByParentPointId(0));
    }

    @Override
    public List<Integer> getAllPointId()
    {
        return findChildPointIds((Collection<KnowledgePoint>) kpRepository.findAll());
    }

    @Override
    public List<KnowledgePointTree> getAllChildPointTree(int parentPointId)
    {
        return findChildPointTree(kpRepository.findByParentPointId(parentPointId));
    }

    @Override
    public List<Integer> getAllChildPointId(int parentPointId)
    {
        return findChildPointIds(kpRepository.findByParentPointId(parentPointId));
    }

    public List<KnowledgePointTree> findChildPointTree(Collection<KnowledgePoint> source)
    {
        LinkedList<KnowledgePointTree> pointTree = new LinkedList<>();
        for (KnowledgePoint point : source)
        {
            //转换数据到展示用到类
            KnowledgePointTree treeNode = new KnowledgePointTree(point.getPointId(), point.getPointName(),
                    point.getPointSubjectId(), point.getParentPointId());
            //检查子集
            Collection<KnowledgePoint> childs = kpRepository.findByParentPointId(point.getPointId());
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
            Collection<KnowledgePoint> childs = kpRepository.findByParentPointId(point.getPointId());
            if (childs.size() != 0)
            {
                //递归查询，把结果加入到容器
                childPointId.addAll(findChildPointIds(childs));
            }
        }
        return childPointId;
    }
}
