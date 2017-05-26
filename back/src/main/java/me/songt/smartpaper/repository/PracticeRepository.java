package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.PracticeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sarah on 2017/5/27.
 */
@Repository
public interface PracticeRepository extends CrudRepository<PracticeEntity,Integer>{
}
