package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.Question;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by tony on 2017/3/19.
 */
@Transactional
@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question, Integer>
{

}
