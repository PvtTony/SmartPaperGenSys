package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.KnowledgePoint;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tony on 2017/3/19.
 */
@Transactional
@Repository
public interface KnowledgePointRepository extends CrudRepository<KnowledgePoint, Integer>
{
   //修改知识点信息
    @Modifying
    @Query("update KnowledgePoint a set a.pointName= :pointName where a.pointId = :pointId")
    void updatePointName(@Param("pointId") int pointId,@Param("pointName") String pointName);

    //根据父结点查找知识点
    List<KnowledgePoint> findByParentPointId(int parentPointId);

}
