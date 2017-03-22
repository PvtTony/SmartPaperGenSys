package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.KnowledgePoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by tony on 2017/3/19.
 */
@Transactional
@Repository
public interface KnowledgePointRepository extends CrudRepository<KnowledgePoint, Integer>
{
    Collection<KnowledgePoint> findByparentPointId(int parentPointId);

    Collection<KnowledgePoint> findBypointDepth(int pointDepth);
}
