package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.PracticeEntity;
import me.songt.smartpaper.vo.paper.Paper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sarah on 2017/5/27.
 */
@Transactional
@Repository
public interface PracticeRepository extends CrudRepository<PracticeEntity,Integer>{
    List<PracticeEntity> findByStudentId(int studentId);
}
