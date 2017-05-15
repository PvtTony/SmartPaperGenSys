package me.songt.smartpaper.util;

import me.songt.smartpaper.po.QuestionEntity;
import me.songt.smartpaper.vo.question.OptionSolution;
import me.songt.smartpaper.vo.question.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarah on 2017/3/30.
 */
//题目处理工具类
public class QuestionUtil {
    public static final int SINGLE_CHOICE = 1;
    public static final int CLOZE = 2;

    //处理题目实体
    private static Question dealQuestionEntity(QuestionEntity questionEntity){
        return  new Question(questionEntity.getQuestionId(),questionEntity.getQuestionContent(),questionEntity.getQuestionAttachUrl(),questionEntity.getQuestionAnswer(),
                questionEntity.getQuestionTypeId(),questionEntity.getQuestionDifficultyId(),questionEntity.getQuestionSubjectId(),questionEntity.getQuestionKnowledgePointId());
    }

    //处理单选题
    private static Question dealSingleChoiceQuestion(QuestionEntity questionEntity){
        Question question = dealQuestionEntity(questionEntity);
        List<OptionSolution> optionSolutions = new ArrayList<OptionSolution>();

        String options = questionEntity.getQuestionOption();//未分离的选项

        //分离题目选项
        char c = 'A';
        List<String> items = new ArrayList<String>();
        try {
            do {
                if(options.indexOf((char)(c+1)+".")!=-1)
                    items.add(options.substring(options.indexOf((char) c + "."), options.indexOf((char) (c + 1) + ".")));

                else
                    items.add(options.substring(options.indexOf((char)c+".")));
                c++;
            }while ((options.indexOf((char)c+".")!=-1));
        }
        catch (Exception e){
            System.out.println(e);
        }


        //将分离后的选项和解析存入OptionSolution
        OptionSolution optionSolution = new OptionSolution();
        optionSolution.setItems(items);
        optionSolution.setSolutions(questionEntity.getQuestionSolution());

        //将OptionSolution加入集合中
        optionSolutions.add(optionSolution);

        question.setOptionSolutions(optionSolutions);
        return question;
    }

    //处理完型填空题
    private static Question dealClozeQuestion(QuestionEntity questionEntity){
        Question question = dealQuestionEntity(questionEntity);
        List<OptionSolution> optionSolutions = new ArrayList<OptionSolution>();

        String options = questionEntity.getQuestionOption(); //未分离的选项
        String solutions = questionEntity.getQuestionSolution();  //未分离的解析

        //分离选项和解析
        for(int i=1;i<=questionEntity.getQuestionOptionCount();i++){
            OptionSolution optionSolution = new OptionSolution();
            List<String> items = new ArrayList<String>();
            String option= null,solution= null; //某一小题的选项，分离后的解析
            try {
            if(i!=questionEntity.getQuestionOptionCount()) {
                    option = options.substring(options.indexOf(i + "."), options.indexOf((i + 1) + "."));
                    solution = solutions.substring(solutions.indexOf(i + "."), solutions.indexOf((i + 1) + "."));
                }
                else{
                    option = options.substring(options.indexOf(i + "."));
                    solution = solutions.substring(solutions.indexOf(i + "."));
                }

                //分离题目选项
                char c = 'A';
                do {
                    if (option.indexOf((char) (c + 1) + ".") != -1)
                        items.add(option.substring(option.indexOf((char) c), option.indexOf((char) (c + 1) + ".")));
                    else
                        items.add(option.substring(option.indexOf((char) c + ".")));
                    c++;
                } while ((option.indexOf((char) c + ".") != -1));
            }
            catch (Exception e){
                System.out.println(e);
            }

            //将分离后的选项和解析存入OptionSolution
            optionSolution.setId(i);
            optionSolution.setItems(items);
            optionSolution.setSolutions(solution);

            //将OptionSolution加入集合中
            optionSolutions.add(optionSolution);
        }

        question.setOptionSolutions(optionSolutions);
        return question;
    }

    //根据题目类型处理题目
    public static Question dealQuestion(QuestionEntity questionEntity){
        switch (questionEntity.getQuestionTypeId()){
            case SINGLE_CHOICE:
                return dealSingleChoiceQuestion(questionEntity);
            case CLOZE:
                return dealClozeQuestion(questionEntity);
        }
        return null;
    }

    //将题目分页排序
    public static Page<Question> dealQuestionPage(List<QuestionEntity> questionEntities, Pageable pageable){
        List<Question> questions = new ArrayList<Question>();

        //处理题目，分离选项和解析
        for (QuestionEntity questionEntity :questionEntities)
            questions.add(QuestionUtil.dealQuestion(questionEntity));
        Page<Question> questionPage = new PageImpl<Question>(questions,pageable,questions.size());
        return questionPage;
    }
}
