package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.PaperEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by tony on 2017/3/19.
 */
public interface PaperRepository extends PagingAndSortingRepository<PaperEntity, Integer>
{
    List<PaperEntity> findByPaperUserId(int paperUserId);
    List<PaperEntity> findByPaperSubjectId(int paperSubjectId);
}
