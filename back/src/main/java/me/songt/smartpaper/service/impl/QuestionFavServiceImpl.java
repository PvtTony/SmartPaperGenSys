package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.QuestionEntity;
import me.songt.smartpaper.po.QuestionFav;
import me.songt.smartpaper.repository.QuestionFavRepository;
import me.songt.smartpaper.repository.QuestionRepository;
import me.songt.smartpaper.util.QuestionUtil;
import me.songt.smartpaper.vo.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sarah on 2017/5/23.
 */
@Service
public class QuestionFavServiceImpl implements QuestionFavService {
    @Autowired
    private QuestionFavRepository favRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Map<String, Object> getAll(int userId, Pageable pageable) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<QuestionFav> favList = favRepository.findByUserId(userId);
        if (favList==null|| favList.size()==0) {
            map.put("status", false);
            map.put("msg", "未收藏试题");
        }
        else {
            List<QuestionEntity> questionEntities = new ArrayList<QuestionEntity>();
            for (QuestionFav questionFav:favList){
                QuestionEntity questionEntity = questionRepository.findOne(questionFav.getQuestionId());
                questionEntities.add(questionEntity);
            }
            Page<Question> questions = QuestionUtil.dealQuestionPage(questionEntities,pageable);
            map.put("status", true);
            map.put("questions",questions);
        }
        return map;
    }

    @Override
    public Map<String, Object> addFav(QuestionFav questionFav) {
        Map<String, Object> map = new HashMap<String, Object>();
        favRepository.save(questionFav);
        map.put("status", true);
        map.put("msg", "收藏试题成功");
        return map;
    }

    @Override
    public Map<String, Object> removeFav(int userId,int questionId) {
        Map<String, Object> map = new HashMap<String, Object>();
        favRepository.deleteByQuestionIdAndUserId(questionId,userId);
        map.put("status", true);
        map.put("msg", "取消收藏成功");
        return map;
    }
}
