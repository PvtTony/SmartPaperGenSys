package me.songt.smartpaper.util.generationAlgorithm;

import me.songt.smartpaper.po.QuestionEntity;
import me.songt.smartpaper.vo.question.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Sarah on 2017/5/8.
 */

//遗传算法中的个体，即一套可能的试卷。
public class Individual {
    private int id; //个体id
    private double adaptationDegree = 0.00; //适应度
    private double kPCoverage = 0.00; //知识点覆盖率
    private double difficulty = 0.00; //试卷难度系数
    private List<QuestionEntity> questionList = new ArrayList<QuestionEntity>();  //个体包含的试题集合

    private static final double[] DIFFICULTY_COEF = {1.00,0.93,0.78,0.63,0.48,0.33};

    public Individual(){

    }
    public Individual(int size){
        for (int i = 0; i < size; i++) {
            questionList.add(null);
        }
    }

    //计算试卷个体难度系数 计算公式： 每题难度之和/题量
    public double getDifficulty(){
        if (difficulty==0.00){
            double total = 0;
            for (QuestionEntity question:questionList)
                total += DIFFICULTY_COEF[question.getQuestionDifficultyId()];
            difficulty = total/getQuestionSize();
        }
        return difficulty;
    }

    //获取试题数量
    public int getQuestionSize() {
        return questionList.size();
    }

    //计算知识点覆盖率 公式为：个体包含的知识点/期望包含的知识点
    public void setKPCoverage(RuleBean rule){
        if (kPCoverage==0.00){
            Set<Integer> result = new HashSet<Integer>();
            result.addAll(rule.getPointIds());
            //试卷中的知识点：把 input Stream 的每一个questionEntity元素，映射成 output Stream 的知识点id
            Set<Integer> another = questionList.stream()
                    .map(questionEntity -> questionEntity.getQuestionKnowledgePointId())
                    .collect(Collectors.toSet());
            // 交集操作得到所包含的知识点
            result.retainAll(another);
            kPCoverage = result.size()/rule.getPointIds().size();
        }
    }
    public double getKPCoverage(){
        return kPCoverage;
    }

    /**
     * 计算个体适应度 公式为：f=1-(1-M/N)*f1-|EP-P|*f2
     * 其中M/N为知识点覆盖率，EP为期望难度系数，P为种群个体难度系数，f1为知识点分布的权重
     * ，f2为难度系数所占权重。当f1=0时退化为只限制试题难度系数，当f2=0时退化为只限制知识点分布
     *
     * @param rule 组卷规则
     * @param f1   知识点分布的权重
     * @param f2   难度系数的权重
     */
    public void setAdaptationDegree(RuleBean rule, double f1, double f2) {
        if (adaptationDegree==0){
            adaptationDegree = 1 -getKPCoverage()*f1 - Math.abs(DIFFICULTY_COEF[rule.getDifficulty()]-getDifficulty())*f2;
        }
    }

    //检查是否含有某道题
    public int isContainsQuestion(QuestionEntity questionEntity){
        if (questionEntity==null){
            for (int i=0;i<getQuestionSize();i++)
                if (getQuestion(i)==null)
                    return i;
        }
        else {
            for (int i=0;i<getQuestionSize();i++)
                if (getQuestion(i)!=null && getQuestion(i).equals(questionEntity))
                    return i;
        }
        return -1;
    }

    //添加试题
    public void addQuestion(QuestionEntity question) {
        this.questionList.add(question);
        this.adaptationDegree = 0;
        this.difficulty = 0;
        this.kPCoverage = 0;
    }
    //替换试题
    public void replaceQuestion(int index,QuestionEntity question) {
        this.questionList.remove(index);
        this.questionList.add(index,question);
        this.adaptationDegree = 0;
        this.difficulty = 0;
        this.kPCoverage = 0;
    }
    //根据索引获得试题集合中的题目
    public QuestionEntity getQuestion(int index){
        return questionList.get(index);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAdaptationDegree() {
        return adaptationDegree;
    }

    public void setAdaptationDegree(double adaptationDegree) {
        this.adaptationDegree = adaptationDegree;
    }

    public List<QuestionEntity> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionEntity> questionList) {
        this.questionList = questionList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Individual){
            if(this.id == ((Individual) obj).getId() && this.questionList == ((Individual) obj).getQuestionList()
                    && this.adaptationDegree == ((Individual) obj).getAdaptationDegree()
                    && this.difficulty == ((Individual) obj).getDifficulty()
                    && this.kPCoverage == ((Individual) obj).getKPCoverage())
                return true;

        }
        return false;
    }
}
