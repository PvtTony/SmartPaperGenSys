package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.QuestionFav;
import me.songt.smartpaper.vo.question.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Sarah on 2017/5/23.
 */
@Service
public interface QuestionFavService {
    //获得所有收藏试题
    Map<String, Object> getAll(int userId, Pageable pageable);
    //加入收藏夹
    Map<String,Object> addFav(QuestionFav questionFav);
    //移除收藏夹
    Map<String,Object> removeFav(int userId,int questionId);
}
