package me.songt.smartpaper.repository;

import me.songt.smartpaper.po.ExamResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tony on 2017/3/19.
 */
@Transactional
@Repository
public interface ExamResultRepository extends CrudRepository<ExamResult, Integer>
{
//    List<ExamResult> findBystudentId(int studentId);

//    ExamResult findBypaperIdAndquestionIdAndstudentId(int paperId, int questionId, int studentId);

    List<ExamResult> findByPaperIdEqualsAndStudentIdEquals(int paperId, int studentId);

    List<ExamResult> findByStudentId(int studentId);

    ExamResult findByPaperIdEqualsAnAndStudentIdEqualsAndQuestionIdEquals(int paperId, int studentId, int questionId);

}
