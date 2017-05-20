package me.songt.smartpaper.util.generationAlgorithm;

import me.songt.smartpaper.po.QuestionEntity;
import me.songt.smartpaper.service.QuestionService;
import me.songt.smartpaper.vo.paper.PaperQuestionType;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sarah on 2017/5/9.
 */
//种群，即多套试卷
public class Population {
    private Individual[] individuals; //试卷集合
    private boolean errorFlag = false;
    private String errorMsg;
    private List<QuestionEntity[]> questions; //题库
    /**
     * 初始种群
     *
     * @param populationSize 种群规模
     * @param initFlag       初始化标志 true-初始化
     * @param rule           规则bean
     */
    public Population(int populationSize, boolean initFlag, RuleBean rule,QuestionService questionService) {

        individuals = new Individual[populationSize];
        int subjectId = rule.getSubjectId();
        questions = new ArrayList<QuestionEntity[]>();
        for (PaperQuestionType type:rule.getEachTypeCount())
            questions.add(questionService.getQuestionArray(type.getTypeId(),rule.getPointIds(),subjectId));
        if (initFlag){
            Individual individual;
            Random random = new Random();
            for (int i=0;i< populationSize;i++){
                individual = new Individual();
                individual.setId(i+1);
                List<PaperQuestionType> typeCount = rule.getEachTypeCount();
                for (int j=0;j<rule.getEachTypeCount().size();j++){
                    individual = generateQuestion(typeCount.get(j),random,individual,questions.get(j));
                    if (errorFlag)
                        return;
                }
                //计算试卷知识点覆盖率
                individual.setKPCoverage(rule);
                // 计算试卷适应度
                individual.setAdaptationDegree(rule,Global.KP_WEIGHT,Global.DIFFICULTY_WEIGHT);
                individuals[i] = individual;
            }
        }
    }
    public Population(int populationSize){
        individuals = new Individual[populationSize];
    }

    public Population() {
    }

    //根据科目、题型、题量随机筛选试题
    private Individual generateQuestion(PaperQuestionType type, Random random,
                                 Individual individual,QuestionEntity[] questionArray){
        int questionNum = type.getCount();
        if (questionArray.length<questionNum){
            errorMsg = type.getTypeName() + "数量不够，组卷失败";
            errorFlag = true;
            System.out.println(errorMsg);
            return null;
        }
        QuestionEntity tmpQuestion;
        for (int i=0;i< questionNum;i++){
            int index  = random.nextInt(questionArray.length - i);
            individual.addQuestion(questionArray[index]);
            // 保证不会重复添加试题,将随机筛选的试题与最后一位交换
            tmpQuestion = questionArray[questionArray.length-i-1];
            questionArray[questionArray.length-i-1] = questionArray[index];
            questionArray[index] = tmpQuestion;
        }
        return individual;
    }

    //获取种群中最优秀个体
    public Individual getBestIndividual(){
        Individual individual = individuals[0];
        for (int i=1;i<individuals.length;i++){
            if (individual.getAdaptationDegree() < individuals[i].getAdaptationDegree())
                individual = individuals[i];
        }
        return individual;
    }

    //获取种群中最差个体
    public int getWorstIndividual(){
        int min = 0;
        Individual individual = individuals[0];
        for (int i=1;i<individuals.length;i++){
            if (individual.getAdaptationDegree() > individuals[i].getAdaptationDegree()) {
                individual = individuals[i];
                min = i;
            }
        }
        return min;
    }


    //获取种群中某个个体
    public Individual getIndividual(int index){
        return individuals[index];
    }

    //设置种群中某个个体
    public void setIndividual(int index,Individual individual){
        individuals[index] = new Individual(individual.getId(),individual.getAdaptationDegree(),individual.getKPCoverage(),
                individual.getDifficulty(),individual.getQuestionList());
    }

    //返回种群规模
    public int getSize(){
        return individuals.length;
    }

    //计算个体总适应度
    public double getAllAdaptationDegree(){
        double allAdaptationDegree = 0;
        for (int i=0;i<individuals.length;i++)
            allAdaptationDegree += individuals[i].getAdaptationDegree();
        return allAdaptationDegree;
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

    public void setIndividuals(Individual[] individuals) {
        this.individuals = individuals;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isErrorFlag() {
        return errorFlag;
    }

    public void setErrorFlag(boolean errorFlag) {
        this.errorFlag = errorFlag;
    }

    //计算适应度
    public void computeFitness(RuleBean rule){
        for (int i=0;i<individuals.length;i++){
            //计算试卷知识点覆盖率
            individuals[i].setKPCoverage(rule);
            // 计算试卷适应度
            individuals[i].setAdaptationDegree(rule,Global.KP_WEIGHT,Global.DIFFICULTY_WEIGHT);
        }
    }

    public List<QuestionEntity[]> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity[]> questions) {
        this.questions = questions;
    }

}
