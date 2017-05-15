package me.songt.smartpaper.util.generationAlgorithm;

import me.songt.smartpaper.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Sarah on 2017/5/11.
 */
//遗传算法自动组卷
public class GeneratePaper {

    //最大进化代数
    public static final int MAX_RUN_COUNT = 100;
    // 适应度期望值
    public static final double EXPAND = 0.98;
    /**
     * 错误信息
     */
    private  String errorMsg;
    private  boolean errorFlag = false;

    public  Individual getPaper(RuleBean rule,QuestionService questionService){
        // 迭代计数器
        int count = 0;
        Individual best = null; //历史最佳个体
        if (rule!=null){
            Population population = new Population(20,true,rule,questionService);
            if (!population.isErrorFlag()){
                best = population.getBestIndividual();
                while (count < MAX_RUN_COUNT && best.getAdaptationDegree() < EXPAND){
                    population = GA.evolvePopulation(population,questionService);
                    //精英保留策略
                    Individual maxFit = population.getBestIndividual();  //当代群体中的最佳个体
                    //若历史最佳个体优于当代最佳个体，则将当代最差个体替换成历史最佳个体，否则更换历史最佳个体
                    if (best.getAdaptationDegree() > maxFit.getAdaptationDegree())
                        population.setIndividual(population.getWorstIndividual(),best);
                    else
                        best = population.getBestIndividual();
                    count++;
                }
            }
            else {
                errorFlag = true;
                errorMsg = population.getErrorMsg();
            }

        }

        return best;
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
}
