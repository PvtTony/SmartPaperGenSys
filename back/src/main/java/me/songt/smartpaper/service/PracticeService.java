package me.songt.smartpaper.service;

import me.songt.smartpaper.vo.paper.Paper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sarah on 2017/5/27.
 */
@Service
public interface PracticeService {
    List<Paper> findByStudentId(int studentId);
}
