package me.songt.smartpaper.util.generationAlgorithm;

import me.songt.smartpaper.po.QuestionEntity;
import me.songt.smartpaper.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Sarah on 2017/5/9.
 */

public class GA {
    private static final int SEGMENT = 3;  //交叉点个数
    private static final double MUTATION_RATE = 0.085; //变异概率


    //选择算子,返回下一代种群。 （轮盘赌选择）
    private static Population select(Population population,int size){

        Population nextPopulation = new Population(size);
        List<Individual> selectedList = new ArrayList<Individual>();

        //种群个体适应度和
        double allAdaptationDegree = population.getAllAdaptationDegree();
        while (selectedList.size()<size){
            double degree = 0.00;
            //随机产生适应度
            double randomDegree = Math.random()*allAdaptationDegree;
            //选择符合要求的个体
            for (int i=0;i<population.getSize();i++){
                degree += population.getIndividual(i).getAdaptationDegree();
                if (degree >= randomDegree){
                    //不重复选择
                    if (!(selectedList.contains(population.getIndividual(i))))
                        selectedList.add(population.getIndividual(i));
                    break;
                }

            }
        }


        for (int i=0;i<size;i++)
            nextPopulation.setIndividual(i,selectedList.get(i));

        return nextPopulation;
    }

    // 交叉算子(多点交叉)
    public static Population crossover(Population population,int size){
        Population nextPopulation = new Population(size);
        List<Individual> crossedList = new ArrayList<Individual>();
        Random random = new Random();
        while (crossedList.size()<size){
            //随机选择两个个体进行交叉
            int n1 = random.nextInt(population.getSize());
            int n2 = random.nextInt(population.getSize());
            Individual iOne,iTwo;
            if (n1 != n2){
                iOne = population.getIndividual(n1);
                iTwo = population.getIndividual(n2);
                //随机产生交叉位置
                Integer[] crossPoint = randCrossPoint(SEGMENT,iOne.getQuestionSize()-1,random);
                //避免重题， 采用基因换位法，即将产生重题的到同一位置上
                iTwo = compareAndExchange(iOne,iTwo);
                //将随机产生的交叉位置从小到大排序
                int[] points = new int[crossPoint.length];
                for (int i =0;i<crossPoint.length;i++)
                    points[i] = crossPoint[i];
                Arrays.sort(points);
                //交叉
                int start;
                for (int i =0;i<points.length;i++){
                    start = points[i];
                    //交换交叉位置后的基因
                    for (int j=start+1;j<iOne.getQuestionSize();j++){
                        QuestionEntity tmpQuestion = iOne.getQuestion(j);
                        iTwo.replaceQuestion(j,iTwo.getQuestion(j));
                        iOne.replaceQuestion(j,tmpQuestion);
                    }
                }
                //将新的两个体添加到交叉集合
                if (crossedList.size()<size){
                    iOne.setId(crossedList.size()+1);
                    crossedList.add(iOne);
                }
                if (crossedList.size()<size){
                    iTwo.setId(crossedList.size()+1);
                    crossedList.add(iTwo);
                }
            }

        }
        for (int i=0;i<size;i++)
            nextPopulation.setIndividual(i,crossedList.get(i));

        return nextPopulation;
    }

    //随机产生多个交叉点
    private static Integer[] randCrossPoint(int segment,int range,Random random){
        Set<Integer> crossPoint = new HashSet<Integer>();
        while (crossPoint.size()!=segment){
            int number = random.nextInt(range);
            crossPoint.add(number);
        }
        Integer[] points = new Integer[segment];
        return crossPoint.toArray(points);
    }

   //比较两个体中是否有重复试题,若有则将重复试题换到同一位置
    private static Individual compareAndExchange(Individual iOne, Individual iTwo){
        for (int i=0;i<iOne.getQuestionSize();i++){
            int position = iTwo.isContainsQuestion(iOne.getQuestion(i));
            if (position != -1){
                QuestionEntity tmpQuestion = iTwo.getQuestion(i);
                iTwo.replaceQuestion(i,iTwo.getQuestion(position));
                iTwo.replaceQuestion(position,tmpQuestion);
            }
        }
        return iTwo;
    }

    //变异算子  种群的每个个体的每个基因都有变异机会.变异策略为：在(0,1)之间产生一个随机数，如果小于变异概率，那么该基因突变.
    public static Population mutate(Population population,QuestionService questionService){
        for (int i=0;i<population.getSize();i++){
            Individual individual = population.getIndividual(i);
            for (int j=0;j<individual.getQuestionSize();j++){
                if (Math.random() < MUTATION_RATE){
                    List<QuestionEntity> list = questionService.getQuestionListDifAndType(individual.getQuestion(j));
                    if (list.size() > 0) {
                        int index = (int) (Math.random()*list.size());
                        individual.replaceQuestion(j,list.get(index));
                    }
                }
            }
        }

        return population;
    }

    // 进化种群
    public static Population evolvePopulation(Population population, QuestionService questionsService) {
        Population nextPopulation = select(population,population.getSize()/2);
        nextPopulation = crossover(nextPopulation,population.getSize());
        nextPopulation = mutate(population,questionsService);
        return nextPopulation;
    }
}
