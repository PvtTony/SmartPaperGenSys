package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.Exam;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by tony on 2017/3/19.
 */
@Transactional
@Repository
public interface ExamRepository extends PagingAndSortingRepository<Exam, Integer>
{
}
