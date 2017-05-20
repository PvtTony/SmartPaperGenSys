package me.songt.smartpaper.service;

import me.songt.smartpaper.po.Subject;
import org.springframework.stereotype.Service;

/**
 * Created by yst on 2017/5/16.
 */
@Service
public interface SubjectService
{
    Subject findBySubjectId(int subjectId);
}
