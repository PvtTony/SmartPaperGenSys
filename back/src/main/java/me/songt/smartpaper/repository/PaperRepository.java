package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.Paper;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by tony on 2017/3/19.
 */
public interface PaperRepository extends PagingAndSortingRepository<Paper, Integer>
{
}
