package me.songt.smartpaper.service;

import me.songt.smartpaper.po.KnowledgePoint;
import me.songt.smartpaper.vo.knowledgePoint.KnowledgePointTree;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Sarah on 2017/3/27.
 */
@Service
public interface KnowledgePointService {

    //添加知识点
    Map<String,Object> addPoint(KnowledgePoint point);
    //修改知识点
    Map<String,Object> updatePoint(int id,String pointName);
    //删除知识点
    Map<String,Object> deletePoint(Integer[] pointIds);

    //获取整体知识点树
    List<KnowledgePointTree> getAllPointTree();

    //获取所有知识点ID
    List<Integer> getAllPointId();

    //获取指定id下所有知识点树
    List<KnowledgePointTree> getAllChildPointTree(int parentPointId);

    //获取指定id下所有知识点Id
    List<Integer> getAllChildPointId(int parentPointId);

    //递归查询方法：获取树
    List<KnowledgePointTree> findChildPointTree(Collection<KnowledgePoint> source);

    //递归查询方法：获取Id
    List<Integer> findChildPointIds(Collection<KnowledgePoint> source);
}
