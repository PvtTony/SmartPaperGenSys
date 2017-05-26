package me.songt.smartpaper.service.impl;

import apriori4j.*;
import me.songt.smartpaper.po.*;
import me.songt.smartpaper.repository.ExamPersonRepository;
import me.songt.smartpaper.repository.ExamRepository;
import me.songt.smartpaper.repository.ExamResultRepository;
import me.songt.smartpaper.repository.WrongAnswerRepository;
import me.songt.smartpaper.service.DataMiningService;
import me.songt.smartpaper.service.PaperService;
import me.songt.smartpaper.service.QuestionService;
import me.songt.smartpaper.service.WrongAnswerService;
import me.songt.smartpaper.vo.mining.DataItemSet;
import me.songt.smartpaper.vo.mining.DataMiningResult;
import me.songt.smartpaper.vo.question.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by tony on 2017/5/25.
 */
@Service
public class DataMiningServiceImpl implements DataMiningService
{

    private final byte CORRECT_ANSWER_FLAG = new Integer(1).byteValue();
    private Logger logger = LoggerFactory.getLogger(DataMiningServiceImpl.class);
    @Autowired
    private ExamResultRepository examResultRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private ExamPersonRepository examPersonRepository;
    @Autowired
    private PaperService paperService;
    @Autowired
    private QuestionService questionService;

    @Override
    public AnalysisResult getExamMiningResult(double minSupport, double minConfident, int examId)
    {
        Exam exam = examRepository.findOne(examId);

        int paperId = exam.getExamPaperId();

        List<ExamPerson> examPeople = examPersonRepository.findByexamId(examId);
        List<Transaction> apriTransaction = new ArrayList<>();
        for (ExamPerson person :
                examPeople)
        {
            List<ExamResult> results = examResultRepository.findByPaperIdEqualsAndStudentIdEquals(paperId,
                    person.getExamStudentId());
            Set<String> dataSet = new HashSet<>();
            for (ExamResult result :
                    results)
            {
                boolean isCorrect = result.getQuestionIsCorrect() == CORRECT_ANSWER_FLAG;
                if (!isCorrect)
                {
                    String questionId = Integer.toString(result.getQuestionId());
                    dataSet.add(questionId);
                }
            }
            apriTransaction.add(new Transaction(dataSet));
        }


        AprioriAlgorithm algorithm = new AprioriAlgorithm(minSupport, minConfident);
        try
        {
            AnalysisResult result = algorithm.analyze(apriTransaction);

            Set<Integer> questionSets = new HashSet<>();
            Set<Integer> questionTypes = new HashSet<>();
            List<PaperQuestionEntity> questionEntities = new ArrayList<>();
            List<PaperQuestionTypeEntity> typeEntities = new ArrayList<>();

            PaperEntity paperEntity = new PaperEntity();
            paperEntity.setPaperIsShare(new Integer(0).byteValue());
            paperEntity.setPaperSubjectId(1);
            paperEntity.setPaperTitle("考试： " + exam.getExamName() + " 加强测试");
            paperEntity.setPaperUserId(1);

            for (AssociationRule rule :
                    result.getAssociationRules())
            {
                ItemSet leftSet = rule.getLeftHandSide();
                ItemSet rightSet = rule.getRightHandSide();
                String[] left = leftSet.toArray(new String[leftSet.size()]);
                String[] right = rightSet.toArray(new String[rightSet.size()]);

                for (String leftItem : left)
                {
                    questionSets.add(Integer.parseInt(leftItem));
                }

                for (String rightItem : right)
                {
                    questionSets.add(Integer.parseInt(rightItem));
                }
                logger.info(rule.getLeftHandSide() + " --> " + rule.getRightHandSide() + " : " + rule.getConfidence());
            }

            for (Integer questionId :
                    questionSets)
            {
                PaperQuestionEntity entity = new PaperQuestionEntity();
                Question question = questionService.query(questionId);
//                question.getQuestionSubjectId()
                entity.setPaperQuestionId(questionId);
                questionEntities.add(entity);
                questionTypes.add(question.getQuestionTypeId());
            }

            for (Integer type :
                    questionTypes)
            {
                PaperQuestionTypeEntity typeEntity = new PaperQuestionTypeEntity();
                typeEntity.setPaperTypeId(type);
                typeEntities.add(typeEntity);
            }
            paperService.addPaper(paperEntity, typeEntities, questionEntities);
            return result;


        } catch (AprioriTimeoutException e)
        {
            e.printStackTrace();
        }


        /*int paperId = examRepository.findOne(examId).getExamPaperId();
        List<ExamResult> examResults = examResultRepository.findByPaperId(paperId);
        Map<Integer, Integer> answerInfo = new HashMap<>();
        Set<Integer> studentIds = new HashSet<>();
        Set<Integer> questionIds = new HashSet<>();
        for (ExamResult result : examResults)
        {
            int questionId = result.getQuestionId();
            int studentId = result.getStudentId();
            boolean isCorrect = result.getQuestionIsCorrect() == CORRECT_ANSWER_FLAG;
            if (!questionIds.contains(questionId))
            {
                questionIds.add(questionId);
            }

            if (!studentIds.contains(studentId))
            {
                studentIds.add(studentId);
            }
            if (answerInfo.containsKey(questionId))
            {
                int count = answerInfo.get(questionId);

                if (!isCorrect)
                {
                    answerInfo.remove(questionId);
                    count++;
                    answerInfo.put(questionId, count);
                }
            }
            else
            {
                if (!isCorrect)
                {
                    answerInfo.put(questionId, 1);
                }
                else
                {
                    answerInfo.put(questionId, 0);
                }
            }
        }
        Map<Integer, Double> singleDimensionFrequentItemSet = new HashMap<>();
        Set<Integer> frequentQuestionId = new HashSet<>();
        Iterator<Integer> integerIterator = questionIds.iterator();
        while (integerIterator.hasNext())
        {
            int questionId = integerIterator.next();
            int count = answerInfo.get(questionId);
            double studentSize = studentIds.size();
            double support = count / studentSize;
            if (support < minSupport)
            {
//                errorStatus.remove(questionId);
                continue;
            }
            else
            {
                singleDimensionFrequentItemSet.put(questionId, support);
                frequentQuestionId.add(questionId);
            }

        }
        int dimension = 2;
        List<List<DataItemSet>> frequentItemSetList = new ArrayList<>();
        List<DataItemSet> itemSets;
        do
        {
            itemSets = new ArrayList<>();
            Integer[] frequentQs = frequentQuestionId.toArray(new Integer[frequentQuestionId.size()]);
            List<Integer[]> combinationList = combination(frequentQs, dimension);


//            itemSets.size();
        } while (itemSets.size() > 1);

        return null;*/
        return null;
    }




    /*private double getSupport(List<ExamResult> examResults, int[] questionIds, int studentSize)
    {
        int questionLength = questionIds.length;
        for (ExamResult result :
                examResults)
        {
            boolean[] isCorrect = new boolean[questionLength];



        }

        return Double.parseDouble(null);
    }*/


    //Combination
    /*private List<Integer[]> combination(Integer[] questions, int selection)
    {
        int questionAmount = questions.length;
        List<Integer[]> combinationList = new ArrayList<>();

        int C = (1 << selection) - 1;
        while (C <= ((1 << questionAmount) - (1 << (questionAmount - selection))))
        {
            combinationList.add(get(questions, C));
            C = nextN(C);
        }
        return combinationList;
    }


    private Integer[] get(Integer[] questions, int C)
    {
        List<Integer> idList = new ArrayList<>();
        int i = 0;
        int k;
        while ((k = 1 << i) <= C)
        {
            if ((C & k) != 0)
            {
                idList.add(questions[i]);
            }
            i++;
        }
        return idList.toArray(new Integer[idList.size()]);
    }

    private int nextN(int N)
    {
        return (N + (N & (-N))) | ((N ^ (N + (N & (-N)))) / (N & (-N))) >> 2;
    }*/
}
